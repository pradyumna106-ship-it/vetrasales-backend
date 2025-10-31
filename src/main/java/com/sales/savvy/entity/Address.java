package com.sales.savvy.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Address {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String fullName;
	    private String phone;
	    private String pincode;
	    private String street;
	    private String city;
	    private String state;
	    private String landmark;
	    private String type; // home / office / other

	    @ManyToOne
	    @JoinColumn(name = "customer_id")
	    @JsonBackReference
	    private Customer customer;

	    // No-arg constructor
	    public Address() {}

	    // All-arg constructor
	    public Address(Long id, String fullName, String phone, String pincode, String street, String city, String state,
	                   String landmark, String type, Customer customer) {
	        this.id = id;
	        this.fullName = fullName;
	        this.phone = phone;
	        this.pincode = pincode;
	        this.street = street;
	        this.city = city;
	        this.state = state;
	        this.landmark = landmark;
	        this.type = type;
	        this.customer = customer;
	    }

	    // Getters and Setters

	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	    public String getFullName() { return fullName; }
	    public void setFullName(String fullName) { this.fullName = fullName; }

	    public String getPhone() { return phone; }
	    public void setPhone(String phone) { this.phone = phone; }

	    public String getPincode() { return pincode; }
	    public void setPincode(String pincode) { this.pincode = pincode; }

	    public String getStreet() { return street; }
	    public void setStreet(String street) { this.street = street; }

	    public String getCity() { return city; }
	    public void setCity(String city) { this.city = city; }

	    public String getState() { return state; }
	    public void setState(String state) { this.state = state; }

	    public String getLandmark() { return landmark; }
	    public void setLandmark(String landmark) { this.landmark = landmark; }

	    public String getType() { return type; }
	    public void setType(String type) { this.type = type; }

	    public Customer getCustomer() { return customer; }
	    public void setCustomer(Customer customer) { this.customer = customer; }

	    @Override
	    public String toString() {
	        return "Address [id=" + id + ", fullName=" + fullName + ", phone=" + phone + ", pincode=" + pincode
	                + ", street=" + street + ", city=" + city + ", state=" + state + ", landmark=" + landmark + ", type="
	                + type + ", customer=" + (customer != null ? customer.getId() : null) + "]";
	    }
}
