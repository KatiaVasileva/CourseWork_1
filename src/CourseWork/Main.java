package CourseWork;

public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.addEmployee("Пушкин Александр Сергеевич", 1, 55_000);
        employeeBook.addEmployee("Лермонтов Михаил Юрьевич", 2, 55_000);
        employeeBook.addEmployee("Достоевский Федор Михайлович", 2, 70_000);
        employeeBook.addEmployee("Тургенев Иван Сергеевич", 2, 60_000);
        employeeBook.addEmployee("Гончаров Иван Александрович", 1, 44_000);
        employeeBook.addEmployee("Гоголь Николай Васильевич", 3, 88_000);
        employeeBook.addEmployee("Островский Александр Николаевич", 3, 48_000);
        employeeBook.addEmployee("Грибоедов Александр Сергеевич", 4, 90_000);
        employeeBook.addEmployee("Чехов Антон Павлович", 4, 87_000);
        employeeBook.addEmployee("Булгаков Михаил Афанасьевич", 5, 65_000);
        employeeBook.addEmployee("Некрасов Николай Алексеевич", 5, 44_000);
        employeeBook.addEmployee("Толстой Лев Николаевич", 5, 70_000);
        employeeBook.addEmployee("Есенин Сергей Александрович", 1, 45_000);
        employeeBook.addEmployee("Маяковский Владимир Владимирович", 3, 53_000);
        employeeBook.addEmployee("Ахматова Анна Андреевна", 5, 43_000);

        insertSeparator();
        System.out.println("Книга сотрудников");
        insertSeparator();
        employeeBook.printAllEmployees();
        insertSeparator();

        employeeBook.removeEmployee("Грибоедов Александр Сергеевич");
        insertSeparator();
        employeeBook.printRenewedListOfEmployees();
        insertSeparator();
        employeeBook.addEmployee("Блок Александр Александрович", 4, 80_000);
        employeeBook.printRenewedListOfEmployees();
        insertSeparator();

        int totalSalaryForMonth = employeeBook.calculateTotalExpensesForSalary();
        System.out.println("Сумма затрат на зарплаты в месяц составляет " + totalSalaryForMonth + " руб.");
        insertSeparator();
        int minSalary = employeeBook.findMinimumSalary();
        employeeBook.printEmployeeWithMinimumSalary(minSalary);
        insertSeparator();
        int maxSalary = employeeBook.findMaximumSalary();
        employeeBook.printEmployeeWithMaximumSalary(maxSalary);
        insertSeparator();
        int averageSalary = employeeBook.calculateAverageSalaryPerMonth();
        System.out.println("Среднее значение зарплат составляет " + averageSalary + " руб.");
        insertSeparator();
        employeeBook.printAllFullNames();
        insertSeparator();
        int increaseInSalaryInPercent = 10;
        employeeBook.printAdjustedSalary(increaseInSalaryInPercent);
        insertSeparator();
        int department = 5;
        Employee[] departmentEmployees = employeeBook.generateDepartmentEmployees(department);
        System.out.println("Ниже приведена информация по отделу " + department + "\n");
        employeeBook.printListOfDepartmentEmployees(departmentEmployees);
        int minSalaryByDepartment = employeeBook.findMinimumSalaryInDepartment(departmentEmployees);
        employeeBook.printEmployeeWithMinimumSalaryInDepartment(departmentEmployees, minSalaryByDepartment);
        int maxSalaryByDepartment = employeeBook.findMaximumSalaryInDepartment(departmentEmployees);
        employeeBook.printEmployeeWithMaximumSalaryInDepartment(departmentEmployees, maxSalaryByDepartment);
        int totalSalaryForDepartment = employeeBook.calculateTotalExpensesForSalaryByDepartment(departmentEmployees);
        System.out.println("Сумма затрат на зарплаты по отделу в месяц составляет " + totalSalaryForDepartment + " руб.");
        int averageSalaryForDepartment = employeeBook.calculateAverageSalaryPerMonthByDepartment(departmentEmployees);
        System.out.println("Среднее значение зарплат по отделу составляет " + averageSalaryForDepartment + " руб.\n");
        int increaseInSalaryInPercentForDepartment = 5;
        employeeBook.printListOfEmployeesWithAdjustedSalaryByDepartment(departmentEmployees, increaseInSalaryInPercentForDepartment);
        insertSeparator();
        int number = 70_000; // число для определения сотрудников с зарплатой ниже или выше этого числа
        employeeBook.findEmployeesWithSalaryEqualOrHigherThanNumber(number);
        insertSeparator();
        employeeBook.findEmployeesWithSalaryLowerThanNumber(number);
        insertSeparator();
    }

    public static void insertSeparator() {
        System.out.println("==========================================================================================");
    }

}