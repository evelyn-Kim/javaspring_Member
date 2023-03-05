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
	
	//�Ķ���ͷκ��� ��ϰ� ���� -> BoardVo�� ����
	//TABLE�� ����
	@RequestMapping(value="/board/insert", method = RequestMethod.POST)
	public String insert_post(
			Model model,
			BoardVo vo
			) {
		try {
			boardDao.save(vo);
			model.addAttribute("msg", "��� ����");
		} catch (Exception e) {
			model.addAttribute("msg", "��� ���� �߻�");
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
	
	//�����۾��� ����: �Է¾�ȣ�� ������ȣ�� ������ ������. Ʋ���� �����޽��� ���
	@RequestMapping(value="/board/update", method = RequestMethod.POST)
	public String update_post(
			Model model,
			BoardVo vo
			) {
		try {
	         BoardVo vo2 = boardDao.selectOne(vo.getNo());
	         if(vo2.getPasswd().equals(vo.getPasswd())) {
	            boardDao.update( vo );
	            model.addAttribute("msg", "���� ����");
	         }else {
	            model.addAttribute("err", "���� ����. ��ȣƲ��");
	         }
	      } catch (Exception e) {
	         model.addAttribute("msg", "���� ���� �߻�");
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
				model.addAttribute("msg", "���� ����");
			}else {
				model.addAttribute("err", "��й�ȣ�� �߸��Ǿ����ϴ�.");
			}
		} catch (Exception e) {
			model.addAttribute("msg", "���� ���� �߻�");
			model.addAttribute("err", e);
			e.printStackTrace();
		}
		
		return "board/delete_result";
	}
}
