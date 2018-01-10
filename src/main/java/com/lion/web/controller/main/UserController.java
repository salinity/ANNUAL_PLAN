package com.lion.web.controller.main;

import com.lion.common.base.repones.PageResponse;
import com.lion.common.base.repones.ResponseResult;
import com.lion.common.base.web.BaseController;
import com.lion.main.pojo.UserEntity;
import com.lion.main.pojo.dto.UserDTO;
import com.lion.main.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/8.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    IUserService userService;

//    @RequestLimit(count = 6,time = 60000)
    @GetMapping("")
    @ResponseBody
    public PageResponse findUserPage(HttpServletRequest httpServletRequest, UserDTO userDTO) {
         return userService.getUserPage(userDTO);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public UserEntity findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    /**
     * 添加用户的方法
     * @param userDTO
     * @return
     */
    @PostMapping("")
    @ResponseBody
    public ResponseResult addUser(UserDTO userDTO) {
        userDTO.setCreateTime(new Date().getTime());
        userDTO.setUpdateTime(new Date().getTime());
        userDTO.setUpdateUser("admin");
        userDTO.setCreateUser("admin");
        return getSucMessage();
    }

}
