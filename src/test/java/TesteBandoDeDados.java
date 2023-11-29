import conexao_jdbc.SingleConnection;
import dao.UsuarioDao;
import junit.framework.TestCase;
import model.BeanUsuarioFone;
import model.Telefone;
import model.Usuario;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class TesteBandoDeDados{
   @Test
    public void iniciaBanco(){
       UsuarioDao usuarioDao = new UsuarioDao();
       Usuario usuario = new Usuario();
       usuario.setNome("guilherme");
       usuario.setEmail("guilherme@gmail.com");
       usuarioDao.salvar(usuario);
    }
    @Test
    public void listar() throws Exception {
       UsuarioDao usuarioDao = new UsuarioDao();
       List<Usuario> listaUsuario = usuarioDao.listarUsuarios();
       for (Usuario usuario : listaUsuario){
           System.out.println("ID: " + usuario.getId() + " | NOME: " + usuario.getNome() + " | EMAIL: " + usuario.getEmail());
       }
    }
    @Test
    public void listarInnerJoin() throws SQLException {
       UsuarioDao usuarioDao = new UsuarioDao();
       List<BeanUsuarioFone> beanUsuarioFone = usuarioDao.listaInnerJoin();

       for (BeanUsuarioFone beanUsuarioFone1 : beanUsuarioFone){
           System.out.println("Numero: " + beanUsuarioFone1.getNumero() + " | Nome: " + beanUsuarioFone1.getNome() + " | Email: " + beanUsuarioFone1.getEmail());
       }
    }

    @Test
    public void testaUpdade(){
       try {
           UsuarioDao usuarioDao = new UsuarioDao();
           Usuario usuario = usuarioDao.buscarUsuarios(6L);
           usuario.setNome("piriguete");
           usuarioDao.updateUsuario(usuario);
       } catch (Exception e){
           e.printStackTrace();
       }

    }
    @Test
    public void testeDelete(){
       UsuarioDao usuarioDao = new UsuarioDao();
       usuarioDao.deletarUsuario(6L);
    }
    @Test
    public void testaTelefoneInsert(){
       Telefone telefone = new Telefone();
       telefone.setTelefone("98484-5555");
       telefone.setDescricao("empresa");
       telefone.setUsuario_id(3L);

       UsuarioDao usuarioDao = new UsuarioDao();
       usuarioDao.salvarTelefone(telefone);
    }
    @Test
    public void deletarEmCascata(){
       UsuarioDao usuarioDao = new UsuarioDao();
       usuarioDao.deletarEmCascata(7L);
    }

}
