package program.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import program.blog.model.TypeBlog;
import program.blog.service.ITypeService;

import java.util.List;

@RestController
@RequestMapping("/api/typeBlogs")
public class TypeBlogRestController {

    @Autowired
    private ITypeService iTypeService;

    @GetMapping("/list")
    public ResponseEntity<List<TypeBlog>> getListType(){
        List<TypeBlog> typeBlogList = iTypeService.findAllTypeBlog();
        if(typeBlogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(typeBlogList,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<List<FieldError>> addNewType(@Validated @RequestBody TypeBlog typeBlog,
                                                       BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }
        iTypeService.save(typeBlog);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
