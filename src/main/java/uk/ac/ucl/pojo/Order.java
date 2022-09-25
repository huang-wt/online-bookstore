package uk.ac.ucl.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Taobang
 * @create 2022-09-25 20:57
 */
public class Order {

    private String orderId;
    private Date createTime;
    private BigDecimal totalPriceAmount;
    private Integer status = 0; // 0:NOT YET DISPATCHED  1:SHIPPED  2:ORDER COMPLETED
    private Integer userId;

    public Order() {
    }

    public Order(String orderId, Date createTime, BigDecimal totalPriceAmount, Integer status, Integer userId) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.totalPriceAmount = totalPriceAmount;
        this.status = status;
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getTotalPriceAmount() {
        return totalPriceAmount;
    }

    public void setTotalPriceAmount(BigDecimal totalPriceAmount) {
        this.totalPriceAmount = totalPriceAmount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", createTime=" + createTime +
                ", totalPriceAmount=" + totalPriceAmount +
                ", status=" + status +
                ", userId=" + userId +
                '}';
    }
}
