package com.qst.itofferbacker.javabean;

/**
 * 后台管理用户JavaBean
 * @公司 青软实训
 * @作者 fengjj
 */
public class User {


    private int userId;

    private String userLogname;

    private String userPwd;

    private String userRealname;

    private String userEmail;

    private int userRole;

    private int userState;

    public User(){

    }

    public User(String userLogname, String userPwd,
                String userRealname, String userEmail, int userRole, int userState) {
        super();
        this.userLogname = userLogname;
        this.userPwd = userPwd;
        this.userRealname = userRealname;
        this.userEmail = userEmail;
        this.userRole = userRole;
        this.userState = userState;
    }

    public User(int userId, String userLogname, String userPwd,
                String userRealname, String userEmail, int userRole, int userState) {
        super();
        this.userId = userId;
        this.userLogname = userLogname;
        this.userPwd = userPwd;
        this.userRealname = userRealname;
        this.userEmail = userEmail;
        this.userRole = userRole;
        this.userState = userState;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserLogname() {
        return userLogname;
    }

    public void setUserLogname(String userLogname) {
        this.userLogname = userLogname;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserRealname() {
        return userRealname;
    }

    public void setUserRealname(String userRealname) {
        this.userRealname = userRealname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public int getUserState() {
        return userState;
    }

    public void setUserState(int userState) {
        this.userState = userState;
    }
}