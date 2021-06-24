package com.lagou.controller;

import com.lagou.domain.*;
import com.lagou.service.MenuService;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /*
        查询所有角色（条件）
     */

    @RequestMapping("/findAllRole")
    public ResponseResult findAllRole(@RequestBody Role role){

        List<Role> allRole = roleService.findAllRole(role);

        ResponseResult responseResult = new ResponseResult(true, 200, "查询所有角色成功", allRole);

        return responseResult;

    }

    /*
        添加&修改角色
     */
    @RequestMapping("/saveOrUpdateRole")
    public ResponseResult saveOrUpdateRole(@RequestBody Role role, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        String name = user.getName();
        //String name = "system";
        try {
            if (role.getId() == null) {
                Date date = new Date();
                role.setCreatedTime(date);
                role.setUpdatedTime(date);
                role.setCreatedBy(name);
                role.setUpdatedBy(name);
                roleService.saveRole(role);
                ResponseResult result = new ResponseResult(true, 200, "新增响应成功", null);
                return result;
            } else {
                Date date = new Date();
                role.setUpdatedTime(date);
                role.setUpdatedBy(name);
                roleService.updateRole(role);
                ResponseResult result = new ResponseResult(true, 200, "修改响应成功", null);
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
        查询所有的父子菜单信息（分配菜单的第一个接口）
     */
    @Autowired
    private MenuService menuService;

    @RequestMapping("/findAllMenu")
    public ResponseResult findSubMenuListByPid(){

        // -1 表示查询所有的父子级菜单
        List<Menu> menuList = menuService.findSubMenuListByPid(-1);

        // 响应数据
        Map<String, Object> map = new HashMap<>();
        map.put("parentMenuList",menuList);

        ResponseResult responseResult = new ResponseResult(true, 200, "查询所有的父子菜单信息成功", map);

        return responseResult;

    }

    /*
        根据角色ID查询关联的菜单信息ID
     */
    @RequestMapping("/findMenuByRoleId")
    public ResponseResult findMenuByRoleId(Integer roleId){

        List<Integer> menuByRoleId = roleService.findMenuByRoleId(roleId);

        ResponseResult responseResult = new ResponseResult(true, 200, "查询角色关联的菜单信息成功", menuByRoleId);

        return responseResult;

    }

    /*
        为角色分配菜单
     */
    @RequestMapping("/RoleContextMenu")
    public ResponseResult RoleContextMenu(@RequestBody RoleMenuVo roleMenuVo){

        roleService.roleContextMenu(roleMenuVo);

        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", null);

        return responseResult;

    }

    /*
        删除角色
     */
    @RequestMapping("/deleteRole")
    public ResponseResult deleteRole(Integer id){

        roleService.deleteRole(id);
        ResponseResult responseResult = new ResponseResult(true, 200, "删除角色成功", null);
        return  responseResult;

    }

    /*
        根据角色ID查询关联的资源信息
     */
    @RequestMapping("/findResourceListByRoleId")
    public ResponseResult findResourceListByRoleId(Integer roleId){

        List<ResourceCategory> resourceCategoryList = roleService.findResourceListByRoleId(roleId);

        ResponseResult responseResult = new ResponseResult(true, 200, "查询角色关联的菜单信息成功", resourceCategoryList);

        return responseResult;

    }

    /*
        为角色分配菜单
     */
    @RequestMapping("/roleContextResource")
    public ResponseResult roleContextResource(@RequestBody RoleResourceVo resourceVo, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        String name = user.getName();
        //String name = "system";
        try {
                Date date = new Date();
                resourceVo.setCreatedTime(date);
                resourceVo.setUpdatedTime(date);
                resourceVo.setCreatedBy(name);
                resourceVo.setUpdatedBy(name);
                roleService.roleContextResource(resourceVo);
                ResponseResult result = new ResponseResult(true, 200, "响应成功", null);
                return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
