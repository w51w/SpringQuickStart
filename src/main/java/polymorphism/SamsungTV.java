package polymorphism;

public class SamsungTV implements TV {
	
	private Speaker speaker;
	
	public SamsungTV() {
		System.out.println("[按眉 积己]SamsungTV(1) ");
	}
	public SamsungTV(Speaker speaker) {
		System.out.println("[按眉 积己]SamsungTV(2) ");
		this.speaker = speaker;
	}
	@Override
	public void powerOn() {
		System.out.println("伙己TV 傈盔 脑");
	}
	@Override
	public void powerOff() {
		System.out.println("伙己TV 傈盔 阐");
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