package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberDTO;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {

    private MemberService memberService = new MemberService();

    @GetMapping("/members")
    public List<MemberDTO> getAllMember() {
        return memberService.getAllMember();
    }

    @GetMapping("/member")
    public MemberDTO getMemberById(Integer id) {
        return memberService.getMemberById(id);
    }

    @PostMapping("/member")
    public MemberDTO addMember(MemberDTO memberVO) {
        return memberService.addMember(memberVO);
    }

    @PutMapping("/member")
    public int updateMember(MemberDTO memberVO) {
        return memberService.updateMember(memberVO);
    }

    @DeleteMapping("/member")
    public int removeMember(Integer id) {
        return memberService.removeMember(id);
    }
}
