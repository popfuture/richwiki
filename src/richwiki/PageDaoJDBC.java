package richwiki;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class PageDaoJDBC implements PageDao {
	private NamedParameterJdbcTemplate jdbc;
	
	@Override
	public Page loadPage(String title) {
		Map<String, String> paramMap = new HashMap<String,String>();
		paramMap.put("title", title);
		Page page = jdbc.queryForObject("SELECT * FROM pages Where title = :title order by last_updated desc limit 1",
				paramMap, new RowMapper<Page>() {
					@Override
					public Page mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Page page = new Page();
						page.setTitle(rs.getString("title"));
						page.setHtml(rs.getString("html"));
						page.setLastEditTime(rs.getDate("last_updated"));
						return page;
					}
				});
		return page;
	}

	@Override
	public void savePage(Page page) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("title", page.getTitle());
		paramMap.put("html", page.getHtml());
		jdbc.update("INSERT into pages (title,html) values (:title,:html)", paramMap);
	}

	public void setJdbc(NamedParameterJdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
}
