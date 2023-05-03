import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.*;
public class CityDAOImpl implements CityDAO{
    final String user = "postgres";
    final String password = "ilya354909";
    final String url = "jdbc:postgresql://localhost:5432/postgres";
    @Override
    public void mergeCity(City city) {

            EntityManager entityManager = EmployeeDAOImpl.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.merge(city);

            transaction.commit();
            entityManager.close();
        }


    @Override
    public void saveCity(City city) {

        EntityManager entityManager = EmployeeDAOImpl.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(city);

        transaction.commit();
        entityManager.close();
    }

    @Override
    public void deleteCity(City city) {
        EntityManager entityManager = EmployeeDAOImpl.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.remove(city);

        transaction.commit();
        entityManager.close();
    }

    @Override
    public void selectCity(City city, int a) {

            EntityManager entityManager = EmployeeDAOImpl.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.find(City.class, a);

            transaction.commit();
            entityManager.close();
        }
    static EntityManager createEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        return entityManagerFactory.createEntityManager();}
    }

