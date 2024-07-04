package com.example.rent.service.ifs;

import com.example.rent.vo.BasicRes;
import com.example.rent.vo.CreateContractReq;
import com.example.rent.vo.UpdateContractReq;

public interface ContractService {

	public BasicRes createContract(CreateContractReq req);

	public BasicRes updateContract(UpdateContractReq req);

//	public ContractSearchRes billSearch(ContractSearchReq req);

}
