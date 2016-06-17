package org.zerock.controller;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.persistence.BoardDAO;
import org.zerock.persistence.TBoardDAOImpl;


@RunWith(SpringJUnit4ClassRunner.class)//스프링의 모든 Bean이 로딩
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class DAOTest {
	
	@Inject
	ApplicationContext ctc;
	
	@Inject
	BoardDAO dao;
	
	@Test
	public void test() {
		
		System.out.println("as"+ctc);
		System.out.println("aaa");
		
	}
	

	@Test
	public void testInsert() {
		
		BoardVO vo = new BoardVO();
		vo.setTitle("제목테스트1");
		vo.setContent("글쓰기 테스트입니다1");
		vo.setWriter("kwon1");
		
		dao.insert(vo);
		System.out.println();
		
	}
	
	@Test
	public void testlist() {
				
		System.out.println(dao.getList());				
	}
	
	@Test
	public void testSearch(){
		
		System.out.println(dao.search(2));
	}
	
	@Test
	public void testlistPage() throws Exception {
				
		System.out.println(dao.listPage(20));				
	}
	
	@Test
	public void testlistCri() throws Exception {
		
		Criteria cri = new Criteria();
		cri.setPage(0);
		cri.setPerPageNum(15);
		
		List<BoardVO> list = dao.listCri(cri);
		
		for (BoardVO vo : list) {
			System.out.println(vo);
		}		
					
	}
	
	@Test
	public void TestUri() throws Exception {
				
		UriComponents uriComponents = UriComponentsBuilder.newInstance().path("/board/read").queryParam("bno", 12).queryParam("perPageNum", 20).build();
		System.out.println("/board/read?bno=12&perPageNum=20");
		System.out.println(uriComponents.toString());
	}

}
