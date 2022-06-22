package program.blog.service;

import program.blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> getAll();
    void addNewBlog(Blog blog);
    void editBlog(Blog blog);
    Blog getOneBlogById(Integer id);
    void deleteBlogById(Integer id);
}
