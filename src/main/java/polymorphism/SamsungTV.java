package polymorphism;

public class SamsungTV implements TV {
	public SamsungTV() {
		System.out.println("[按眉 积己]SamsungTV ");
	}
	@Override
	public void powerOn() {
		System.out.println("伙己TV 傈盔 脑");
	}
	@Override
	public void powerOff() {
		System.out.println("伙己TV 傈盔 阐");
	}
	@Override
	public void volumeUp() {
		System.out.println("伙己TV 家府 棵覆");
	}
	@Override
	public void volumeDown() {
		System.out.println("伙己TV 家府 郴覆");
	}
}
