package program.form_dang_ky.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import program.form_dang_ky.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {

    User save(User user);

}

