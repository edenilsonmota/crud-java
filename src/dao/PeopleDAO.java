package dao;

import model.People;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
            throw new RuntimeException("Error na conexão com o banco de dados", e);
        }
    }

    public boolean insert(People peopleModel){
        String query = "INSERT INTO people (cpf, name, email) VALUES (?, ?, ?)";
        boolean status = false;

        //Estabelecer conexao
        try(
                Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
                ){

            stmt.setString(1, peopleModel.getCpf());
            stmt.setString(2, peopleModel.getName());
            stmt.setString(3, peopleModel.getEmail());
            stmt.execute();
            status = true;
        } catch (SQLException e){
            throw new RuntimeException("error ao inserir usuarios", e);
        }

        return status;
    }

   public List<People> getAll(){
        List<People> peoples = new ArrayList<>(); //reversando a lista

        String query = "SELECT * FROM people";

        try(
                Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();
                ){
            //iterar o resultado
            while(rs.next()){
                peoples.add(new People(
                        rs.getInt("ID"),
                        rs.getString("cpf"),
                        rs.getString("name"),
                        rs.getString("email")));
            }
        } catch (SQLException e){
            throw new RuntimeException("Erro ao bsucar usuarios", e);
        }

        return peoples;
    }

}

