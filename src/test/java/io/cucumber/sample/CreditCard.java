package io.cucumber.sample;

public class CreditCard {
  private static final String DEFAULT_CVC = "123";
  private static final String DEFAULT_CARD_NUMBER = "1234567";
  private static final String DEFAULT_EXPIRATION_MONTH = "12";
  private static final String DEFAULT_EXPIRATION_YEAR = "2027";

  private final String name;
  private final String cvc;
  private final String expirationMonth;
  private final String expirationYear;
  private final String cardNumber;

  public static CreditCard getDefaultCard(String name) {
    return new CreditCard(name, DEFAULT_CARD_NUMBER, DEFAULT_CVC, DEFAULT_EXPIRATION_MONTH, DEFAULT_EXPIRATION_YEAR);
  }
  public CreditCard(String name, String cardNumber, String cvc, String expirationMonth, String expirationYear) {
    this.name = name;
    this.cardNumber = cardNumber;
    this.cvc = cvc;
    this.expirationMonth = expirationMonth;
    this.expirationYear = expirationYear;
  }

  public String getName() {
    return name;
  }

  public String getCvc() {
    return cvc;
  }

  public String getExpirationMonth() {
    return expirationMonth;
  }

  public String getExpirationYear() {
    return expirationYear;
  }

  public String getCardNumber() {
    return cardNumber;
  }
}
