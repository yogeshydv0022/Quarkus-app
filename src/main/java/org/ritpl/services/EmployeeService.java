package org.ritpl.services;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.ritpl.dto.request.EmployeeDto;
import org.ritpl.entities.Employee;
import org.ritpl.exciption.model.ResourceConflictException;
import org.ritpl.exciption.model.ResourceNotFoundException;
import org.ritpl.repositorys.EmployeeRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class EmployeeService {

    @Inject
    private EmployeeRepository employeeRepository;


    @Transactional
    public Employee createEmployee(EmployeeDto employeeDto) {
        // Check if email or phone number already exists
        Optional<Employee> existingEmployeeByEmail = employeeRepository.findByEmail(employeeDto.getEmail());
        if (existingEmployeeByEmail.isPresent()) {
            throw new ResourceConflictException("Employee with email already exists: " + employeeDto.getEmail());
        }
        Optional<Employee> existingEmployeeByPhone = employeeRepository.findByPhone(employeeDto.getPhone());
        if (existingEmployeeByPhone.isPresent()) {
            throw new ResourceConflictException("Employee with phone number already exists: " + employeeDto.getPhone());
        }
        Employee employee = new Employee();
//        employee1.setId(employee1.getId());
        employee.setFullName(employeeDto.getFullName());
        employee.setEmail(employeeDto.getEmail());
        employee.setPhone(employeeDto.getPhone());
        employee.setTechnologyType(employeeDto.getTechnologyType());
        employee.setSalary(employeeDto.getSalary());
        employee.setJoinDate(LocalDate.now());
        // If not found, persist the new employee
        employeeRepository.persist(employee);
        return employee;
    }

    @Transactional
    public Employee updateEmployee(Long id, EmployeeDto employee) {
        Employee existingEmployee = employeeRepository.findByIdOptional(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        existingEmployee.setFullName(employee.getFullName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPhone(employee.getPhone());
        existingEmployee.setTechnologyType(employee.getTechnologyType());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setJoinDate(LocalDate.now());
        return existingEmployee;
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findByIdOptional(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.listAll();
        if (employees.isEmpty()) {
            throw new ResourceNotFoundException("No employees found");
        }
        return employees;
    }

    @Transactional
    public String deleteEmployee(Long id) {
        Employee employee = employeeRepository.findByIdOptional(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        employeeRepository.delete(employee);
        return "Employee deleted with id: " + id + "successfully!";
    }
}

