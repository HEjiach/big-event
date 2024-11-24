package com.itheima.service;

import com.itheima.pojo.Article;
import com.itheima.pojo.PageBean;

/**
* @author 何佳臣
* @description 针对表【article】的数据库操作Service
* @createDate 2024-11-09 17:22:07
*/
public interface ArticleService {

    void add(Article article);

    void update(Article article);

    Article detail(Integer id);

    void delete(Integer id);

    PageBean pageInfo(Integer pageNum, Integer pageSize, Integer categoryId, String state);
}
