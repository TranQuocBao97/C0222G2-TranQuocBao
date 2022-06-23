package program.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import program.blog.model.TypeBlog;

import java.util.List;

@Repository
public interface ITypeRepository extends JpaRepository<TypeBlog,Integer> {

    @Query(value = " SELECT * FROM type_blog ", nativeQuery = true)
    List<TypeBlog> selectAllType();
}
