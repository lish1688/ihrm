package com.ihrm.company.controller;

import com.ihrm.common.controller.BaseController;
import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import com.ihrm.company.serivce.CompanyService;

import com.ihrm.company.serivce.DepartmentService;
import com.ihrm.domain.company.Company;
import com.ihrm.domain.company.Department;
import com.ihrm.domain.company.DeptListResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lish
 * @date 2020/10/4 12:26
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/company")
public class DepartmentController extends BaseController {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private CompanyService companyService;


    //保存
    @RequestMapping(value = "/department",method = RequestMethod.POST)
    public Result save(@RequestBody Department department){

        //设置保存企业的id

        department.setId(companyId);
        departmentService.save(department);
        return new Result(ResultCode.SUCCESS);
    }

    //根据ID修改department
    @RequestMapping(value = "/department/{id}",method = RequestMethod.PUT)
    public Result update(@PathVariable(value = "id") String id,@RequestBody Department department){

        department.setId(id);
        departmentService.update(department);

        return new Result(ResultCode.SUCCESS);
    }

    //查询企业的部门列表
    @RequestMapping(value = "/department",method = RequestMethod.GET)
    public Result findAll(){

        //1.指定企业id
        Company company = companyService.findById(companyId);
        //2.完成查询
        List<Department> list = departmentService.findAll(companyId);
        //3.构造返回结果
        DeptListResult deptListResult = new DeptListResult(company,list);
        return new Result(ResultCode.SUCCESS,deptListResult);
    }

    //根据ID查询department
    @RequestMapping(value = "/department/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable(value = "id") String id){

        Department department = departmentService.findById(id);
        Result result = new Result();
        result.setData(department);
        return result;
    }


    //根据ID删除department
    @RequestMapping(value = "/department/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable(value = "id") String id){

        departmentService.delete(id);

        return new Result(ResultCode.SUCCESS);
    }
}
