public class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private double salary;
    private Department department;

    public Employee(int id, String name, double salary, Department department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Department getDepartment() {
        return department;
    }

    public int compareTo(Employee other) {
        if (this.salary < other.salary) {
            return -1;
        } else if (this.salary > other.salary) {
            return 1;
        } else {
            return 0;
        }
    }

    public String toString() {
        return id + " | " + name + " | " + salary + " | " + department;
    }
}