package org.kpu.test;


import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kpu.di.domain.StudentVO;
import org.kpu.di.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContext.xml")

public class MemberTest {
	
	@Autowired
	MemberService memberService;
	Scanner scan = new Scanner(System.in);
	
//	@Test
	public void testAddMember( ) throws Exception {
		String strID = "b";
		StudentVO vo = new StudentVO(); 
		vo.setId(strID); 
		vo.setPasswd(strID);  
		vo.setUsername(strID); 
		vo.setSnum(strID);
		memberService.addMember(vo);
		StudentVO member = memberService.readMember(strID);
		System.out.println(member);
	}
	
//	@Test
	public void testReadMember( ) throws Exception {
		StudentVO member = memberService.readMember("bhj");
		System.out.println(member);
	}
	
//	@Test
	public void testUpdateMember() throws Exception {
		System.out.println("수정할 회원의 id를 입력하세요.");
		String uid = scan.next();
		StudentVO uvo = memberService.readMember(uid);
		System.out.println(uvo);
		System.out.println("수정할 학생의 비밀번호, 이름, 학번, 학과, 핸드폰번호, 이메일을 입력하세요.");
		String upasswd = scan.next();
		String uptusername = scan.next();
		String usnum = scan.next();
		String udepart = scan.next();
		String umobile = scan.next();
		String uemail = scan.next();
		uvo.setId(uid); uvo.setPasswd(upasswd); uvo.setUsername(uptusername);
		uvo.setSnum(usnum); uvo.setDepart(udepart); uvo.setMobile(umobile); uvo.setEmail(uemail);
		memberService.update(uvo);
		System.out.println("수정완료");
	}
	
	@Test
	public void testDeleteMember() throws Exception {
		memberService.delete("b");
		System.out.println("삭제 완료");
	}
}
