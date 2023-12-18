package Vacation.vacationrental.Controller;

import Vacation.vacationrental.Model.User;
import Vacation.vacationrental.Service.InfoImplementation.UserImplementation;
import Vacation.vacationrental.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;



    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("registerRequest", new User());
        return "registration_page";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("loginRequest", new User());
        return "login_page";
    }


    @PostMapping("/register")
    public String register(@ModelAttribute User user){
        System.out.println("register request :" + user);
        User registerUser = userService.createUser(user);
//        User registerUser = userImplementation.createUser(user);
        return registerUser == null ? "error_page" : "redirect:/login";
//        User registeredEmployee = userService.registerEmployee( user.getEmail(), user.getPassword());
//        return registeredEmployee == null ? "error_page" : "redirect:/login";

    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model){
        System.out.println("login request :" + user);

        User authenticate = userService.getUser(user);
        if(authenticate !=null){
            model.addAttribute("userLogin", authenticate.getEmail());
            return "booking";
        }else{
            return "error_page";
        }
//        User authenticated = userService.authenticate(user.getEmail(), user.getPassword());
//        if(authenticated !=null){
//            model.addAttribute("employeeLogin", authenticated.getEmail());
//            return "booking";
//        }else {
//            return "error_page";
//        }

    }


}
