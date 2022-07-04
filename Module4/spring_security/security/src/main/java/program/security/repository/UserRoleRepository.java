package program.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import program.security.model.AppUser;
import program.security.model.UserRole;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
