package kz.iitu.com.controller;

import kz.iitu.com.entity.Employee;
import kz.iitu.com.service.SalaryCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private SalaryCalculatorService salaryCalculatorService;
    public List<Employee> getByName(String name){
        return salaryCalculatorService.getByName(name);
    }
    public void createEmployee(Employee employee) {
        salaryCalculatorService.createEmployee(employee);
    }

    public void employeeList() {
        salaryCalculatorService.employeeList();
    }

    public void deleteEmployee(Long id) {
        salaryCalculatorService.deleteEmployee(id);
    }

    public List<Employee> findByName(String name) {
        return salaryCalculatorService.getByName(name);
    }

    public void updateEmployee(Long id) {
        salaryCalculatorService.updateEmployee(id);
    }

    public void rewardSalariedCommissionEmployees(int persent) {
        salaryCalculatorService.rewardSalariedCommissionEmployees(persent);
    }

    public void salaryHourlyEmployees(){
        salaryCalculatorService.salaryHourlyEmployees();
    }
    public void salaryCommisionAndSalariedCommision(){
        salaryCalculatorService.salaryCommisionAndSalariedCommision();
    }
    }
