package CourseWork;

public class EmployeeBook {
    private final Employee[] employees;
    private int size;

    public EmployeeBook() {
        this.employees = new Employee[15];
    }

    public void addEmployee(String fullName, int department, int salary) {
        if (size >= employees.length) {
            System.out.println("Нельзя добавить нового сотрудника, так как закончилось место.");
        }
        Employee newEmployee = new Employee(fullName, department, salary);
        employees[size++] = newEmployee;
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
        int minSalary = 100_000;
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
        int maxSalary = 0;
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
        int averageSalary = totalSalary / size;
        return averageSalary;
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
        if (increase < 1 || increase > 100) {
            throw new IllegalArgumentException("Введено некорректное значение <индексация зарплаты>: " + increase);
        }
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
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Введено некорректное значение <отдел>: " + department);
        }
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
        int averageSalary = totalSalary / departmentEmployees.length;
        return averageSalary;
    }

    public void printListOfEmployeesWithAdjustedSalaryByDepartment(Employee[] departmentEmployees, int increase) {
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
}
