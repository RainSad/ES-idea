package com.sys.repository.sys;

import com.core.dao.MysqlBaseDaoImp;
import com.sys.entity.sys.SysUser;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@Service
public class SysUserServiceImp extends MysqlBaseDaoImp<SysUser> {

    public SysUserServiceImp() {
        Type superclass = getClass().getGenericSuperclass();
        ParameterizedType type = (ParameterizedType) superclass;
        entityClass = (Class<SysUser>) type.getActualTypeArguments()[0];
    }
}
