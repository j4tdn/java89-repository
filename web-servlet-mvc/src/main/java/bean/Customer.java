package bean;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import validation.StartsWith;

public class Customer {

	@NotNull(message = "is required")
	private String firstName;

	@NotNull(message = "is required")
	@Size(min = 5, message = "at least 5 letters")
	private String lastName;
	
	@NotNull(message = "is required")
	@Min(value = 4, message = "freePasses must greater than 4")
	@Max(value = 8, message = "freePasses must less than 8")
	private Integer freePasses;

	@NotNull(message = "is required")
	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
	private String postalCode;
	
	@StartsWith(value="BKIT", message="must start with BKIT")
	private String courseCode;
	
	public Customer() {

	}

	public Customer(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
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

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getCourseCode() {
		return courseCode;
	}
	
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

}
