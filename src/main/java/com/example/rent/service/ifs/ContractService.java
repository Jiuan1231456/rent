package com.example.rent.service.ifs;

import com.example.rent.vo.BasicRes;
import com.example.rent.vo.ContractSearchReq;
import com.example.rent.vo.ContractSearchRes;
import com.example.rent.vo.CreateContractReq;
import com.example.rent.vo.TenantListReq;
import com.example.rent.vo.TenantListRes;
import com.example.rent.vo.UpdateContractReq;

public interface ContractService {

	public BasicRes createContract(CreateContractReq req);

	public BasicRes updateContract(UpdateContractReq req);

	public ContractSearchRes contratSearch(ContractSearchReq req);

	public TenantListRes tenantList(TenantListReq req);
}
