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
       usuarioDao.salvar(usuario);
    }
}
