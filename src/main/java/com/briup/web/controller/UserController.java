package com.briup.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.bean.User;
import com.briup.bean.extend.UserExtend;
import com.briup.service.IUserService;
import com.briup.utils.Message;
import com.briup.utils.MessageUtil;
import com.briup.vm.UserRoleVM;
import com.briup.vm.UserVM;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Elvira
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;

	@PostMapping("login")
    public Message login(@RequestBody UserVM userVM){
        // 1. 认证用户的用户名和密码
        // 2. 如果登录成功产生token,将token缓存起来，返回
        // 3. 如果登录失败
        Map<String,String> map = new HashMap<>();
        map.put("token","admin-token");
        return MessageUtil.success(map);
    }

    @ApiOperation(value = "通过token获取用户的基本信息")
    @GetMapping("info")
    public Message info(String token){
        // 1. 通过token获取用户信息  {id,use,gender,roles:[]}
        UserExtend userExtend = userService.findById(1l);
        return MessageUtil.success(userExtend);
    }

    @PostMapping("logout")
    public Message logout(){
        // 1. 登录， token从缓存中移除掉
        return MessageUtil.success("退出成功");
    }


    @ApiOperation(value = "查询所有")
    @GetMapping(value = "findAll")
    public Message findAll(){
        List<User> list = userService.findAll();
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "查询所有",notes = "级联用户角色")
    @GetMapping(value = "cascadeRoleFindAll")
    public Message cascadeRoleFindAll(){
        List<UserExtend> list = userService.cascadeRoleFindAll();
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "保存或更新")
    @PostMapping(value = "saveOrUpdate")
    public Message saveOrUpdate(User user){
        userService.saveOrUpdate(user);
        return MessageUtil.success("更新成功");
    }

    @ApiOperation(value = "通过id删除")
    @GetMapping(value = "deleteById")
    public Message deleteById(long id){
        userService.deleteById(id);
        return MessageUtil.success("删除成功");
    }

    @ApiOperation(value = "设置权限")
    @PostMapping(value = "setRoles")
    public Message setRoles(UserRoleVM userRoleVM){
        System.out.println(userRoleVM);
        userService.setRoles(userRoleVM.getId(),userRoleVM.getRoles());
        return MessageUtil.success("设置成功");
    }
}
