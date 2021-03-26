package com.vlad.wordysentences.repositories;

import com.vlad.wordysentences.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
//    Optional<Customer> findCustomerByName(String name);
}
