package com.itheima.mapper;

import com.itheima.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
* @author 何佳臣
* @description 针对表【category】的数据库操作Mapper
* @createDate 2024-11-09 17:22:07
* @Entity generator.pojo.Category
*/
@Mapper
public interface CategoryMapper  {

    @Insert("insert into category (category_name, category_alias, create_user, create_time, update_time)" +
            " VALUES (#{categoryName},#{categoryAlias}," +
            "#{createUser},#{createTime},#{updateTime})")
    void add(Category category);
    @Select("SELECT * from category where create_user=#{id}")
    List<Category> getCategory(Integer id);
    @Select("select * from category where id=#{id}")
    Category detail(Integer id);
    @Update("update category set category_name=#{categoryName},category_alias=#{categoryAlias},update_time=#{updateTime} where id=#{id}")
    void update(Category category);
    @Delete("delete from category where id=#{id}")
    void delete(Integer id);
}
