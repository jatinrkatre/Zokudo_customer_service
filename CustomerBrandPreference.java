package com.customer.zokudo.entities;

import com.customer.zokudo.enums.BrandCategory;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="customer_brand_preferences")
public class CustomerBrandPreference extends  AbstractEntity {
    private static final long serialVersionUID = 1L;

    @Column(name="preference_category")
    private String preference;
}
