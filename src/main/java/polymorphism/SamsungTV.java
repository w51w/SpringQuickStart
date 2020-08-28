package polymorphism;

public class SamsungTV implements TV {
	
	private SonySpeaker speaker;
	
	public SamsungTV() {
		System.out.println("[��ü ����]SamsungTV(1) ");
	}
	public SamsungTV(SonySpeaker speaker) {
		System.out.println("[��ü ����]SamsungTV(2) ");
		this.speaker = speaker;
	}
	@Override
	public void powerOn() {
		System.out.println("�ＺTV ���� ��");
	}
	@Override
	public void powerOff() {
		System.out.println("�ＺTV ���� ��");
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