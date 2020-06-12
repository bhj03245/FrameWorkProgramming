package opg.kpu.web.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kpu.web.dao.BoardDAO;
import org.kpu.web.domain.BoardVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class BoardDAOTest {

	@Autowired
	private BoardDAO dao;
	private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);

	@Test
	public void testReadList() throws Exception {
		List<BoardVO> voList;
		voList = dao.listAll();

		for(BoardVO vo : voList) {
			logger.info(vo.toString());
		}
	}
}
