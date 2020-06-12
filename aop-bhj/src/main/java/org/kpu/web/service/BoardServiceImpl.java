package org.kpu.web.service;

import java.util.List;

import javax.inject.Inject;

import org.kpu.web.dao.BoardDAO;
import org.kpu.web.domain.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
    private BoardDAO dao;
    
    public BoardServiceImpl() {}
    
    @Override
    public void create(BoardVO vo) throws Exception {
        dao.create(vo);
    }
    
    @Override
    public void createFail(BoardVO vo) throws Exception {
        dao.create(vo);
        dao.createFail(vo);
    }
    
    @Override
    public List<BoardVO> listAll() throws Exception {    
        return dao.listAll();
    }
 
    @Override
    public BoardVO read(Integer b_no) throws Exception {       
        return dao.read(b_no);
    }
 
    @Override
    public void delete(Integer b_no) throws Exception {
        dao.delete(b_no);
    }
 
    @Override
    public void update(BoardVO vo) throws Exception {     
        dao.update(vo);
    }
    
}
