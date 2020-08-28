package polymorphism;

public class AppleSpeaker implements Speaker{
	public AppleSpeaker() {
		System.out.println("[객체 생성]애플 스피커");
	}
	@Override
	public void volumeUp() {
		System.out.println("애플 스피커 소리 올린다");
	}

	@Override
	public void volumeDown() {
		System.out.println("애플 스피커 소리 내린다");		
	}

}
