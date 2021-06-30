package com.lsm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    private int empId;
    private String empName;
    private int deptId;
    private String jobName;
    private String joinDate;
    private String telephone;

    // 一对一 一个员工属于一个部门
    private Dept dept;

    // 一对多 客户经理可以对多个用户进行管理
    private List<User> userList;

    @Override
    public String toString() {
        return "Emp{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", deptId=" + deptId +
                ", jobName='" + jobName + '\'' +
                ", joinDate=" + joinDate +
                ", telephone='" + telephone + '\'' +
                ", dept=" + dept.getDeptName() +
                '}';
    }
}
