package org.zerock.persistence;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface TBoardDAO {
	
	public int insert(BoardVO vo);
	
	public List<BoardVO> getList();
	
	public BoardVO search(int target);

}
