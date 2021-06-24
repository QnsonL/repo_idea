package com.lagou.dao;

import com.lagou.domain.ResourceCategory;
import com.lagou.domain.Role;
import com.lagou.domain.RoleResourceVo;
import com.lagou.domain.Role_menu_relation;

import java.util.List;

public interface RoleMapper {

    /*
        查询所有角色&条件进行查询
     */

    public List<Role> findAllRole(Role role);

    /*
        角色新增
     */
    void saveRole(Role role);

    /*
        角色修改
     */
    void updateRole(Role role);


    /*
        根据角色ID查询该角色关联的菜单信息ID [1,2,3,5]
     */
    public List<Integer> findMenuByRoleId(Integer roleid);


    /*
        根据roleid清空中间表的关联关系
     */
    public void deleteRoleContextMenu(Integer rid);


    /*
        为角色分配菜单信息
     */
    public void roleContextMenu(Role_menu_relation role_menu_relation);

    /*
        删除角色
     */

    public void deleteRole(Integer roleId);


    List<ResourceCategory> findResourceListByRoleId(Integer roleId);

    /*
        根据角色ID删除关联表
     */
    void deleteRelationByRoleId(Integer roleId);

    /*
        为角色分配资源, 删除完成后 ,插入最新的关联关系
     */
    void saveRelationByRoleResourceVo(RoleResourceVo roleResourceVo);

}
