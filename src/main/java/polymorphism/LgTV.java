package polymorphism;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV{
	@Resource(name="apple") //Autowired + Qualifier
	
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
