package br.edu.unibratec.myExpenses.model.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class AddressPK implements Serializable {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 6539444810312647971L;
	
	private String	aZipCode;
	private Short	aNumber;
	
	public AddressPK() {}

	public String getZipCode() {
		return aZipCode;
	}
	
	public void setZipCode(String aZipCode) {
		this.aZipCode = aZipCode;
	}

	public Short getNumber() {
		return aNumber;
	}

	public void setNumber(Short aNumber) {
		this.aNumber = aNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aZipCode	== null) ? 0 : aZipCode	.hashCode());
		result = prime * result + ((aNumber		== null) ? 0 : aNumber	.hashCode());
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
		AddressPK other = (AddressPK) obj;
		if (aZipCode == null) {
			if (other.aZipCode != null)
				return false;
		} else if (!aZipCode.equals(other.aZipCode))
			return false;
		if (aNumber == null) {
			if (other.aNumber != null)
				return false;
		} else if (!aNumber.equals(other.aNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AddressPK [ZipCode=" + aZipCode + 
						", Number=" + aNumber + "]";
	}
	
}
