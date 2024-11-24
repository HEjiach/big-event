package com.itheima.service;


import com.itheima.pojo.Category;

import java.util.List;

/**
* @author 何佳臣
* @description 针对表【category】的数据库操作Service
* @createDate 2024-11-09 17:22:07
*/
public interface CategoryService {

    void add(Category category);

   List<Category> getCaegory();

    Category detail(Integer id);

    void update(Category category);

    void delete(Integer id);
}
