
package org.kpu.di.main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.kpu.di.domain.StudentVO;
import org.kpu.di.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;


public class MemberSampleMain {

	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("---------------------------");
		System.out.println("  학생 정보 관리 프로그램");
		System.out.println("---------------------------");

		ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		MemberService memberService = ctx.getBean(MemberService.class);  
		
		while(true) {
			System.out.println("1. 전체 학생 정보 출력");
			System.out.println("2. 개인 학생 정보 출력");
			System.out.println("3. 개인 학생 정보 생성");
			System.out.println("4. 개인 학생 정보 수정");
			System.out.println("5. 개인 학생 정보 삭제");
			System.out.println("6. 프로그램 종료");
			System.out.print("select >> ");
			try {
				int sel = scan.nextInt();
				scan.nextLine();
				switch(sel) {
					case 1:
						List<StudentVO> list = memberService.readMemberList();
						for(StudentVO svo : list) {
							System.out.println(svo);
						}
						break;
					case 2:
						System.out.print("출력할 학생의 id를 입력하세요.");
						String strID = scan.next();
						scan.nextLine();
						StudentVO vo = new StudentVO(); 
						vo.setId(strID); vo.setPasswd(strID);  vo.setUsername(strID); vo.setSnum(strID);
						StudentVO member = memberService.readMember(strID);
						System.out.println(member);
						break;
					case 3:
						System.out.println("추가할 학생의 id, 비밀번호, 이름, 학번, 학과, 핸드폰번호, 이메일을 입력하세요.");				
						StudentVO addvo = new StudentVO();
						String ID = scan.next();
						String passwd = scan.next();
						String username = scan.next();
						String snum = scan.next();
						String depart = scan.next();
						String mobile = scan.next();
						String email = scan.next();
						addvo.setId(ID); addvo.setPasswd(passwd); addvo.setUsername(username);
						addvo.setSnum(snum); addvo.setDepart(depart); addvo.setMobile(mobile); addvo.setEmail(email);
						memberService.addMember(addvo);	
						break;
					case 4:
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
						break;
					case 5:
						System.out.println("삭제할 회원의 id를 입력하세요.");
						String did = scan.next();
						memberService.delete(did);
						System.out.println("삭제 완료");
						break;
					case 6:
						System.out.println("안녕히 가세요.");
						return;
				}
			} catch(InputMismatchException e) {
				System.out.println("확인 후 입력하세요. ");
				continue;
			}
		}
	}		
}
