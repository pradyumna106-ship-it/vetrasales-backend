package dto;

public class SetPasswordDTO {

	private String email;
	private String newPassword;

	public SetPasswordDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SetPasswordDTO(String email, String newPassword) {
		super();
		this.email = email;
		this.newPassword = newPassword;
	}

	@Override
	public String toString() {
		return "SetPasswordDTO [email=" + email + ", newPassword=" + newPassword + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}