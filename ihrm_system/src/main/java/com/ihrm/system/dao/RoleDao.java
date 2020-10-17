package com.ihrm.system.dao;

import com.ihrm.domain.system.Role;
import com.ihrm.domain.system.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author lish
 * @date 2020/10/8 17:09
 */
public interface RoleDao extends JpaRepository<Role,String>, JpaSpecificationExecutor<User> {
}
