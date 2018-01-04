package com.wzdz.service;

import java.util.List;

import com.wzdz.dto.NoticeDto;
import com.wzdz.entity.NoticeUser;

public interface NoticeService {

	List<NoticeDto> findNoticeByType(String type,int currentPage,int pageSize,String mobile);
	int readNoticeByIdAndMobile(String mobile,long id);
	NoticeUser findNoticeByMobile(String mobile,long noticeId);
}
