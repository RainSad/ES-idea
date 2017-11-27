package com.sys.repository.sys;


import com.sys.entity.sys.SysUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface SysUserRepositoryImp extends Repository<SysUser,String>, CrudRepository<SysUser,String>{

}
