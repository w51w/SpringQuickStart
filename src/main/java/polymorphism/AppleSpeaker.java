package polymorphism;

public class AppleSpeaker implements Speaker{
	public AppleSpeaker() {
		System.out.println("[��ü ����]���� ����Ŀ");
	}
	@Override
	public void volumeUp() {
		System.out.println("���� ����Ŀ �Ҹ� �ø���");
	}

	@Override
	public void volumeDown() {
		System.out.println("���� ����Ŀ �Ҹ� ������");		
	}

}
