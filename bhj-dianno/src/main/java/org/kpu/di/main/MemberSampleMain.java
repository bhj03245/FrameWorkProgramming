
package org.kpu.di.main;

import org.kpu.di.domain.StudentVO;
import org.kpu.di.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.support.GenericXmlApplicationContext;

public class MemberSampleMain {

	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("안녕하세요 bhj-dianno");

//		ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		MemberService memberService = (MemberService)ctx.getBean(MemberService.class);  // by Class name
//		MemberService memberService = (MemberService)ctx.getBean("memberService");  // by Component name 
		
		StudentVO vo = new StudentVO(); vo.setId("bhj-dianno");
		vo.setPasswd("1234"); vo.setUsername("백현준");
		vo.setSnum("2015150017"); vo.setDepart("컴퓨터공학부");
		vo.setMobile("010-1234-1234"); vo.setEmail("bhj@kpu.ac.kr");
		memberService.addMember(vo); 
		StudentVO member = memberService.readMember("bhj-dianno");
		
		System.out.println(member);
	}

}
