package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.persistence.BoardDAO;

@Service
public class BoardService {
	
	@Inject
	private BoardDAO dao;
	
	public void register(BoardVO vo){
		dao.insert(vo);
	}
	
	public List<BoardVO> getList(){
		return dao.getList();
	}
	
	public BoardVO search(int target){
		return dao.search(target);
	}
	
	public List<BoardVO> getListPage(int page) throws Exception{
		return dao.listPage(page);
	}
	
	public List<BoardVO> listCri(Criteria cri) throws Exception{
		return dao.listCri(cri);
	}
	
	public int listCount(Criteria cri)throws Exception{
		return dao.countPaging(cri);
		
	}

	
}
