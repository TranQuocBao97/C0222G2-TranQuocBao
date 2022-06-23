package program.blog.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import program.blog.model.TypeBlog;
import program.blog.repository.ITypeRepository;
import program.blog.service.ITypeService;

import java.util.List;

@Service
public class TypeServiceImpl implements ITypeService {

    @Autowired
    private ITypeRepository iTypeRepository;

    @Override
    public List<TypeBlog> getAllType() {
        return iTypeRepository.selectAllType();
    }
}
