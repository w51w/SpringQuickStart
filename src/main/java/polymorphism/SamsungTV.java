package polymorphism;

public class SamsungTV implements TV {
	
	private Speaker speaker;
	
	public SamsungTV() {
		System.out.println("[객체 생성]SamsungTV(1) ");
	}
	
	// set + name속성값(첫글자는 대문자)
	public void setSpeaker(Speaker speaker) {
		System.out.println("setSpeaker() 호출");
		this.speaker = speaker;
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
		speaker.volumeUp();
	}
	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}
}