package com.example.SportyShoes.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Orders {
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", user=" + user + ", orderAmount=" + orderAmount + ", orderedDate="
				+ orderedDate + ", category=" + category + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;

	@OneToOne
	@JoinColumn(name = "user_id", nullable = false)
	private Person user;
	private double orderAmount;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate orderedDate;

	@OneToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	public Orders() {
		super();
	}

	public Orders(int orderId, Person user, double orderAmount, LocalDate orderedDate, Category category) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.orderAmount = orderAmount;
		this.orderedDate = orderedDate;
		this.category = category;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Person getUser() {
		return user;
	}

	public void setUser(Person user) {
		this.user = user;
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public LocalDate getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(LocalDate orderedDate) {
		this.orderedDate = orderedDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
