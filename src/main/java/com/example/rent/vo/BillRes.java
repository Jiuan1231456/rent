package com.example.rent.vo;

import java.util.List;

import com.example.rent.entity.Bill;

public class BillRes extends BasicRes {

	private List<Bill> BillList;

	public BillRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BillRes(int code, String message) {
		super(code, message);
		// TODO Auto-generated constructor stub
	}

	public BillRes(int code, String message,List<Bill> billList) {
		super(code, message);
		BillList = billList;
	}

	public List<Bill> getBillList() {
		return BillList;
	}

	public void setBillList(List<Bill> billList) {
		BillList = billList;
	}

}
