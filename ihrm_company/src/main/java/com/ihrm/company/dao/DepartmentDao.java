package com.ihrm.company.dao;

import com.ihrm.domain.company.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author lish
 * @date 2020/10/4 12:10
 */
public interface DepartmentDao  extends JpaRepository<Department,String>, JpaSpecificationExecutor<Department> {

}
