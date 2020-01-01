package io.github.platinumcat.model;

import java.util.Date;

/**
 * 用户模型
 */
public class User {
    private int id;//账号
    private int psd;//密码
    private Date zcTime;//注册时间

    public User(int id, int psd,Date zcTime) {
        this.id = id;
        this.psd = psd;
        this.zcTime = zcTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPsd() {
        return psd;
    }

    public void setPsd(int psd) {
        this.psd = psd;
    }

    public Date getZcTime() {
        return zcTime;
    }

    public void setZcTime(Date zcTime) {
        this.zcTime = zcTime;
    }
}
