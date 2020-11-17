package ru.rass.api.models;

import lombok.Getter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Entity
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "role_accesses",
			joinColumns = @JoinColumn(name = "role_id"),
			inverseJoinColumns = @JoinColumn(name = "access_id"))
	private Set<Access> accesses = new HashSet<>();

	public Role() {

	}

	public static Role.Builder builder() {
		return new Role().new Builder();
	}

	public class Builder {

		private Builder() {
			// private constructor
		}

		public Role.Builder setId(Long id) {
			Role.this.id = id;

			return this;
		}

		public Role.Builder setName(String name) {
			Role.this.name = name;

			return this;
		}

		public Role build() {
			return Role.this;
		}

	}

	@Override
	public String toString() {
		return "Role{" +
				"id=" + id +
				", name='" + name + '\'' +
				", accesses=" + accesses +
				'}';
	}
}