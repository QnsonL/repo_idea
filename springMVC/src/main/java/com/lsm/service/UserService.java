package com.lsm.service;

import com.lsm.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAllUser();

    List<User> findUserByEmpId(int empId);
}
