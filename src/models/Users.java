package models;

public class Users {
    private int id;
    private String name;
    private String password;
//    String oldPwd;
//    String newPwd;
//    String newPwd2;

    private String password2;
//    private String sex;

//    public String getOldPwd() {
//        return oldPwd;
//    }
//
//    public void setOldPwd(String oldPwd) {
//        this.oldPwd = oldPwd;
//    }
//
//    public String getNewPwd() {
//        return newPwd;
//    }
//
//    public void setNewPwd(String newPwd) {
//        this.newPwd = newPwd;
//    }
//
//    public String getNewPwd2() {
//        return newPwd2;
//    }
//
//    public void setNewPwd2(String newPwd2) {
//        this.newPwd2 = newPwd2;
//    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    //    private int age;
//    private String email;
    public Users(){

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}

