package Vacation.vacationrental.Service.InfoImplementation;

import Vacation.vacationrental.Model.Information;
import Vacation.vacationrental.Repository.InformationRepository;
import Vacation.vacationrental.Service.InformationInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InformationService implements InformationInterface {
    @Autowired
    private InformationRepository infoRepo;


    @Override
    public Information saveInformation(Information information) {
        return infoRepo.save(information);
    }

    @Override
    public Information updateInformation(Information information) {
        Information n = findInformationById(information);
        if (n != null) {
            n.setId(information.getId());
            n.setFirstname(information.getFirstname());
            n.setLastname(information.getLastname());
            n.setEmail(information.getLastname());
            n.setPhone(information.getPhone());
            n.setGuests(information.getGuests());
            return infoRepo.save(n);
        } else {
            return saveInformation(information);

        }
    }

    @Override
    public void deleteInformationById(Information information) {
        infoRepo.delete(information);

    }

    @Override
    public List<Information> InformationList(String keyword) {
        if (keyword != null){
            return infoRepo.search(keyword);

    }
     return infoRepo.findAll();
}

    @Override
    public Information findInformationById(Information information) { return infoRepo.findById(information.getId()).get();

    }
}
