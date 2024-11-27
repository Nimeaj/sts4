package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;

public class MemberService {
	
	@Autowired
	private MemberRepository memberRepo;

	public List<Member> getMembers() {
        return memberRepo.findAll();
	}

}
