package Vacation.vacationrental.Service;

import Vacation.vacationrental.Model.Information;

import java.util.List;

public interface InformationInterface {
    Information saveInformation(Information information);
    Information updateInformation(Information information);
    void deleteInformationById(Information information);
    List<Information> InformationList(String keyword);
    Information findInformationById(Information information);
}
