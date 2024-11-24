package com.itheima.controller;

import com.itheima.pojo.Article;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.ArticleService;
import com.itheima.utils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @GetMapping("/list")
    public Result<String> list(HttpServletResponse response, @RequestHeader(name = "Authorization") String token) {
//        try {
//            Map<String, Object> clamins = JwtUtil.parseToken(token);
//
//            return Result.success("文章内容！");
//        } catch (Exception e) {
//            response.setStatus(401);
//            return Result.error("未登录!");
//        }
        return Result.success("文章内容！");
    }
    @PostMapping
    public Result add(@RequestBody @Validated Article article){
       articleService.add(article);
        return Result.success();
    }
    @PutMapping
    public Result update(@RequestBody Article article){
        articleService.update(article);
        return Result.success();
    }
    @GetMapping("/detail")
    public Result<Article> detail(@RequestParam Integer id){
       Article article= articleService.detail(id);
        return Result.success(article);
    }
    @DeleteMapping
    public Result delete(@RequestParam Integer id){
        articleService.delete(id);
        return Result.success();
    }
    @GetMapping
   public Result<PageBean<Article>> pageInfo(Integer pageNum,
                                             Integer pageSize,
                                             @RequestParam(required = false)Integer categoryId,
                                             @RequestParam(required = false)String state){
     PageBean pageBean=   articleService.pageInfo(pageNum,pageSize,categoryId,state);
        return Result.success(pageBean);

    }
}
