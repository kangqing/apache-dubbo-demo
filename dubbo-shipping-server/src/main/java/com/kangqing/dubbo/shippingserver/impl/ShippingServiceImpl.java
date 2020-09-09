package com.kangqing.dubbo.shippingserver.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kangqing.dubbo.mapper.ShippingMapper;
import com.kangqing.dubbo.pojo.Shipping;
import com.kangqing.dubbo.service.ShippingService;
import lombok.AllArgsConstructor;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yunqing
 * @since 2020/9/9 23:16
 */
@Service
@AllArgsConstructor
@DubboService(version = "0.0.1")
public class ShippingServiceImpl extends ServiceImpl<ShippingMapper, Shipping> implements ShippingService {

    private final ShippingMapper shippingMapper;


    @Override
    public List<Shipping> getAll(String userId) {
        return shippingMapper.selectList(new QueryWrapper<Shipping>().lambda().eq(Shipping::getUserId, userId));
    }
}
