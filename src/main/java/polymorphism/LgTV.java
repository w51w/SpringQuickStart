package polymorphism;

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
