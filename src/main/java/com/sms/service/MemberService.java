package com.sms.service;

import java.util.List;

import com.sms.entity.Member;
import com.sms.exception.SMSException;

public interface MemberService {

	List<Member> getAllMembers() throws SMSException;

}
