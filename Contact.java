

public class Contact {
	// variables needed for the class
	private String contactId;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	
	
	// creating an object of the class
	public Contact(String contactId, String firstName, String lastName, String phone, String address) {
		// checking ID for requirements
		if (contactId == null || contactId.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		// checking first name for requirements
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		// checking last name for requirements
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		// checking phone for requirements
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		// checking address for requirements
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		// handling with no exceptions
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	// getter methods needed
	public String getId() {
		return contactId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
    
	// setter methods for use by ContactService
	// no set methods for the contactId because it should not be updated
	public void setFirstName(String fName) {
		if (fName == null || fName.length() > 10) {
			throw new IllegalArgumentException("Ivalid First Name");
		}
		this.firstName = fName;
	}
	public void setLastName(String lName) {
		if (lName == null || lName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		this.lastName = lName;
	}
	public void setPhone(String newPhone) {
		if (newPhone == null || newPhone.length() != 10) {
			throw new IllegalArgumentException("Inavlid Phone Number");
		}
		this.phone = newPhone;
	}
	public void setAddress(String newAddress) {
		if (newAddress == null || newAddress.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		this.address = newAddress;
	}
}