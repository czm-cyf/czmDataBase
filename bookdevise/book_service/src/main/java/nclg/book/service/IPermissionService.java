package nclg.book.service;

import nclg.book.domain.Permission;

import java.util.List;

public interface IPermissionService {
    public  List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;


}
