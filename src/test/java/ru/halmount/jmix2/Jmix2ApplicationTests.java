package ru.halmount.jmix2;

import io.jmix.core.FetchPlan;
import io.jmix.core.FetchPlans;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.halmount.jmix2.Repository.ReestrRepo;
import ru.halmount.jmix2.Repository.TeacherRepo;
import ru.halmount.jmix2.Repository.UserRepo;
import ru.halmount.jmix2.entity.Reestr;
import ru.halmount.jmix2.entity.Teacher;
import ru.halmount.jmix2.entity.User;
import ru.halmount.jmix2.security.DatabaseUserRepository;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class Jmix2ApplicationTests {

	@Autowired
	DatabaseUserRepository databaseUserRepository;
	@Autowired
	UserRepo userRepository;

	@Autowired
	ReestrRepo reestrRepo;

	@Autowired
	TeacherRepo teacherRepo;

	public ArrayList<Object> entitiesToDelete = new ArrayList<>();
	@Autowired
	FetchPlans fetchPlans;
	@Test
	void checkUser() {
		String sysUserName = System.getProperty("user.name");
		User sysUser = databaseUserRepository.getSystemUser();
		assertEquals(sysUser.getUsername(), sysUserName, "System user is correct");
	}

	@Test
	void contextLoads() {
	}

	@Test
	void findById() {
		//given
		String firstName = "Василий";
		String lastName = "Пупкин";
		var user = userRepository.create();
		user.setUsername("findById_user");
		user.setFirstName(firstName);
		user.setLastName(lastName);
		var teacher = teacherRepo.create();
		teacher.setUser(user);
		teacher = teacherRepo.save(teacher);
		entitiesToDelete.add(teacher);
		var createdUUID = teacher.getId();
		var fetchPlan = fetchPlans.builder(Teacher.class)
				.addFetchPlan(FetchPlan.LOCAL)
				.add("user")
				.build();
		//when
		var foundTeacher = teacherRepo.getById(teacher.getId(), fetchPlan);
		var foundUUID = foundTeacher.getId();
		//then
		assertEquals(createdUUID, foundUUID, "Not equals");
		assertNotNull(foundTeacher.getUser(), "User is null");
		assertEquals(firstName, foundTeacher.getUser().getFirstName(), "Not equals");
		assertEquals(lastName, foundTeacher.getUser().getLastName(), "Not equals");
	}

	@Test
	void findTeacherByName() {
		//given
		String firstName = "Василий";
		String lastName = "Пупкин";
		var user = userRepository.create();
		user.setUsername("Test_findTeacherByName");
		user.setFirstName(firstName);
		user.setLastName(lastName);
		var teacher = teacherRepo.create();
		teacher.setUser(user);
		teacher = teacherRepo.save(teacher);
		entitiesToDelete.add(teacher);
		List<UUID> createdUUID = Stream.of(teacher.getId()).collect(Collectors.toList());
		//when
		List<Teacher> foundTeacher = teacherRepo.findTeachersByName(firstName, lastName);
		List<UUID> foundUUID = foundTeacher.stream().map(Teacher::getId).collect(Collectors.toList());
		//then
		assertEquals(createdUUID, foundUUID, "Not equals");
	}
	@Test
	void getReestrByNum() {
		//given
		var user = userRepository.create();
		user.setUsername("TEST_USR");
		var teacher = teacherRepo.create();
		teacher.setUser(user);
		Random random = new Random();
		Integer number1 = random.nextInt();
		var reestr1 = reestrRepo.create();
		reestr1.setNum(number1);
		reestr1.setTeacher(teacher);
		Integer number2 = random.nextInt();
		var reestr2 = reestrRepo.create();
		reestr2.setNum(number2);
		reestr2.setTeacher(teacher);
		teacher.setReestrs(List.of(reestr1, reestr2));
		teacherRepo.save(teacher);
		entitiesToDelete.add(teacher);
		//when
		var foundSheet = reestrRepo.getReestrByNum(number1);
		//then
		assertEquals(reestr1.getId(), foundSheet.getId(), "Not equals");
	}

	@Test
	void getExamSheetsByTeacherEquals() {
		//given
		var user = userRepository.create();
		user.setUsername("TEST_USR");
		var teacher = teacherRepo.create();
		teacher.setUser(user);
		var reestr1 = reestrRepo.create();
		reestr1.setNum(1);
		reestr1.setTeacher(teacher);
		var reestr2 = reestrRepo.create();
		reestr2.setNum(2);
		reestr2.setTeacher(teacher);
		teacher.setReestrs(List.of(reestr1, reestr2));
		teacherRepo.save(teacher);
		entitiesToDelete.add(teacher);
		//when
		List<UUID> foundIds = reestrRepo.getReestrsByTeacher(teacher)
				.stream().sorted(Comparator.comparing(Reestr::getNum))
					.map(Reestr::getId).collect(Collectors.toList());
		List<UUID> createdIds = List.of(reestr1.getId(), reestr2.getId());
		//then
		assertEquals(createdIds, foundIds, "Not equals");
	}

}
