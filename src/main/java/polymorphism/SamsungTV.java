package polymorphism;

public class SamsungTV implements TV {
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
		System.out.println("�ＺTV �Ҹ� �ø�");
	}
	@Override
	public void volumeDown() {
		System.out.println("�ＺTV �Ҹ� ����");
	}
}
