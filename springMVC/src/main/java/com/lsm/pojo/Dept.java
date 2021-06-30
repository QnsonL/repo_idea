package com.lsm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {

    private int deptId;
    private String deptName;
    // 本应该是一对一的关系
    private String majorName;
    private String telephone;
    private String email;

    // 一对多 一个部门有许多员工
    private List<Emp> empList;

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", majorName='" + majorName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
