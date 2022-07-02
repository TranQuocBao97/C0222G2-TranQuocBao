package program.blog.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import program.blog.model.TypeBlog;
import program.blog.repository.ITypeRepository;
import program.blog.service.ITypeService;

import java.util.List;
import java.util.Optional;

@Service
public class TypeServiceImpl implements ITypeService {

    @Autowired
    private ITypeRepository iTypeRepository;

    @Override
    public List<TypeBlog> getAllType() {
        return iTypeRepository.selectAllType();
    }

    @Override
    public Optional<TypeBlog> getTypeBlogById(Integer id) {
        return iTypeRepository.findById(id);
    }

    public List<TypeBlog> findAllTypeBlog(){
        return iTypeRepository.findAll();
    }

    public void save(TypeBlog typeBlog){
        iTypeRepository.save(typeBlog);
    }
}
