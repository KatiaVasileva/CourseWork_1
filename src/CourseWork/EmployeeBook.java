package CourseWork;

public class EmployeeBook {
    private final Employee[] employees;
    private int size;

    public EmployeeBook() {
        this.employees = new Employee[15];
    }

    public void addEmployee(String lastName, String firstName, String middleName, int department, int salary) {
        checkDepartment(department);
        checkSalary(salary);
        if (size >= employees.length) {
            System.out.println("Нельзя добавить нового сотрудника, так как закончилось место.");
        }
        Employee newEmployee = new Employee(lastName, firstName, middleName, department, salary);
        employees[size++] = newEmployee;
    }

    public void removeEmployee(String lastName, String firstName, String middleName) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getLastName().equals(lastName) && employees[i].getFirstName().equals(firstName)
                && employees[i].getMiddleName().equals(middleName)) {
                System.out.println("Удален сотрудник: " + employees[i].getLastName() + " " + employees[i].getFirstName()
                                    + " " + employees[i].getMiddleName());
                System.arraycopy(employees, i + 1, employees, i, size - i - 1);
                employees[size - 1] = null;
                size--;
                return;
            }
        }
        System.out.println("Сотрудник с таким именем не найден.");
    }

    public void printAllEmployees() {
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            System.out.println(employee);
        }
    }

    public double calculateTotalExpensesForSalary() {
        double totalSalary = 0;
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            totalSalary = totalSalary + employee.getSalary();
        }
        return totalSalary;
    }

