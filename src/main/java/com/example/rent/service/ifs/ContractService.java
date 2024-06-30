package com.example.rent.service.ifs;

import com.example.rent.vo.BasicRes;
import com.example.rent.vo.CreateContractReq;
import com.example.rent.vo.UpdateContractReq;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Basic;

public interface ContractService {

	public BasicRes createContract(CreateContractReq req);
	
	public BasicRes updateContract(UpdateContractReq req);
	
}
