package program.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import program.security.model.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUserName(String userName);
}
