package com.example.rent.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.rent.constants.ResMessage;
import com.example.rent.entity.Register;
import com.example.rent.entity.Room;
import com.example.rent.repository.RegisterDao;
import com.example.rent.repository.RoomDao;
import com.example.rent.service.ifs.RoomService;
import com.example.rent.vo.BasicRes;
import com.example.rent.vo.CreateRoomAndphotoReq;
import com.example.rent.vo.CreateRoomReq;
import com.example.rent.vo.DeleteRoomReq;
import com.example.rent.vo.RoomSearchReq;
import com.example.rent.vo.RoomSearchRes;
import com.example.rent.vo.UpdateRoomReq;

@Service
public class RoomServiceImpl implements RoomService{

	//這個是抓取我帳號那邊表格的資訊用的
	@Autowired
	private RegisterDao registerDao;
	
	//這個是抓取我創建房間資訊用的
	@Autowired
	private RoomDao roomDao;


	
	@Override
	public BasicRes creatRoom(CreateRoomReq req) {
		//先看看帳號存不存在(這裡的req是我"房間"的帳號與我"創建帳號"那邊的帳號做對比)
		Optional<Register> op=registerDao.findById(req.getAccount());
		if(op.isEmpty()) {
			return new BasicRes(ResMessage.ACCOUNT_NOT_FOUND.getCode(),ResMessage.ACCOUNT_NOT_FOUND.getMessage());
		}
		//這是要填入表單用
		Register register = op.get();
		//如果我的地址已經存在就要凡回錯誤
		if(roomDao.existsById(req.getAddress())) {
			return new BasicRes(ResMessage.ADDRESS_DUPLICATED_FILLIN.getCode(),ResMessage.ADDRESS_DUPLICATED_FILLIN.getMessage());
		}
//		List<Room> ex = roomDao.findByAccountEquals(req.getAccount());
//		Room aa = ex.get(0);
		//當我資料庫中的房號已存在，則返回錯誤    當帳號相同、房號也相同時
		/*if(roomDao.existsByAccountAndRoomId(req.getAccount(), req.getrId())) {
			return new BasicRes(ResMessage.RID_DUPLICATED_FILLIN.getCode(),ResMessage.RID_DUPLICATED_FILLIN.getMessage());	
		}
		*/
		
		Room room = new Room();
		
		room.setAddress(req.getAddress());//地址家樓層家房號
		room.setAccount(register.getOwnerAccount());//從房東的帳號抓取他的帳號
		room.setRoomId(req.getrId());//創建房號  不重複
		room.setFloor(req.getFloor());//創建樓層
		room.setRentP(req.getRentP());//租金
		room.setDeposit(req.getDeposit());//押金
		room.setCutP(req.getCutP());//違約金
		room.setEletricP(req.getEletricP());//電費一度的設定
		room.setWaterP(req.getWaterP());//水費一個月多少
		room.setManageP(req.getManageP());//管理費一個月多少
		room.setAcreage(req.getAcreage());//面積有多大
		room.setParking(req.getParking());//是否有時停車場(true/false)
		
		if(req.getrOther()!=null) {
			room.setEquip(req.getEquip());//其他詳情
		}
		if(req.getrOther()!=null) {
			room.setrOther(req.getrOther());//其他
		}

		
		roomDao.save(room);
		
		
		return new BasicRes(ResMessage.SUCCESS.getCode(),ResMessage.SUCCESS.getMessage());
	}



