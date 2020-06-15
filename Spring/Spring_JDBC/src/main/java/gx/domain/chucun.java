package gx.domain;

public class chucun {
    private int id;
    private int userid;
    private int money;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "chucun{" +
                "id=" + id +
                ", userid=" + userid +
                ", money=" + money +
                '}';
    }
}
