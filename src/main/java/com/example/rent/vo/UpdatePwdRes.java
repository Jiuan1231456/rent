package com.example.rent.vo;

public class UpdatePwdRes extends BasicRes {

	private String ownerAccount;

	private String ownerOldPwd;

	private String ownerNewPwd;

	public UpdatePwdRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdatePwdRes(int code, String message) {
		super(code, message);
		// TODO Auto-generated constructor stub
	}
	
	public UpdatePwdRes(int code, String message,String ownerAccount, String ownerOldPwd, String ownerNewPwd) {
		super(code, message);
		this.ownerAccount = ownerAccount;
		this.ownerOldPwd = ownerOldPwd;
		this.ownerNewPwd = ownerNewPwd;
	}

	public UpdatePwdRes(String ownerAccount, String ownerOldPwd, String ownerNewPwd) {
		super();
		this.ownerAccount = ownerAccount;
		this.ownerOldPwd = ownerOldPwd;
		this.ownerNewPwd = ownerNewPwd;
	}

	public String getOwnerAccount() {
		return ownerAccount;
	}

	public void setOwnerAccount(String ownerAccount) {
		this.ownerAccount = ownerAccount;
	}

	public String getOwnerOldPwd() {
		return ownerOldPwd;
	}

	public void setOwnerOldPwd(String ownerOldPwd) {
		this.ownerOldPwd = ownerOldPwd;
	}

	public String getOwnerNewPwd() {
		return ownerNewPwd;
	}

	public void setOwnerNewPwd(String ownerNewPwd) {
		this.ownerNewPwd = ownerNewPwd;
	}

}
