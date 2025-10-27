package dto;

public class AdminSignupDTO {
	private String businessName;
	private String businessType;
	private String gstNumber;
	private String panNumber;
	private String companyEmail;
	private String businessAddress;
	private String city;
	private String state;
	private String pincode;
	private String documentPath;

	public AdminSignupDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminSignupDTO(String businessName, String businessType, String gstNumber, String panNumber,
			String companyEmail, String businessAddress, String city, String state, String pincode,
			String documentPath) {
		super();
		this.businessName = businessName;
		this.businessType = businessType;
		this.gstNumber = gstNumber;
		this.panNumber = panNumber;
		this.companyEmail = companyEmail;
		this.businessAddress = businessAddress;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.documentPath = documentPath;
	}

	@Override
	public String toString() {
		return "AdminSignupDTO [businessName=" + businessName + ", businessType=" + businessType + ", gstNumber="
				+ gstNumber + ", panNumber=" + panNumber + ", companyEmail=" + companyEmail + ", businessAddress="
				+ businessAddress + ", city=" + city + ", state=" + state + ", pincode=" + pincode + ", documentPath="
				+ documentPath + "]";
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
}
