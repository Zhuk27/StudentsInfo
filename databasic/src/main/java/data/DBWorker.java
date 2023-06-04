package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DBWorker {
    private static String URL = "jdbc:mysql://localhost:3306/";//mydbtest
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private Connection connection;

    public DBWorker(){
        try {
            System.out.println("Введите имя файла базы данных");
            Scanner scanner = new Scanner(System.in);
            String fileName = scanner.nextLine();
            URL += fileName;
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
