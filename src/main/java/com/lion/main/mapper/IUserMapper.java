package com.lion.main.mapper;


import com.lion.main.pojo.UserEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/6/12.
 */
@Mapper
public interface IUserMapper {

    UserEntity selectByPrimaryKey(@Param("id") Long id);

    UserEntity selectUserByUserName(@Param("loginName") String loginName);

    List<UserEntity> selectUserPage(@Param("entity") UserEntity userEntity);

    int selectPageCount(@Param("entity") UserEntity userEntity);

    int insertSelective(UserEntity userEntity);

    int modifyUser(UserEntity userEntity);

    int deleteUser(@Param("userId") Long userId);
}
