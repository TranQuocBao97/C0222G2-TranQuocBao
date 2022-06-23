package program.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import program.blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> getAll();
    Page<Blog> getAllBlogByName(String name, Pageable pageable);

    Page<Blog> getAllBlogByNameContaining(String name, Pageable pageable);

    void addNewBlog(Blog blog);
    void editBlog(Blog blog);
    Blog getOneBlogById(Integer id);

    void deleteBlogById(Integer id);
}
