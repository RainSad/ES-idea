package com.sys.service.sys;

import com.core.common.utills.LevelUtil;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.sys.entity.dto.DeptLevelDto;
import com.sys.entity.sys.SysDepartment;
import com.sys.repository.sys.SysDepartmentRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class SysTreeService {

    @Autowired
    private SysDepartmentRepositoryImp sysDepartmentRepositoryImp;

    public List<DeptLevelDto> deptTree() {
        Iterable<SysDepartment> deptList = sysDepartmentRepositoryImp.findAll();

        List<DeptLevelDto> dtoList = Lists.newArrayList();
        for (SysDepartment dept : deptList) {
            DeptLevelDto dto = DeptLevelDto.adapt(dept);
            dtoList.add(dto);
        }
        return deptListToTree(dtoList);
    }


    public List<DeptLevelDto> deptListToTree(List<DeptLevelDto> deptLevelList) {
        if (CollectionUtils.isEmpty(deptLevelList)) {
            return Lists.newArrayList();
        }

        //level -> [dept1, dept2, ...]
        Multimap<String, DeptLevelDto> leveldeptMap = ArrayListMultimap.create();
        List<DeptLevelDto> rootList = Lists.newArrayList();

        for (DeptLevelDto dto : deptLevelList) {
            leveldeptMap.put(dto.getLevel(), dto);
            if (LevelUtil.ROOT.equals(dto.getLevel())) {
                rootList.add(dto);
            }
        }
        //按照seq从小到大排序
        Collections.sort(rootList, Comparator.comparing(DeptLevelDto::getSeq));
        //递归生成树
        transformDeptTree(rootList, LevelUtil.ROOT, leveldeptMap);
        return rootList;
    }

    public void transformDeptTree(List<DeptLevelDto> deptLevelList, String level, Multimap<String, DeptLevelDto> levelDeptMap) {

        for (int i = 0; i < deptLevelList.size(); i++) {
            //遍历改层每个元素
            DeptLevelDto deptLevelDto = deptLevelList.get(i);
            //处理当前层级数据
            String nextLevel = LevelUtil.calculateLevel(level, deptLevelDto.getId());
            //处理下一层
            List<DeptLevelDto> tempDeptList = (List<DeptLevelDto>) levelDeptMap.get(nextLevel);
            if (!CollectionUtils.isEmpty(tempDeptList)) {
                //排序
                Collections.sort(tempDeptList, deptSeqComparator);
                //设置下一层部门
                deptLevelDto.setDeptList(tempDeptList);
                //进入下一层处理
                transformDeptTree(tempDeptList, nextLevel, levelDeptMap);
            }
        }
    }

    public Comparator<DeptLevelDto> deptSeqComparator = Comparator.comparing(DeptLevelDto::getSeq);
}
