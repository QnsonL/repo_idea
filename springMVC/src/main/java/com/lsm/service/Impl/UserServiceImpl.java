package com.lsm.service.Impl;

import com.lsm.mapper.UserMapper;
import com.lsm.pojo.User;
import com.lsm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    public List<User> findUserByEmpId(int empId) {
        return userMapper.findUserByEmpId(empId);
    }
}
