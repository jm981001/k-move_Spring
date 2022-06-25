package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component//스프링에게 해당 클래스가 스프링에서 관리하는 대상 객체 (빈-bean)임을 표시
@Data//생성자, to String()등을 자동으로 생성하는 어노테이션

public class Restaurant {

	//자동으로 setChef()를 컴파일 시 생성하는 어노테이션
	//onMethod_ 생성은 생성되는 setChef()에 @Autowired 어노테이션을 추가
	//@Autowired 어노테이션은 해당 인스턴스 변수가 스프링으로부터 자동으로 주입해 달라는 표시 - Chef 타입의 객체를 주입함.
		@Setter(onMethod_=@Autowired)
		private Chef chef;
}
