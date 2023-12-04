package io.cucumber.sample;

public abstract class AbstractUser {
  protected String username;
  protected String email;

  protected String password;
  protected String userFirstname;
  protected String userLastname;
  protected String address;
  protected String state;
  protected String city;
  protected String zipCode;
  protected String phone;

  protected AbstractUser(String username, String email) {
    this.username = username;
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public String getEmail() {
    return email;
  }

  public String getUserFirstname() {
    return userFirstname == null ? "John" : userFirstname;
  }


  public String getUserLastname() {
    return userLastname == null ? "Smith" : userLastname;
  }

  public String getAddress() {
    return address == null ? "Calle 1" : address;
  }

  public String getState() {
    return state == null ? "Barcelona" : state;
  }

  public String getCity() {
    return city == null ? "Barcelona" : city;
  }

  public String getZipCode() {
    return zipCode == null ? "01234" : zipCode;
  }

  public String getPhone() {
    return phone == null ? "1234567" : phone;
  }

  public String getPassword() {
    return password;
  }

  public void setUserFirstname(String userFirstname) {
    this.userFirstname = userFirstname;
  }

  public void setUserLastname(String userLastname) {
    this.userLastname = userLastname;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setState(String state) {
    this.state = state;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
