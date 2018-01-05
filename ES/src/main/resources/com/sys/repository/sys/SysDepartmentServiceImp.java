package com.sys.repository.sys;

import com.core.dao.MysqlBaseDaoImp;
import com.sys.entity.sys.SysDepartment;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@Service
public class SysDepartmentServiceImp extends MysqlBaseDaoImp<SysDepartment> {

    public SysDepartmentServiceImp() {
        Type superclass = getClass().getGenericSuperclass();
        ParameterizedType type = (ParameterizedType) superclass;
        entityClass = (Class<SysDepartment>) type.getActualTypeArguments()[0];
    }
}
