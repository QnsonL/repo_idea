package com.lsm.service;

import com.lsm.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> findAllDept();

    Dept findDeptById(int id);
}
