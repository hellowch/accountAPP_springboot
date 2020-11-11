package com.example.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 收入信息表
 * </p>
 *
 * @author wch的个人理财通
 * @since 2020-10-30
 */
@TableName("tb_inaccount")
public class Inaccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 收入金额
     */
    private BigDecimal money;

    /**
     * 收入时间
     */
    private String time;

    /**
     * 收入类别
     */
    private String type;

    /**
     * 付款方
     */
    private String handler;

    /**
     * 备注
     */
    private String mark;

    /**
     * 用户id
     */
    private Integer user_id;

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

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Inaccount{" +
                "id=" + id +
                ", money=" + money +
                ", time='" + time + '\'' +
                ", type='" + type + '\'' +
                ", handler='" + handler + '\'' +
                ", mark='" + mark + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}

