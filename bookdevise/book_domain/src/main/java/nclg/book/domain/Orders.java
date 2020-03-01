package nclg.book.domain;

import nclg.book.utils.DateUtils;

import java.math.BigDecimal;
import java.util.Date;

public class Orders {
    private Integer id;
    private String uname;
    private String bname;
    //@DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date time;
    private String timesrc;
    private BigDecimal money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getTimesrc() {
        if (time != null) {
            timesrc = DateUtils.date2String(time, "yyyy-MM-dd HH:mm");
        }
        return timesrc;
    }
    public void setTimesrc(String timesrc) {
        this.timesrc = timesrc;
    }
}
