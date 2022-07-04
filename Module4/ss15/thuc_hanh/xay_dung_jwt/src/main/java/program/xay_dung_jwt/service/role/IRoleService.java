package program.xay_dung_jwt.service.role;


import program.xay_dung_jwt.model.Role;
import program.xay_dung_jwt.service.IGeneralService;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}