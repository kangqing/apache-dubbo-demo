package com.kangqing.dubbo.shippingserver.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kangqing.dubbo.exception.BaseException;
import com.kangqing.dubbo.mapper.ShippingMapper;
import com.kangqing.dubbo.pojo.Shipping;
import com.kangqing.dubbo.pojo.User;
import com.kangqing.dubbo.service.ShippingService;
import com.kangqing.dubbo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yunqing
 * @since 2020/9/9 23:16
 */
@Service
@RequiredArgsConstructor
@DubboService
public class ShippingServiceImpl extends ServiceImpl<ShippingMapper, Shipping> implements ShippingService {

    private final ShippingMapper shippingMapper;

    /**
     * 消费userService服务
     */
    @DubboReference
    private UserService userService;


    @Override
    public List<Shipping> getAll(String userId) {
        final User user = userService.getOne(userId);
        if (user == null) {
            throw new BaseException("用户不存在");
        }
        return shippingMapper.selectList(new QueryWrapper<Shipping>().lambda().eq(Shipping::getUserId, userId));
    }
}
