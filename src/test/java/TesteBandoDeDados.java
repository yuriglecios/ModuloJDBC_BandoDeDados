import conexao_jdbc.SingleConnection;
import junit.framework.TestCase;
import org.junit.Test;

public class TesteBandoDeDados{
   @Test
    public void iniciaBanco(){
        SingleConnection.getConnection();
    }
}
