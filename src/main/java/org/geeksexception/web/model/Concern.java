package org.geeksexception.web.model;

public class Concern {
	
	private String name;
	
	private String phone;
	
	private String email;
	
	private String concern;
	
	public Concern() { }

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the concern
	 */
	public String getConcern() {
		return concern;
	}

	/**
	 * @param concern the concern to set
	 */
	public void setConcern(String concern) {
		this.concern = concern;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Concern [name=" + name + ", phone=" + phone + ", email="
				+ email + ", concern=" + concern + "]";
	}
	
}