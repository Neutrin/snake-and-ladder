package model;

public class User {
    private static Long uId = 0l;
    private String name;

    public static Long getuId() {
        return uId;
    }

    public static void setuId() {
        User.uId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name){
        setuId();
        setName(name);
    }



}