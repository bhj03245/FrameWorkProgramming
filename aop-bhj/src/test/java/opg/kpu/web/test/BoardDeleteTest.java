package opg.kpu.web.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kpu.web.dao.BoardDAO;
import org.kpu.web.domain.BoardVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })

public class BoardDeleteTest {	
	BoardVO vo;
	
	@Autowired
	private BoardDAO dao;
	private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Test
	@Rollback(false)
	public void testReadList() throws Exception {
		List<BoardVO> voList;
		voList = dao.listAll();
		//Delete 단위 테스트시 데이터가 없으면 SQL 파일에 있는 insert 쿼리(b_no=999번)를 실행 해주어야 합니당 교수님.
		dao.delete(999);
		
		for(BoardVO vo : voList) {
			logger.info(vo.toString());
		}
	}
}
