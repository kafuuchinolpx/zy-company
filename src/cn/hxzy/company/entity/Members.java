package cn.hxzy.company.entity;


public class Members {

  private Integer id;
  private String name;
  private Integer age;
  private String image;
  private String work;

  public Members() {
  }

  public Members(String name, Integer age, String image, String work) {
    this.name = name;
    this.age = age;
    this.image = image;
    this.work = work;
  }

  public Members(Integer id, String name, Integer age, String image, String work) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.image = image;
    this.work = work;
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

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getWork() {
    return work;
  }

  public void setWork(String work) {
    this.work = work;
  }

  @Override
  public String toString() {
    return "Members{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", age=" + age +
            ", image='" + image + '\'' +
            ", work='" + work + '\'' +
            '}';
  }
}
