package com.lsm.controller;

import com.lsm.pojo.Emp;
import com.lsm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    @RequestMapping("/findAll")
    public String findAllEmp(Model model){
        List<Emp> allEmp = empService.findAllEmp();
        model.addAttribute("allEmp",allEmp);
        return "list";
    }

    //deleteBatch
    @RequestMapping("/deleteBatch")
    public String deleteBatch(Integer[] ids){
        empService.deleteByIds(ids);
        return "redirect:/emp/findAll";
    }

    //toAdd
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "add";
    }

    //save
    @RequestMapping("/save")
    public String save(Emp emp){
        empService.save(emp);
        return "redirect:/emp/findAll";
    }

    //findById
    @RequestMapping("/findById")
    public String save(Integer id, Model model){
        Emp emp = empService.findEmpById(id);
        System.out.println(emp);
        model.addAttribute("emp",emp);
        return "update";
    }

    //update
    @RequestMapping("/update")
    public String update(Emp emp){
        empService.update(emp);
        return "redirect:/emp/findAll";
    }
}
