package com.mrwang.search.service.impl;

import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrwang.common.pojo.SearchResult;
import com.mrwang.search.dao.SearchDao;
import com.mrwang.search.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService {
	@Autowired
	private SearchDao searchDao;

	@Override
	public SearchResult search(String keyword, int page, int rows) throws Exception {
		//
		SolrQuery query = new SolrQuery();
		query.setQuery(keyword);
		if (page <= 0) {
			page = 1;
		}
		query.setStart((page - 1) * rows);
		query.setRows(rows);
		query.set("df", "item_title");
		query.setHighlight(true);
		query.addHighlightField("item_title");
		query.setHighlightSimplePre("<em style=\"color:red\">");
		query.setHighlightSimplePost("</em>");

		SearchResult result = searchDao.search(query);

		long recordCount = result.getRecordCount();
		int totalPages = (int) (recordCount / rows);
		if (recordCount % rows > 0) {
			totalPages++;
		}
		result.setTotalPages(totalPages);
		return result;
	}

}
