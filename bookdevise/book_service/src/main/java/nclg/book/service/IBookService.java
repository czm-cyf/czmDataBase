package nclg.book.service;


import nclg.book.domain.Book;

import java.util.List;

public interface IBookService {
    public List<Book> findAll(int page,int size) throws Exception;

    public  void save(Book book) throws Exception;

    public  void delete(Integer id) throws Exception;

    public  Book findById(Integer id) throws Exception;

    public void update(Integer id, String number) throws Exception;

}
