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


//        City city = new City("Rim");
//        Employee employee = new Employee("Rum", "Rum", "men", city);
//        Employee employee1 = new Employee("Pum", "Kum", "men", city);
//        Employee employee2 = new Employee("ytum", "uyum", "wumen", city);
//        Employee employee = entityManager.find(Employee.class,1);
//        System.out.println(employee.getCity());

        City city1 = entityManager.find(City.class, 3);
        System.out.println(city1.getEmployee());
//        List<Employee> employees=city1.getEmployee();
        entityManager.remove(city1);

        entityManager.flush();


        transaction.commit();
        entityManager.close();
    }

    static EntityManager createEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        return entityManagerFactory.createEntityManager();
    }
}
