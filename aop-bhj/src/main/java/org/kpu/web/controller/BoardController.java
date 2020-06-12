package org.kpu.web.controller;

import javax.inject.Inject;

import org.kpu.web.domain.BoardVO;
import org.kpu.web.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
    private BoardService service;
    
    @RequestMapping(value="/create",method=RequestMethod.GET)
    public void createGET(BoardVO board, Model model) throws Exception{
        System.out.println("/board/create입니다. GET방식");
    }
    
    @RequestMapping(value = "/create",method=RequestMethod.POST )
    public String createPOST(BoardVO board, RedirectAttributes rttr) throws Exception{
        System.out.println("/board/create POST방식 입니다.");
        System.out.println(board.toString());
        
        service.create(board);
        
        rttr.addFlashAttribute("msg","성공");
        return "redirect:/board/listAll";
    }
    
    @RequestMapping(value = "/createFail",method=RequestMethod.POST )
    public String createFail(BoardVO board, RedirectAttributes rttr) throws Exception{    
        service.createFail(board);
        return "redirect:/board/listAll";
    }
        
    @RequestMapping(value = "/listAll", method= {RequestMethod.GET, RequestMethod.POST})
    public void listAll(Model model) throws Exception{      
        System.out.println("전체목록 페이지");
        model.addAttribute("boardList", service.listAll());
    }
    
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String detail(@RequestParam("b_no") int b_no, Model model) throws Exception{     
        System.out.println("글 번호"+b_no+"번의 상세내용 페이지");
        model.addAttribute("boardVO",service.read(b_no));
        return "board/detail";
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateView(BoardVO boardVO, Model model) throws Exception{		
		model.addAttribute("update", service.read(boardVO.getB_no()));
		return "board/update";
	}
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BoardVO boardVO) throws Exception{
		service.update(boardVO);
		return "redirect:/board/listAll";
	}
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(BoardVO boardVO) throws Exception{
		service.delete(boardVO.getB_no());
		return "redirect:/board/listAll";
	}
}
