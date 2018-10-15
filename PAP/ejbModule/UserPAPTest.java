

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import PAP.ENTITY.IUserPAP;
import PAP.ENTITY.IUserPAPFactory;
import PAP.ENTITY.UserPAPFactory;
import PAP.SESSION.IApplication;

class UserPAPTest {
	private static IApplication app;
	@Test
	void testCreate() {
		IUserPAPFactory createUserFactory = new UserPAPFactory();
		IUserPAP userJustCreated = createUserFactory.createUser("test@test.com", "cityTest", "nameTest", "passTest");
		assertEquals(userJustCreated.getMail(),"test@test.com");
		assertEquals(userJustCreated.getCity(), "cityTest");
		assertEquals(userJustCreated.getName(), "nameTest");
		assertEquals(userJustCreated.getPass(), "passTest");
		
	}
}
