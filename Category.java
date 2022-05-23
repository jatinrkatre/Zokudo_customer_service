package com.customer.zokudo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.customer.zokudo.enums.BrandCategory;

import lombok.Data;

@Data
@Entity
@Table(name= "brand_category")
public class Category extends AbstractEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="category_name")
	private String categoryName;
}
