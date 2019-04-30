package br.edu.unibratec.myExpenses.model.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long							aIdentifier;
	
	@OneToOne
	private User							aUserOwner;
	
	@OneToMany
	private List<FinancialTransaction>		aTransactions;
	
	public Account(User aUserOwner, List<FinancialTransaction> aTransactions) {
		super();
		this.aUserOwner = aUserOwner;
		this.aTransactions = aTransactions;
	}
	public long getaIdentifier() {
		return aIdentifier;
	}
	public void setaIdentifier(long aIdentifier) {
		this.aIdentifier = aIdentifier;
	}
	public User getaUserOwner() {
		return aUserOwner;
	}
	public void setaUserOwner(User aUserOwner) {
		this.aUserOwner = aUserOwner;
	}
	public List<FinancialTransaction> getaTransactions() {
		return aTransactions;
	}
	public void setaTransactions(List<FinancialTransaction> aTransactions) {
		this.aTransactions = aTransactions;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (aIdentifier ^ (aIdentifier >>> 32));
		result = prime * result + ((aTransactions == null) ? 0 : aTransactions.hashCode());
		result = prime * result + ((aUserOwner == null) ? 0 : aUserOwner.hashCode());
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
		Account other = (Account) obj;
		if (aIdentifier != other.aIdentifier)
			return false;
		if (aTransactions == null) {
			if (other.aTransactions != null)
				return false;
		} else if (!aTransactions.equals(other.aTransactions))
			return false;
		if (aUserOwner == null) {
			if (other.aUserOwner != null)
				return false;
		} else if (!aUserOwner.equals(other.aUserOwner))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Account [aIdentifier=" + aIdentifier + ", aUserOwner=" + aUserOwner + ", aTransactions=" + aTransactions
				+ "]";
	}
	
}