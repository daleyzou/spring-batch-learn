package com.daleyzou.file2db.po;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * TestUserEntity
 * @description TODO
 * @author zoudaifa
 * @date 2021年03月06日 5:11 下午
 */
@Entity
@Table(name = "test_user", schema = "mytest", catalog = "")
public class TestUserEntity {
    private long id;

    private String name;

    private String phone;

    private String title;

    private String email;

    private String gender;

    private Date dateOfBirth;

    private Date sysCreateTime;

    private String sysCreateUser;

    private Date sysUpdateTime;

    private String sysUpdateUser;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 32)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 32)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 128)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "gender", nullable = true, length = 32)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "date_of_birth", nullable = true)
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Basic
    @Column(name = "sys_create_time", nullable = false)
    public Date getSysCreateTime() {
        return sysCreateTime;
    }

    public void setSysCreateTime(Date sysCreateTime) {
        this.sysCreateTime = sysCreateTime;
    }

    @Basic
    @Column(name = "sys_create_user", nullable = true, length = 255)
    public String getSysCreateUser() {
        return sysCreateUser;
    }

    public void setSysCreateUser(String sysCreateUser) {
        this.sysCreateUser = sysCreateUser;
    }

    @Basic
    @Column(name = "sys_update_time", nullable = false)
    public Date getSysUpdateTime() {
        return sysUpdateTime;
    }

    public void setSysUpdateTime(Date sysUpdateTime) {
        this.sysUpdateTime = sysUpdateTime;
    }

    @Basic
    @Column(name = "sys_update_user", nullable = true, length = 255)
    public String getSysUpdateUser() {
        return sysUpdateUser;
    }

    public void setSysUpdateUser(String sysUpdateUser) {
        this.sysUpdateUser = sysUpdateUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        TestUserEntity that = (TestUserEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(phone, that.phone) && Objects
                .equals(title, that.title) && Objects.equals(email, that.email) && Objects.equals(gender, that.gender)
                && Objects.equals(dateOfBirth, that.dateOfBirth) && Objects.equals(sysCreateTime, that.sysCreateTime)
                && Objects.equals(sysCreateUser, that.sysCreateUser) && Objects
                .equals(sysUpdateTime, that.sysUpdateTime) && Objects.equals(sysUpdateUser, that.sysUpdateUser);
    }

    @Override
    public int hashCode() {
        return Objects
                .hash(id, name, phone, title, email, gender, dateOfBirth, sysCreateTime, sysCreateUser, sysUpdateTime,
                        sysUpdateUser);
    }
}
