package com.customer.zokudo.entities;

import java.util.List;

import javax.persistence.*;

import com.customer.zokudo.enums.Status;

import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Data
@Table(name = "brand")
public class Brand extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="brand_name")
	private String brandName;
	
	@Column(name="brand_id")
	private String brandId;
	
	@Column(name = "brand_logo")
	private String brandLogo;

	@Column(name = "description")
	private String description;

	@Column(name = "offer_page_url")
	private String offerPageUrl;
 
	@Column(name = "offer_img")
	private String offerImg;

	@Column(name = "category_img1")
	private String categoryImg1;

	@Column(name = "category_img2")
	private String categoryImg2;

	@Column(name = "category_img3")
	private String categoryImg3;

	@Column(name = "min_price")
	private double minPrice;

	@Column(name = "max_price")
	private double maxPrice;

	@Column(name = "location")
	private String location;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="brand_id", referencedColumnName = "id")
	private List<Category> categories;

	/*@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="brand_id", referencedColumnName = "brand_id")
	private List<Merchant> merchants;*/
}
