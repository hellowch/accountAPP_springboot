package com.example.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 支出信息表
 * </p>
 *
 * @author wch的个人理财通
 * @since 2020-10-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_outaccount")
public class Outaccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "_id", type = IdType.AUTO)
    private Integer id;

    /**
     * 支出金额
     */
    private BigDecimal money;

    /**
     * 支出时间
     */
    private String time;

    /**
     * 支出类别
     */
    private String type;

    /**
     * 支出地点
     */
    private String address;

    /**
     * 备注
     */
    private String mark;


}
