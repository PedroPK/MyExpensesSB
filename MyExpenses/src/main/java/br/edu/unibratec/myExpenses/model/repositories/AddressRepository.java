package br.edu.unibratec.myExpenses.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unibratec.myExpenses.model.entities.Address;
import br.edu.unibratec.myExpenses.model.entities.AddressPK;

@Repository
public interface AddressRepository extends JpaRepository<Address, AddressPK> {}