package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV{
	//������ �����̳ʴ� �ش� Ÿ���� ��ü�� ã�Ƽ� �ڵ����� �Ҵ�
	@Autowired //�޼ҵ�, ������� ���� ���,  ���� ����
	private Speaker speaker;
	
	public LgTV() {
		System.out.println("[��ü ����]LgTV");
	}
	@Override
	public void powerOn() {
		System.out.println("LgTV ���� ��");		
	}
	@Override
	public void powerOff() {
		System.out.println("LgTV ���� ��");		
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
