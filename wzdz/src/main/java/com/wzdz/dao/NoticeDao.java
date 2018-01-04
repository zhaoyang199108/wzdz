package com.wzdz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wzdz.dto.NoticeDto;
import com.wzdz.entity.Notice;
import com.wzdz.entity.NoticeUser;

public interface NoticeDao {
	
	List<NoticeDto> findNoticeByType(@Param("type")String type,@Param("currentPage")int currentPage,@Param("pageSize")int pageSize,@Param("mobile")String mobile);
	int readNoticeByIdAndMobile(@Param("mobile")String mobile,@Param("id")long id);
	NoticeUser findNoticeByMobile(@Param("mobile")String mobile,@Param("noticeId")long noticeId);
}
