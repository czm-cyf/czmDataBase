package nclg.book.service;

import nclg.book.domain.Orders;

import java.util.List;

public interface IOrdersService {

    public List<Orders> findAll() throws Exception ;

    void save(Orders orders) throws Exception ;


    public  Orders findById(Integer id) throws Exception;

    public  void reserve(Integer userId, Integer ordersId) throws Exception;
}
