package nclg.book.service.impl;

import nclg.book.dao.IRoleDao;
import nclg.book.service.IRoleService;

import nclg.book.domain.Permission;
import nclg.book.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao iRoleDao;

    @Override
    public List<Role> findAll() throws Exception {
        return iRoleDao.findAll();
    }

    @Override
    public Role findById(String roleId) throws Exception {
        return iRoleDao.findById(roleId);
    }

    @Override
    public List<Permission> findOtherPermissions(String roleId) throws Exception {
        return iRoleDao.findOtherPermissions(roleId);
    }

    @Override
    public void save(Role role) throws Exception {
        iRoleDao.save(role);
    }

    @Override
    public void addPermission(String roleId, String[] permissions) {
        for (String permission : permissions) {
            iRoleDao.addPermissionToRole(roleId,permission);
        }
    }
}
