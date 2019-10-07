package com.sunwx.springboot.entity;

import java.io.Serializable;
import java.util.Date;

public class ums_admin implements Serializable {
    private static final long serialVersionUID = 22993759801708311L;

    /**
     * ums_admin.id: 
     * <p>
     */
    private Long id;

    /**
     * ums_admin.username: 
     * <p>
     */
    private String username;

    /**
     * ums_admin.password: 
     * <p>
     */
    private String password;

    /**
     * ums_admin.icon: 
     * <p>
     * <code>
     * 头像<br>
     * </code>
     */
    private String icon;

    /**
     * ums_admin.email: 
     * <p>
     * <code>
     * 邮箱<br>
     * </code>
     */
    private String email;

    /**
     * ums_admin.nick_name: 
     * <p>
     * <code>
     * 昵称<br>
     * </code>
     */
    private String nickName;

    /**
     * ums_admin.note: 
     * <p>
     * <code>
     * 备注信息<br>
     * </code>
     */
    private String note;

    /**
     * ums_admin.create_time: 
     * <p>
     * <code>
     * 创建时间<br>
     * </code>
     */
    private Date createTime;

    /**
     * ums_admin.login_time: 
     * <p>
     * <code>
     * 最后登录时间<br>
     * </code>
     */
    private Date loginTime;

    /**
     * ums_admin.status: 
     * <p>
     * <code>
     * 帐号启用状态：0->禁用；1->启用<br>
     * </code>
     */
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}