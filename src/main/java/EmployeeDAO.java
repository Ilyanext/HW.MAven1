import java.util.List;


public interface EmployeeDAO {
    List<Employee> getAllEmployee();
//
//    void createEmployee();
//
//    void selectOneEmployee(int id);


    void mergeOneEmployee(Employee employee);

    void saveOneEmployee(Employee employee);

    void deleteOneEmployee(Employee employee);


    void selectEmployee(Employee employee, int a);
}
