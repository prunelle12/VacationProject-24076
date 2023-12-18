package Vacation.vacationrental.Controller;

import Vacation.vacationrental.Model.Information;
import Vacation.vacationrental.Repository.InformationRepository;
import Vacation.vacationrental.Service.InfoImplementation.InformationService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.Authenticator;
import java.util.List;
import java.util.Optional;

@Controller
public class InformationController {
    @Autowired
    private InformationRepository repo;
    @Autowired
    private InformationService infoservice;

    @GetMapping("/registerInfo")
    public String getRegistration_Page(Model model){
        model.addAttribute("informationRequest", new Information());
        model.addAttribute("RegistrationPage", "Add new information");
        return "booking";

    }

    @GetMapping("/inf")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String InfoList(Model model,@Param("keyword") String keyword, Authentication authentication){
        List<Information> ListOfInformation = infoservice.InformationList(keyword);
        model.addAttribute("ListOfInformation", ListOfInformation);

        return "Display";

    }

    @PostMapping("/saveInformation")
    public String register (@ModelAttribute  Information information){
        System.out.println("register request:" +information);
        Information registeredInformation = infoservice.saveInformation(information);
        return "redirect:/inf";

    }
    @GetMapping("/updateInformation/{id}")
    public String updateInformation(@PathVariable("id") Integer id, Model model){
        Optional<Information> infos = repo.findFirstById(id);
        Information infor = infos.get();
        model.addAttribute("infor", infor);

        return "Edit";
    }

    @GetMapping("/deleteInformation/{id}")
    public String deleteInformation(@PathVariable("id") Integer id){
        repo.deleteById(id);
        System.out.println("Deleted information successfully");
        return "redirect:/inf";
    }
}
