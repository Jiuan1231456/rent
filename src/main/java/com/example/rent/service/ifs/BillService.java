package com.example.rent.service.ifs;

import com.example.rent.vo.BillReq;
import com.example.rent.vo.BillRes;
import com.example.rent.vo.BillSearchReq;
import com.example.rent.vo.BillSearchRes;
import com.example.rent.vo.ContractSearchReq;
import com.example.rent.vo.ContractSearchRes;
import com.example.rent.vo.UpdateBillReq;
import com.example.rent.vo.UpdateCutDateReq;

public interface BillService {

	public BillRes bill(BillReq req);

	public BillRes updateBill(UpdateBillReq req);
	
	public BillRes updateCutDate(UpdateCutDateReq req);

	public BillSearchRes billSearch(BillSearchReq req);

}
