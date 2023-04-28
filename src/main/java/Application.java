public class Application {

    public static void main(String[] args) {


        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        Employee employees = new Employee("Ira", "Kira", "women", 1);

        employees.setFirst_name("Kola");
        employeeDAO.mergeOneEmployee(employees);
        System.out.println();

        employeeDAO.selectEmployee(employees, 8);
        employeeDAO.deleteOneEmployee(employees);


    }
}
