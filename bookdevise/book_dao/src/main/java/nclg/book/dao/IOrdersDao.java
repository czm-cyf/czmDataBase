package nclg.book.dao;

import nclg.book.domain.Orders;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IOrdersDao {

    @Select("select * from orders")
    public List<Orders> findAll()throws Exception ;

    @Insert("insert into orders(time,money,uname,bname) values(#{time},#{money},#{uname},#{bname})")
    public  void save(Orders orders) throws Exception;

    @Select("select * from orders where id=#{id}")
    public  Orders findById(Integer id);

    @Insert("insert into reserve(userId,ordersId) values(#{userId},#{ordersId})")
    public  void reserve(@Param("userId") Integer userId, @Param("ordersId") Integer ordersId);

//    @Insert("insert into user_role(userId,roleId) values(#{userId},#{roleId})")
//    public void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId) throws Exception;
}
