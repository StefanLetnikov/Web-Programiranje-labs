package mk.finki.ukim.mk.lab.web.controlers;

import mk.finki.ukim.mk.lab.exeptions.InvalidArgumentsException;
import mk.finki.ukim.mk.lab.exeptions.PasswordsDoNotMatchException;
import mk.finki.ukim.mk.lab.exeptions.UsernameAlreadyExistsException;
import mk.finki.ukim.mk.lab.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final AuthService authService;

    public RegisterController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        return "register";
    }

    @PostMapping
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String repeatPassword,
                           @RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam String dateOfBirth) {
        LocalDate localDate = LocalDate.parse(dateOfBirth);
        try {
            authService.register(username, password, repeatPassword, name, surname, localDate);
            return "redirect:/login";
        } catch (InvalidArgumentsException | UsernameAlreadyExistsException | PasswordsDoNotMatchException exception) {
            return "redirect:/register?error=" + exception.getMessage();
        }
    }

}
