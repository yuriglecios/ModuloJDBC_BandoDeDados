package dao;

import conexao_jdbc.SingleConnection;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDao {

    private Connection connection;

    public UsuarioDao(){
        connection = SingleConnection.getConnection();
    }

    public void salvar(Usuario usuario){
        try {
            String sql = "insert into usuario (nome, email) values (?,?)";
            PreparedStatement insert = connection.prepareStatement(sql);
            insert.setString(1, "teste");
            insert.setString(2, "gllecios@gmail.com");
            insert.execute();
            connection.commit();//salva no bamco

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
