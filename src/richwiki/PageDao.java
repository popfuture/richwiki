package richwiki;

public interface PageDao {
	Page loadPage(String title);
	void savePage(Page page);
}
