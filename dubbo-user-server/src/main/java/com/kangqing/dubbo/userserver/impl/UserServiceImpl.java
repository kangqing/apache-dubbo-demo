package com.kangqing.dubbo.userserver.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kangqing.dubbo.mapper.UserMapper;
import com.kangqing.dubbo.pojo.User;
import com.kangqing.dubbo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

/**
 * @author yx
 * @since 2020/9/9 15:36
 */
@DubboService
@RequiredArgsConstructor
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final UserMapper userMapper;

    @Override
    public User getOne(String userId) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", userId);
        return userMapper.selectOne(wrapper);
    }
}
