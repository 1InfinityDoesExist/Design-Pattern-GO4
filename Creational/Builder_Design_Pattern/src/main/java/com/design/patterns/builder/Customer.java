package com.design.patterns.builder;

public class Customer {

	private final String name;
	private final String email;

	private Customer(CustomerBuilder customerBuilder) {
		this.name = customerBuilder.name;
		this.email = customerBuilder.email;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public static class CustomerBuilder {
		private String name;
		private String email;

		public CustomerBuilder name(String name) {
			this.name = name;
			return this;
		}

		public CustomerBuilder email(String email) {
			this.email = email;
			return this;
		}

		public Customer build() {
			if (name == null || name.trim().isEmpty()) {
				throw new IllegalStateException("name is required");
			}
			if (email == null || email.trim().isEmpty()) {
				throw new IllegalStateException("email is required");
			}
			return new Customer(this);
		}

	}

	@Override
	public String toString() {
		return "Customer{name=" + name + ", email=" + email + "}";
	}

}
