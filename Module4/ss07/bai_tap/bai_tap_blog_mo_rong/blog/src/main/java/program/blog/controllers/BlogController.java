package program.blog.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import program.blog.model.Blog;
import program.blog.service.IBlogService;
import program.blog.service.ITypeService;

import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {


    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ITypeService iTypeService;

    @GetMapping("/home")
    public String helloPage(){
        return "hello";
    }

//    @GetMapping("/list")
//    public String showList(Model model){
//        List<Blog> blogList = iBlogService.getAll();
//        model.addAttribute("blogList",blogList);
//        return "blog-list";
//    }

    @GetMapping("/list")
    public String showListWithPage(Model model,
                                   @PageableDefault(value = 2)Pageable pageable,
                                   @RequestParam Optional<String> searchByName){
        String searchNameValue = searchByName.orElse("");
        Page<Blog> blogList = this.iBlogService.getAllBlogByName("%"+searchNameValue+"%",pageable);
        model.addAttribute("blogList",blogList);
        model.addAttribute("searchNameValue",searchNameValue);
        return "blog-list";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable Integer id,
                             Model model){
        Blog blog = iBlogService.getOneBlogById(id);
        model.addAttribute(blog);
        return "blog-detail";
    }

    @GetMapping("/editPage/{id}")
    public String editPage(@PathVariable Integer id,
                           Model model){
        Blog blog = iBlogService.getOneBlogById(id);
        model.addAttribute(blog);
        return "blog-edit";
    }

    @PostMapping("/edit")
    public String editBlog(Blog blog){
        iBlogService.editBlog(blog);
        return "redirect:/blog/list";
    }


    @GetMapping("/addPage")
    public String addPage(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("typeBlogList",iTypeService.getAllType());
        return "blog-add";
    }

    @PostMapping("/add")
    public String addBlog(Blog blog){
        iBlogService.addNewBlog(blog);
        return "redirect:/blog/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable Integer id){
        iBlogService.deleteBlogById(id);
        return "redirect:/blog/list";
    }
}
