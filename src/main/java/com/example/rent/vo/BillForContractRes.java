package com.example.rent.vo;

import java.util.List;

import com.example.rent.entity.Bill;

public class BillForContractRes extends BasicRes {

	private List<Bill> billList;

	public BillForContractRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BillForContractRes(int code, String message) {
		super(code, message);
		// TODO Auto-generated constructor stub
	}

	public BillForContractRes(int code, String message,List<Bill> billList) {
		super(code, message);
		this.billList = billList;
	}

	public List<Bill> getBillList() {
		return billList;
	}

	public void setBillList(List<Bill> billList) {
		this.billList = billList;
	}
	
	
	
}
