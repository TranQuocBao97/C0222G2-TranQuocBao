package program.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import program.blog.model.Blog;
import program.blog.service.IBlogService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blogs")
@CrossOrigin
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/list")
    public ResponseEntity<Page<Blog>> showListWithPage(@PageableDefault(value = 5) Pageable pageable,
                                                       @RequestParam Optional<String> name) {
        String searchNameValue = name.orElse("");
        Page<Blog> blogPage = this.iBlogService.getAllBlogByName("%" + searchNameValue + "%", pageable);
        if (!blogPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }
    @GetMapping("/list5")
    public ResponseEntity<Page<Blog>> show5ListWithPage(@PageableDefault(value = 5) Pageable pageable,
                                                       @RequestParam Optional<String> name) {
        String searchNameValue = name.orElse("");
        Page<Blog> blogPage = this.iBlogService.getAllBlogByName("%" + searchNameValue + "%", pageable);
        if (!blogPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }
    @GetMapping("/list10")
    public ResponseEntity<Page<Blog>> show10ListWithPage(@PageableDefault(value = 10) Pageable pageable,
                                                        @RequestParam Optional<String> name) {
        String searchNameValue = name.orElse("");
        Page<Blog> blogPage = this.iBlogService.getAllBlogByName("%" + searchNameValue + "%", pageable);
        if (!blogPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }
    @GetMapping("/list15")
    public ResponseEntity<Page<Blog>> show15ListWithPage(@PageableDefault(value = 15) Pageable pageable,
                                                         @RequestParam Optional<String> name) {
        String searchNameValue = name.orElse("");
        Page<Blog> blogPage = this.iBlogService.getAllBlogByName("%" + searchNameValue + "%", pageable);
        if (!blogPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }


    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> getPageById(@PathVariable("id") Integer id) {
        Optional<Blog> blogOptional = iBlogService.getBlogById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogOptional.get(), HttpStatus.OK);
    }


    @GetMapping("/list-type-by-id/{id}")
    public ResponseEntity<List<Blog>> getListBlogByTypeId(@PathVariable("id") Integer id) {
        List<Blog> blogList = iBlogService.getListBlogByTypeBlogId(id);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<List<FieldError>> updateTypeBlog(@PathVariable Integer id,
                                                           @Validated @RequestBody Blog blog,
                                                           BindingResult bindingResult) {
        System.out.print(blog.getName());
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }

        Optional<Blog> blogOptional = iBlogService.getBlogById(id);

        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setId(id);
        iBlogService.update(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBlogById(@PathVariable Integer id) {
        Optional<Blog> blogOptional = iBlogService.getBlogById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iBlogService.deleteBlogById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
