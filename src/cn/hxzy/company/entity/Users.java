package cn.hxzy.company.entity;


public class Users {

  private Integer id;
  private String loginName;
  private String loginPassword;

  public Users() {
  }

  public Users(String loginName, String loginPassword) {
    this.loginName = loginName;
    this.loginPassword = loginPassword;
  }

  public Users(Integer id, String loginName, String loginPassword) {
    this.id = id;
    this.loginName = loginName;
    this.loginPassword = loginPassword;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }

  public String getLoginPassword() {
    return loginPassword;
  }

  public void setLoginPassword(String loginPassword) {
    this.loginPassword = loginPassword;
  }

  @Override
  public String toString() {
    return "Users{" +
            "id=" + id +
            ", username='" + loginName + '\'' +
            ", password='" + loginPassword + '\'' +
            '}';
  }
}
