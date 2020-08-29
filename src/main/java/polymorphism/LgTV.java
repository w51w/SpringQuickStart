package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV{
	//스프링 컨테이너는 해당 타입의 객체를 찾아서 자동으로 할당
	@Autowired //메소드, 멤버변수 위에 사용,  변수 생성
	@Qualifier("sony") // Speaker 타입의 객체가 두 개 이상일 때 특정 객체의 이름을 이용하여 할당
	private Speaker speaker;
	
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
		speaker.volumeUp();		
	}
	@Override
	public void volumeDown() {
		speaker.volumeDown();	
	}
}
