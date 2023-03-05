package com.hwkim.mvc04;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hwkim.mvc04.vo.MemberVo;

@Controller
public class MemberController {
	
	@Autowired
	private SqlSession session;
	
	@RequestMapping("/member_insert_form")
	public String member_insert_form() {
		
		return "member/member_insert_form";
	}
	
	@RequestMapping("/member_insert_action")
	public String member_insert_action(
			Model model,
			MemberVo vo
			) {
		System.out.println("회원정보 수집 : "+vo);
		session.insert("MemberMapper.insert", vo);
		
		return "member/member_insert_action";
	}
	
	@RequestMapping("/member_list")
	public String member_list(
			Model model
			) {
		//오라클에서 회원목록 가져오기
		List<MemberVo> memList = session.selectList("MemberMapper.selectAll");
		model.addAttribute("memList",memList);
		
		return "member/member_list";
	}
	
	@RequestMapping("/member_detail")
	public String member_detail(
			Model model,
			@RequestParam String mid
			) {
		MemberVo vo = session.selectOne("MemberMapper.selectOne", mid);
		model.addAttribute("vo",vo);
		
		return "member/member_detail";
	}
	
	@RequestMapping("/member_update_form")
	public String member_update_form(
			Model model,
			@RequestParam String mid
			) {
		MemberVo vo = session.selectOne("MemberMapper.selectOne", mid);
		model.addAttribute("vo",vo);
		
		return "member/member_update_form";
	}
	
	@RequestMapping("/member_update_action")
	public String member_update_action(
			Model model,
			MemberVo vo
			) {
		System.out.println("회원정보 수집 : "+vo);
		session.insert("MemberMapper.update", vo);
		
		return "member/member_update_action";
	}
	
	@RequestMapping("/member_delete_form")
	public String member_delete_form(
			Model model,
			@RequestParam String mid
			) {
		MemberVo vo = session.selectOne("MemberMapper.selectOne", mid);
		model.addAttribute("vo",vo);
		
		return "member/member_delete_form";
	}
	
	//회원 정보 삭제
	@RequestMapping("/member_delete_action")
	public String member_delete_action(
			Model model,
			@RequestParam String mid,  //파라미터에서 상세보기할 회원id추출
			@RequestParam String mpwd  //파라미터에서 상세보기할 회원암호추출
			) {
		MemberVo vo = session.selectOne("MemberMapper.selectOne", mid);
		if(mpwd.equals(vo.getMpwd())) {
			session.delete("MemberMapper.delete", mid);
			model.addAttribute("msg", "삭제성공");
		}else {
			model.addAttribute("msg", "삭제실패 : 암호틀림");
		}
		
		return "member/member_delete_action";
	}
	
}
