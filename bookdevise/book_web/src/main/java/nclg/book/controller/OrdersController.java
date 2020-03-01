package nclg.book.controller;

import nclg.book.service.IBookService;
import nclg.book.service.IOrdersService;
import nclg.book.service.IUserService;
import nclg.book.domain.Book;
import nclg.book.domain.Orders;
import nclg.book.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrdersService iOrdersService;

    @Autowired
    private IBookService iBookService;

    @Autowired
    private IUserService iUserService;
    //查询所有订单
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Orders> all = iOrdersService.findAll();
        mv.addObject("product",all);
        mv.setViewName("product-list");
        return mv;
    }
    //借书页面展示  Principal principal
    @RequestMapping("/borrowing.do")
    public ModelAndView borroWing(@RequestParam(name = "id",required = true) Integer id,
                                  Principal principal) throws Exception {
        String name = principal.getName();
        UserInfo user =iUserService.findByUsernameforUser(name);
        Book byId = iBookService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("book",byId);
        mv.addObject("user",user);
        mv.setViewName("product-add");
        return mv;
    }
    //借书存入数据库
    @RequestMapping("/save.do")
    public String  save(Orders orders) throws Exception {
        iOrdersService.save(orders);
        return "redirect:findAll.do";
    }
    //借出图书
    @RequestMapping("/findAllReserve.do")
    public ModelAndView findAllReserve() throws Exception {
        List<Orders> all = iOrdersService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("reserve",all);
        mv.setViewName("reserve-list");
        return mv;
    }
}
