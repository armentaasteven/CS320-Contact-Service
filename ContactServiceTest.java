
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

	//creates a contact and test values
	// Generates contacts with a unique ID using the ContactService addContact method
	@Test
	void testContactServiceClass() {
		ContactService.addContact("Tom", "Brady", "9095679789", 
				"123 9th St. San Bernardino, CA 91158");
		//System.out.println(ContactService.contactList.get(0).getId());	used for debugging
		assertTrue(ContactService.contactList.get(0).getId().equals("1000000002"));
		assertTrue(ContactService.contactList.get(0).getFirstName().equals("Tom"));
		assertTrue(ContactService.contactList.get(0).getLastName().equals("Brady"));
		assertTrue(ContactService.contactList.get(0).getPhone().equals("9095679789"));
		assertTrue(ContactService.contactList.get(0).getAddress().equals("123 9th St. San Bernardino, CA 91158"));
	}
	// confirm deletion of a contact
	@Test
	void testContactServiceDelete() {
		ContactService.addContact("Tom", "Brady", "9095679789", 
				"123 9th St. San Bernardino, CA 91158");
		int size = ContactService.contactList.size();
		//System.out.println(ContactService.contactList.get(size - 1).getId());
		ContactService.deleteContact("1000000003");
		//ContactService.searchContact("1000000003");
		//System.out.println(ContactService.contactList.get(1).getId());
		assertTrue(ContactService.searchContact("1000000003") == 2);
	}
	// update first name test
	@Test
	void testContactServiceUpdateFirstName() {
		ContactService.addContact("Grace", "Brady", "9095679789", "Christmas Ave.");
		int size = ContactService.contactList.size();
		System.out.println(ContactService.contactList.get(size - 1).getId());
		System.out.println(ContactService.contactList.get(size - 1).getFirstName());
		ContactService.updateFirstName("1000000003", "Grace");
		System.out.println(ContactService.contactList.get(size - 1).getFirstName());
		assertTrue(ContactService.contactList.get(size - 1).getFirstName().equals("Grace"));
	}
	// using 1000000003 to test the rest
	// test confirming update to last name
	@Test
	void testContactServiceUpdateLastName() {
		int size = ContactService.contactList.size();
		ContactService.updateLastName("1000000003", "Daniels");
		assertTrue(ContactService.contactList.get(size - 1).getLastName().equals("Daniels"));
	}
	// test confirming update to phone number
	@Test
	void testContactServiceUpdatePhone() {
		int target = 0;
		target = ContactService.findIndex("1000000003");
		ContactService.updatePhoneNum("1000000003", "8884446161");
		assertTrue(ContactService.contactList.get(target).getPhone().equals("8884446161"));
	}
	// test confirming update to address
	@Test
	void testContactServiceUpdateAddress() {
		int target = 0;
		target = ContactService.findIndex("1000000003");
		ContactService.updateAddress("1000000003", "456 9th St. Acton, CA 91542");
		assertTrue(ContactService.contactList.get(target).getAddress().equals("456 9th St. Acton, CA 91542"));
	}
	
	// test to confirm unique ID
	@Test
	void testContactServiceUniqueId() {
		Contact newContact = new Contact("49594", "Sanchez", "Daniels", "9095679789", "Original Contact Address");
		ContactService.addContact(newContact);
		Contact duplicateId = new Contact("49594", "Sanchez", "Daniels", "9095679789", "Duplicate Contact Address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.addContact(duplicateId);
		});
	}

}