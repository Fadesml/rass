package ru.rass.api.models;

import lombok.Getter;

import javax.persistence.*;

/**
 * Class Access.
 *
 * @version 1.0
 * @autor Fadesml
 */
@Entity
@Table(name = "accesses")
@Getter
public class Access {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String name;

    public Access() { }

    public static Builder builder() {
        return new Access().new Builder();
    }

    public class Builder {

        private Builder() {
            // private constructor
        }

        public Builder setId(Long id) {
            Access.this.id = id;

            return this;
        }

        public Builder setName(String name) {
            Access.this.name = name;

            return this;
        }

        public Access build() {
            return Access.this;
        }

    }

    @Override
    public String toString() {
        return "Access{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
