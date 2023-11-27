import conexao_jdbc.SingleConnection;
import dao.UsuarioDao;
import junit.framework.TestCase;
import model.Usuario;
import org.junit.Test;

public class TesteBandoDeDados{
   @Test
    public void iniciaBanco(){
       UsuarioDao usuarioDao = new UsuarioDao();
       Usuario usuario = new Usuario();
       usuario.setNome("guilherme");
       usuario.setEmail("guilherme@gmail.com");
       usuarioDao.salvar(usuario);
    }
}
