package polymorphism;

public class SonySpeaker implements Speaker {
	public SonySpeaker() {
		System.out.println("[��ü ����]�ҴϽ���Ŀ");
	}
	@Override
	public void volumeUp() {
		System.out.println("�ҴϽ���Ŀ �Ҹ� �ø���");
	}
	@Override
	public void volumeDown() {
		System.out.println("�ҴϽ���Ŀ �Ҹ� ������");
	}
}
