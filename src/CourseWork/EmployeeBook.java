package CourseWork;

import java.lang.Integer;

public class EmployeeBook {
    private final Employee[] employees;
    private int size;

    public EmployeeBook() {
        this.employees = new Employee[15];
    }

    public void addEmployee(String fullName, int department, int salary) {
        checkDepartment(department);
        checkSalary(salary);
        if (size >= employees.length) {
            System.out.println("Нельзя добавить нового сотрудника, так как закончилось место.");
        }
        Employee newEmployee = new Employee(fullName, department, salary);
        employees[size++] = newEmployee;
    }

    public void removeEmployee(String fullName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getFullName().equals(fullName)) {
                System.out.println("Удален сотрудник: " + employees[i].getFullName());
                System.arraycopy(employees, i + 1, employees, i, size - i - 1);
                employees[size - 1] = null;
                size--;
                return;
            }
        }
        System.out.println("Сотрудник" + fullName + " не найден.");
    }

    public void printAllEmployees() {
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            System.out.println(employee);
        }
    }

    public int calculateTotalExpensesForSalary() {
        int totalSalary = 0;
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            totalSalary = totalSalary + employee.getSalary();
        }
        return totalSalary;
    }

    public int findMinimumSalary() {
        int minSalary = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
            }
        }
        return minSalary;
    }

    public void printEmployeeWithMinimumSalary(int minSalary) {
        System.out.println("Сотрудник(-и) с минимальной зарплатой:");
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getSalary() == minSalary) {
                System.out.println(employee);
            }
        }
    }

    public int findMaximumSalary() {
        int maxSalary = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
            }
        }
        return maxSalary;
    }

    public void printEmployeeWithMaximumSalary(int maxSalary) {
        System.out.println("Сотрудник(-и) с максимальной зарплатой:");
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getSalary() == maxSalary) {
                System.out.println(employee);
            }
        }
    }

    public int calculateAverageSalaryPerMonth() {
        int totalSalary = calculateTotalExpensesForSalary();
        return totalSalary / size;
    }

    public void printAllFullNames() {
        System.out.println("Полный перечень Ф.И.О всех сотрудников:");
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            String fullName = employee.getFullName();
            System.out.println(fullName);
        }
    }

    public void printAdjustedSalary(int increase) {
        checkSalaryIncrease(increase);
        System.out.printf("Полный перечень всех сотрудников с указанием зарплаты, проиндексированной на %d %%:\n",
                increase);
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            int increasedSalary = employee.getSalary() + employee.getSalary() * increase / 100;
            employee.setSalary(increasedSalary);
            System.out.println(employee);
        }
    }

    public Employee[] generateDepartmentEmployees(int department) {
        checkDepartment(department);
        int arraySize = 0;
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getDepartment() == department) {
                arraySize++;
            }
        }
        Employee[] departmentEmployees = new Employee[arraySize];
        for (int i = 0, j = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getDepartment() == department) {
                departmentEmployees[j] = employee;
                j++;
            }
        }
        return departmentEmployees;
    }

    public void printListOfDepartmentEmployees(Employee[] departmentEmployees) {
        System.out.println("Перечень всех сотрудников отдела с указанием зарплаты:\n");
        for (Employee departmentEmployee : departmentEmployees) {
            printEmployeesWithoutDepartment(departmentEmployee);
        }
        System.out.println();
    }

    public int findMinimumSalaryInDepartment(Employee[] departmentEmployees) {
        int minSalary = 100_000;
        for (Employee departmentEmployee : departmentEmployees) {
            if (departmentEmployee.getSalary() < minSalary) {
                minSalary = departmentEmployee.getSalary();
            }
        }
        return minSalary;
    }
    public void printEmployeeWithMinimumSalaryInDepartment(Employee[] departmentEmployees, int minSalary) {
        for (Employee departmentEmployee : departmentEmployees) {
            int department = departmentEmployee.getDepartment();
            if (departmentEmployee.getSalary() == minSalary) {
                System.out.println("Сотрудник(-и) с минимальной зарплатой в отделе " + department + ":");
                printEmployeesWithoutDepartment(departmentEmployee);
            }
        }
        System.out.println();
    }

    public int findMaximumSalaryInDepartment(Employee[] departmentEmployees) {
        int maxSalary = 0;
        for (Employee departmentEmployee : departmentEmployees) {
            if (departmentEmployee.getSalary() > maxSalary) {
                maxSalary = departmentEmployee.getSalary();
            }
        }
        return maxSalary;
    }

    public void printEmployeeWithMaximumSalaryInDepartment(Employee[] departmentEmployees, int maxSalary) {
        for (Employee departmentEmployee : departmentEmployees) {
            int department = departmentEmployee.getDepartment();
            if (departmentEmployee.getSalary() == maxSalary) {
                System.out.println("Сотрудник(-и) с максимальной зарплатой в отделе " + department + ":");
                printEmployeesWithoutDepartment(departmentEmployee);
            }
        }
        System.out.println();
    }

    public int calculateTotalExpensesForSalaryByDepartment(Employee[] departmentEmployees) {
        int totalSalary = 0;
        for (Employee departmentEmployee : departmentEmployees) {
            totalSalary = totalSalary + departmentEmployee.getSalary();
        }
        return totalSalary;
    }

    public int calculateAverageSalaryPerMonthByDepartment(Employee[] departmentEmployees) {
        int totalSalary = calculateTotalExpensesForSalaryByDepartment(departmentEmployees);
        return totalSalary / departmentEmployees.length;
    }

    public void printListOfEmployeesWithAdjustedSalaryByDepartment(Employee[] departmentEmployees, int increase) {
        checkSalaryIncrease(increase);
        System.out.printf("Перечень всех сотрудников отдела с указанием зарплаты, проиндексированной на %d %%:\n",
                increase);
        for (Employee departmentEmployee : departmentEmployees) {
            int increasedSalary = departmentEmployee.getSalary() + departmentEmployee.getSalary() * increase / 100;
            departmentEmployee.setSalary(increasedSalary);
            printEmployeesWithoutDepartment(departmentEmployee);
        }
    }

    public void findEmployeesWithSalaryEqualOrHigherThanNumber(int number) {
        System.out.printf("Перечень сотрудников с зарплатой больше или равно %d руб.:\n", number);
        int count = 0;
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getSalary() >= number) {
                count++;
                printEmployeesWithoutDepartment(employee);
            }
        }
        System.out.printf("Всего: %d чел.\n", count);
    }

    public void findEmployeesWithSalaryLowerThanNumber(int number) {
        System.out.printf("Перечень сотрудников с зарплатой меньше %d руб.:\n", number);
        int count = 0;
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getSalary() < number) {
                count++;
                printEmployeesWithoutDepartment(employee);
            }
        }
        System.out.printf("Всего: %d чел.\n", count);
    }

    public void printEmployeesWithoutDepartment(Employee employee) {
        System.out.println(employee.getId() + ". " + employee.getFullName() + ", зарплата: "
                + employee.getSalary() + " руб.");
    }

    public void changeSalary(String fullName, int newSalary) {
        checkSalary(newSalary);
        for (Employee employee : employees) {
            if (employee.getFullName().equals(fullName)) {
                employee.setSalary(newSalary);
                System.out.println("Обновленные данные по сотруднику " + fullName + " (изменение зарплаты):");
                System.out.println(employee);
                return;
            }
        }
        System.out.println("Сотрудник" + fullName + " не найден.");
    }

    public void changeDepartment(String fullName, int newDepartment) {
        checkDepartment(newDepartment);
        for (Employee employee : employees) {
            if (employee.getFullName().equals(fullName)) {
                employee.setDepartment(newDepartment);
                System.out.println("Обновленные данные по сотруднику " + fullName + " (изменение отдела):");
                System.out.println(employee);
                return;
            }
        }
        System.out.println("Сотрудник" + fullName + " не найден.");
    }

    public void printAllEmployeesByDepartment() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Отдел " + i);
            for (int j = 0; j < size; j++) {
                Employee employee = employees[j];
                if (employee.getDepartment() == i) {
                    System.out.println(employee.getFullName());
                }
            }
        }
    }

//  Проверка передаваемых параметров
    public void checkDepartment(int department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Введено некорректное значение <отдел>: " + department);
        }
    }
    public void checkSalaryIncrease(int increase) {
        if (increase < 1 || increase > 100) {
            throw new IllegalArgumentException("Введено некорректное значение <процент индексации зарплаты>: " + increase);
        }
    }
    public void checkSalary(int salary) {
        if (salary < 0 || salary > 1_000_000) {
            throw new IllegalArgumentException("Введено некорректное значение <зарплата>: " + salary);
        }
    }
}
