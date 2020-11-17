package ru.rass.api.payload.response;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private String email;
	private String role;

	public static Builder builder() {
		return new JwtResponse().new Builder();
	}

	public class Builder {
		private Builder() {
			// private constructor
		}

		public Builder setToken(String token) {
			JwtResponse.this.token = token;
			return this;
		}

		public Builder setId(Long id) {
			JwtResponse.this.id = id;
			return this;
		}

		public Builder setUsername(String username) {
			JwtResponse.this.username = username;
			return this;
		}

		public Builder setEmail(String email) {
			JwtResponse.this.email = email;
			return this;
		}

		public Builder setRole(String role) {
			JwtResponse.this.role = role;
			return this;
		}

		public JwtResponse build() {
			return JwtResponse.this;
		}

	}
}
