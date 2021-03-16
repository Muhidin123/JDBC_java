package muhidinCliProjectJava;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menuChoice();
    }

    public static void menuChoice () {
        int userInput = cliMainMenu.input();

            switch (userInput) {
                case 1:
                    addNewCity();
                    break;
                case 2:
                    listAllCities();
                case 3:
                    System.out.println("EXIT");
                    break;
                default:
                    System.out.println("WRONG CHOICE");
                    menuChoice();
            }
    }

    public static void listAllCities () {
        Connection connectionToDatabase = null;
        ResultSet resultOfQuery;

        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:identifier.sqlite";
            connectionToDatabase = DriverManager.getConnection(url);
            String sqlGetCities = "SELECT * FROM cities;";
            PreparedStatement preparedInfo = connectionToDatabase.prepareStatement(sqlGetCities);
            resultOfQuery = preparedInfo.executeQuery();
            while (resultOfQuery.next()) {
                System.out.println("Name " + resultOfQuery.getString(2) + "\n" + resultOfQuery.getString(5));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (connectionToDatabase != null) {
                    connectionToDatabase.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void addNewCity (){
        Scanner input = new Scanner(System.in);
        System.out.println("City name: ");
        String name = input.next();
        System.out.println("City state(two letter abrr): ");
        String state = input.next();
        System.out.println("City ZIP: ");
        int zipCode = input.nextInt();
        System.out.println("City info: ");
        input.nextLine();
        String info = input.nextLine();
        databaseAction(name,state,zipCode,info);
    }

    public static void databaseAction(String name, String state, int zipCode, String info) {
        Connection connectionToDatabase = null;
        ResultSet resultOfQuery;
        String sqlString = "INSERT INTO cities(name, state, zipCode, info) VALUES (?,?,?,?)";
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:identifier.sqlite";
            connectionToDatabase = DriverManager.getConnection(url);
            String sqlGetCities = "SELECT * FROM cities;";
            PreparedStatement preparedStatementSql = connectionToDatabase.prepareStatement(sqlString);
            PreparedStatement preparedInfo = connectionToDatabase.prepareStatement(sqlGetCities);
            preparedStatementSql.setString(1, name);
            preparedStatementSql.setString(2, state);
            preparedStatementSql.setInt(3,zipCode);
            preparedStatementSql.setString(4, info);
//            preparedStatementSql.executeUpdate();
            resultOfQuery = preparedInfo.executeQuery();

            while (resultOfQuery.next()) {
                System.out.println(resultOfQuery.getString(2));
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (connectionToDatabase != null) {
                    connectionToDatabase.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
