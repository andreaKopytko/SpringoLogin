package mobi.skopernico.login.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import mobi.skopernico.login.domains.Utente;

@Service
public class UtenteServices {

    // collezione degli utenti
    public ArrayList<Utente> utenti = new ArrayList<>();

    // getter degli utenti
    public ArrayList<Utente> getUtenti() {
        return utenti;
    }

    // inserisce un utente
    public void addUtente(Utente newUtente) {
        utenti.add(newUtente);
    }

    // restituisce l'utente cercato dato il nickname
    public Optional<Utente> getUtenteByNickname(String seachedNickname) {

        for(int i=0; i < utenti.size(); i++) {
            if(utenti.get(i).getNickname().equals(seachedNickname)){
                return Optional.of(utenti.get(i));
            }
        }

        return Optional.empty();
    }
}
