package polymorphism;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV{
	@Resource(name="apple") //Autowired + Qualifier
	
	private Speaker speaker;
	
	public LgTV() {
		System.out.println("[°´Ã¼ »ý¼º]LgTV");
	}
	@Override
	public void powerOn() {
		System.out.println("LgTV Àü¿ø ÄÔ");		
	}
	@Override
	public void powerOff() {
		System.out.println("LgTV Àü¿ø ²û");		
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
