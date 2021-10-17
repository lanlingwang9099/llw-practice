package com.lin.community.controller;

import com.lin.community.entity.DiscussPost;
import com.lin.community.entity.Page;
import com.lin.community.entity.User;
import com.lin.community.service.DiscussPostService;
import com.lin.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private DiscussPostService discussPostService;
    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String getIndexPage(Model model, Page page){
        //MVC自动实例化model page 的时候会把page注入model
        //所以thymeleaf可以直接访问page对象
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");
        List<DiscussPost> list=discussPostService.findDiscussPosts(0,page.getOffset(),page.getLimit());
        List<Map<String,Object> > discussPosts=new ArrayList<>();
        if(list!=null){
            for(DiscussPost post:list){
                Map<String,Object> map=new HashMap<>();
                map.put("post",post);
                User user=userService.findUserById(post.getUserId());
                map.put("user",user);
                discussPosts.add(map);

            }
        }
        model.addAttribute("discussPosts",discussPosts);
        model.addAttribute("page",page);
        return "/index";
    }


}
