package polymorphism;

public class SamsungTV implements TV {
	
	private SonySpeaker speaker;
	
	public SamsungTV() {
		System.out.println("[��ü ����]SamsungTV ");
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
		speaker = new SonySpeaker();
		speaker.volumeUp();
	}
	@Override
	public void volumeDown() {
		speaker = new SonySpeaker();
		speaker.volumeDown();
	}
}
//SonySpeaker ��ü�� ���� ���� �� ���� �����Ǵ� ��
//�ٸ� ����Ŀ�� ��ü�� �ҽ��ڵ带 ��� �����ؾ� ��
//�������� �� ������ ������ ������ �̿��Ͽ�  �ذ��Ѵ�.
