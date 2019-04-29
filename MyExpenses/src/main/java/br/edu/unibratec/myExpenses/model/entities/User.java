package br.edu.unibratec.myExpenses.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long aIdentifier;

	private String		aName;
	
	/*
	 * @Temporal(TemporalType.DATE) private Date aBirthday;
	 */
	
	private String		aEmail;

	private String aPassword;

	public User(
		String aName, 
		//Date aBirthday, 
		String aEmail, 
		String aPassword
	) {
		super();
		this.aName = aName;
		//this.aBirthday = aBirthday;
		this.aEmail = aEmail;
		this.aPassword = aPassword;
	}

	public long getIdentifier() {
		return aIdentifier;
	}

	public void setIdentifier(long aIdentifier) {
		this.aIdentifier = aIdentifier;
	}

	public String getName() {
		return aName;
	}

	public void setName(String aName) {
		this.aName = aName;
	}

	/*
	 * public Date getBirthday() { return aBirthday; }
	 * 
	 * public void setBirthday(Date aBirthday) { this.aBirthday = aBirthday; }
	 */

	public String getEmail() {
		return aEmail;
	}

	public void setEmail(String aEmail) {
		this.aEmail = aEmail;
	}

	public String getPassword() {
		return aPassword;
	}

	public void setPassword(String aPassword) {
		this.aPassword = aPassword;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((aBirthday == null) ? 0 : aBirthday.hashCode());
		result = prime * result + ((aEmail == null) ? 0 : aEmail.hashCode());
		result = prime * result + (int) (aIdentifier ^ (aIdentifier >>> 32));
		result = prime * result + ((aName == null) ? 0 : aName.hashCode());
		result = prime * result + ((aPassword == null) ? 0 : aPassword.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		
		/*
		 * if (aBirthday == null) { if (other.aBirthday != null) return false; } else if
		 * (!aBirthday.equals(other.aBirthday)) return false;
		 */
		
		if (aEmail == null) {
			if (other.aEmail != null)
				return false;
		} else if (!aEmail.equals(other.aEmail))
			return false;
		if (aIdentifier != other.aIdentifier)
			return false;
		if (aName == null) {
			if (other.aName != null)
				return false;
		} else if (!aName.equals(other.aName))
			return false;
		if (aPassword == null) {
			if (other.aPassword != null)
				return false;
		} else if (!aPassword.equals(other.aPassword))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [aIdentifier="		+ aIdentifier + 
					", aName="			+ aName + 
				//	", aBirthday="		+ aBirthday + 
					", aEmail="			+ aEmail + 
					", aPassword="		+ aPassword + "]";
	}
	
}