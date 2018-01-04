package com.sys.repository.sys;

import com.sys.entity.sys.SysDepartment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface SysDepartmentRepositoryImp extends Repository<SysDepartment, String>, CrudRepository<SysDepartment, String> {

}
