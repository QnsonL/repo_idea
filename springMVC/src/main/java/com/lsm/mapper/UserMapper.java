package com.lsm.mapper;

import com.lsm.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> findAllUser();

    List<User> findUserByEmpId(int empId);
}
