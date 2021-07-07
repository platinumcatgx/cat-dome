package gx.domain;

import java.awt.*;
import java.util.Date;

public class User {
    private Integer UserId;
    private String Email;
    private String FirstName;
    private String LastName;
    private String Password;
    private String Gender;
    private Date DateOfBirth;
    private Integer Phone;
    private Image Photo;
    private String Address;
    private Integer RoleId;

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public Integer getPhone() {
        return Phone;
    }

    public void setPhone(Integer phone) {
        Phone = phone;
    }

    public Image getPhoto() {
        return Photo;
    }

    public void setPhoto(Image photo) {
        Photo = photo;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Integer getRoleId() {
        return RoleId;
    }

    public void setRoleId(Integer roleId) {
        RoleId = roleId;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserId=" + UserId +
                ", Email='" + Email + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Password='" + Password + '\'' +
                ", Gender='" + Gender + '\'' +
                ", DateOfBirth=" + DateOfBirth +
                ", Phone=" + Phone +
                ", Photo='" + Photo + '\'' +
                ", Address='" + Address + '\'' +
                ", RoleId=" + RoleId +
                '}';
    }
}
