package com.itheima.mapper;

import com.github.pagehelper.Page;
import com.itheima.pojo.Article;
import org.apache.ibatis.annotations.*;

/**
* @author 何佳臣
* @description 针对表【article】的数据库操作Mapper
* @createDate 2024-11-09 17:22:07
* @Entity generator.pojo.Article
*/
@Mapper
public interface ArticleMapper {

    @Insert("INSERT INTO article (title, content, cover_img,state,category_id, create_user, create_time, update_time) VALUES " +
            "(#{title},#{content},#{coverImg},#{state},#{categoryId},#{createUser},#{createTime},#{updateTime})")
    void add(Article article);
    @Update("update article set title=#{title},content=#{content},cover_img=#{coverImg},state=#{state},category_id=#{categoryId},update_time=#{updateTime} where id=#{id}")
    void update(Article article);
    @Select("select * from article where id=#{id}")
    Article detail(Integer id);
    @Delete("delete from article where id=#{id}")
    void delete(Integer id);

    Page<Article> pageInfo(Integer categoryId, String state,Integer id);
}
