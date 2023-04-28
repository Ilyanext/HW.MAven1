import javax.persistence.*;

public class EmployeeDAOImpl implements EmployeeDAO {
    final String user = "postgres";
    final String password = "ilya354909";
    final String url = "jdbc:postgresql://localhost:5432/postgres";

    @Override
    public void mergeOneEmployee(Employee employee) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.merge(employee);

        transaction.commit();
        entityManager.close();
    }
    @Override
    public void updateOneEmployee(Employee employee) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(employee);

        transaction.commit();
        entityManager.close();
    }

    @Override
    public void deleteOneEmployee(Employee employee) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.remove(employee);

        transaction.commit();
        entityManager.close();
    }
    @Override
    public void selectEmployee(Employee employee, long a) {
        EntityManager entityManager = createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        employee = entityManager.find(Employee.class, a);

        transaction.commit();
        entityManager.close();
    }
private static EntityManager createEntityManager(){
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
    return entityManagerFactory.createEntityManager();
}

}
