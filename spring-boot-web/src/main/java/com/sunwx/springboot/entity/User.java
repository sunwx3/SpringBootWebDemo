package com.sunwx.springboot.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private static final long serialVersionUID = 22993759801708311L;

    /**
     * ums_user.user_id: 
     * <p>
     * <code>
     * 用户ID<br>
     * </code>
     */
    private String userId;

    /**
     * ums_user.user_code: 
     * <p>
     * <code>
     * 用户编码<br>
     * </code>
     */
    private String userCode;

    /**
     * ums_user.administrator: 
     * <p>
     * <code>
     * 是否是管理员 Y是 N否<br>
     * </code>
     */
    private String administrator;

    /**
     * ums_user.user_name: 
     * <p>
     * <code>
     * 用户名称<br>
     * </code>
     */
    private String userName;

    /**
     * ums_user.password: 
     * <p>
     * <code>
     * 密码<br>
     * </code>
     */
    private String password;

    /**
     * ums_user.token: 
     * <p>
     * <code>
     * token<br>
     * </code>
     */
    private String token;

    /**
     * ums_user.phone: 
     * <p>
     * <code>
     * 手机号<br>
     * </code>
     */
    private String phone;

    /**
     * ums_user.email: 
     * <p>
     * <code>
     * email<br>
     * </code>
     */
    private String email;

    /**
     * ums_user.status: 
     * <p>
     * <code>
     * 状态 0 禁用 1 启用<br>
     * </code>
     */
    private String status;

    /**
     * ums_user.create_by: 
     * <p>
     * <code>
     * 创建人<br>
     * </code>
     */
    private String createBy;

    /**
     * ums_user.create_time: 
     * <p>
     * <code>
     * 创建时间<br>
     * </code>
     */
    private Date createTime;

    /**
     * ums_user.update_by: 
     * <p>
     * <code>
     * 修改人<br>
     * </code>
     */
    private String updateBy;

    /**
     * ums_user.update_time: 
     * <p>
     * <code>
     * 修改时间<br>
     * </code>
     */
    private Date updateTime;

    /**
     * ums_user.center_id: 
     * <p>
     * <code>
     * 创建人ID<br>
     * </code>
     */
    private String centerId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getAdministrator() {
        return administrator;
    }

    public void setAdministrator(String administrator) {
        this.administrator = administrator == null ? null : administrator.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCenterId() {
        return centerId;
    }

    public void setCenterId(String centerId) {
        this.centerId = centerId == null ? null : centerId.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userCode='" + userCode + '\'' +
                ", administrator='" + administrator + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                ", createBy='" + createBy + '\'' +
                ", createTime=" + createTime +
                ", updateBy='" + updateBy + '\'' +
                ", updateTime=" + updateTime +
                ", centerId='" + centerId + '\'' +
                '}';
    }
}