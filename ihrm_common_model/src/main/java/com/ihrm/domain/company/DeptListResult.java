package com.ihrm.domain.company;

import com.ihrm.domain.company.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author lish
 * @date 2020/10/5 11:53
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeptListResult {

    private String companyId;
    private String companyName;
    private String companyManage;//公司联系人
    private List<Department> depts;

    public DeptListResult(Company company, List<Department> all) {
    }
}
