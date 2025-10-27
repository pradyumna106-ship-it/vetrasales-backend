package dto;

public class EmailRequestDTO {

	private String email;

	public EmailRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmailRequestDTO(String email) {
		super();
		this.email = email;
	}

	@Override
	public String toString() {
		return "EmailRequestDTO [email=" + email + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}