package polymorphism;

public class LgTV implements TV{
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
