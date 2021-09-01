package org.programmers.kdt.customer.repository;

import org.programmers.kdt.customer.Customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {
    Customer insert(Customer customer);
    default void deleteCustomer(Customer customer) {
        deleteCustomer(customer.getCustomerId());
    }
    void deleteCustomer(UUID customerId);

    Optional<Customer> findById(UUID customerId);
    List<Customer> findByName(String name);
    Optional<Customer> findByEmail(String email);

    List<Customer> findAll();

    Customer registerToBlacklist(Customer customer);
    List<Customer> findAllBlacklistCustomer();

    void deleteAll();
}
