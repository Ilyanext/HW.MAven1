import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public interface EmployeeDAO {
//    List<Employee> getAllEmployee();
//
//    void createEmployee();
//
//    void selectOneEmployee(int id);


    void updateOneEmployee(Employee employee);

    void deleteOneEmployee(Employee employee);
}
