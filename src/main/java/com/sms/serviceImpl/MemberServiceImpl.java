package com.sms.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.dao.MemberDao;
import com.sms.entity.Member;
import com.sms.exception.SMSException;
import com.sms.service.MemberService;

@Transactional
@Service
public class MemberServiceImpl implements MemberService {

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class.getName());

	@Autowired
	private MemberDao memberDao;

	@Override
	public List<Member> getAllMembers() throws SMSException {

		return memberDao.getAllMembers();
	}

}
