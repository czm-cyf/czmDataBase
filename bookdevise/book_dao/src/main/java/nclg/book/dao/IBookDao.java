package nclg.book.dao;

import nclg.book.domain.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IBookDao {
        @Select("select * from book")
        public List<Book> findAll() throws Exception;

        @Insert("insert into book(bianhao,name,author,number) values(#{bianhao},#{name},#{author},#{number})")
        public  void save(Book book) throws Exception;

        @Delete("DELETE  FROM book WHERE id=#{id}")
        public  void delete(Integer id) throws Exception;

        @Select("select * from book where id=#{id}")
        public  Book findById(Integer id) throws Exception;

        @Update("update book set number=#{number} where id=#{id}")
        public  void upDate(@Param("id") Integer id, @Param("number") String number);
}
