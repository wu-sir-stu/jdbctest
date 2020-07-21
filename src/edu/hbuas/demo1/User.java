package edu.hbuas.demo1;


public class User {
  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", uname='" + uname + '\'' +
            ", pwd='" + pwd + '\'' +
            '}';
  }

  private long id;
  private String uname;
  private String pwd;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUname() {
    return uname;
  }

  public void setUname(String uname) {
    this.uname = uname;
  }


  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

}
