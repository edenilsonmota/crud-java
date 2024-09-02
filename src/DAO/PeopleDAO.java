package DAO;

import controller.People;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

public class PeopleDAO {
    //url + port + database name
    private static final String URL = "jdbc:mysql://localhost:3307/crud";
    //name user database
    private static final String USER = "root";
    //pass user database
    private static final String PASSWORD = "12345";


    //method connection
    public static Connection getConnection() {
        try{
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void create(People people){
        String query = "INSERT INTO people (cpf, name, email) VALUES (?, ?, ?)";

        //Estabelecer conexao
        try(
                Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
                ){

            stmt.setString(1, people.getCpf());
            stmt.setString(2, people.getName());
            stmt.setString(3, people.getEmail());

            stmt.execute();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}

