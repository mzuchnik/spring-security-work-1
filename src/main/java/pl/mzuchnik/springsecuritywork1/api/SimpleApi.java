package pl.mzuchnik.springsecuritywork1.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mzuchnik.springsecuritywork1.service.AuthenticationCounter;

import java.security.Principal;

@RestController
public class SimpleApi {

    private AuthenticationCounter authenticationCounter;

    @Autowired
    public SimpleApi(AuthenticationCounter authenticationCounter) {
        this.authenticationCounter = authenticationCounter;
    }

    @GetMapping("")
    public String allInfo(Principal principal) {
        if (principal == null) {
            return "Hello for all";
        }
        else {
            String username = principal.getName();
            return "Hello ALL: " + username + "</t> miło cię widzieć po raz " + authenticationCounter.getCounter(username);
        }
    }

    @GetMapping("/user")
    public String userInfo(Principal principal) {
        String username = principal.getName();
        return "Hello USER: " + username + "</t> miło cię widzieć po raz " + authenticationCounter.getCounter(username);
    }

    @GetMapping("/admin")
    public String adminInfo(Principal principal) {
        String username = principal.getName();
        return "Hello ADMIN:" + username + "</t> miło cię widzieć po raz " + authenticationCounter.getCounter(username);
    }

    @GetMapping("/sayBye")
    public String sayBye() {
        return "papa ;*";
    }
}
