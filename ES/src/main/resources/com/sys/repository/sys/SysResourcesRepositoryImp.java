package com.sys.repository.sys;

import com.sys.entity.sys.SysResources;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SysResourcesRepositoryImp extends Repository<SysResources,String>, CrudRepository<SysResources,String>{

	@Query(value = "SELECT " + 
			"sys_resources.* " + 
			"FROM " + 
			"sys_role_resources " + 
			"INNER JOIN sys_resources ON sys_role_resources.resources_id = sys_resources.id " + 
			"WHERE sys_role_resources.role_id=?1", nativeQuery = true)
    List<SysResources> findRole(@Param("roleId") String roleId);
	
//	@Query(value = "SELECT t FROM sysRoleResources t INNER JOIN " + 
//			"sysResources b ON t.resourcesId = b.id WHERE t.roleId=?1")
//	public List<SysResources> findRole(@Param("roleId")String roleId);
}
