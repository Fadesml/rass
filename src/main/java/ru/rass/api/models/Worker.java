package ru.rass.api.models;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "workers",
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
@Getter
public class Worker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	private String firstName, lastName, middleName;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id", referencedColumnName = "id")
	private Role role;

	public Worker() {
	}

	public static Worker.Builder builder() {
		return new Worker().new Builder();
	}

	public class Builder {

		private Builder() {
			// private constructor
		}

		public Worker.Builder setId(Long id) {
			Worker.this.id = id;

			return this;
		}

		public Worker.Builder setUsername(String username) {
			Worker.this.username = username;

			return this;
		}

		public Worker.Builder setFirstName(String firstName) {
			Worker.this.firstName = firstName;

			return this;
		}

		public Worker.Builder setLastName(String lastName) {
			Worker.this.lastName = lastName;

			return this;
		}
		public Worker.Builder setMiddleName(String middleName) {
			Worker.this.middleName = middleName;

			return this;
		}
		public Worker.Builder setEmail(String email) {
			Worker.this.email = email;

			return this;
		}
		public Worker.Builder setPassword(String password) {
			Worker.this.password = password;

			return this;
		}

		public Worker build() {
			return Worker.this;
		}

	}

	@Override
	public String toString() {
		return "Worker{" +
				"id=" + id +
				", username='" + username + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", middleName='" + middleName + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", role=" + role +
				'}';
	}
}
