package program.blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import program.blog.model.Blog;

import javax.transaction.Transactional;


@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {


    @Query(value = " SELECT * FROM blog WHERE `name` like :nameSearch ", nativeQuery = true,
    countQuery = " SELECT count(*) FROM ( SELECT * FROM blog WHERE `name` like :nameSearch) count_table")
    Page<Blog> findAllBlog(@Param("nameSearch") String name, Pageable pageable);

    Page<Blog> findAllByNameContaining(String name, Pageable pageable);

    @Query(value = " SELECT * FROM blog WHERE id = :idSearch ", nativeQuery = true)
    Blog getOneBlogById(@Param("idSearch") Integer id);

    @Modifying
    @Transactional
    Blog save(Blog blog);


    @Modifying
    @Transactional
    @Query(value = " DELETE FROM blog WHERE id = :idDelete ",nativeQuery = true )
    void deleteBlogById(@Param("idDelete") Integer id);



}
