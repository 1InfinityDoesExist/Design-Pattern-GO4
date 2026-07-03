package com.design.patterns.builderPattern;

public class Customer {

	private String name;
	private String email;

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
			return new Customer(this);
		}

	}

	@Override
	public String toString() {
		return super.toString();
	}

}
