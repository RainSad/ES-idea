package com.sys.service.sys;

import com.core.common.exception.ParamException;
import com.core.common.utills.MD5Util;
import com.core.common.utills.PassWordUtil;
import com.core.common.webUtils.BeanValidator;
import com.google.common.base.Preconditions;
import com.sys.entity.param.UserParam;
import com.sys.entity.sys.SysUser;
import com.sys.repository.sys.SysUserRepositoryImp;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class SysUserService {

    Logger log = Logger.getLogger(SysUserService.class);

    @Autowired
    private SysUserRepositoryImp sysUserRepositoryImp;

    @Transactional
    public void save(UserParam param) {
        BeanValidator.check(param);
        if (checkEmailExist(param.getEmail(), param.getId())) {
            throw new ParamException("电话已被占用");
        }
        if (checkTelPhoneExist(param.getPhone(), param.getId())) {
            throw new ParamException("邮箱已被占用");
        }

        String passWord = PassWordUtil.randomPassWord(); //由于没有发邮件，暂时设置为固定值
        passWord = "123456";
        String encryptedPassWord = MD5Util.encrypt(passWord);
        SysUser sysUser = SysUser.builder()
                .username(param.getUsername())
                .realname(param.getRealname())
                .nickname(param.getNickname())
                .password(encryptedPassWord)
                .phone(param.getPhone())
                .email(param.getEmail())
                .birthday(param.getBirthday())
                .geneder(param.getGeneder())
                .regTime(param.getRegTime())
                .deptId(param.getDeptId())
                .status(param.getStatus())
                .remark(param.getRemark())
                .operator("system") //TODO
                .operateIp("127.0.0.1") //TODO
                .operateTime(new Date())
                .build();

        // TODO  send Email
        sysUserRepositoryImp.save(sysUser);

    }

    @Transactional
    public void update(UserParam param) {
        BeanValidator.check(param);
        if (checkEmailExist(param.getEmail(), param.getId())) {
            throw new ParamException("电话已被占用");
        }
        if (checkTelPhoneExist(param.getPhone(), param.getId())) {
            throw new ParamException("邮箱已被占用");
        }
        SysUser before = sysUserRepositoryImp.findOne(param.getId().toString());
        Preconditions.checkNotNull(before, "待更新的用户不存在");

        SysUser after = SysUser.builder()
                .id(param.getId().toString())
                .username(param.getUsername())
                .realname(param.getRealname())
                .nickname(param.getNickname())
                .password(before.getPassword())
                .phone(param.getPhone())
                .email(param.getEmail())
                .birthday(param.getBirthday())
                .geneder(param.getGeneder())
                .regTime(param.getRegTime())
                .deptId(param.getDeptId())
                .status(param.getStatus())
                .remark(param.getRemark())
                .operator("system") //TODO
                .operateIp("127.0.0.1") //TODO
                .operateTime(new Date())
                .build();

        //更新
        sysUserRepositoryImp.save(after);
    }

    /**
     * 根据用户名，邮箱，电话登陆
     *
     * @param keyWord
     * @return
     */
    public SysUser findByKeyWord(String keyWord) {
        return sysUserRepositoryImp.findByUsernameOrEmailOrPhone(keyWord, keyWord, keyWord);
    }

    /**
     * 检测邮箱是否被占用
     * @param mail
     * @param userId
     * @return
     */
    public boolean checkEmailExist(String mail, Integer userId) {
        return sysUserRepositoryImp.countByEmailAndId(mail, userId.toString()) > 0;
    }

    /**
     * 检测电话是否被占用
     * @param phone
     * @param userId
     * @return
     */
    public boolean checkTelPhoneExist(String phone, Integer userId) {
        return sysUserRepositoryImp.countByPhoneAndId(phone, userId.toString()) > 0;
    }
}
