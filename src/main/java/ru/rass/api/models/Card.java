package ru.rass.api.models;

import lombok.Getter;

import javax.persistence.*;

/**
 * Class Card.
 *
 * @version 1.0
 * @autor Fadesml
 */
@Entity
@Table(name = "cards")
@Getter
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rfid;

    public static Card.Builder builder() {
        return new Card().new Builder();
    }

    public class Builder {

        private Builder() {
            // private constructor
        }

        public Card.Builder setId(Long id) {
            Card.this.id = id;

            return this;
        }

        public Card.Builder setRfid(String rfid) {
            Card.this.rfid = rfid;

            return this;
        }

        public Card build() {
            return Card.this;
        }

    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", rfid='" + rfid + '\'' +
                '}';
    }
}
