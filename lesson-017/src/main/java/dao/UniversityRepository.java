package dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import domain.University;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long>, CrudRepository<University, Long> {

	List<University> findByName(String name);

	List<University> findByAccreditationLevel(String accreditationLevel);

	List<University> findByInstitutesNumber(Integer institutesNumber);

	List<University> findByStudentsNumber(Integer studentsNumber);

}