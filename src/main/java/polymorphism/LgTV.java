package polymorphism;

import org.springframework.stereotype.Component;

//클라이언트가 스프링 컨테이너가 생성한 객체를 요청하려면 
//아이디나 이름이 반드시 설정되어 있어야 한다 
//없다면 그냥 객체가 메모리에 생성만 된다
@Component("tv") 	//클래스 위 선언, 객체 생성
public class LgTV implements TV{
	public LgTV() {
		System.out.println("[객체 생성]LgTV");
	}
	@Override
	public void powerOn() {
		System.out.println("LgTV 전원 켬");		
	}
	@Override
	public void powerOff() {
		System.out.println("LgTV 전원 끔");		
	}
	@Override
	public void volumeUp() {
		System.out.println("LgTV 소리 올림");		
	}
	@Override
	public void volumeDown() {
		System.out.println("LgTV 소리 내림");		
	}
}
