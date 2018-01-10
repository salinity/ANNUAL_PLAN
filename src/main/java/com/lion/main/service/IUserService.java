package com.lion.main.service;


import com.lion.common.base.message.MessageResult;
import com.lion.common.base.repones.PageResponse;
import com.lion.main.pojo.UserEntity;
import com.lion.main.pojo.dto.UserDTO;

/**
 * Created by Administrator on 2017/6/8.
 */
public interface IUserService {

    UserEntity findUserById(Long id);

    UserEntity findUserByUserName(String loginName);

    PageResponse getUserPage(UserDTO userDTO);

    MessageResult addUser(UserDTO userDTO);

    MessageResult updateUser(UserDTO userDTO);
}
