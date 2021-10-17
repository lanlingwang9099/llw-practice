package com.lin.community.controller;

import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/alpha")
public class AlphaController {
    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
    }

    //get是向服务器获取数据  post是向服务器提交数据
    @GetMapping("/student") //传参方式1 /student?current=1&limit=20
    @ResponseBody
    public String getStudent(@RequestParam(name="current",required = false,defaultValue = "1") int current,
                             @RequestParam(name="limit",required=false,defaultValue = "1") int limit) {
        System.out.println(current);
        System.out.println(limit);
        return "some student";
    }

    @GetMapping("/students/{id}")  //传参方式2 /student/101
    @ResponseBody
    public String getStudents(@PathVariable("id") int id){
        System.out.println(id);
        return "one student";
    }

    @PostMapping("/student")
    @ResponseBody
    public String save(String name,int age){
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    @GetMapping("/teacher")
    public ModelAndView getTeacher(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("name","张三");
        mav.addObject("age",12);
        mav.setViewName("/demo/view");
        return mav;
    }
    @GetMapping("/school")
    public String getSchool(Model model){
        model.addAttribute("name","北京大学");
        model.addAttribute("age",100);
        return "/demo/view";

    }
    @GetMapping("/emp")
    @ResponseBody
    public List<Map<String,Object>> getEmp(){
        List<Map<String,Object>> list=new ArrayList<>();

        Map<String,Object> emp=new HashMap<>();
        emp.put("name","张三");
        emp.put("age","19");
        emp.put("salary","2000");
        list.add(emp);

        emp=new HashMap<>();
        emp.put("name","张四");
        emp.put("age","20");
        emp.put("salary","2001");
        list.add(emp);

        emp=new HashMap<>();
        emp.put("name","王三");
        emp.put("age","21");
        emp.put("salary","2002");
        list.add(emp);

        return list;
    }







}
