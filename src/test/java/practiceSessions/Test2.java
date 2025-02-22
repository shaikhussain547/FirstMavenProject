package practiceSessions;

import org.testng.annotations.Test;

public class Test2 {
	
	ThreadLocal<String> name = new ThreadLocal<>();
	
	public String initName() {
		name.set("testing");
		System.out.println(getName().length());
		return getName();
	}
	
	public String getName() {
		return name.get();
	}
	
	
	@Test
	public void test() {
		initName();
		System.out.println(name.get());
	}
	
	
}
