package CourseWork;

import java.util.Objects;

public class Employee {
    private static long counter;
    private final String lastName;
    private final String firstName;
    private final String middleName;
    private final long id;
    private int department;
    private double salary;

    public Employee(String lastName, String firstName, String middleName, int department, double salary) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.department = department;
        this.salary = salary;
        id = ++counter;
    }

    public long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + ". " + lastName + " " + firstName + " " + middleName + ", отдел: " + department + ", зарплата: " + salary + " руб.";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Employee employee = (Employee) other;
        return id == employee.id && lastName.equals(employee.lastName) && firstName.equals(employee.firstName) && middleName.equals(employee.middleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, middleName, id);
    }
}