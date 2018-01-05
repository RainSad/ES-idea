package com.sys.controller.sys;

import com.sys.entity.dto.DeptLevelDto;
import com.sys.entity.param.DeptParam;
import com.sys.entity.resdata.JsonData;
import com.sys.service.sys.SysTreeService;
import com.sys.service.sys.SysDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/sys/dept")
public class sysDept {

    @Autowired
    private SysDepartmentService sysDepartmentService;
    @Autowired
    private SysTreeService sysTreeService;

    @RequestMapping("/save.json")
    @ResponseBody
    public JsonData saveDept(DeptParam deptParam) {
        sysDepartmentService.save(deptParam);
        return JsonData.success();
    }

    @RequestMapping("/update.json")
    @ResponseBody
    public JsonData updateDept(DeptParam deptParam) {
        sysDepartmentService.update(deptParam);
        return JsonData.success();
    }

    @RequestMapping("/tree.json")
    @ResponseBody
    public JsonData tree() {
        List<DeptLevelDto> dtoList = sysTreeService.deptTree();

        return JsonData.success(dtoList);
    }


}
