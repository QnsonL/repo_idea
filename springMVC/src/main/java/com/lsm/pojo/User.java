package com.lsm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int usrId;
    private String usrName;
    private int empId;
    private String accountNum;
    private String telephone;
    private String address;
    private String remarks;

    // 一对一 一个用户有一个客户经理
    private Emp emp;

    @Override
    public String toString() {
        return "User{" +
                "usrId=" + usrId +
                ", usrName='" + usrName + '\'' +
                ", empId=" + empId +
                ", accountNum='" + accountNum + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", remarks='" + remarks + '\'' +
                ", emp=" + emp +
                '}';
    }
}
