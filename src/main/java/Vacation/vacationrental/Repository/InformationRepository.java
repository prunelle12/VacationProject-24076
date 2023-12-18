package Vacation.vacationrental.Repository;

import Vacation.vacationrental.Model.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface InformationRepository extends JpaRepository<Information, Integer> {

    Optional<Information> findById(Integer id);
    Optional<Information> findFirstById(Integer id);

    @Query("SELECT p FROM Information p WHERE CONCAT(p.id,'',p.firstname,'',p.lastname,'',p.email,'',p.phone,'',p.guests) LIKE %?1% ")
    public List<Information>search(String keyword);
}
