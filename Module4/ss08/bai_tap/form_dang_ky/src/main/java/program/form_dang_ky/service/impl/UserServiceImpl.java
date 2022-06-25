package program.form_dang_ky.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import program.form_dang_ky.model.User;
import program.form_dang_ky.repository.IUserRepository;
import program.form_dang_ky.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public void saveUser(User user) {
        iUserRepository.save(user);
    }
}
