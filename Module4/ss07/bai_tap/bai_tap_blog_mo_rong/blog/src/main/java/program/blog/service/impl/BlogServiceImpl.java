package program.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import program.blog.model.Blog;
import program.blog.repository.IBlogRepository;
import program.blog.service.IBlogService;

import java.util.List;


@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    private IBlogRepository iBlogRepository;


    @Override
    public List<Blog> getAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Page<Blog> getAllBlogByName(String name, Pageable pageable) {
        return iBlogRepository.findAllBlog(name,pageable);
    }

    @Override
    public Page<Blog> getAllBlogByNameContaining(String name, Pageable pageable) {
        return iBlogRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public void addNewBlog(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void editBlog(Blog blog) {
//        iBlogRepository.updateBlog(blog.getName(),blog.getContent(),blog.getId());
        iBlogRepository.save(blog);
    }

    @Override
    public Blog getOneBlogById(Integer id) {
        return iBlogRepository.getOneBlogById(id);
    }

    @Override
    public void deleteBlogById(Integer id) {
        iBlogRepository.deleteBlogById(id);
    }


}
