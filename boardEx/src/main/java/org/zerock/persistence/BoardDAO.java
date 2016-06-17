package org.zerock.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

@Repository
public class BoardDAO {

	@Inject
	SqlSession session;

	public void setSession(SqlSession session) {
		this.session = session;
	}

	public int insert(BoardVO vo) {
		return session.insert("org.zerock.persistence.boardMapper.insert", vo);
	}

	public List<BoardVO> getList() {

		return session.selectList("org.zerock.persistence.boardMapper.list");
	}

	public BoardVO search(int target) {

		return session.selectOne("org.zerock.persistence.boardMapper.find", target);
	}

	public List<BoardVO> listPage(int page)throws Exception {

		return session.selectOne("org.zerock.persistence.boardMapper.listPage", page);
	}
	
	public List<BoardVO> listCri(Criteria cri)throws Exception {
		
		return session.selectList("org.zerock.persistence.boardMapper.listCri", cri);
	}
	
	public int countPaging(Criteria cri)throws Exception{
		return session.selectOne("org.zerock.persistence.boardMapper.total", cri);
	}

}
