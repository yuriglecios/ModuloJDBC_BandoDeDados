package dao;

import conexao_jdbc.SingleConnection;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

    private Connection connection;

    public UsuarioDao(){
        connection = SingleConnection.getConnection();
    }

    public void salvar(Usuario usuario){
        try {
            String sql = "insert into usuario (nome, email) values (?,?)";
            PreparedStatement insert = connection.prepareStatement(sql);
            insert.setString(1, usuario.getNome());
            insert.setString(2, usuario.getEmail());
            insert.execute();
            connection.commit();//salva no bamco

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<UsuarioDao> listarUsuarios() throws Exception{
            List<UsuarioDao> lista = new ArrayList<>();
            String sql = "select * from usuarios";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            return lista;
    }

}
