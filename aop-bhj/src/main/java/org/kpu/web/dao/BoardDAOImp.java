package org.kpu.web.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.kpu.web.domain.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImp implements BoardDAO{
	
	public BoardDAOImp() {}
	
	@Autowired
    private SqlSession sqlSession;
    
    private static String namespace = "org.kpu.web.mapper.BoardMapper";
 
    @Override
    public void create(BoardVO vo) throws Exception {        
        sqlSession.insert(namespace+".insertBoard", vo);
    }
    
    @Override
    public void createFail(BoardVO vo) throws Exception {        
        sqlSession.insert(namespace+".insertFailBoard", vo);
    }
    
    @Override
    public List<BoardVO> listAll() throws Exception {
        sqlSession.selectList(namespace+".listPage");
        return sqlSession.selectList(namespace+".listPage");
    }

    @Override
    public BoardVO read(Integer b_no) throws Exception {
        sqlSession.selectOne(namespace+".detailBoard", b_no);
        return sqlSession.selectOne(namespace+".detailBoard", b_no);
    }

    @Override
    public void delete(Integer b_no) throws Exception {
        sqlSession.delete(namespace+".deleteBoard", b_no);
 
    }

    @Override
    public void update(BoardVO vo) throws Exception {
        sqlSession.update(namespace+".updateBoard", vo);
    }
    

}
