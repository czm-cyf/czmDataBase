package nclg.book.service;

import nclg.book.domain.Permission;
import nclg.book.domain.Role;

import java.util.List;

public interface IRoleService {
    public List<Role> findAll() throws Exception;

    Role findById(String roleId) throws Exception ;

    List<Permission> findOtherPermissions(String roleId)throws Exception;

    void save(Role role)throws Exception;

    void addPermission(String roleId, String[] permissions);
}
