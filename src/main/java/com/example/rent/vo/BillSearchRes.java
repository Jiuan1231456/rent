package com.example.rent.vo;

import java.util.List;

import com.example.rent.entity.Bill;

public class BillSearchRes extends BasicRes {

	private List<Bill> billList;

	public BillSearchRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BillSearchRes(int code, String message) {
		super(code, message);
		// TODO Auto-generated constructor stub
	}

	public BillSearchRes(int code, String message,List<Bill> billList) {
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
