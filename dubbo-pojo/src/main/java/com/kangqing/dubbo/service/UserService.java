package com.kangqing.dubbo.service;

import com.kangqing.dubbo.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author yunqing
 * @since 2020-09-09
 */
public interface UserService extends IService<User> {

    User getOne(String userId);

}
