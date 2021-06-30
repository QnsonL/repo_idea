package com.lsm.controller;

import com.lsm.pojo.Dept;
import com.lsm.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Dept> findAll(){
        List<Dept> allDept = deptService.findAllDept();
        return allDept;
    }

    @RequestMapping("/findById")
    @ResponseBody
    public String findById(int id){
        Dept dept = deptService.findDeptById(id);
        return dept.toString();
    }

}
