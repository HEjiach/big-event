package com.itheima.service.impl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.ArticleMapper;
import com.itheima.pojo.Article;
import com.itheima.pojo.PageBean;
import com.itheima.service.ArticleService;
import com.itheima.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
* @author 何佳臣
* @description 针对表【article】的数据库操作Service实现
* @createDate 2024-11-09 17:22:07
*/
@Service
public class ArticleServiceImpl
implements ArticleService{
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void add(Article article) {
        article.setUpdateTime(LocalDateTime.now());
        article.setCreateTime(LocalDateTime.now());
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer id =(Integer) map.get("id");
        article.setCreateUser(id);
        articleMapper.add(article);
    }

    @Override
    public void update(Article article) {
        article.setUpdateTime(LocalDateTime.now());
        articleMapper.update(article);
    }

    @Override
    public Article detail(Integer id) {
        return articleMapper.detail(id);

    }

    @Override
    public void delete(Integer id) {
        articleMapper.delete(id);
    }

    @Override
    public PageBean pageInfo(Integer pageNum, Integer pageSize, Integer categoryId, String state) {
        PageHelper.startPage(pageNum,pageSize);
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
       Page<Article> page= articleMapper.pageInfo(categoryId,state,id);
        List<Article> result = page.getResult();
        long total = page.getTotal();

        PageBean pageBean = new PageBean(total, result);
        return pageBean;
    }
}
