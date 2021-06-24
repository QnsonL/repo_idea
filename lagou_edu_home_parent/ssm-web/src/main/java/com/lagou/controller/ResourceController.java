package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.*;
import com.lagou.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    public ResourceService resourceService;

    @RequestMapping("/findAllResource")
    public ResponseResult findAllResourceByPage(@RequestBody ResourseVo resourseVo){

        PageInfo<Resource> pageInfo = resourceService.findAllResourceByPage(resourseVo);

        return  new ResponseResult(true,200,"资源信息分页多条件查询成功",pageInfo);

    }

    /*
        添加&修改资源信息
     */
    @RequestMapping("/saveOrUpdateResource")
    public ResponseResult saveOrUpdateResource(@RequestBody Resource resource, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        String name = user.getName();
        Date date = new Date();
        try {
            if (resource.getId() == null) {
                resource.setCreatedTime(date);
                resource.setUpdatedTime(date);
                resource.setCreatedBy(name);
                resource.setUpdatedBy(name);
                resourceService.saveResource(resource);
                ResponseResult result = new ResponseResult(true, 200, "新增响应成功", null);
                return result;
            } else {
                resource.setUpdatedTime(date);
                resource.setUpdatedBy(name);
                resourceService.updateResource(resource);
                ResponseResult result = new ResponseResult(true, 200, "修改响应成功", null);
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
        删除资源信息
     */
    @RequestMapping("/deleteResource")
    public ResponseResult deleteResource(Integer id){

        resourceService.deleteResource(id);
        ResponseResult responseResult = new ResponseResult(true, 200, "删除角色成功", null);
        return  responseResult;

    }

}
