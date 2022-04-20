package AddTwoNumbers;

public class Singleton {


	private Singleton() {
		System.out.println("init instance");
	}

	private static class InstanceHolder {
		private static final Singleton instance = new Singleton();
	}

	public static Singleton getInstance() {
		return InstanceHolder.instance;
	}

	public static void main(String[] args) {
		Singleton.getInstance();
	}
}
