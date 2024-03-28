package com.springbooteshop.SpringBootEShop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
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

  @Setter
  @Column(name = "surname", nullable = false)
  @NotBlank(message = "{billing.surname.notBlank}")
  @Size(max = 50, message = "{billing.surname.maxSize}")
  private String surname;

  @Getter
  @Column(name = "country_region", nullable = false)
  @NotBlank(message = "{billing.countryRegion.notBlank}")
  @Size(max = 55, message = "{billing.countryRegion.maxSize}")
  private String countryRegion;

  @Setter
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

  @Setter
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
