import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployee();

    void createEmployee();

    void selectOneEmployee(int id);

    void updateOneEmployee(int id);

    void deleteOneEmployee(int id);
}
