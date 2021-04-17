package com.sms.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sms.dao.MemberDao;
import com.sms.entity.Member;
import com.sms.exception.SMSException;
import com.sms.utils.SMSUtils;

@Repository
public class MemberDaoImpl implements MemberDao {

	private static final Logger logger = LoggerFactory.getLogger(MemberDaoImpl.class.getName());

	@Autowired
	private DataSource dataSource;

	@Override
	public List<Member> getAllMembers() throws SMSException {

		CallableStatement cb = null;
		List<Member> memberList = new ArrayList<Member>();

		try (Connection connection = dataSource.getConnection()) {

			cb = connection.prepareCall(SMSUtils.StoredProcedures.MemberStoredProcedures.SP_GET_ALL_MEMBERS);

			ResultSet rs = cb.executeQuery();

			while (rs.next()) {

				Member member = new Member(rs.getInt("flat_no"), rs.getString("first_name"),
						rs.getString("middle_name"), rs.getString("last_name"));

				memberList.add(member);
			}

		} catch (Exception e) {
			logger.error("Error executing stored procedure : "
					+ SMSUtils.StoredProcedures.MemberStoredProcedures.SP_GET_ALL_MEMBERS);
		}

		return memberList;
	}

}
