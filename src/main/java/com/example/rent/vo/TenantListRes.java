package com.example.rent.vo;

import java.util.List;

import com.example.rent.entity.Bill;
import com.example.rent.entity.Contract;

public class TenantListRes extends BasicRes {

	private List<Contract> contractList;

	private List<Bill> billList;

	public TenantListRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TenantListRes(int code, String message) {
		super(code, message);
		// TODO Auto-generated constructor stub
	}

	public TenantListRes(int code, String message,List<Contract> contractList, List<Bill> billList) {
		super(code, message);
		this.contractList = contractList;
		this.billList = billList;
	}

	public List<Contract> getContractList() {
		return contractList;
	}

	public void setContractList(List<Contract> contractList) {
		this.contractList = contractList;
	}

	public List<Bill> getBillList() {
		return billList;
	}

	public void setBillList(List<Bill> billList) {
		this.billList = billList;
	}

}
