import conexao_jdbc.SingleConnection;
import dao.UsuarioDao;
import junit.framework.TestCase;
import model.Usuario;
import org.junit.Test;

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

}
