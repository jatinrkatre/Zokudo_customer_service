package com.customer.zokudo.entities;

import javax.persistence.*;

import com.customer.zokudo.enums.Status;
import lombok.Data;

@Data
@Entity
@Table(name="merchant_has_tid")
public class MerchantHasTIDs extends AbstractEntity{
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*@ManyToOne
	@JoinColumn(name="merchant_id",referencedColumnName = "id")
	private Merchant merchant;*/
	
    @Column(name="t_id")
    private String terminalId;

	@Column(name="tid_status")
	@Enumerated(EnumType.STRING)
	private Status terminalStatus;

}
