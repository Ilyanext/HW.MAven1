import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        City city = new City("Rim");
        CityDAO cityDAO = new CityDAOImpl();

        Employee employee = new Employee("Rum", "Rum", "men", city);
        Employee employee1 = new Employee("Pum", "Kum", "men", city);
        Employee employee2 = new Employee("ytum", "uyum", "wumen", city);
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();


        cityDAO.saveCity(city);
        employeeDAO.saveOneEmployee(employee);
        employeeDAO.saveOneEmployee(employee1);
        employeeDAO.saveOneEmployee(employee2);


        City city1 = entityManager.find(City.class, 2);
        List<Employee> employee3 = city1.getEmployee();
        Employee employee4 = employee3.get(1);
        employee4.setFirstName("Max");
        entityManager.merge(city1);


        City city2 = entityManager.find(City.class, 1);
        entityManager.remove(city2);
//        cityDAO.selectCity(city, 1);
//        cityDAO.deleteCity(city);

        transaction.commit();
        entityManager.close();
    }

    static EntityManager createEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        return entityManagerFactory.createEntityManager();
    }
}
