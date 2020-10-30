package com.example.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 支出信息表
 * </p>
 *
 * @author wch的个人理财通
 * @since 2020-10-30
 */
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


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
