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

    public boolean insert(People people){
        String query = "INSERT INTO people (cpf, name, email) VALUES (?, ?, ?)";
        boolean status = false;

        //Estabelecer conexao
        try(
                Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
                ){

            stmt.setString(1, people.getCpf());
            stmt.setString(2, people.getName());
            stmt.setString(3, people.getEmail());
            stmt.execute();
            status = true;
        } catch (SQLException e){
            throw new RuntimeException("error ao inserir usuarios", e);
        }

        return status;
    }

    public boolean update (People people, int id){
        String query = "UPDATE people SET cpf = ?, name = ?, email = ? WHERE id = ?";
        boolean status = false;

        try(
                Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(query);
                ){
            stmt.setString(1, people.getCpf());
            stmt.setString(2, people.getName());
            stmt.setString(3, people.getEmail());
            stmt.setInt(4, id);
            stmt.execute();

            status = true;
        } catch (SQLException e){
            throw new RuntimeException("Error ao atualizar usuario", e);
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

