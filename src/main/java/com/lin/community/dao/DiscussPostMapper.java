package com.lin.community.dao;

import com.lin.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    List<DiscussPost> selectDiscussPosts(int userId,int offset,int limit);  //offset 跳过的条数  limit 取多少条

    //注解用于给参数起别名，动态sql里 如果<id>里只有一个参数，就必须起别名
    int selectDiscussPostRows(@Param("userId") int userId);

}
