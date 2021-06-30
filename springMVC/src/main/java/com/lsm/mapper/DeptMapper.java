package com.lsm.mapper;

import com.lsm.pojo.Dept;

import java.util.List;

public interface DeptMapper {
    List<Dept> findAllDept();

    Dept findDeptById(int id);
}
