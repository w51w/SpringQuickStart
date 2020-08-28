package polymorphism;

public class TVUser {

	public static void main(String[] args) {
		BeanFactory factory = new BeanFactory();
		TV tv = (TV)factory.getBean(args[0]);
		
		//���α׷� ���� �� ����� �Ű������� �����ϸ� �ٲ�
		//Run as> Run Configuration > argument�� lg �Ǵ� samsung �� �Է��ϰ� Run�غ���
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
	}

}
