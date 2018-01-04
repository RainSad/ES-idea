package com.sys.service.sys;

import com.core.common.exception.ParamException;
import com.core.common.utills.LevelUtil;
import com.core.common.webUtils.BeanValidator;
import com.sys.entity.param.DeptParam;
import com.sys.entity.sys.SysDepartment;
import com.sys.repository.sys.SysDepartmentRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SysDepartmentService {

    @Autowired
    private SysDepartmentRepositoryImp sysDepartmentRepositoryImp;


    public void save(DeptParam param) {
        BeanValidator.check(param);
        if (checkExist(param.getParentId(), param.getName(), param.getId())) {
            throw new ParamException("同一层级下存在相同的部门");
        }
        SysDepartment dept = SysDepartment.builder().name(param.getName())
                .seq(param.getSeq())
                .parentId(param.getParentId())
                .remark(param.getRemark())
                .build();

        dept.setLevel(LevelUtil.calculateLevel(getLevel(param.getParentId()), param.getParentId()));
        dept.setOperator("system");//TODO
        dept.setOperateIp("127.0.0.1");//TODO
        dept.setOperateTime(new Date());
        dept.setDeptAddress("武汉市洪山区惠安新苑");//TODO
        dept.setDeptPhone("156291s21821");//TODO
        dept.setCreateTime(new Date());//TODO
        dept.setDeptAddress("武汉市洪山区惠安新苑");//TODO
        dept.setDeptAddress("武汉市洪山区惠安新苑");//TODO
        sysDepartmentRepositoryImp.save(dept);
    }


    private boolean checkExist(String parentId, String deptName, String deptId) {


        //TODO

        return true;
    }

    private String getLevel(String deptId) {
        SysDepartment sysDepartment = sysDepartmentRepositoryImp.findOne(deptId);
        if (sysDepartment == null) {
            return null;
        }
        return sysDepartment.getLevel();
    }
}
