package org.dimigo.vo;

public class UserVO {
    private String id;
    private String pwd;
    private String name;

    public UserVO() {

    }

    public UserVO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserVO(String id, String pwd, String name) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPwd() {
        return pwd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
