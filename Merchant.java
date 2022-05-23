package com.customer.zokudo.entities;

import com.customer.zokudo.enums.Status;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="merchant", indexes = {
		@Index(name = "m_id", columnList = "m_id")
})
public class Merchant extends AbstractEntity {

	@Column(name="merchant_full_name")
	private String merchantFullName;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name="mobile_no", nullable = false)
	private String mobileNo;

	@Column(name="m_id", nullable = false)
	private String merchantId;

	@Column(name = "reg_tid_count", nullable = false)
	private int registeredTidCount;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private Status status;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="merchant_id", referencedColumnName = "id")
	private List<MerchantHasTIDs> terminals;

	@ManyToOne
	@JoinColumn(name = "brand_id", referencedColumnName = "id")	
	private Brand brand;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String mId) {
		this.merchantId = mId;
	}

	public void setMerchantFullName(String merchantFullName) { this.merchantFullName = merchantFullName; }

	public int getRegisteredTidCount() {
		return registeredTidCount;
	}

	public void setRegisteredTidCount(int registeredTidCount) {
		this.registeredTidCount = registeredTidCount;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getMerchantFullName() { return merchantFullName; }

	public List<MerchantHasTIDs> getTerminals() {
		return terminals;
	}

	public void setTerminals(List<MerchantHasTIDs> terminals) {
		this.terminals = terminals;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public Brand getBrand() {
		return this.brand;
	}
}
