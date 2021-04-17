package com.sms.dao;

import java.util.List;

import com.sms.entity.Member;
import com.sms.exception.SMSException;

public interface MemberDao {

	List<Member> getAllMembers() throws SMSException;

}
