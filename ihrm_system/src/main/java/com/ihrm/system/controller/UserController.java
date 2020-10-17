package com.ihrm.system.controller;

import com.ihrm.common.controller.BaseController;
import com.ihrm.common.entity.PageResult;
import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import com.ihrm.domain.system.User;
import com.ihrm.system.service.UserService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

/**
 * @author lish
 * @date 2020/10/7 16:18
 */
@CrossOrigin
@RestController
@RequestMapping("/sys")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    //查询
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public Result findAll(int page, int size, @RequestParam Map map){
        map.put("companyId",companyId);

        Page<User> pageUser = userService.findAll(map, page, size);
        PageResult pageResult = new PageResult(pageUser.getTotalElements(),pageUser.getContent());

        return new Result(ResultCode.SUCCESS,pageResult);

    }

    //保存用户
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public Result save(@RequestBody User user){
        user.setDepartmentId(companyId);
        user.setDepartmentName(companyName);
        userService.save(user);
        return new Result(ResultCode.SUCCESS);
    }

    //更新用户
    @RequestMapping(value = "/user/{id}",method = RequestMethod.PUT)
    public Result update(@PathVariable(value = "id") String id,@RequestBody User user){

        user.setId(id);
        userService.update(user);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id查询用户
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public Result findByID(@PathVariable(value = "id") String id){
        User user = userService.findById(id);
        Result result = new Result();
        result.setData(user);
        return result;
    }

    //根据id删除用户
    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable(value = "id") String id){
        userService.deleteById(id);
        return new Result(ResultCode.SUCCESS);
    }


}
