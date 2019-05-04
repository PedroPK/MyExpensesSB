package br.edu.unibratec.myExpenses.model.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Address implements EntityInterface {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -4641149132328126273L;

	@EmbeddedId
	private AddressPK	aAddressPK;
	
	private String		aStreedAvenue;
	private String		aNeighborhood;
	private String		aCity;
	private String		aState;
	private String		aCountry;
	
	public Address() {}
	
	public String getZipCode() {
		return aAddressPK.getZipCode();
	}
	
	public void setZipCode(String aZipCode) {
		initializeAddressPKifNeeded();
		
		this.aAddressPK.setZipCode(aZipCode);
	}

	private void initializeAddressPKifNeeded() {
		if ( this.aAddressPK == null ) {
			this.aAddressPK = new AddressPK();
		}
	}

	public Short getNumber() {
		return this.aAddressPK.getNumber();
	}

	public void setNumber(Short aNumber) {
		initializeAddressPKifNeeded();
		
		this.aAddressPK.setNumber(aNumber);
	}
	
	/*public AddressPK getAddress() {
		return aAddress;
	}

	public void setAddress(AddressPK pAddress) {
		this.aAddress = pAddress;
	}*/

	public String getStreetAvenue() {
		return aStreedAvenue;
	}

	public void setStreetAvenue(String pStreetAvenue) {
		this.aStreedAvenue = pStreetAvenue;
	}

	public String getNeighborhood() {
		return aNeighborhood;
	}

	public void setNeighborhood(String pNeighborhood) {
		this.aNeighborhood = pNeighborhood;
	}

	public String getCity() {
		return aCity;
	}

	public void setCity(String pCity) {
		this.aCity = pCity;
	}

	public String getState() {
		return aState;
	}

	public void setState(String pState) {
		this.aState = pState;
	}

	public String getCountry() {
		return aCountry;
	}

	public void setCountry(String pCountry) {
		this.aCountry = pCountry;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aNeighborhood	== null)	? 0 : aNeighborhood	.hashCode());
		result = prime * result + ((aCity			== null)	? 0 : aCity			.hashCode());
		result = prime * result + ((aAddressPK		== null)	? 0 : aAddressPK		.hashCode());
		result = prime * result + ((aState			== null)	? 0 : aState		.hashCode());
		result = prime * result + ((aStreedAvenue	== null)	? 0 : aStreedAvenue	.hashCode());
		result = prime * result + ((aCountry		== null)	? 0 : aCountry		.hashCode());
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
		Address other = (Address) obj;
		if (aNeighborhood == null) {
			if (other.aNeighborhood != null)
				return false;
		} else if (!aNeighborhood.equals(other.aNeighborhood))
			return false;
		if (aCity == null) {
			if (other.aCity != null)
				return false;
		} else if (!aCity.equals(other.aCity))
			return false;
		if (aAddressPK == null) {
			if (other.aAddressPK != null)
				return false;
		} else if (!aAddressPK.equals(other.aAddressPK))
			return false;
		if (aState == null) {
			if (other.aState != null)
				return false;
		} else if (!aState.equals(other.aState))
			return false;
		if (aStreedAvenue == null) {
			if (other.aStreedAvenue != null)
				return false;
		} else if (!aStreedAvenue.equals(other.aStreedAvenue))
			return false;
		if (aCountry == null) {
			if (other.aCountry != null)
				return false;
		} else if (!aCountry.equals(other.aCountry))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [addressPK=" + aAddressPK + 
				", streetOrAvenue=" + aStreedAvenue + 
				", neighborhood=" + aNeighborhood +
				", city=" + aCity + 
				", state=" + aState + 
				", country=" + aCountry + "]";
	}

	@Override
	public Object getPrimaryKey() {
		return this.aAddressPK;
	}
	
}
