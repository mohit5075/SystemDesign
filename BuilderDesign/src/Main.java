public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee.EmployeeBuilder()
                .setName("John Doe")
                .setAge(30)
                .setPosition("Software Engineer")
                .build();
        System.out.println("Name: " + employee.getName());
        System.out.println("Age: " + employee.getAge());
        System.out.println("Position: " + employee.getPosition());
    }
}