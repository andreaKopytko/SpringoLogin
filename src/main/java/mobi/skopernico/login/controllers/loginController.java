package mobi.skopernico.login.controllers;


import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.qos.logback.core.model.Model;
import mobi.skopernico.login.domains.Utente;
import mobi.skopernico.login.services.UtenteServices;

@Controller
@RequestMapping("/")
public class loginController {
    
    UtenteServices utenteServices;

    // Visualizza Main Page
    @GetMapping
    public ModelAndView showMainPage() {
        return new ModelAndView("index.html");
    }

    // mostra pagina di login o di registrazione in base al parametro
    @GetMapping("/users")
    public ModelAndView utenteRedirection(@RequestParam("type") String userChoice) {

        // login
        if(userChoice.equals("new")) {
            return new ModelAndView("login")
            .addObject("signedUtente", new Utente());
        }

        // registrazione
        return new ModelAndView("registrazione")
        .addObject("newUtente", new Utente());
    }

    // handler di registrazione di un nuovo utente
    @PostMapping("/user/new")
    public ModelAndView registrazioneUtente(@ModelAttribute Utente newUtente) {

        utenteServices.addUtente(newUtente);
        String nickname = newUtente.getNickname();

        return new ModelAndView("redirect:/user/" + nickname);
    }

    // handler di accesso dell'utente
    @PostMapping("/user/login")
    public ModelAndView loginUtente(@ModelAttribute Utente form, RedirectAttributes ra) {
        
        String nickname = form.getNickname();
        
        // ricavo utente tramite la search by nickname
        Optional<Utente> utente = utenteServices.getUtenteByNickname(form.getNickname());

        return new ModelAndView("redirect:/user/" + nickname);
    }

    // view dettagli dell'utente
    public ModelAndView showUtente(@PathVariable("nickname") String nickname) {

        Optional<Utente> utente = utenteServices.getUtenteByNickname(nickname);

        //return new ModelAndView("user").addObject("utente", utente);
        return new ModelAndView("user").addObject("utente", utente.get());
    }

}
