package cn.hxzy.company.entity;


import java.util.Date;

public class Works extends WorksExt{

  private Integer id;
  private String name;
  private String image;
  private String value;
  private Date date;
  private Integer usersId;

  public Works() {
  }

  public Works(Integer id, String name, String image, String value) {
    this.id = id;
    this.name = name;
    this.image = image;
    this.value = value;
  }

  public Works(String name, String image, String value, Date date, Integer usersId) {
    this.name = name;
    this.image = image;
    this.value = value;
    this.date = date;
    this.usersId = usersId;
  }

  public Works(Integer id, String name, String image, String value, Date date, Integer usersId, String loginName) {
    this.id = id;
    this.name = name;
    this.image = image;
    this.value = value;
    this.date = date;
    Users users = new Users();
    users.setId(usersId);
    this.usersId = usersId;
    users.setLoginName(loginName);
    this.setUsers(users);
  }

  public Works(Integer id, String name, String image, String value, Date date, Integer usersId) {
    this.id = id;
    this.name = name;
    this.image = image;
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

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
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

  public Integer getUsersId() {
    return usersId;
  }

  public void setUsersId(Integer usersId) {
    this.usersId = usersId;
  }

  @Override
  public String toString() {
    return "Works{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", image='" + image + '\'' +
            ", value='" + value + '\'' +
            ", date=" + date +
            ", member=" + usersId +
            '}';
  }
}
