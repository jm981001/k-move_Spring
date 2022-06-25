package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

//현재 테스트 코드가 스프링을 실행하는 역할임을 나타내는 어노테이션
@RunWith(SpringJUnit4ClassRunner.class)
//스프링이 실행되면서 어던 설정 정보를 읽어 들여야하는지 명시 -가장 중요
//지정된 클래스나 문자열을 이용해서 필요한 객체들을 스프링 내에 객체로 등록 - 스프링의 빈으로 등록
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//로그 기록하는 logger를 변수로 생성
@Log4j
public class SampleTests {

	//자동으로 setRestaurant()를 컴파일 시 생성하는 어노테이션
	//onMethod_ 생성은 생성되는 setRestaurant()에 @Autowired 어노테이션을 추가
	//@Autowired 어노테이션은 해당 인스턴스 변수가 스프링으로부터 자동으로 주입해 달라는 표시 - Restaurant 타입의 객체를 주입함.
	@Setter(onMethod_= { @Autowired})
	private Restaurant restaurant;//필드만 선언. 객체 생성은 하나도 없다는거
		
	//JUnit에서 해당 메서드가 jUnit 상에서 단위 테스트의 대상을 표시하는 어노테이션 - 해당 메서드를 선택해서 	
	@Test
	public void testExist() {
		
		assertNotNull(restaurant);//restaurant가 null이 아니어야만 테스트가 성공함을 의미
		
		log.info(restaurant);
		log.info("-------------------------------------");
		log.info(restaurant.getChef());
	}
		
}
