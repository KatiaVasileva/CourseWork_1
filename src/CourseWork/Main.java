package CourseWork;

public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.addEmployee("Пушкин", "Александр", "Сергеевич", 1, 55_000);
        employeeBook.addEmployee("Лермонтов", "Михаил", "Юрьевич", 2, 55_000);
        employeeBook.addEmployee("Достоевский", "Федор", "Михайлович", 2, 70_000);
        employeeBook.addEmployee("Тургенев", "Иван", "Сергеевич", 2, 160_000);
        employeeBook.addEmployee("Гончаров", "Иван", "Александрович", 1, 44_000);
        employeeBook.addEmployee("Гоголь", "Николай", "Васильевич", 3, 88_000);
        employeeBook.addEmployee("Островский", "Александр", "Николаевич", 3, 48_355);
        employeeBook.addEmployee("Грибоедов", "Александр", "Сергеевич", 4, 90_000);
        employeeBook.addEmployee("Чехов", "Антон", "Павлович", 4, 87_000);
        employeeBook.addEmployee("Булгаков", "Михаил", "Афанасьевич", 5, 65_000);
        employeeBook.addEmployee("Некрасов", "Николай", "Алексеевич", 5, 44_000);
        employeeBook.addEmployee("Толстой", "Лев", "Николаевич", 5, 70_000);
        employeeBook.addEmployee("Есенин", "Сергей", "Александрович", 1, 45_000);
        employeeBook.addEmployee("Маяковский", "Владимир", "Владимирович", 3, 53_000);
        employeeBook.addEmployee("Ахматова", "Анна", "Андреевна", 5, 43_000);

        insertSeparator();
        System.out.println("Книга сотрудников");
        insertSeparator();
        employeeBook.printAllEmployees();
        insertSeparator();
        double totalSalaryForMonth = employeeBook.calculateTotalExpensesForSalary();
        System.out.println("Сумма затрат на зарплаты в месяц составляет " + totalSalaryForMonth + " руб.");
        insertSeparator();
        double minSalary = employeeBook.findMinimumSalary();
        employeeBook.printEmployeeWithMinimumSalary(minSalary);
        insertSeparator();
        double maxSalary = employeeBook.findMaximumSalary();
        employeeBook.printEmployeeWithMaximumSalary(maxSalary);
        insertSeparator();
        double averageSalary = employeeBook.calculateAverageSalaryPerMonth();
        System.out.printf("Среднее значение зарплат составляет %.2f руб.\n", averageSalary);
        insertSeparator();
        employeeBook.printAllFullNames();
        insertSeparator();
        double increaseInSalaryInPercent = 10;
        employeeBook.printAdjustedSalary(increaseInSalaryInPercent);
        insertSeparator();
        int department = 5;
        Employee[] departmentEmployees = employeeBook.generateDepartmentEmployees(department);
        System.out.println("Ниже приведена информация по отделу " + department + "\n");
        employeeBook.printListOfDepartmentEmployees(departmentEmployees);
        double minSalaryInDepartment = employeeBook.findMinimumSalaryInDepartment(departmentEmployees);
        employeeBook.printEmployeeWithMinimumSalaryInDepartment(departmentEmployees, minSalaryInDepartment);
        double maxSalaryInDepartment = employeeBook.findMaximumSalaryInDepartment(departmentEmployees);
        employeeBook.printEmployeeWithMaximumSalaryInDepartment(departmentEmployees, maxSalaryInDepartment);
        double totalSalaryForDepartment = employeeBook.calculateTotalExpensesForSalaryByDepartment(departmentEmployees);
        System.out.println("Сумма затрат на зарплаты по отделу в месяц составляет " + totalSalaryForDepartment + " руб.");
        double averageSalaryForDepartment = employeeBook.calculateAverageSalaryPerMonthByDepartment(departmentEmployees);
        System.out.println("Среднее значение зарплат по отделу составляет " + averageSalaryForDepartment + " руб.\n");
        double increaseInSalaryInPercentForDepartment = 5;
        employeeBook.printListOfEmployeesWithAdjustedSalaryByDepartment(departmentEmployees, increaseInSalaryInPercentForDepartment);
        insertSeparator();
        int number = 70_000; // число для определения сотрудников с зарплатой ниже или выше этого числа
        employeeBook.findEmployeesWithSalaryEqualOrHigherThanNumber(number);
        insertSeparator();
        employeeBook.findEmployeesWithSalaryLowerThanNumber(number);
        insertSeparator();
        employeeBook.removeEmployee("Грибоедов", "Александр", "Сергеевич");
        insertSeparator();
        System.out.println("Обновленный перечень всех сотрудников (удален сотрудник):");
        employeeBook.printAllEmployees();
        insertSeparator();
        employeeBook.addEmployee("Блок", "Александр", "Александрович", 4, 80_000);
        System.out.println("Обновленный перечень всех сотрудников (добавлен сотрудник):");
        employeeBook.printAllEmployees();
        insertSeparator();
        employeeBook.changeSalary("Ахматова", "Анна", "Андреевна", 50_000);
        insertSeparator();
        employeeBook.changeDepartment("Есенин", "Сергей", "Александрович", 5);
        insertSeparator();
        employeeBook.printAllEmployeesByDepartment();
        insertSeparator();
    }

    public static void insertSeparator() {
        System.out.println("==========================================================================================");
    }

}