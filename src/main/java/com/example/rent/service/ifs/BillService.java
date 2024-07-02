package com.example.rent.service.ifs;

import com.example.rent.vo.BillReq;
import com.example.rent.vo.BillRes;
import com.example.rent.vo.UpdateBillReq;

public interface BillService {

	public BillRes bill(BillReq req);

	public BillRes updateBill(UpdateBillReq req);
}
