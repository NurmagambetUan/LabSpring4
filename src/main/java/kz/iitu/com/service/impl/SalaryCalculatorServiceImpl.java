package kz.iitu.com.service.impl;

import kz.iitu.com.entity.EmployeeType;
import kz.iitu.com.entity.Employee;
import kz.iitu.com.repo.UserRepository;
import kz.iitu.com.service.SalaryCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class SalaryCalculatorServiceImpl implements SalaryCalculatorService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void rewardSalariedCommissionEmployees(double persent) {
        userRepository.rewardSalariedCommissionEmployees(persent, EmployeeType.SALARIED_COMMISION);
    }

    @Override
    public void salaryHourlyEmployees() {
        userRepository.salaryHourlyEmployees(1.5, 40, EmployeeType.HOURLY);
    }

    @Override
    public void salaryCommisionAndSalariedCommision() {
        userRepository.salaryCommisionAndSalariedCommision(EmployeeType.COMMISION, EmployeeType.SALARIED_COMMISION);
    }

    @Override
    public Collection<Employee> employeeList() {
        return userRepository.findAllActiveUsersNative();
    }

    @Override
    public List<Employee> getByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public void createEmployee(Employee employee) {
        userRepository.insertWithQuery(employee);
    }

    @Override
    public void updateEmployee(Long id) {
        Optional<Employee> employee = userRepository.findById(id);
        System.out.println(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        userRepository.deleteById(id);
    }
}
