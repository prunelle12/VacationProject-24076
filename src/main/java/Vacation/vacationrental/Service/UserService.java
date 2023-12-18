package Vacation.vacationrental.Service;

import Vacation.vacationrental.Model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    User findUserBYId(User user);
    User getUser(User user);
    List<User> userList();
}

