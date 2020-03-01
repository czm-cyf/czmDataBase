package nclg.book.dao;

import nclg.book.domain.Role;
import nclg.book.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserDao {
    @Select("select * from user where username=#{username}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "phone",column = "phone"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "nclg.book.dao.IRoleDao.findRoleByUserId")),
    })
    public UserInfo findByUsername(String username)throws Exception;

    @Select("select * from user")
    public List<UserInfo> findAll() throws Exception;

    @Insert("insert into user(username,password,phone) values(#{username},#{password},#{phone})")
    public void save(UserInfo userInfo) throws Exception;

    @Select("select * from user where id=#{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "phone",column = "phone"),
            @Result(property ="roles",column = "id",javaType = java.util.List.class,many = @Many(select = "nclg.book.dao.IRoleDao.findRoleByUserId"))
    })
    public UserInfo findBuId(String id) throws Exception;

    @Select("select * from role where id not in (select roleId from user_role where userId=#{userId})")
    public List<Role> findOtherRoles(String userId) throws Exception;

    @Insert("insert into user_role(userId,roleId) values(#{userId},#{roleId})")
    public void addRoleToUser(@Param("userId") String userId,@Param("roleId") String roleId) throws Exception;

    @Select("select username from user where username = #{username}")
    public  String  findUsername(String username) throws Exception ;

    @Select("select * from user where username = #{username}")
    UserInfo findByUsernameforUser(String name);
}
