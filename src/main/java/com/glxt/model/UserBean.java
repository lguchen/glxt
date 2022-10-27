package com.glxt.model;

public class UserBean {
    private Integer id;
    private String userName;
    private String userPass;
    private String userRole;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userRole='" + userRole + '\'' +
                '}';
    }

}
