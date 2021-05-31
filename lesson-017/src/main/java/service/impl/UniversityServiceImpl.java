package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UniversityRepository;
import domain.University;
import service.UniversityService;

@Service
public class UniversityServiceImpl implements UniversityService {

	@Autowired
	private UniversityRepository universityRepository;

	@Override
	public University save(University university) {
		return universityRepository.saveAndFlush(university);
	}

	@Override
	public University findById(Long id) {
		return universityRepository.getById(id);
	}

	@Override
	public University update(University university) {
		return universityRepository.save(university);
	}

	@Override
	public void deleteById(Long id) {
		universityRepository.deleteById(id);
	}

	@Override
	public List<University> findAll() {
		return universityRepository.findAll();
	}

	@Override
	public List<University> findByName(String name) {
		return universityRepository.findByName(name);
	}

	@Override
	public List<University> findByAccreditationLevel(String accreditationLevel) {
		return universityRepository.findByAccreditationLevel(accreditationLevel);
	}

	@Override
	public List<University> findByInstitutesNumber(Integer institutesNumber) {
		return universityRepository.findByInstitutesNumber(institutesNumber);
	}

	@Override
	public List<University> findByStudentsNumber(Integer studentsNumber) {
		return universityRepository.findByStudentsNumber(studentsNumber);
	}
}