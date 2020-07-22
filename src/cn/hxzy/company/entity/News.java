package cn.hxzy.company.entity;


import java.util.Date;

public class News extends NewsExt {

    private Integer id;
    private String name;
    private String value;
    private Date date;
    private Integer usersId;

    public News() {
    }

    public News(Integer id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public News(String name, String value, Date date, Integer usersId) {
        this.name = name;
        this.value = value;
        this.date = date;
        this.usersId = usersId;
    }

    public News(Integer id, String name, String value, Date date, Integer usersId, String loginName) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.date = date;
        Users users = new Users();
        users.setId(usersId);
        this.usersId = usersId;
        users.setLoginName(loginName);
        this.setUsers(users);
    }


    public News(Integer id, String name, String value, Date date, Integer usersId) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.date = date;
        this.usersId = usersId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", date=" + date +
                ", member=" + usersId +
                '}';
    }
}
