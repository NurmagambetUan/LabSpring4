package kz.iitu.com.service;

import kz.iitu.com.entity.Employee;

import java.util.Collection;
import java.util.List;

public interface SalaryCalculatorService {
    void rewardSalariedCommissionEmployees(double persent);
    List<Employee> getByName(String name);
    Collection<Employee> employeeList();
    void createEmployee(Employee employee);
    void updateEmployee(Long id);
    void deleteEmployee(Long id);
    void salaryHourlyEmployees();
    void salaryCommisionAndSalariedCommision();
}
