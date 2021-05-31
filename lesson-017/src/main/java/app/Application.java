package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import domain.University;
import service.UniversityService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		UniversityService universityService = ctx.getBean(UniversityService.class);

		University university1 = new University();
		university1.setName("LMK");
		university1.setAccreditationLevel("college");
		university1.setInstitutesNumber(1);
		university1.setStudentsNumber(450);
		university1.setAddress("70170, Lviv Shas squ 5");

		University university2 = new University();
		university2.setName("LNU");
		university2.setAccreditationLevel("university");
		university2.setInstitutesNumber(2);
		university2.setStudentsNumber(1750);
		university2.setAddress("70170, Lviv Fr str 1");

		University university3 = new University();
		university3.setName("LNMA");
		university3.setAccreditationLevel("academy");
		university3.setInstitutesNumber(3);
		university3.setStudentsNumber(750);
		university3.setAddress("70170, Lviv Rom str 7");

		// save to DB
		universityService.save(university1);
		universityService.save(university2);
		universityService.save(university3);

		// read from DB

		System.out.println(universityService.findById((long) 1));
		System.out.println("LMK: " + universityService.findByName("LMK"));
		System.out.println("All colleges: " + universityService.findByAccreditationLevel("college"));
		System.out.println("All universities: " + universityService.findByAccreditationLevel("university"));
		System.out.println("All academies: " + universityService.findByAccreditationLevel("academy"));
		System.out.println("3 institutes are in ... " + universityService.findByInstitutesNumber(3));
		System.out.println("450 students study in ... " + universityService.findByStudentsNumber(450));

		// read all
		System.out.println("Output of all DB:");
		universityService.findAll().stream().forEach(System.out::println);

		// update from DB
		University update = universityService.findById((long) 1);
		update.setStudentsNumber(1111);
		universityService.update(update);

		// delete from DB
		universityService.deleteById((long) 2);
		System.out.println("record 2 was deleted");

		System.out.println("Output of all DB:");
		universityService.findAll().stream().forEach(System.out::println);
	}
}