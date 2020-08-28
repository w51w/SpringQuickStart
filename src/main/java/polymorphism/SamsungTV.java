package polymorphism;

public class SamsungTV implements TV {
	
	private SonySpeaker speaker;
	
	public SamsungTV() {
		System.out.println("[객체 생성]SamsungTV ");
	}
	@Override
	public void powerOn() {
		System.out.println("삼성TV 전원 켬");
	}
	@Override
	public void powerOff() {
		System.out.println("삼성TV 전원 끔");
	}
	@Override
	public void volumeUp() {
		speaker = new SonySpeaker();
		speaker.volumeUp();
	}
	@Override
	public void volumeDown() {
		speaker = new SonySpeaker();
		speaker.volumeDown();
	}
}
//SonySpeaker 객체가 쓸데 없이 두 개나 생성되는 것
//다른 스피커로 교체시 소스코드를 모두 수정해야 됨
//스프링은 이 문제를 의존성 주입을 이용하여  해결한다.
