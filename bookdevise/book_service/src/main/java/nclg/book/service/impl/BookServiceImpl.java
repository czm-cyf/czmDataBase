package nclg.book.service.impl;

import com.github.pagehelper.PageHelper;
import nclg.book.dao.IBookDao;
import nclg.book.service.IBookService;
import nclg.book.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements IBookService {
    @Autowired
    private IBookDao iBookDao;

    @Override
    public List<Book> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page,size);
        return iBookDao.findAll();
    }

    @Override
    public void save(Book book) throws Exception {
        iBookDao.save(book);
    }

    @Override
    public void delete(Integer id) throws Exception {
       iBookDao.delete(id);
    }

    @Override
    public Book findById(Integer id) throws Exception {
        return iBookDao.findById(id);
    }

    @Override
    public void update(Integer id, String number) {
        iBookDao.upDate(id,number);
    }
}
