package br.edu.unibratec.myExpenses.model.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.edu.unibratec.myExpenses.model.enumeration.FinancialTransactionType;

@Entity
public class FinancialTransaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long aIdentifier;

	private FinancialTransactionType aFinancialTransactionType;
	private BigDecimal aValue;

	public FinancialTransaction(FinancialTransactionType aFinancialTransactionType, BigDecimal aValue) {
		super();
		this.aFinancialTransactionType = aFinancialTransactionType;
		this.aValue = aValue;
	}

	public long getaIdentifier() {
		return aIdentifier;
	}

	public void setaIdentifier(long aIdentifier) {
		this.aIdentifier = aIdentifier;
	}

	public FinancialTransactionType getaFinancialTransactionType() {
		return aFinancialTransactionType;
	}

	public void setaFinancialTransactionType(FinancialTransactionType aFinancialTransactionType) {
		this.aFinancialTransactionType = aFinancialTransactionType;
	}

	public BigDecimal getaValue() {
		return aValue;
	}

	public void setaValue(BigDecimal aValue) {
		this.aValue = aValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aFinancialTransactionType == null) ? 0 : aFinancialTransactionType.hashCode());
		result = prime * result + (int) (aIdentifier ^ (aIdentifier >>> 32));
		result = prime * result + ((aValue == null) ? 0 : aValue.hashCode());
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
		FinancialTransaction other = (FinancialTransaction) obj;
		if (aFinancialTransactionType != other.aFinancialTransactionType)
			return false;
		if (aIdentifier != other.aIdentifier)
			return false;
		if (aValue == null) {
			if (other.aValue != null)
				return false;
		} else if (!aValue.equals(other.aValue))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "FinancialTransaction [aIdentifier=" + aIdentifier + ", aFinancialTransactionType="
				+ aFinancialTransactionType + ", aValue=" + aValue + "]";
	}
	
}