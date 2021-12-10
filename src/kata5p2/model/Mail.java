package kata5p2.model;

public class Mail {
    private final String email;
    
    public Mail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    
    public String getDomain() {
        return this.email.substring(email.indexOf("@") + 1);
    }
    
    public static boolean isMail (String linea) {
        return linea.matches("[-\\w\\.]+@\\w+\\.\\w+");
    }
    
}