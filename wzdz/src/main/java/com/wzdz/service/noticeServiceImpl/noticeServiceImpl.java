package com.wzdz.service.noticeServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wzdz.dao.NoticeDao;
import com.wzdz.dao.UserDao;
import com.wzdz.dto.NoticeDto;
import com.wzdz.entity.Notice;
import com.wzdz.entity.NoticeUser;
import com.wzdz.service.NoticeService;
@Service
public class noticeServiceImpl implements NoticeService {
	private @Autowired NoticeDao noticeDao;
	public List<NoticeDto> findNoticeByType(String type,int currentPage,int pageSize,String mobile) {
		// TODO Auto-generated method stub
		return noticeDao.findNoticeByType(type,currentPage,pageSize,mobile);
	}
	public int readNoticeByIdAndMobile( String mobile, long id) {
		// TODO Auto-generated method stub
		return noticeDao.readNoticeByIdAndMobile(mobile,id);
	}
	public NoticeUser findNoticeByMobile(String mobile,long noticeId) {
		// TODO Auto-generated method stub
		return noticeDao.findNoticeByMobile(mobile,noticeId);
	}

}
