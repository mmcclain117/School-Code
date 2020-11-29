public class Person {
	private String name;
	private String phone;
	private String email;
	private ID ID;
	private Object key;

	public Person(String name, String phone, String email, ID ID) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.ID = ID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setID(ID ID) {
		this.ID = ID;
	}

	public ID getID() {
		return ID;
	}

	public void setKey(Object k) {
		key = k;
	}

	public Object getKey() {
		return key;
	}

	public String toString() {
		return "Name: " + name + "\n" + "Email: " + email + "\n" + "Phone: " + phone + "\n" + "ID: " + ID;
	}
}
