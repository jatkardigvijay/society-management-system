package com.sms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.config.Response;
import com.sms.entity.Member;
import com.sms.exception.SMSException;
import com.sms.service.MemberService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("member")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class.getName());

	@Autowired
	private MemberService memberService;

	@GetMapping("/api/v1")
	public ResponseEntity<Response> getAllMembers() throws SMSException {

		List<Member> memberList = memberService.getAllMembers();

		if (memberList == null || memberList.isEmpty()) {

			logger.error("No data found");
			throw new SMSException("No data found", HttpStatus.OK, null);
		} else {

			logger.info("Received member list with size : " + memberList.size());
			return new ResponseEntity<Response>(new Response("success", memberList, null), HttpStatus.OK);
		}
	}
}
