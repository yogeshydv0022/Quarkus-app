package org.ritpl.repositorys;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.ritpl.entities.Employee;

import java.util.Optional;


@ApplicationScoped
public class EmployeeRepository implements PanacheRepository<Employee> {

    public Optional<Employee> findByEmail(String email) {
        return find("email", email).firstResultOptional();
    }

    public Optional<Employee> findByPhone(long phone) {
        return find("phone", phone).firstResultOptional();
    }
}
