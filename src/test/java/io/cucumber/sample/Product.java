package io.cucumber.sample;

public class Product {
  private String description;
  private int price;
  private int quantities;

  public Product(String description, String price, String quantities) {
    this.description = description;
    this.quantities = quantities == null ? null : Integer.parseInt(quantities);

    if (price != null) {
      String[] monetaryValue = price.split("Rs. ");
      this.price = Integer.parseInt(monetaryValue[1]);
    }
  }
  public String getDescription() {
    return description;
  }

  public int getPrice() {
    return price;
  }

  public int getQuantities() {
    return quantities;
  }

}
