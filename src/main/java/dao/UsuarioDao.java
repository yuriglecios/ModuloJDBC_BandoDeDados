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

    public List<Usuario> listarUsuarios() throws Exception{
            List<Usuario> lista = new ArrayList<>();
            String sql = "select * from usuario";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getLong("id"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setEmail(resultSet.getString("email"));
                lista.add(usuario);
            }
            return lista;
    }

    public Usuario buscarUsuarios(Long id) throws Exception{
        Usuario buscausuario = new Usuario();
        String sql = "select * from usuario where id =" + id;
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            Usuario usuario = new Usuario();
            buscausuario.setId(resultSet.getLong("id"));
            buscausuario.setNome(resultSet.getString("nome"));
            buscausuario.setEmail(resultSet.getString("email"));
        }
        return buscausuario;
    }


    public void updateUsuario(Usuario usuario)  {

        try {
            String sql = "update usuario set nome = ? where id =" + usuario.getId();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,usuario.getNome());
            statement.execute();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