	//更新房間資訊
	@Override
	public BasicRes updateRoom(UpdateRoomReq req) {
		if(!roomDao.existsById(req.getAddress())) {
			return new BasicRes(ResMessage.ADDRESS_NOT_FOUND.getCode(),ResMessage.ADDRESS_NOT_FOUND.getMessage());
		}
		//如果PK存在就可直接更改資訊
		// 獲取現有的房間記錄
	    Optional<Room> roomOpt = roomDao.findById(req.getAddress());
	    if (roomOpt.isPresent()) {
	    	Room room = roomOpt.get();
	    	 // 只更新非空字段
	        if (req.getRentP() != null) {
	            room.setRentP(req.getRentP());
	        }
	        if (req.getDeposit() != null) {
	            room.setDeposit(req.getDeposit());
	        }
	        if (req.getCutP() != null) {
	            room.setCutP(req.getCutP());
	        }
	        if (req.getEletricP() != null) {
	            room.setEletricP(req.getEletricP());
	        }
	        if (req.getWaterP() != null) {
	            room.setWaterP(req.getWaterP());
	        }
	        if (req.getManageP() != null) {
	            room.setManageP(req.getManageP());
	        }
	        if (req.getAcreage() != null) {
	            room.setAcreage(req.getAcreage());
	        }
	        if (req.getParking() != null) {
	            room.setParking(req.getParking());
	        }
	        if (req.getEquip() != null) {
	            room.setEquip(req.getEquip());
	        }
	        if(req.getrOther()!=null) {
				room.setrOther(req.getrOther());//其他
			}
	        
	        roomDao.save(room);
	        
	        return new BasicRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage());
	    } else {
	        return new BasicRes(ResMessage.ERROR.getCode(), ResMessage.ERROR.getMessage());
	    }
	}


	//房間搜索
	@Override
	public RoomSearchRes roomSearch(RoomSearchReq req) {
		String address = req.getAddress();
		String roomId = req.getRoomId();
		if(!StringUtils.hasText(address)) {
			address="";
		}
		if(!StringUtils.hasText(roomId)) {
			roomId="";
		}
		return new RoomSearchRes(ResMessage.SUCCESS.getCode(),ResMessage.SUCCESS.getMessage(),
				roomDao.findByAddressContainingAndRoomIdContaining(address, roomId));
	}



	@Override
	public BasicRes deleteRoom(DeleteRoomReq req) {
		if(!CollectionUtils.isEmpty(req.getAddressList())) {
			try {
//				刪除房間(地址)
				roomDao.deleteAllById(req.getAddressList());
			}catch(Exception e){
				//當deleteAllById方法中，id的值不存在時，jpa會報錯
				//因為刪除之前，JPA會先"搜索"帶入的id，再去做刪除的動作(所以如果沒有搜索到就會報錯)
				//但因實際上也沒刪除任何資訊，所以也就可以不需要這個exception做處理
			}
		}
		return new BasicRes(ResMessage.SUCCESS.getCode(),ResMessage.SUCCESS.getMessage());
	}



	@Override
	public BasicRes insertPhoto(String address, byte[] photo) {
		Optional<Room> room=roomDao.findById(address);
		Room roomAll = room.get();
		roomAll.setPhoto(photo);
		 
		roomDao.save(roomAll);

		return new BasicRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage());
		
	}
	
	
	@Override
	public BasicRes creatRoomAndInsertPhoto(CreateRoomReq req, byte[] photo) {
		//先看看帳號存不存在(這裡的req是我"房間"的帳號與我"創建帳號"那邊的帳號做對比)
		Optional<Register> op=registerDao.findById(req.getAccount());
		if(op.isEmpty()) {
			return new BasicRes(ResMessage.ACCOUNT_NOT_FOUND.getCode(),ResMessage.ACCOUNT_NOT_FOUND.getMessage());
		}
		//這是要填入表單用
		Register register = op.get();
		//如果我的地址已經存在就要凡回錯誤
		if(roomDao.existsById(req.getAddress())) {
			return new BasicRes(ResMessage.ADDRESS_DUPLICATED_FILLIN.getCode(),ResMessage.ADDRESS_DUPLICATED_FILLIN.getMessage());
		}
		
		Room room = new Room();
		
		room.setAddress(req.getAddress());//地址家樓層家房號
		room.setAccount(register.getOwnerAccount());//從房東的帳號抓取他的帳號
		room.setRoomId(req.getrId());//創建房號  不重複
		room.setFloor(req.getFloor());//創建樓層
		room.setRentP(req.getRentP());//租金
		room.setDeposit(req.getDeposit());//押金
		room.setCutP(req.getCutP());//違約金
		room.setEletricP(req.getEletricP());//電費一度的設定
		room.setWaterP(req.getWaterP());//水費一個月多少
		room.setManageP(req.getManageP());//管理費一個月多少
		room.setAcreage(req.getAcreage());//面積有多大
		room.setParking(req.getParking());//是否有時停車場(true/false)
		
		if(req.getEquip()!=null) {
			room.setEquip(req.getEquip());//其他詳情
		}
		if(req.getrOther()!=null) {
			room.setrOther(req.getrOther());//其他
		}

		if(photo!=null) {
			room.setPhoto(photo);
		}
		
		try {
	        roomDao.save(room); // 保存房間
	        return new BasicRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage());
	    } catch (Exception e) {
	        // 異常處理
	        return new BasicRes(ResMessage.ERROR.getCode(), ResMessage.ERROR.getMessage());
	    }
	}



	@Override
	public BasicRes creatRoomAndphoto(CreateRoomAndphotoReq req) {
		//先看看帳號存不存在(這裡的req是我"房間"的帳號與我"創建帳號"那邊的帳號做對比)
		Optional<Register> op=registerDao.findById(req.getAccount());
		if(op.isEmpty()) {
			return new BasicRes(ResMessage.ACCOUNT_NOT_FOUND.getCode(),ResMessage.ACCOUNT_NOT_FOUND.getMessage());
		}
		//這是要填入表單用
		Register register = op.get();
		//如果我的地址已經存在就要凡回錯誤
		if(roomDao.existsById(req.getAddress())) {
			return new BasicRes(ResMessage.ADDRESS_DUPLICATED_FILLIN.getCode(),ResMessage.ADDRESS_DUPLICATED_FILLIN.getMessage());
		}
		
		Room room = new Room();
		
		room.setAddress(req.getAddress());//地址家樓層家房號
		room.setAccount(register.getOwnerAccount());//從房東的帳號抓取他的帳號
		room.setRoomId(req.getrId());//創建房號  不重複
		room.setFloor(req.getFloor());//創建樓層
		room.setRentP(req.getRentP());//租金
		room.setDeposit(req.getDeposit());//押金
		room.setCutP(req.getCutP());//違約金
		room.setEletricP(req.getEletricP());//電費一度的設定
		room.setWaterP(req.getWaterP());//水費一個月多少
		room.setManageP(req.getManageP());//管理費一個月多少
		room.setAcreage(req.getAcreage());//面積有多大
		room.setParking(req.getParking());//是否有時停車場(true/false)
		
		if(req.getEquip()!=null) {
			room.setEquip(req.getEquip());//其他詳情
		}
		if(req.getrOther()!=null) {
			room.setrOther(req.getrOther());//其他
		}

		if(req.getPhoto()!=null) {
			room.setPhoto(req.getPhoto());
		}
		
        roomDao.save(room); // 保存房間
        return new BasicRes(ResMessage.SUCCESS.getCode(), ResMessage.SUCCESS.getMessage());
	}




}
