package com.kangqing.dubbo.pojo;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yunqing
 * @since 2020-09-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("mmall_order_item")
@ApiModel(value="OrderItem对象", description="")
public class OrderItem extends Model<OrderItem> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单子表id")
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    private String userId;

    private String orderNo;

    @ApiModelProperty(value = "商品id")
    private String productId;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "商品图片地址")
    private String productImage;

    @ApiModelProperty(value = "生成订单时的商品单价，单位是元,保留两位小数")
    private BigDecimal currentUnitPrice;

    @ApiModelProperty(value = "商品数量")
    private Integer quantity;

    @ApiModelProperty(value = "商品总价,单位是元,保留两位小数")
    private BigDecimal totalPrice;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
