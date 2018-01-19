package com.sys.controller.sys;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sys.entity.resdata.JsonData;
import com.sys.entity.sys.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sys/users")
public class SysUsers {

    @RequestMapping("/user.json")
    @ResponseBody
    public Map UsersData() {


        List t = Lists.newArrayList();

        for (int i = 0; i < 10; i++) {
            SysUser user = new SysUser();
            user.setId("admin" + i);
            user.setUsername("sunwx" + i);
            user.setDeptId("武汉");
            user.setPhone("15629121821");
            user.setEmail("9793621422@qq.com");
            user.setRegTime(new Date());
            user.setStatus("1");
            t.add(user);
        }
        Map temp = Maps.newLinkedHashMap();
        temp.put("total", 50);
        temp.put("rows", t);
        temp.put("level", "1.1.2");

        return temp;
    }
}
