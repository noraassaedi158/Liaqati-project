package com.liaqaty.liaqaty.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    private String name;

    private String email;

    // تم تعديل الاسم هنا ليطابق نظام Spring Security مع الاحتفاظ باسم العمود في قاعدة البيانات
    @Column(name = "password_hash")
    private String password; 

    private Integer age;

    private BigDecimal weight;

    private BigDecimal height;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    // --- الإضافة الخاصة بمهمتك (علاقة الصلاحيات والأمان) ---
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    // مُشيد فارغ مطلوب لقواعد البيانات
    public User() {}

    // --- دوال الإرجاع والتعديل (Getters and Setters) للجميع --- //

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // الدوال التي كان يبحث عنها ملف UserService
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public BigDecimal getWeight() { return weight; }
    public void setWeight(BigDecimal weight) { this.weight = weight; }

    public BigDecimal getHeight() { return height; }
    public void setHeight(BigDecimal height) { this.height = height; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    // دوال الصلاحيات
    public Collection<Role> getRoles() { return roles; }
    public void setRoles(Collection<Role> roles) { this.roles = roles; }
}