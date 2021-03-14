package com.niuh.seata.domin;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 仓储服务
 * </p>
 *
 * @author hejianhui
 * @since 2019-11-25
 */
@Data
public class Product implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 商品Id
     */
    private Integer productId;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 库存数量
     */
    private Integer count;


}
