package kata5p2.main;

import kata5p2.model.Histogram;
import kata5p2.model.Mail;
import kata5p2.view.HistogramDisplay;
import kata5p2.view.MailListReaderBD;
import java.util.List;
import kata5p2.view.MailHistogramBuilder;

public class Kata5P2 {
    public static void main(String[] args) {
        List<Mail> correos = input();
        Histogram<String> histograma = process(correos);
        output(histograma);
    }
    
    private static List<Mail> input(){
        List<Mail> listaCorreos = MailListReaderBD.read();
        return listaCorreos;    
    }
    
    private static Histogram<String> process(List<Mail> listaCorreos){
        Histogram<String> histogram = MailHistogramBuilder.build(listaCorreos);
        return histogram;
    }
    
    private static void output(Histogram<String> histogram){
        HistogramDisplay histogramaDisplay = new HistogramDisplay("Correos", histogram);
        histogramaDisplay.execute();
    }
    
}