package com.ihrm.system.dao;

import com.ihrm.domain.system.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author lish
 * @date 2020/10/6 15:06
 */
public interface UserDao extends JpaRepository<User,String>, JpaSpecificationExecutor<User> {
}
