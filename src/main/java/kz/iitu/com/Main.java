package kz.iitu.com;

import kz.iitu.com.config.Config;
import kz.iitu.com.controller.UserController;
import kz.iitu.com.entity.EmployeeType;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        UserController userController = context.getBean("userController", UserController.class);
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите Процесс: \n" +
                    "1. Добавить сотрудника \n" +
                    "2. Удалить сотрудника \n" +
                    "3. Редактировать данные сотрудника \n" +
                    "4. Список сотрудников \n" +
                    "5. Найти сотрудника по имени \n" +
                    "6. Награда Наемно-комиссионных сотрудников \n" +
                    "7. 1,5 коэф. Для почасовых сотрудников \n" +
                    "8. Изменение заработной платы сотрудников «Комисионных» и «Наемно-комиссионных». \n" +
                    "0. Завершить");
            int choise = in.nextInt();
            switch (choise) {
                case 1:
                    System.out.println("Номер сотрудника: ");
                    int id = in.nextInt();
                    System.out.println("ФИО сотрудника: ");
                    String fullName = in.next();
                    System.out.println("Зарплата:");
                    int salary = in.nextInt();
                    System.out.println("Часовая ставка:");
                    double hourRate = in.nextDouble();
                    System.out.println("Введите тип сотрудника: \n1. Наемный; \n2. Почасовая; \n3. Комиссия; \n4. Наемная комиссия; \nВыбор: ");
                    int choise1 = in.nextInt();
                    EmployeeType employeeType = null;
                    switch (choise1) {
                        case 1:
                            employeeType = EmployeeType.SALARIED;
                            break;
                        case 2:
                            employeeType = EmployeeType.HOURLY;
                            break;
                        case 3:
                            employeeType = EmployeeType.COMMISION;
                            break;
                        case 4:
                            employeeType = EmployeeType.SALARIED_COMMISION;
                            break;
                    }

                    break;

                case 2:
                    userController.employeeList();
                    System.out.println("Введите номер сотрудника:");
                    Long id1 = Long.valueOf(in.next());

                    userController.deleteEmployee(id1);
                    break;

                case 3:
                    userController.employeeList();
                    System.out.println("Введите номер сотрудника:");
                    Long id2 = in.nextLong();
                    userController.updateEmployee(id2);
                    break;

                case 4:
                    userController.employeeList();
                    break;

                case 5:
                    System.out.print("Имя сотрудника: ");
                    String name = in.next();
                    System.out.println(userController.findByName(name));
                    break;

                case 6:
                    userController.rewardSalariedCommissionEmployees(10);
                    break;

                case 7:
                    userController.salaryHourlyEmployees();
                    break;

                case 8:
                    userController.salaryCommisionAndSalariedCommision();
                    break;

                case 0:

                    return;
            }
        }
    }
}
