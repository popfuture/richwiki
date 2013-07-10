package richwiki;

import static org.junit.Assert.*;

import org.junit.Test;

public class PageDaoMemoryTest {

	@Test
	public void test() {
		PageDaoMemory m = new PageDaoMemory();
		Page p = new Page();
		p.setTitle("TestTitle");
		p.setHtml("<!DOCTYPE html>");
		m.savePage(p);
		Page p2 = m.loadPage("TestTitle");
		assertEquals(p.getHtml(),p2.getHtml());
	}

}
