package com.example.rent.vo;

import java.util.List;

import com.example.rent.entity.Contract;

public class ContractSearchRes extends BasicRes {

	private List<Contract> ContractList;

	public ContractSearchRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContractSearchRes(int code, String message) {
		super(code, message);
		// TODO Auto-generated constructor stub
	}


	public ContractSearchRes(int code, String message,List<Contract> contractList) {
		super(code, message);
		ContractList = contractList;
	}

	public List<Contract> getContractList() {
		return ContractList;
	}

	public void setContractList(List<Contract> contractList) {
		ContractList = contractList;
	}

}
