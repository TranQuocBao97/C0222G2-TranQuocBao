package program.blog.model;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String content;


    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false, referencedColumnName = "type_id")
    private TypeBlog typeBlog;



    public Blog() {
    }


    public Blog(Integer id, String name, String content, TypeBlog typeBlog) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.typeBlog = typeBlog;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TypeBlog getTypeBlog() {
        return typeBlog;
    }

    public void setTypeBlog(TypeBlog typeBlog) {
        this.typeBlog = typeBlog;
    }
}
