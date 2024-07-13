package com.example.rent.vo;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

public class UpdateBillReq {

	@NotNull(message = "ai is required")
	private Integer ai;

//	@NotBlank(message = "R_id is required!!")
	private String roomId;// 房號

//	@NotBlank(message = "Address is required!!")
	private String address;// 地址

	private Integer rentP;// 租金

	private Integer eletricP;// 一度電費用

	@NotNull(message = "eletric_V is required")
	private Integer eletricV;// 當期用電量(當期減上期)

	private Integer eletricOneP;// 電費費用為(間)

	private Integer waterOneP;// 水費為

	private Integer manageOneP;// 管理費為

	private Integer cutP;// 違約金

	private int totalOneP;// 總電費

	private LocalDate paymentDate;// 繳費日期

	public UpdateBillReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdateBillReq(@NotNull(message = "ai is required") Integer ai, String roomId, String address, Integer rentP,
			Integer eletricP, @NotNull(message = "eletric_V is required") Integer eletricV, Integer eletricOneP,
			Integer waterOneP, Integer manageOneP, Integer cutP, int totalOneP, LocalDate paymentDate) {
		super();
		this.ai = ai;
		this.roomId = roomId;
		this.address = address;
		this.rentP = rentP;
		this.eletricP = eletricP;
		this.eletricV = eletricV;
		this.eletricOneP = eletricOneP;
		this.waterOneP = waterOneP;
		this.manageOneP = manageOneP;
		this.cutP = cutP;
		this.totalOneP = totalOneP;
		this.paymentDate = paymentDate;
	}

	public Integer getAi() {
		return ai;
	}

	public void setAi(Integer ai) {
		this.ai = ai;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId != null ? roomId.trim() : null;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address != null ? address.trim() : null;
	}

	public Integer getRentP() {
		return rentP;
	}

	public void setRentP(Integer rentP) {
		this.rentP = rentP;
	}

	public Integer getEletricP() {
		return eletricP;
	}

	public void setEletricP(Integer eletricP) {
		this.eletricP = eletricP;
	}

	public Integer getEletricV() {
		return eletricV;
	}

	public void setEletricV(Integer eletricV) {
		this.eletricV = eletricV;
	}

	public Integer getEletricOneP() {
		return eletricOneP;
	}

	public void setEletricOneP(Integer eletricOneP) {
		this.eletricOneP = eletricOneP;
	}

	public Integer getWaterOneP() {
		return waterOneP;
	}

	public void setWaterOneP(Integer waterOneP) {
		this.waterOneP = waterOneP;
	}

	public Integer getManageOneP() {
		return manageOneP;
	}

	public void setManageOneP(Integer manageOneP) {
		this.manageOneP = manageOneP;
	}

	public Integer getCutP() {
		return cutP;
	}

	public void setCutP(Integer cutP) {
		this.cutP = cutP;
	}

	public int getTotalOneP() {
		return totalOneP;
	}

	public void setTotalOneP(int totalOneP) {
		this.totalOneP = totalOneP;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

}
