package com.sunwx.springboot.bean;

public class Employee {
    private Integer id;
    private String name;
    private String email;
    private String tel_phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel_phone() {
        return tel_phone;
    }

    public void setTel_phone(String tel_phone) {
        this.tel_phone = tel_phone;
    }

    public Employee(Integer id, String name, String email, String tel_phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.tel_phone = tel_phone;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", tel_phone='" + tel_phone + '\'' +
                '}';
    }
}
