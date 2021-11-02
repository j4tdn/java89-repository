package bean;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

public class Customer {
	
	@NotNull(message = "lastName cannot be null")
	private String firstName;
	
	@NotNull(message = "lastName cannot be null")
	@Size(min=5,message = "at least 5 letters")
	private String lastName;
	
	@Min(value = 4,message = "freePasses must greater than 4")
	@Max(value = 8,message = "freePasses must  less than 8")
	private Integer freePasses;
	
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
	@Pattern(regexp = "^[a-zA-Z0-9] {5}",message = "only 5 chars/digits")
	private String postalCode;
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
	
	
}
