package com.lsm.controller;

import com.lsm.pojo.User;
import com.lsm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findByEmpId")
    @ResponseBody
    public String findByEmpId(int empId){
        List<User> userByEmpId = userService.findUserByEmpId(empId);
        return Arrays.toString(userByEmpId.toArray());
    }
}
