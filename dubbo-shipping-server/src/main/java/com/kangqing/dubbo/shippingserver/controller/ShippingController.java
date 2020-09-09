package com.kangqing.dubbo.shippingserver.controller;

import com.kangqing.dubbo.common.JsonResult;
import com.kangqing.dubbo.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yunqing
 * @since 2020/9/9 23:34
 */
@RestController
@RequestMapping("/shipping")
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    @GetMapping("/getAll")
    public JsonResult<?> getAll(@RequestParam String userId) {
        return JsonResult.success(shippingService.getAll(userId));
    }
}
