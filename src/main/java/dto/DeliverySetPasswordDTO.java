package dto;

public class DeliverySetPasswordDTO {
	private String deliveryEmail;
	private String newPassword;

	public String getDeliveryEmail() {
		return deliveryEmail;
	}

	public void setDeliveryEmail(String deliveryEmail) {
		this.deliveryEmail = deliveryEmail;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@Override
	public String toString() {
		return "DeliverySetPasswordDTO{" + "deliveryEmail='" + deliveryEmail + '\'' + ", newPassword='" + newPassword
				+ '\'' + '}';
	}
}
