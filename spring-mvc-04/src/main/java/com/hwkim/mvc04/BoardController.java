package com.hwkim.mvc04;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hwkim.mvc04.dao.BoardDao;
import com.hwkim.mvc04.vo.BoardVo;


@Controller
public class BoardController {
	
	@Autowired
	private BoardDao boardDao;
	
	@RequestMapping("/board")
	public String home() {
		
		return "board/home";
	}
	
	@RequestMapping(value="/board/insert")
	public String insert() {
		
		return "board/insert";
	}
	
	//파라미터로부터 등록값 추출 -> BoardVo에 저장
	//TABLE에 저장
	@RequestMapping(value="/board/insert", method = RequestMethod.POST)
	public String insert_post(
			Model model,
			BoardVo vo
			) {
		try {
			boardDao.save(vo);
			model.addAttribute("msg", "등록 성공");
		} catch (Exception e) {
			model.addAttribute("msg", "등록 오류 발생");
			model.addAttribute("err", e);
			e.printStackTrace();
		}
		
		return "board/insert_result";
	}
	
	@RequestMapping(value="/board/list")
	public String list(
			Model model,
			BoardVo vo
			) {
		List<BoardVo> boardList = boardDao.selectAll();
		model.addAttribute("boardList", boardList);
		
		return "board/list";
	}
	
	@RequestMapping(value="/board/detail")
	public String detail(
			Model model,
			@RequestParam int no
			) {
		BoardVo vo = boardDao.selectOne(no);
		model.addAttribute("vo", vo);
		
		return "board/detail";
	}
	
	@RequestMapping("/board/update")
	public String update(
			Model model,
			@RequestParam int no
			) {
		BoardVo vo = boardDao.selectOne(no);
		model.addAttribute("vo",vo);
		
		return "board/update";
	}
	
	//수정작업시 조건: 입력암호가 기존암호랑 맞으면 수정함. 틀리면 오류메시지 출력
	@RequestMapping(value="/board/update", method = RequestMethod.POST)
	public String update_post(
			Model model,
			BoardVo vo
			) {
		try {
	         BoardVo vo2 = boardDao.selectOne(vo.getNo());
	         if(vo2.getPasswd().equals(vo.getPasswd())) {
	            boardDao.update( vo );
	            model.addAttribute("msg", "수정 성공");
	         }else {
	            model.addAttribute("err", "수정 실패. 암호틀림");
	         }
	      } catch (Exception e) {
	         model.addAttribute("msg", "수정 오류 발생");
	         model.addAttribute("err", e);
	         e.printStackTrace();
	      }
	      return "board/update_result";
	}
	
	@RequestMapping("/board/delete")
	public String delete(
			Model model,
			@RequestParam int no
			) {
		BoardVo vo = boardDao.selectOne(no);
		model.addAttribute("vo",vo);
		
		return "board/delete";
	}
	
	@RequestMapping(value="/board/delete", method = RequestMethod.POST)
	public String delete_post(
			Model model,
			BoardVo vo
			) {
		try {
			BoardVo vo2 = boardDao.selectOne(vo.getNo());
			if(vo2.getPasswd().equals(vo.getPasswd())) {
				boardDao.delete(vo.getNo());
				model.addAttribute("msg", "삭제 성공");
			}else {
				model.addAttribute("err", "비밀번호가 잘못되었습니다.");
			}
		} catch (Exception e) {
			model.addAttribute("msg", "수정 오류 발생");
			model.addAttribute("err", e);
			e.printStackTrace();
		}
		
		return "board/delete_result";
	}
}
