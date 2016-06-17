package org.zerock.persistence;

import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVO;

@Repository
public class TBoardDAOImpl implements TBoardDAO {

	
	@Inject
	SqlSession session;
	
	

	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	public String getTime(){
		return session.selectOne("org.zerock.persistence.boardMapper.getTime");
	}

	@Override
	public int insert(BoardVO vo) {
		return session.insert("org.zerock.persistence.boardMapper.insert", vo);
	}

	@Override
	public List<BoardVO> getList() {
		
		return session.selectList("org.zerock.persistence.boardMapper.list");
	}

	@Override
	public BoardVO search(int target) {
		// TODO Auto-generated method stub
		return session.selectOne("org.zerock.persistence.boardMapper.find", target);
	}

}
