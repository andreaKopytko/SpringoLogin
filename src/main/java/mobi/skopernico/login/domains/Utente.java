package mobi.skopernico.login.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utente {
    
    private String nickname;
    private String email;
    private String password;
    
}
