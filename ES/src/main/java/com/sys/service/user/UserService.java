package com.sys.service.user;

import com.core.dao.MysqlBaseDaoImp;
import com.sys.entity.user.User;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@Service
public class UserService extends MysqlBaseDaoImp<User>{

	@SuppressWarnings("unchecked")
	public UserService() {
		Type superclass = getClass().getGenericSuperclass();
	    ParameterizedType type = (ParameterizedType) superclass;
	    entityClass = (Class<User>) type.getActualTypeArguments()[0];
	}

	
}
