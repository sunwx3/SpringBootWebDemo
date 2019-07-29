package com.sunwx.springboot.bean;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1547761882981414918L;

    /**
     * Student.student_id:
     * <p>
     * <code>
     * 学生编号<br>
     * </code>
     */
    private Integer studentId;

    /**
     * Student.student_name:
     * <p>
     * <code>
     * 学生姓名<br>
     * </code>
     */
    private String studentName;

    /**
     * Student.student_sex:
     * <p>
     * <code>
     * 学生性别<br>
     * </code>
     */
    private String studentSex;

    /**
     * Student.student_num:
     * <p>
     * <code>
     * 手机号码<br>
     * </code>
     */
    private String studentNum;

    /**
     * Student.student_code:
     * <p>
     * <code>
     * 账号<br>
     * </code>
     */
    private String studentCode;

    /**
     * Student.student_pass:
     * <p>
     * <code>
     * 密码<br>
     * </code>
     */
    private String studentPass;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex == null ? null : studentSex.trim();
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum == null ? null : studentNum.trim();
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode == null ? null : studentCode.trim();
    }

    public String getStudentPass() {
        return studentPass;
    }

    public void setStudentPass(String studentPass) {
        this.studentPass = studentPass == null ? null : studentPass.trim();
    }
}