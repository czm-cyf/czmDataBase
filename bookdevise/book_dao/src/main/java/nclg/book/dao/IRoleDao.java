package nclg.book.dao;

import nclg.book.domain.Permission;
import nclg.book.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRoleDao {
    @Select("SELECT * FROM role WHERE id IN(SELECT roleId FROM user_role WHERE userId=#{userId})")
    @Results({
            @Result(id = true,property ="id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "nclg.book.dao.IPermissionDao.findPermissionByRoleId")),
    })
    public  List<Role> findRoleByUserId(String  UserId) throws Exception ;

    @Select("select * from role")
   public  List<Role> findAll();

    @Select("select * from role where id=#{roleId}")
    public  Role findById(String roleId);

    @Select("select * from permission where id not in(select permissionId from role_permission where roleId=#{roleId} )")
    List<Permission> findOtherPermissions(String roleId) throws Exception;

    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
    public void addPermissionToRole(@Param("roleId") String roleId,@Param("permissionId") String permissionId);

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    public  void save(Role role);
}
