package ru.rass.api.models;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Class Customer.
 *
 * @version 1.0
 * @autor Fadesml
 */

@Entity
@Table(name = "customers")
@Getter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String firstName, lastName, middleName;
    @NotBlank
    @Size(max = 6)
    private String passportNumber;
    @NotBlank
    @Size(max = 4)
    private String passportSerial;

    @NotBlank
    private String photoPath;

    private int balance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    private Card card;

    @NotBlank
    @Size(max = 120)
    private String secret;

    public static Customer.Builder builder() {
        return new Customer().new Builder();
    }

    public class Builder {

        private Builder() {
            // private constructor
        }

        public Customer.Builder setId(Long id) {
            Customer.this.id = id;

            return this;
        }

        public Customer.Builder setFirstName(String firstName) {
            Customer.this.firstName = firstName;

            return this;
        }

        public Customer.Builder setLastName(String lastName) {
            Customer.this.lastName = lastName;

            return this;
        }
        public Customer.Builder setMiddleName(String middleName) {
            Customer.this.middleName = middleName;

            return this;
        }
        public Customer.Builder setPassportNumber(String passportNumber) {
            Customer.this.passportNumber = passportNumber;

            return this;
        }
        public Customer.Builder setPassportSerial(String passportSerial) {
            Customer.this.passportSerial = passportSerial;

            return this;
        }
        public Customer.Builder setPhotoPath(String photoPath) {
            Customer.this.photoPath = photoPath;

            return this;
        }
        public Customer.Builder setBalance(Integer balance) {
            Customer.this.balance = balance;

            return this;
        }
        public Customer.Builder setSecret(String secret) {
            Customer.this.secret = secret;

            return this;
        }

        public Customer build() {
            return Customer.this;
        }

    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                ", passportSerial='" + passportSerial + '\'' +
                ", photoPath='" + photoPath + '\'' +
                ", balance=" + balance +
                ", card=" + card +
                ", secret='" + secret + '\'' +
                '}';
    }
}
