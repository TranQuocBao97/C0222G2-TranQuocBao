package program.blog.service;

import program.blog.model.TypeBlog;

import java.util.List;
import java.util.Optional;

public interface ITypeService {
    List<TypeBlog> getAllType();
    Optional<TypeBlog> getTypeBlogById(Integer id);

    List<TypeBlog> findAllTypeBlog();

    void save(TypeBlog typeBlog);
}
