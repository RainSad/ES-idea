package com.sys.service.sys;

import com.core.common.exception.ParamException;
import com.core.common.utills.LevelUtil;
import com.core.common.webUtils.BeanValidator;
import com.google.common.base.Preconditions;
import com.sys.entity.param.DeptParam;
import com.sys.entity.sys.SysDepartment;
import com.sys.repository.sys.SysDepartmentRepositoryImp;
import com.sys.repository.sys.SysDepartmentServiceImp;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
public class SysDepartmentService {
    Logger log = Logger.getLogger(SysDepartmentService.class);

    @Autowired
    private SysDepartmentRepositoryImp sysDepartmentRepositoryImp;

    @Autowired
    private SysDepartmentServiceImp SysDepartmentServiceImp;


    @Transactional
    public void save(DeptParam param) {
        BeanValidator.check(param);
        if (checkExist(param.getParentId(), param.getName(), param.getId())) {
            throw new ParamException("同一层级下存在相同的部门");
        }
        SysDepartment dept = SysDepartment.builder().deptName(param.getName())
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
        //不使用spring data是因为他使用hibernate方法，主键为查询最大值后自动生成,因此没有指定主键的情况下，用save会报异常。
        SysDepartmentServiceImp.save(dept);
    }

    public void update(DeptParam param) {
        BeanValidator.check(param);
        if (checkExist(param.getParentId(), param.getName(), param.getId())) {
            throw new ParamException("同一层级下存在相同的部门");
        }
        SysDepartment before = sysDepartmentRepositoryImp.findOne(param.getId());
        Preconditions.checkNotNull(before, "待更新的部门不存在");
        if (checkExist(param.getParentId(), param.getName(), param.getId())) {
            throw new ParamException("同一层级下存在相同的部门");
        }
        SysDepartment after = SysDepartment.builder()
                .id(param.getId())
                .deptName(param.getName())
                .seq(param.getSeq())
                .parentId(param.getParentId())
                .remark(param.getRemark())
                .build();
        after.setLevel(LevelUtil.calculateLevel(getLevel(param.getParentId()), param.getParentId()));
        after.setOperator("system-update");//TODO
        after.setOperateIp("127.0.0.1");//TODO
        after.setOperateTime(new Date());
        after.setDeptAddress("武汉市洪山区惠安新苑");//TODO
        after.setDeptPhone("156291s21821");//TODO

        updateWithChild(before, after);
    }

    @Transactional
    public void updateWithChild(SysDepartment before, SysDepartment after) {

        String newLevelPrefix = after.getLevel();
        String oldLevelPrefix = before.getLevel();
        if (!newLevelPrefix.equals(oldLevelPrefix)) {
            List<SysDepartment> deptList = sysDepartmentRepositoryImp.findByLevelIsLike(oldLevelPrefix + ".%");
            if (!CollectionUtils.isEmpty(deptList)) {
                for (SysDepartment dept : deptList) {
                    String level = dept.getLevel();
                    if (level.indexOf(oldLevelPrefix) == 0) {
                        level = newLevelPrefix + level.substring(oldLevelPrefix.length());
                        dept.setLevel(level);
                    }
                }
                sysDepartmentRepositoryImp.save(deptList);
            }
        }
        sysDepartmentRepositoryImp.save(after);
    }


    public boolean checkExist(String parentId, String deptName, String deptId) {

        return StringUtils.isEmpty(deptId) ? sysDepartmentRepositoryImp.checkDeptIsExistWithBlankId(parentId, deptName) > 0 : sysDepartmentRepositoryImp.checkDeptIsExist(parentId, deptName, deptId) > 0;
    }


    private String getLevel(String deptId) {
        SysDepartment sysDepartment = sysDepartmentRepositoryImp.findOne(deptId);
        if (sysDepartment == null) {
            return null;
        }
        return sysDepartment.getLevel();
    }
}
