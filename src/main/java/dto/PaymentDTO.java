package dto;

public class PaymentDTO {

	private String email;
	private String paymentId;
	private String orderId;
	private int amount;

	public PaymentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentDTO(String email, String paymentId, String orderId, int amount) {
		super();
		this.email = email;
		this.paymentId = paymentId;
		this.orderId = orderId;
		this.amount = amount;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "PaymentDTO [email=" + email + ", paymentId=" + paymentId + ", orderId=" + orderId + ", amount=" + amount
				+ "]";
	}
}
