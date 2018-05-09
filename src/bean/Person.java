package bean;

public class Person {
    private String name;
    private String password;
    private String ensurepwd;

    public String getEnsurepwd() {
        return ensurepwd;
    }

    public void setEnsurepwd(String ensurepwd) {
        this.ensurepwd = ensurepwd;
    }

    public Person(){

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
