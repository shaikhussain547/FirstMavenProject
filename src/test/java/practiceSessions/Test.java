package practiceSessions;

public class Test {
	
	public Test(int name) {
		
	}
	
	public static void main(String[] args) {
		
		ThreadLocal<String> name = new ThreadLocal<>();
		name.set("Automation");
		System.out.println(name.get());
		name.remove();
		System.out.println(name.get());
		System.out.println("Completed");
		int n = 1;
		Test te = new Test(n);
		
	}
}