//package com.example.rent.service.impl;
//
//import java.time.LocalDate;
//import java.time.Period;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Service;
//
//import com.example.rent.constants.ResMessage;
//import com.example.rent.entity.Bill;
//import com.example.rent.entity.Contract;
//import com.example.rent.entity.Room;
//import com.example.rent.repository.BillDao;
//import com.example.rent.repository.ContractDao;
//import com.example.rent.repository.RoomDao;
//import com.example.rent.service.ifs.Bill2Service;
//import com.example.rent.service.ifs.BillService;
//import com.example.rent.vo.BillReq;
//import com.example.rent.vo.BillRes;
//import com.example.rent.vo.UpdateBillReq;
//import com.example.rent.vo.UpdateCutDateReq;
//
//@Service
//public class Bill2ServiceImpl implements Bill2Service {
//
//    @Autowired
//    private ContractDao contractDao;
//
//    @Autowired
//    private RoomDao roomDao;
//
//    @Autowired
//    private BillDao billDao;
//
////    @Scheduled(cron = "5 * * * * ?")
//    public void generateMonthlyBills() {
//        List<Contract> contracts = contractDao.findAll();
//        for (Contract contract : contracts) {
//            generateBillForContract(contract, new BillReq());
//        }
//    }
//
//    public BillRes bill(BillReq req) {
//        Optional<Contract> op = contractDao.findById(req.getAi());
//        if (op.isEmpty()) {
//            return new BillRes(ResMessage.AI_IS_NOT_FOUND.getCode(), ResMessage.AI_IS_NOT_FOUND.getMessage());
//        }
//
//        Contract contract = op.get();
//        if (!validateRequest(req, contract)) {
//            return new BillRes(ResMessage.PARAMETER_CHECK_ERROR.getCode(), ResMessage.PARAMETER_CHECK_ERROR.getMessage());
//        }
//
//        generateBillForContract(contract, req);
//        return new BillRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage());
//    }
//
//    private void generateBillForContract(Contract contract, BillReq req) {
//        LocalDate startDate = contract.getStartDate();
//        LocalDate endDate = contract.getEndDate();
//        LocalDate cutDate = contract.getCutDate();
//        LocalDate billEndDate = (cutDate != null) ? cutDate : endDate;
//        LocalDate currentBillingStart = startDate;
//
//        while (currentBillingStart.isBefore(billEndDate)) {
//            LocalDate currentBillingEnd = currentBillingStart.plusDays(29);
//            if (currentBillingEnd.isAfter(billEndDate)) {
//                currentBillingEnd = billEndDate;
//            }
//
//            Period period = Period.between(currentBillingStart, currentBillingEnd);
//            int daysInBillingPeriod = period.getDays();
//
//            Optional<Room> roomOptional = roomDao.findById(contract.getAddress());
//            Room room = roomOptional.get();
//
//            int rent = contract.getRentP();
//            int eletricV = req.getEletricV() != null ? req.getEletricV() : 0; // 默認電量值
//            int waterCharge = req.getWaterOneP() != null ? req.getWaterOneP() : calculateWaterCharge(room, daysInBillingPeriod);
//            int manageCharge = req.getManageOneP() != null ? req.getManageOneP() : calculateManageCharge(room, daysInBillingPeriod);
//            int electricCharge = room.getEletricP() * eletricV;
//
//            Bill bill = new Bill();
//            bill.setAddress(contract.getAddress());
//            bill.setRoomId(contract.getRoomId());
//            bill.setTenantIdentity(contract.getTenantIdentity());
//            bill.setTenantName(contract.getTenantName());
//            bill.setOwnerName(contract.getOwnerName());
//            bill.setFloor(contract.getFloor());
//            bill.setPeriodStart(currentBillingStart);
//            bill.setPeriodEnd(currentBillingEnd);
//            bill.setEletricV(eletricV);
//            bill.setEletricP(room.getEletricP());
//            bill.setWaterOneP(waterCharge);
//            bill.setManageOneP(manageCharge);
//            bill.setEletricOneP(electricCharge);
//
//            int totalCharge = waterCharge + manageCharge + electricCharge + rent;
//
//            if (cutDate != null && currentBillingEnd.equals(billEndDate)) {
//                totalCharge += room.getCutP();
//                bill.setCutP(room.getCutP());
//            }
//
//            if (req.getCutP() != null) {
//                bill.setCutP(req.getCutP());
//            }
//
//            bill.setTotalOneP(totalCharge);
//            bill.setPaymentDate(currentBillingEnd.plusDays(10));
//
//            billDao.save(bill);
//            currentBillingStart = currentBillingEnd.plusDays(1);
//        }
//    }
//
//    private boolean validateRequest(BillReq req, Contract contract) {
//        return req.getAddress().equals(contract.getAddress()) &&
//               req.getTenantIdentity().equals(contract.getTenantIdentity()) &&
//               req.getPeriodStart().equals(contract.getStartDate());
//    }
//
//    private int calculateWaterCharge(Room room, int daysInBillingPeriod) {
//        if (daysInBillingPeriod + 1 < 30) {
//            return (int) Math.round(room.getWaterP() * ((double) daysInBillingPeriod / 30));
//        } else {
//            return room.getWaterP();
//        }
//    }
//
//    private int calculateManageCharge(Room room, int daysInBillingPeriod) {
//        if (daysInBillingPeriod + 1 < 30) {
//            return (int) Math.round(room.getManageP() * ((double) daysInBillingPeriod / 30));
//        } else {
//            return room.getManageP();
//        }
//    }
//
//	@Override
//	public BillRes generateAllBills() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//  
//}
