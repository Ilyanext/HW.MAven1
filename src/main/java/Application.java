import java.sql.SQLException;

public class Application {

    public static void main(String[] args)  {


        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        Employee employees = new Employee();

        employeeDAO.updateOneEmployee(employees);
        System.out.println();

        employeeDAO.deleteOneEmployee(employees);

    }
}
