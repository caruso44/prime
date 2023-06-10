package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.*;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

public class Database {
    private Prime primos;
    
    public Database(int n){
        primos = new Prime(n);
    }

    public void createTable(){
        String jdbcUrl = "";
        String username = "";
        String password = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
                String createTableQuery = "CREATE TABLE primes ("
            + "P1 INT,"
            + "P2 INT,"
            + "N INT PRIMARY KEY)";

            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(createTableQuery);
                System.out.println("Table created successfully.");
            } 
            catch (SQLException e) {
                e.printStackTrace();
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean check_table_exist(String tableName){
        String jdbcUrl = "";
        String username = "";
        String password = "";
        boolean tableExists = false;
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)){
            try {
                DatabaseMetaData metadata = connection.getMetaData();
                ResultSet resultSet = metadata.getTables(null, null, tableName, null);

                if (resultSet.next()) {
                    tableExists = true;
                }

                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableExists;
    }

    public void insertTable(Tuple t){
        String jdbcUrl = "";
        String username = "";
        String password = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)){
            String insertQuery = "INSERT INTO primes(p1, p2, n) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, t.getP1());
                preparedStatement.setInt(2, t.getP2());
                preparedStatement.setInt(3, t.getN());
            
                // Execute the insert statement
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fill_table(){
        List<Tuple> tuplas = primos.get_all_tuples();
        int n = tuplas.size();
        for(int i = 0; i < n; i++){
            insertTable(tuplas.get(i));
        }
    }

    public Tuple get_tuple(Integer n){
        String jdbcUrl = "";
        String username = "";
        String password = "";
        Tuple ans;
        int p1 = 0, p2 = 0;
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            String query = "SELECT * FROM public.primes WHERE n = " + n;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                p1 = resultSet.getInt("p1");
                p2 = resultSet.getInt("p2");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ans = new Tuple(p1, p2, n);
        return ans;
    }
}
