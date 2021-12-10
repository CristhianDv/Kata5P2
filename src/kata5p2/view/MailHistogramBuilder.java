package kata5p2.view;

import kata5p2.model.Histogram;
import kata5p2.model.Mail;
import java.util.HashMap;
import java.util.List;

public class MailHistogramBuilder {
    
    public static Histogram<String> build(List<Mail> listaCorreos) {
        Histogram histogramaCorreos = new Histogram(new HashMap<String, Integer>() {});
        
        for (Mail correo : listaCorreos){
            histogramaCorreos.increment(correo.getEmail());
        }
        
        return histogramaCorreos;
    }
    
}