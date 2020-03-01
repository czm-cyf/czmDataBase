package nclg.book.controller;

import nclg.book.service.IOrdersService;
import nclg.book.service.IUserService;
import nclg.book.domain.Orders;
import nclg.book.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import java.security.Principal;

@Controller
@RequestMapping("/reserve")
public class ReserveController {
    @Autowired
    private IOrdersService ordersService;

    @Autowired
    private IUserService userService;

    //预定页面展示
    @RequestMapping("/reserve.do")
    public ModelAndView borroWing(@RequestParam(name = "id",required = true) Integer id,
                                  Principal principal) throws Exception {
        Orders orders= ordersService.findById(id);
        String name = principal.getName();
        UserInfo user =userService.findByUsernameforUser(name);
        ModelAndView mv = new ModelAndView();
        mv.addObject("orders",orders);
        mv.addObject("user",user);
        mv.setViewName("reserve-add");
        return mv;
    }
    //预定保存
    @RequestMapping("/save.do")
    public String  save(@RequestParam(name = "userId",required = true) Integer userId,
                        @RequestParam(name = "ordersId",required = true) Integer ordersId) throws Exception {
        ordersService.reserve(userId,ordersId);
        return "reserve-success";
    }
}
