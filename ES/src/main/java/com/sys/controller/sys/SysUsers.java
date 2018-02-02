package com.sys.controller.sys;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sys.entity.param.UserParam;
import com.sys.entity.resdata.JsonData;
import com.sys.entity.sys.SysUser;
import com.sys.service.sys.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sys/users")
public class SysUsers {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/save.json")
    @ResponseBody
    public JsonData saveUser(UserParam param) {
        sysUserService.save(param);
        return JsonData.success();
    }

    @RequestMapping("/update.json")
    @ResponseBody
    public JsonData updateUser(UserParam param) {
        sysUserService.update(param);
        return JsonData.success();
    }
}
