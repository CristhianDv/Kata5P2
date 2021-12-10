package kata5p2.view;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kata5p2.model.Mail;

public class MailListReaderBD {
    public static List<Mail> read(){
        List<Mail> listaCorreos = new ArrayList<>();
        selectAll(listaCorreos);
        return listaCorreos;
    }
    
    private static void selectAll(List<Mail> correos) {
        String sql = "SELECT * FROM EMAIL";
        
        try (   Connection conexion = connect();
                Statement statement = conexion.createStatement();
                ResultSet respuesta = statement.executeQuery(sql)){
            
            while (respuesta.next()){
                correos.add(new Mail(respuesta.getString("Mail")));
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        
    }
    
    private static Connection connect(){
        Connection conexion = null;
        try {
            String url = "jdbc:sqlite:KATA5.db";
            conexion = DriverManager.getConnection(url);
            System.out.println("Conexión establecida a SQLITE");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conexion;
    }
    
}