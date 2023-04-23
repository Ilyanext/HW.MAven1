import java.sql.*;
import java.util.List;

public class Application {

    public static void main(String[] args) throws SQLException {
        
//        task1
        final String user = "postgres";
        final String password = "ilya354909";
        final String url = "jdbc:postgresql://localhost:5432/postgres";

        try (final Connection connection =
                     DriverManager.getConnection(url, user, password);
             PreparedStatement statement =
                     connection.prepareStatement("SELECT * FROM employee " +
                             "FULL JOIN city ON employee.city_id = city.city_id")) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                int idEmployee = resultSet.getInt("id");
                if (idEmployee == 6) {

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
            // Исключение для обработки возможных ошибок при подключении
        }
        System.out.println();
//        task2
        EmployeeDAO employeeDAO= new EmployeeDAOImpl();

        employeeDAO.createEmployee();
        System.out.println();

        employeeDAO.selectOneEmployee(7);
        System.out.println();

        List<Employee>employees = employeeDAO.getAllEmployee();
        for (Employee employee : employees) {
            System.out.println("Name: " + employee.getFirst_name());
            System.out.println("Last_name: " + employee.getLast_name());
            System.out.println("Gender: " +employee.getGender());
            System.out.println("City_name: " + employee.getCity_name());
        }
        System.out.println();

        employeeDAO.updateOneEmployee(18);
        System.out.println();

        employeeDAO.deleteOneEmployee(19);
    }
}
