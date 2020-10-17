package com.ihrm.company.controller;

import com.ihrm.domain.company.Company;
import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import com.ihrm.company.serivce.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author lish
 * @date 2020/9/20 16:30
 */


@CrossOrigin
@RestController
@RequestMapping(value = "/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    //保存企业
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public Result save(@RequestBody Company company){
        companyService.add(company);
       return new Result(ResultCode.SUCCESS);

    }
    //更新企业
    @RequestMapping(value = "/{id}",method = RequestMethod.POST)
    public Result update(@PathVariable(value = "id") String id,@RequestBody Company company){
        company.setId(id);
        companyService.update(company);
        return new Result(ResultCode.SUCCESS);
    }
    //删除企业
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable(value = "id") String id){

        companyService.deleteById(id);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id查询企业
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable(value = "id") String id){
        Company company = companyService.findById(id);
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(company);
        return result;
    }

    //查询所有企业
    @RequestMapping(value = "",method = RequestMethod.GET)
    public List<Company> findAll(){
        List<Company> list = companyService.findAll();
        Result result = new Result(ResultCode.SUCCESS);
        result.setData(list);
        return list;
    }
}
