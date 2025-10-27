package entity;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String email;
	private String paymentId;
	private int amount;
	private LocalDateTime paymentDate;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	@JsonBackReference
	private Customer customer;

	@OneToOne
	@JoinColumn(name = "order_id")
	@JsonBackReference
	private Orders order;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(Long id, String email, String paymentId, int amount, LocalDateTime paymentDate, Customer customer,
			Orders order) {
		super();
		this.id = id;
		this.email = email;
		this.paymentId = paymentId;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.customer = customer;
		this.order = order;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", email=" + email + ", paymentId=" + paymentId + ", amount=" + amount
				+ ", paymentDate=" + paymentDate + ", customer=" + customer + ", order=" + order + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}
}
