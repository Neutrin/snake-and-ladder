package model;

public class UserPosition {
    private User user;
    private Long postion;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getPostion() {
        return postion;
    }

    public void setPostion(Long postion) {
        this.postion = postion;
    }

    public UserPosition(User user, Long postion) {
        this.user = user;
        this.postion = postion;
    }



}