package com.lin.community;


import com.lin.community.dao.DiscussPostMapper;
import com.lin.community.dao.UserMapper;
import com.lin.community.entity.DiscussPost;
import com.lin.community.entity.User;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;

@ContextConfiguration(classes= CommunityApplication.class)
@MapperScan({"com.lin.community.dao"})
@SpringBootTest
public class MapperTests {

    @Autowired
    public UserMapper userMapper;

    @Autowired
    public DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectUser(){
        User user=userMapper.selectById(101);
        System.out.println(user);
        user=userMapper.selectByName("liubei");
        System.out.println(user);
        user =userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);

    }
    @Test
    public void testInsertUser(){
        User user=new User();
        user.setUsername("lll");
        user.setPassword("12345");
        user.setEmail("1322@qq.com");
        user.setSalt("abc");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());

        int rows=userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());

    }
    @Test
    public void testUpdateUser(){
        int rows=userMapper.updateHeader(150,"http://www.nowcoder.com/102.png");
        System.out.println(rows);
        rows=userMapper.updateStatus(150,1);
        System.out.println(rows);


    }

    @Test
    public void testSelectPost(){
        List<DiscussPost> list= discussPostMapper.selectDiscussPosts(149,0,10);
        for(DiscussPost post:list)
        System.out.println(post);

        int rows=discussPostMapper.selectDiscussPostRows(149);
        System.out.println(rows);
    }




}
