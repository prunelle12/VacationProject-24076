package Vacation.vacationrental.Service.InfoImplementation;

import Vacation.vacationrental.Model.User;
import Vacation.vacationrental.Repository.UserRepository;
import Vacation.vacationrental.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserImplementation implements UserService {
    @Autowired
    UserRepository userRepo;

    @Override
    public User createUser(User user) {

        return userRepo.save(user);
    }

    @Override
    public User findUserBYId(User user) {
        return userRepo.findById(user.getId()).get();
    }

    @Override
    public User getUser(User user) {
        return userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword()).orElse(null);
    }

    @Override
    public List<User> userList() {
        return userRepo.findAll();
    }
}
