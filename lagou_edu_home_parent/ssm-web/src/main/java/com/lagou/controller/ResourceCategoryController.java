package com.lagou.controller;

import com.lagou.domain.ResourceCategory;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.User;
import com.lagou.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/ResourceCategory")
public class ResourceCategoryController {

    @Autowired
    private ResourceCategoryService resourceCategoryService;

    @RequestMapping("/findAllResourceCategory")
    public ResponseResult findAllResourceCategory(){
        List<ResourceCategory> allResourceCategory = resourceCategoryService.findAllResourceCategory();

        return  new ResponseResult(true,200,"查询所有分类信息成功",allResourceCategory);

    }

    /*
        添加&修改资源分类
     */
    @RequestMapping("/saveOrUpdateResourceCategory")
    public ResponseResult saveOrUpdateResourceCategory(@RequestBody ResourceCategory resourceCategory,HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        String name = user.getName();
        Date date = new Date();
        try {
            if (resourceCategory.getId() == null) {
                resourceCategory.setCreatedTime(date);
                resourceCategory.setUpdatedTime(date);
                resourceCategory.setCreatedBy(name);
                resourceCategory.setUpdatedBy(name);
                resourceCategoryService.saveResourceCategory(resourceCategory);
                ResponseResult result = new ResponseResult(true, 200, "新增响应成功", null);
                return result;
            } else {
                resourceCategory.setUpdatedTime(date);
                resourceCategory.setUpdatedBy(name);
                resourceCategoryService.updateResourceCategory(resourceCategory);
                ResponseResult result = new ResponseResult(true, 200, "修改响应成功", null);
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
        删除资源分类
     */
    @RequestMapping("/deleteResourceCategory")
    public ResponseResult deleteResourceCategory(Integer id){

        resourceCategoryService.deleteResourceCategory(id);
        ResponseResult responseResult = new ResponseResult(true, 200, "删除角色成功", null);
        return  responseResult;

    }


}