/* Метод getTheFirstSalary получает значение зарплаты сотрудника, записанного в первую ячейку массива. В дальнейшем это значение
* будет использоваться для нахождения минимальной и максимальной зарплаты сотрудников путем сравнения. Единственная проверка -
* это наличие значения в первом элементе массиве (не равно null); если значение равно null, то массив пустой, поскольку при удалении
* сотрудников из массива выполняется сдвиг массива на одну ячейку, и при наличии хотя бы одной записи первая ячейка не может быть пустой. */
    public double getTheFirstSalary() {
        if (employees[0].equals(null)) {
            throw new RuntimeException("В книге учета сотрудников отсутствуют данные, введите данные о сотрудниках.");
        }
        return employees[0].getSalary();
    }

    public double findMinimumSalary() {
        double minSalary = getTheFirstSalary();
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
            }
        }
        return minSalary;
    }

    public void printEmployeeWithMinimumSalary(double minSalary) {
        System.out.println("Сотрудник(-и) с минимальной зарплатой:");
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getSalary() == minSalary) {
                System.out.println(employee);
            }
        }
    }

    public double findMaximumSalary() {
        double maxSalary = getTheFirstSalary();
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
            }
        }
        return maxSalary;
    }

    public void printEmployeeWithMaximumSalary(double maxSalary) {
        System.out.println("Сотрудник(-и) с максимальной зарплатой:");
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee.getSalary() == maxSalary) {
                System.out.println(employee);
            }
        }
    }

    public double calculateAverageSalaryPerMonth() {
        double totalSalary = calculateTotalExpensesForSalary();
        return totalSalary / size;
    }

    public void printAllFullNames() {
        System.out.println("Полный перечень Ф.И.О всех сотрудников:");
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            String fullName = employee.getLastName() + " " + employee.getFirstName() + " " + employee.getMiddleName();
            System.out.println(fullName);
        }
    }

    public void printAdjustedSalary(double increase) {
        checkSalaryIncrease(increase);
        System.out.printf("Полный перечень всех сотрудников с указанием зарплаты, проиндексированной на %.2f %%:\n",
                increase);
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            double increasedSalary = employee.getSalary() + employee.getSalary() * increase / 100;
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

    public double findMinimumSalaryInDepartment(Employee[] departmentEmployees) {
        double minSalary = getTheFirstSalary();
        for (Employee departmentEmployee : departmentEmployees) {
            if (departmentEmployee.getSalary() < minSalary) {
                minSalary = departmentEmployee.getSalary();
            }
        }
        return minSalary;
    }
    public void printEmployeeWithMinimumSalaryInDepartment(Employee[] departmentEmployees, double minSalary) {
        for (Employee departmentEmployee : departmentEmployees) {
            int department = departmentEmployee.getDepartment();
            if (departmentEmployee.getSalary() == minSalary) {
                System.out.println("Сотрудник(-и) с минимальной зарплатой в отделе " + department + ":");
                printEmployeesWithoutDepartment(departmentEmployee);
            }
        }
        System.out.println();
    }

    public double findMaximumSalaryInDepartment(Employee[] departmentEmployees) {
        double maxSalary = getTheFirstSalary();
        for (Employee departmentEmployee : departmentEmployees) {
            if (departmentEmployee.getSalary() > maxSalary) {
                maxSalary = departmentEmployee.getSalary();
            }
        }
        return maxSalary;
    }

    public void printEmployeeWithMaximumSalaryInDepartment(Employee[] departmentEmployees, double maxSalary) {
        for (Employee departmentEmployee : departmentEmployees) {
            int department = departmentEmployee.getDepartment();
            if (departmentEmployee.getSalary() == maxSalary) {
                System.out.println("Сотрудник(-и) с максимальной зарплатой в отделе " + department + ":");
                printEmployeesWithoutDepartment(departmentEmployee);
            }
        }
        System.out.println();
    }

    public double calculateTotalExpensesForSalaryByDepartment(Employee[] departmentEmployees) {
        double totalSalary = 0;
        for (Employee departmentEmployee : departmentEmployees) {
            totalSalary = totalSalary + departmentEmployee.getSalary();
        }
        return totalSalary;
    }

    public double calculateAverageSalaryPerMonthByDepartment(Employee[] departmentEmployees) {
        double totalSalary = calculateTotalExpensesForSalaryByDepartment(departmentEmployees);
        return totalSalary / departmentEmployees.length;
    }

    public void printListOfEmployeesWithAdjustedSalaryByDepartment(Employee[] departmentEmployees, double increase) {
        checkSalaryIncrease(increase);
        System.out.printf("Перечень всех сотрудников отдела с указанием зарплаты, проиндексированной на %.2f %%:\n",
                increase);
        for (Employee departmentEmployee : departmentEmployees) {
            double increasedSalary = departmentEmployee.getSalary() + departmentEmployee.getSalary() * increase / 100;
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
        System.out.println(employee.getId() + ". " + employee.getLastName() + " " + employee.getFirstName() + " " +
                            employee.getMiddleName() + ", зарплата: " + employee.getSalary() + " руб.");
    }

    public void changeSalary(String lastName, String firstName, String middleName, double newSalary) {
        checkSalary(newSalary);
        for (Employee employee : employees) {
            if (employee.getLastName().equals(lastName) && employee.getFirstName().equals(firstName) &&
                employee.getMiddleName().equals(middleName)) {
                employee.setSalary(newSalary);
                System.out.println("Обновленные данные по сотруднику " + lastName + " " + firstName + " " + middleName +
                        " (изменение зарплаты):");
                System.out.println(employee);
                return;
            }
        }
        System.out.println("Сотрудник с таким именем не найден.");
    }

    public void changeDepartment(String lastName, String firstName, String middleName, int newDepartment) {
        checkDepartment(newDepartment);
        for (Employee employee : employees) {
            if (employee.getLastName().equals(lastName) && employee.getFirstName().equals(firstName) &&
                    employee.getMiddleName().equals(middleName)) {
                employee.setDepartment(newDepartment);
                System.out.println("Обновленные данные по сотруднику " + lastName + " " + firstName + " " + middleName +
                        " (изменение отдела):");
                System.out.println(employee);
                return;
            }
        }
        System.out.println("Сотрудник с таким именем не найден.");
    }

    public void printAllEmployeesByDepartment() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Отдел " + i);
            for (int j = 0; j < size; j++) {
                Employee employee = employees[j];
                if (employee.getDepartment() == i) {
                    System.out.println(employee.getLastName() + " " + employee.getFirstName() + " " + employee.getMiddleName());
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
    public void checkSalaryIncrease(double increase) {
        if (increase < 1 || increase > 100) {
            throw new IllegalArgumentException("Введено некорректное значение <процент индексации зарплаты>: " + increase);
        }
    }
    public void checkSalary(double salary) {
        if (salary < 0 || salary > 1_000_000) {
            throw new IllegalArgumentException("Введено некорректное значение <зарплата>: " + salary);
        }
    }
}
