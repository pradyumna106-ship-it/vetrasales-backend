package com.sales.savvy.dto;

public class CustomerSummaryDTO {
	  private String username;
	  private int totalOrders;
	  private double totalSpend;
	  public CustomerSummaryDTO() {
		super();
		// TODO Auto-generated constructor stub
	  }
	  @Override
	public String toString() {
		return "CustomerSummaryDTO [id=" + id + ", username=" + username + ", totalOrders=" + totalOrders
				+ ", totalSpend=" + totalSpend + "]";
	}
	  public int getId() {
		return id;
	}
	  public void setId(int id) {
		  this.id = id;
	  }
	  public String getUsername() {
		  return username;
	  }
	  public void setUsername(String username) {
		  this.username = username;
	  }
	  public int getTotalOrders() {
		  return totalOrders;
	  }
	  public void setTotalOrders(int totalOrders) {
		  this.totalOrders = totalOrders;
	  }
	  public double getTotalSpend() {
		  return totalSpend;
	  }
	  public void setTotalSpend(double totalSpend) {
		  this.totalSpend = totalSpend;
	  }
	  public CustomerSummaryDTO( String username, int totalOrders, double totalSpend) {
		super();
		this.username = username;
		this.totalOrders = totalOrders;
		this.totalSpend = totalSpend;
	  }
	}

