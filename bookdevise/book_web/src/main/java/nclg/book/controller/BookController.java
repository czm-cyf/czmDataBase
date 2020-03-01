package nclg.book.controller;

import com.github.pagehelper.PageInfo;
import nclg.book.service.IBookService;
import nclg.book.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService iBookService;

    //查询全部
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                @RequestParam(name ="size",required = true,defaultValue = "4") Integer size) throws Exception {
        List<Book> all = iBookService.findAll(page, size);
        ModelAndView mv = new ModelAndView();
        PageInfo pageInfo = new PageInfo(all);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("book-list");
        return mv;
    }

    //图书删除
    @RequestMapping("/delete.do")
    public String delete(@RequestParam(name = "id",required = true)Integer  id) throws Exception {
        iBookService.delete(id);
        return "redirect:findAll.do";
    }

    //图书添加
    @RequestMapping("/save.do")
    public String  save(Book book) throws Exception {
        iBookService.save(book);
        return "redirect:findAll.do";
    }

    //找到修改图书
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) Integer id) throws Exception{
        Book byId = iBookService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("book", byId);
        mv.setViewName("book-update");
        return mv;
    }
    //修改图书的操作
    @RequestMapping("/upDate.do")
    public String update(@RequestParam("id") Integer id,@RequestParam("number") String  number) throws Exception {
        iBookService.update(id,number);
        return "redirect:findAll.do";
    }
}
