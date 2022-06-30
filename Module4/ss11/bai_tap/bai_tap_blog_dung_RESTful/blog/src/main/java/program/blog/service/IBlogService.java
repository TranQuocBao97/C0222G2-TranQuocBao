package program.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import program.blog.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> getAll();
    Page<Blog> getAllBlogByName(String name, Pageable pageable);

    Page<Blog> getAllBlogByNameContaining(String name, Pageable pageable);

    void addNewBlog(Blog blog);
    void editBlog(Blog blog);
    Blog getOneBlogById(Integer id);

    void deleteBlogById(Integer id);

    Page<Blog> getAllBlog(Pageable pageable);
    Optional<Blog> getBlogById(Integer id);

    List<Blog> getListBlogByTypeBlogId(Integer id);

    void update(Blog blog);

}
