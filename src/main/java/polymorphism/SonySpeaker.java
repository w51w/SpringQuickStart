package polymorphism;

public class SonySpeaker implements Speaker {
	public SonySpeaker() {
		System.out.println("[객체 생성]소니스피커");
	}
	@Override
	public void volumeUp() {
		System.out.println("소니스피커 소리 올린다");
	}
	@Override
	public void volumeDown() {
		System.out.println("소니스피커 소리 내린다");
	}
}
