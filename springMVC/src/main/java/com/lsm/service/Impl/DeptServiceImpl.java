package com.lsm.service.Impl;

import com.lsm.mapper.DeptMapper;
import com.lsm.pojo.Dept;
import com.lsm.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;


public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    public List<Dept> findAllDept() {
        return deptMapper.findAllDept();
    }

    public Dept findDeptById(int id) {
        return deptMapper.findDeptById(id);
    }
}
