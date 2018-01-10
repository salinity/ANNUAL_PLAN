package com.lion.main.service.impl;

import com.lion.common.base.message.MessageResult;
import com.lion.common.base.repones.PageResponse;
import com.lion.common.base.service.BaseService;
import com.lion.common.until.BeanUtils;
import com.lion.common.until.Md5Util;
import com.lion.main.mapper.IUserMapper;
import com.lion.main.pojo.UserEntity;
import com.lion.main.pojo.dto.UserDTO;
import com.lion.main.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by Administrator on 2017/6/8
 */
@Service
public class UserService extends BaseService implements IUserService {

    @Autowired
    private IUserMapper userMapper;

    @Override
    public PageResponse getUserPage(UserDTO userDTO) {
        UserEntity userEntity = BeanUtils.copyBeanPropertyUtils(userDTO,UserEntity.class);
        List<UserEntity> list = userMapper.selectUserPage(userEntity);
        for (UserEntity entity : list) {
            entity.setLoginPwd("");
        }
        Integer total = userMapper.selectPageCount(userEntity);
        PageResponse pageResponse = new PageResponse();
        pageResponse.setRows(list);
        pageResponse.setTotal(total);
        return pageResponse;
    }

    @Override
    public UserEntity findUserById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public MessageResult addUser(UserDTO userDTO) {
        UserEntity userEntity = BeanUtils.copyBeanPropertyUtils(userDTO, UserEntity.class);
        userEntity.setLoginPwd(Md5Util.decryptMd5(userDTO.getLoginPwd() + userDTO.getLoginName()));
        userMapper.insertSelective(userEntity);
        return MessageResult.getSucMessage();
    }

    @Override
    public UserEntity findUserByUserName(String loginName) {
        return userMapper.selectUserByUserName(loginName);
    }

    @Override
    public MessageResult updateUser(UserDTO userDTO) {
        UserEntity userEntity = BeanUtils.copyBeanPropertyUtils(userDTO, UserEntity.class);
        userMapper.modifyUser(userEntity);
        return MessageResult.getSucMessage();
    }

    public static void main(String args[]){
        try {
            Class aClass= Class.forName("com.lion.main.pojo.UserEntity");
            Method[] methods = aClass.getDeclaredMethods();
            Field[] fields = aClass.getDeclaredFields();
            for (Method method : methods) {
                System.out.println(method.getName());
            }
            for (Field field : fields) {
                System.out.println(field.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
