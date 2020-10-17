package com.ihrm.system.service;


import com.ihrm.common.utils.IdWorker;
import com.ihrm.domain.system.User;
import com.ihrm.system.dao.UserDao;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author lish
 * @date 2020/10/6 15:09
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private IdWorker idWorker;
    //保存用户
    public void save(User user){
        String id = idWorker.nextId()+"";
        user.setId(id);
        user.setEnableState(1);
        user.setPassword("123456");
        userDao.save(user);
    }

    //更新用户
    public void update(User user){
        User target = userDao.findById(user.getId()).get();
        target.setUsername(user.getUsername());
        target.setPassword(user.getPassword());
        target.setDepartmentId(user.getDepartmentId());
        target.setDepartmentName(user.getDepartmentName());
        userDao.save(target);
    }

    //根据id查询用户
    public User findById(String id){
        return userDao.findById(id).get();
    }

    //查询用户列表
    public Page findAll(Map<String,Object> map,int page,int size) {

        Specification<User> specification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                if (!StringUtils.isEmpty(map.get("companyId"))){

                    list.add(criteriaBuilder.equal(root.get("companyId").as(String.class), (String)map.get("companyId")));
                }

                if (!StringUtils.isEmpty(map.get("departmentId"))) {
                    list.add(criteriaBuilder.equal(root.get("departmentId").as(String.class), (String)map.get("departmentId")));
                }

                //根据请hasDept构造查询条件，是否分配部门 0：未分配（departmentId=null）   1：已分配（departmentId != null）
                if (!StringUtils.isEmpty(map.get("hasDept"))){

                    if("0".equals((String) map.get("hasDept"))){
                        list.add(criteriaBuilder.isNull(root.get("departmentId")));
                    }else {
                        list.add(criteriaBuilder.isNotNull(root.get("departmentId")));
                    }
                }
                return criteriaBuilder.and(list.toArray(new Predicate[list.size()]));
            }
        };

        //分页
        Page<User> pageUser = userDao.findAll(specification, new PageRequest(page-1, size));
        return pageUser;
    }

    //根据用户id删除用户
    public void deleteById(String id){
        userDao.deleteById(id);
    }
}
