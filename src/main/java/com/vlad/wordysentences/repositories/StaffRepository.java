package com.vlad.wordysentences.repositories;

import com.vlad.wordysentences.models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {
//    Optional<Customer> findCustomerByName(String name);
}
