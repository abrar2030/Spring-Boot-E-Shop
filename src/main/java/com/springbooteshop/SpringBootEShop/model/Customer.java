package com.springbooteshop.SpringBootEShop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customers")
public class Customer {

  @Setter
  @Getter
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Setter
  @Getter
  @Column(name = "name", nullable = false)
  @NotBlank(message = "{billing.name.notBlank}")
  @Size(max = 50, message = "{billing.name.maxSize}")
  private String name;

  @Column(name = "surname", nullable = false)
  @NotBlank(message = "{billing.surname.notBlank}")
  @Size(max = 50, message = "{billing.surname.maxSize}")
  private String surname;

  @Getter
  @Column(name = "country_region", nullable = false)
  @NotBlank(message = "{billing.countryRegion.notBlank}")
  @Size(max = 55, message = "{billing.countryRegion.maxSize}")
  private String countryRegion;

  @Column(name = "street_and_house_number", nullable = false)
  @NotBlank(message = "{billing.streetAndHouseNumber.notBlank}")
  @Size(max = 100, message = "{billing.streetAndHouseNumber.maxSize}")
  private String streetAndHouseNumber;

  @Getter
  @Column(name = "city", nullable = false)
  @NotBlank(message = "{billing.city.notBlank}")
  @Size(max = 60, message = "{billing.city.maxSize}")
  private String city;

  @Getter
  @Column(name = "postal_code", nullable = false)
  @NotBlank(message = "{billing.postalCode.notBlank}")
  @Size(max = 18, message = "{billing.postalCode.maxSize}")
  private String postalCode;

  @Column(name = "phone_number", nullable = false)
  @NotBlank(message = "{billing.phoneNumber.notBlank}")
  @Size(max = 15, message = "{billing.phoneNumber.maxSize}")
  private String phoneNumber;

  @Getter
  @Column(name = "email", nullable = false)
  @NotBlank(message = "{billing.email.notBlank}")
  @Size(max = 254, message = "{billing.email.maxSize}")
  @Email
  private String email;

  public Customer() {}

  public Customer(
      Long id,
      String name,
      String surname,
      String countryRegion,
      String streetAndHouseNumber,
      String city,
      String postalCode,
      String phoneNumber,
      String email) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.countryRegion = countryRegion;
    this.streetAndHouseNumber = streetAndHouseNumber;
    this.city = city;
    this.postalCode = postalCode;
    this.phoneNumber = phoneNumber;
    this.email = email;
  }

  @Override
  public String toString() {
    return "Customer [id="
        + id
        + ", name="
        + name
        + ", surname="
        + surname
        + ", countryRegion="
        + countryRegion
        + ", streetAndHouseNumber="
        + streetAndHouseNumber
        + ", city="
        + city
        + ", postalCode="
        + postalCode
        + ", phoneNumber="
        + phoneNumber
        + ", email="
        + email
        + "]";
  }
}
