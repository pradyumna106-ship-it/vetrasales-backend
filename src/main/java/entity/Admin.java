package entity;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String businessName;
	private String businessType;
	private String gstNumber;
	@Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]", message = "Invalid PAN format")
	private String panNumber;
	@Column(unique = true)
	@Email(message = "Invalid email format")
	private String companyEmail;
	private String password;
	private String businessAddress;
	private String city;
	private String state;
	private String pincode;
	private String documentPath;
	private String role;
	private String status;

	@OneToMany(mappedBy = "admin")
	@JsonManagedReference
	private List<Product> products; 


	@PrePersist
	public void setRole() {
		this.role = "admin";
	}


	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Admin(Long id, String businessName, String businessType, String gstNumber, String panNumber,
			String companyEmail, String password, String businessAddress, String city, String state, String pincode,
			String documentPath, String role, String status, List<Product> products) {
		super();
		this.id = id;
		this.businessName = businessName;
		this.businessType = businessType;
		this.gstNumber = gstNumber;
		this.panNumber = panNumber;
		this.companyEmail = companyEmail;
		this.password = password;
		this.businessAddress = businessAddress;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.documentPath = documentPath;
		this.role = role;
		this.status = status;
		this.products = products;
	}


	@Override
	public String toString() {
		return "Admin [id=" + id + ", businessName=" + businessName + ", businessType=" + businessType + ", gstNumber="
				+ gstNumber + ", panNumber=" + panNumber + ", companyEmail=" + companyEmail + ", password=" + password
				+ ", businessAddress=" + businessAddress + ", city=" + city + ", state=" + state + ", pincode="
				+ pincode + ", documentPath=" + documentPath + ", role=" + role + ", status=" + status + ", products="
				+ products + "]";
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getBusinessName() {
		return businessName;
	}


	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}


	public String getBusinessType() {
		return businessType;
	}


	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}


	public String getGstNumber() {
		return gstNumber;
	}


	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}


	public String getPanNumber() {
		return panNumber;
	}


	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}


	public String getCompanyEmail() {
		return companyEmail;
	}


	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getBusinessAddress() {
		return businessAddress;
	}


	public void setBusinessAddress(String businessAddress) {
		this.businessAddress = businessAddress;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getPincode() {
		return pincode;
	}


	public void setPincode(String pincode) {
		this.pincode = pincode;
	}


	public String getDocumentPath() {
		return documentPath;
	}


	public void setDocumentPath(String documentPath) {
		this.documentPath = documentPath;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}

	
}
