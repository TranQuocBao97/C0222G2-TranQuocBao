package program.xay_dung_jwt.service.user;

import org.springframework.security.core.userdetails.UserDetailsService;
import program.xay_dung_jwt.model.User;
import program.xay_dung_jwt.service.IGeneralService;

import java.util.Optional;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    Optional<User> findByUsername(String username);
}