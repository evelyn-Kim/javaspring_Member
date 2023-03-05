package com.hwkim.mvc04.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hwkim.mvc04.vo.BoardVo;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession session;

	public void save(BoardVo vo) {
		session.insert("BoardMapper.insert", vo);
	}

	public List<BoardVo> selectAll() {
		return session.selectList("BoardMapper.selectAll");
	}

	public BoardVo selectOne(int no) {
		return session.selectOne("BoardMapper.selectOne", no);
	}

	public void update(BoardVo vo) {
		session.insert("BoardMapper.update", vo);
	}

	public void delete(int no) {
		session.delete("BoardMapper.delete", no);	
	}
	
}
