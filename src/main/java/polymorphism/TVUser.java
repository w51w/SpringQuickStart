package polymorphism;

public class TVUser {

	public static void main(String[] args) {
		BeanFactory factory = new BeanFactory();
		TV tv = (TV)factory.getBean(args[0]);
		
		//프로그램 실행 시 명령행 매개변수를 전달하면 바뀜
		//Run as> Run Configuration > argument에 lg 또는 samsung 을 입력하고 Run해보자
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
	}

}
