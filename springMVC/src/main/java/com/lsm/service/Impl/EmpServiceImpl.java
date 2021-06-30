package com.lsm.service.Impl;

import com.lsm.mapper.EmpMapper;
import com.lsm.pojo.Emp;
import com.lsm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    public List<Emp> findAllEmp() {
        return empMapper.findAllEmp();
    }

    public List<Emp> findEmpByDeptId(int deptId) {
        return empMapper.findEmpByDeptId(deptId);
    }

    public Emp findEmpById(int id) {
        return empMapper.findEmpById(id);
    }

    @Override
    public void deleteByIds(Integer[] ids) {
        empMapper.deleteByIds(ids);
    }

    @Override
    public void save(Emp emp) {
        empMapper.save(emp);
    }

    @Override
    public void update(Emp emp) {
        empMapper.update(emp);
    }
}
