package com.wuwei.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

public class User {
    private Integer id;
    @Excel(name = "姓名", orderNum = "1")
    private String name;
    @Excel(name = "性别", orderNum = "2")
    private String gender;
    @Excel(name = "年龄", orderNum = "3")
    private Integer age;
    @Excel(name = "电话", orderNum = "4")
    private String phone;
    @Excel(name = "地址", orderNum = "5")
    private String address;
    private Date createTime;
    private Date updateTime;

    public User() {}

    public User(String name, String gender, Integer age, String phone, String address) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
