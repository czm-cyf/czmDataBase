package nclg.book.service.impl;

import nclg.book.dao.IOrdersDao;
import nclg.book.service.IOrdersService;
import nclg.book.domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {
    @Autowired
    private IOrdersDao iordersDao;

    @Override
    public List<Orders> findAll() throws Exception {
        return iordersDao.findAll();
    }

    @Override
    public void save(Orders orders) throws Exception {
        iordersDao.save(orders);
    }

    @Override
    public Orders findById(Integer id) throws Exception  {
        return iordersDao.findById(id);
    }

    @Override
    public void reserve(Integer userId, Integer ordersId) throws Exception {
        iordersDao.reserve(userId,ordersId);
    }
}
