package com.lsm.mapper;

import com.lsm.pojo.Emp;

import java.util.List;

public interface EmpMapper {
    List<Emp> findAllEmp();

    List<Emp> findEmpByDeptId(int deptId);

    Emp findEmpById(int id);

    void deleteByIds(Integer[] ids);

    void save(Emp emp);

    void update(Emp emp);
}
