package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import edu.pnu.domain.Member;
import edu.pnu.service.MemberService;

public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/member")
	public List<Member> getMembers() {
		return memberService.getMembers();
	}
}
