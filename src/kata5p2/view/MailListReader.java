package kata5p2.view;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kata5p2.model.Mail;

public class MailListReader {
    public static List<Mail> read(String fileName){
        List<Mail> listaCorreos = new ArrayList<>();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
            String linea;
            while ((linea = br.readLine()) != null) {
                if (Mail.isMail(linea)) {
                    listaCorreos.add(new Mail(linea));
                }                
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(MailListReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCorreos;
    }
    
}