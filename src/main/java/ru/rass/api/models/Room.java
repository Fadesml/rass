package ru.rass.api.models;

import lombok.Getter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Class Room.
 *
 * @version 1.0
 * @autor Fadesml
 */
@Entity
@Getter
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "room_cards",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "card_id"))
    private Set<Card> cards = new HashSet<>();

    public static Room.Builder builder() {
        return new Room().new Builder();
    }

    public class Builder {

        private Builder() {
            // private constructor
        }

        public Room.Builder setId(Long id) {
            Room.this.id = id;

            return this;
        }

        public Room.Builder setName(String number) {
            Room.this.number = number;

            return this;
        }

        public Room build() {
            return Room.this;
        }

    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", cards=" + cards +
                '}';
    }
}
