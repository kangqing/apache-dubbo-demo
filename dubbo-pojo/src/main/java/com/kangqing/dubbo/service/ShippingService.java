package com.kangqing.dubbo.service;

import com.kangqing.dubbo.pojo.Shipping;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yunqing
 * @since 2020-09-09
 */
public interface ShippingService extends IService<Shipping> {

    List<Shipping> getAll(String userId);

}
