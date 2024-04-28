package mobi.skopernico.login.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mobi.skopernico.login.domains.Utente;

@Controller
//@RequestMapping("/utente")
public class loginController {
    
    /*
     * La gestione della visualizzazio delle pagine non è stata fatta tramite 
     * query string per varie problematiche, quindi ho utilizzato questa soluzione :(
     */

    // Visualizza Main Page
    @GetMapping("")
    public ModelAndView showMainPage() {
        return new ModelAndView("index.html");
    }

    // Visualizza Login Page
    @GetMapping("/new")
    public ModelAndView showLogin() {
        return new ModelAndView("login.html");
    }

    // Visualizza pagina di Registrazione
    @GetMapping("/login")
    public ModelAndView showRegistrazione() {
        return new ModelAndView("registrazione.html");
    }

    @GetMapping("/user")
    public ModelAndView showUtente() {
        return new ModelAndView("user.html");
    }
}
