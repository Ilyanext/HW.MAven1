import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    final String user = "postgres";
    final String password = "ilya354909";
    final String url = "jdbc:postgresql://localhost:5432/postgres";

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employee = new ArrayList<>();
        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM employee " +
                             "FULL JOIN city ON employee.city_id = city.city_id")) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                int idEmployee = resultSet.getInt("id");
                System.out.println("ID: " + idEmployee);
                String nameEmployee = resultSet.getString("first_name");
                String lastEmployee = resultSet.getString("last_name");
                String genderEmployee = resultSet.getString("gender");
                String cityEmployee = resultSet.getString("city_name");

                System.out.println("Name: " + nameEmployee);
                System.out.println("Last_name: " + lastEmployee);
                System.out.println("Gender: " + genderEmployee);
                System.out.println("City_name: " + cityEmployee);

            }

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void createEmployee() {
        try (final Connection connection =
                     DriverManager.getConnection(url, user, password)) {
           Statement statement =
                    connection.createStatement();
            String sql = "INSERT INTO employee (first_name, last_name, city_id, gender) VALUES " +
                    "('Larisa', 'Lihoskai',1,'women')";
            int countRow = statement.executeUpdate(sql);
            System.out.printf("Изменено %d строк\n ", countRow);

            sql = "SELECT * FROM employee";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                String nameEmployee = resultSet.getString("first_name");
                String lastEmployee = resultSet.getString("last_name");
                String genderEmployee = resultSet.getString("gender");
                String cityEmployee = resultSet.getString("city_name");

                System.out.println("Name: " + nameEmployee);
                System.out.println("Last_name: " + lastEmployee);
                System.out.println("Gender: " + genderEmployee);
                System.out.println("City_name: " + cityEmployee);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }
    }

    @Override
    public void selectOneEmployee(int id) {
        try (final Connection connection =
                     DriverManager.getConnection(url, user, password)){
             Statement statement =
                     connection.createStatement();
             String sql ="SELECT * FROM employee " +
                             "FULL JOIN city ON employee.city_id = city.city_id "+
                             "WHERE id= " +id;

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                int idEmployee = resultSet.getInt("id");
                if (idEmployee == id) {

                    String nameEmployee = resultSet.getString("first_name");
                    String lastEmployee = resultSet.getString("last_name");
                    String genderEmployee = resultSet.getString("gender");
                    String cityEmployee = resultSet.getString("city_name");

                    System.out.println("Name: " + nameEmployee);
                    System.out.println("Last_name: " + lastEmployee);
                    System.out.println("Gender: " + genderEmployee);
                    System.out.println("City_name: " + cityEmployee);

                }
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }

    }


    @Override
    public void updateOneEmployee(int id) {
        try (final Connection connection =
                     DriverManager.getConnection(url, user, password)) {
            Statement statement =
                    connection.createStatement();
            String sql = "UPDATE employee SET " +
                            "last_name = 'Kuma' WHERE id = " + id;
            int update = statement.executeUpdate(sql);
            System.out.println("Изменили ID "+id);
            sql = "SELECT * FROM employee " +
                    "FULL JOIN city ON employee.city_id = city.city_id "+
                    "WHERE id= " +id;
            ResultSet resultSet =statement.executeQuery(sql);
            while (resultSet.next()){

                int idEmployee = resultSet.getInt("id");
                System.out.println("ID: " + idEmployee);

                String nameEmployee = resultSet.getString("first_name");
                String lastEmployee = resultSet.getString("last_name");
                String genderEmployee = resultSet.getString("gender");
                String cityEmployee = resultSet.getString("city_name");

                System.out.println("Name: " + nameEmployee);
                System.out.println("Last_name: " + lastEmployee);
                System.out.println("Gender: " + genderEmployee);
                System.out.println("City_name: " + cityEmployee);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOneEmployee(int id) {
        try (final Connection connection =
                     DriverManager.getConnection(url, user, password)) {
            Statement statement =
                    connection.createStatement();
            String sql = "DELETE FROM employee " +
                            "WHERE id = " + id;
            id = statement.executeUpdate(sql);
            System.out.println("Элемент под id "+ id+ " был удален!");

            sql = "SELECT * FROM employee " +
                    "FULL JOIN city ON employee.city_id = city.city_id ";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){

                int idEmployee = resultSet.getInt("id");
                System.out.println("ID: " + idEmployee);

                String nameEmployee = resultSet.getString("first_name");
                String lastEmployee = resultSet.getString("last_name");
                String genderEmployee = resultSet.getString("gender");
                String cityEmployee = resultSet.getString("city_name");

                System.out.println("Name: " + nameEmployee);
                System.out.println("Last_name: " + lastEmployee);
                System.out.println("Gender: " + genderEmployee);
                System.out.println("City_name: " + cityEmployee);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных!");
            e.printStackTrace();
        }
    }
}
