package com.example.rent.vo;

import javax.validation.constraints.NotBlank;

public class TenantListReq {

	@NotBlank(message = "Tenant identity is required!!")
	private String tenantIdentity;

	@NotBlank(message = "tenantPhone is required!!")
	private String tenantPhone;

	public TenantListReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTenantIdentity() {
		return tenantIdentity;
	}

	public void setTenantIdentity(String tenantIdentity) {
		this.tenantIdentity = tenantIdentity;
	}

	public String getTenantPhone() {
		return tenantPhone;
	}

	public void setTenantPhone(String tenantPhone) {
		this.tenantPhone = tenantPhone;
	}

}
