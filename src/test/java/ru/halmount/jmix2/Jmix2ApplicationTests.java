package ru.halmount.jmix2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.halmount.jmix2.Repository.ReestrRepo;
import ru.halmount.jmix2.entity.Reestr;
import ru.halmount.jmix2.entity.User;
import ru.halmount.jmix2.security.DatabaseUserRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Jmix2ApplicationTests {

	@Autowired
	DatabaseUserRepository databaseUserRepository;

	@Autowired
	ReestrRepo reestrRepo;

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
	int getReestrByNum(){
			var reestr = reestrRepo.create();
//			reestr.


	}

}
