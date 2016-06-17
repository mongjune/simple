package org.zerock.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageMaker;
import org.zerock.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	BoardService service;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public void registerGET(){
		logger.info("registerGet.........");
	}
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerPOST(BoardVO vo)throws Exception{
		logger.info("registerPOST.........");
		logger.info(""+vo.toString());
		
		service.register(vo);
				
		//rtts.addFlashAttribute("result", "success");// 동작원리?	
		return "redirect:/board/listPage"; 		
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void listGet(Model model)throws Exception{
		logger.info("list GET......");
		model.addAttribute("list",service.getList());
		
	}
	
	@RequestMapping(value="/listCri", method=RequestMethod.GET)
	public void listPageGet(Criteria cri, Model model)throws Exception{
		logger.info("listPage GET......");
		model.addAttribute("listCri",service.listCri(cri));		
	}
	
	@RequestMapping(value="/listPage", method=RequestMethod.GET)
	public void listPage(@ModelAttribute("cri")Criteria cri, Model model)throws Exception{
		logger.info("Page GET......");
		
		model.addAttribute("list", service.listCri(cri));
		
		PageMaker pageMaker = new PageMaker();
		
		pageMaker.setCri(cri);		
		
		pageMaker.setTotalCount(service.listCount(cri));
		
		model.addAttribute("pageMaker", pageMaker);
		
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public void read(@ModelAttribute("bno")int bno, Criteria cri, Model model)throws Exception{
		
		model.addAttribute("bno",service.search(bno));	
		model.addAttribute("page", cri.getPage());
	
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public void searchGet(){
		logger.info("search........");
	}

}
