import static org.junit.Assert.*;

import org.gitmining.util.DomainRetriever;
import org.junit.Test;


public class Testttt {

	@Test
	public void test() {
		assertEquals(null, "123", "123");
	}

	@Test
	public void test2() {
		assertEquals(null, "123", "123");
	}
	
	@Test
	public void test4() {
		assertEquals(null, "123", "123");
	}
	
	@Test
	public void test5() {
		assertEquals(null, "123", "12");
	}
	
	@Test
	public void test6() {
		DomainRetriever.extractBlogDomain("http:\\baidu.com");
	}
}
