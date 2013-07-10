package richwiki;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PageDaoMemory implements PageDao {
	private ConcurrentHashMap<String,Page> pagetable = new ConcurrentHashMap<String,Page>();
	
	public PageDaoMemory() {}
	
	public PageDaoMemory(Map map) {
		pagetable.putAll(map);
	}
	
	@Override
	public Page loadPage(String title) {
		return pagetable.get(title);
	}

	@Override
	public void savePage(Page page) {
		pagetable.put(page.getTitle(), page);
	}

}
