package service;

import java.util.List;

import domain.University;

public interface UniversityService {

	University save(University university);

	University findById(Long id);

	University update(University university);

	void deleteById(Long id);

	List<University> findAll();

	List<University> findByName(String name);

	List<University> findByAccreditationLevel(String accreditationLevel);

	List<University> findByInstitutesNumber(Integer institutesNumber);

	List<University> findByStudentsNumber(Integer studentsNumber);

}