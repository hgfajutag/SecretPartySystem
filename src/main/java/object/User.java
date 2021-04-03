package object;
import dbcon.AccessDb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class User  {

	@Override
	public String toString() {
		return "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", dateOfbirth=" + dateOfbirth + ", address=" + address + "]";
	}
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String pass;
	private LocalDate dateOfbirth;
	private Address address;
	public User() {};
	public User(String id, String firstName, String lastName, String email, LocalDate dateOfbirth, Address address) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dateOfbirth = dateOfbirth;
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDateOfbirth() {
		return dateOfbirth;
	}
	public void setDateOfbirth(LocalDate dateOfbirth) {
		this.dateOfbirth = dateOfbirth;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	public String userlogin(String email, String pass) {
		AccessDb query = new AccessDb();
		String sql = "select typeofusers FROM users WHERE email ='"+email+"' and password='"+pass+"'";
		ResultSet p=query.doquery(sql);
		//System.out.println(p);
		String usertype = "";
		if (p !=null) {
			try {
				while(p.next()) {  
					usertype = p.getString(1);
				}
				query.closeconn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	//	System.out.println(usertype);
		return usertype;
	}
	
	
	
	
	
	
}
