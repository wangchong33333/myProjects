package com.mrwang.solrj;

import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class TestSolrj {
	@Test
	public void addDocument() throws Exception {
		SolrServer solrServer = new HttpSolrServer("http://192.168.25.125:8080/solr/collection1");
		SolrInputDocument document = new SolrInputDocument();
		document.addField("id", "doc01");
		document.addField("item_title", "测试商品");
		document.addField("item_price", 1000);

		solrServer.add(document);
		solrServer.commit();
	}

	@Test
	public void deleteDocument() throws Exception {
		SolrServer solrServer = new HttpSolrServer("http://192.168.25.125:8080/solr/collection1");
		solrServer.deleteById("doc01");
		// solrServer.deleteByQuery("id:doc01");
		solrServer.commit();
	}

	@Test
	public void queryIndex() throws Exception {
		SolrServer solrServer = new HttpSolrServer("http://192.168.25.125:8080/solr/collection1");
		SolrQuery solrQuery = new SolrQuery();
		// solrQuery.setQuery("*:*");
		solrQuery.set("q", "*:*");
		QueryResponse queryResponse = solrServer.query(solrQuery);
		SolrDocumentList results = queryResponse.getResults();
		System.out.println(results.getNumFound());
		for (SolrDocument solrDocument : results) {
			System.out.println(solrDocument.get("id"));
			System.out.println(solrDocument.get("item_title"));
			System.out.println(solrDocument.get("item_sell_point"));
			System.out.println(solrDocument.get("item_price"));
			System.out.println(solrDocument.get("item_image"));
			System.out.println(solrDocument.get("item_category_name"));
		}
	}

	@Test
	public void queryHard() throws Exception {
		SolrServer solrServer = new HttpSolrServer("http://192.168.25.125:8080/solr/collection1");
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.setQuery("手机");
		solrQuery.setStart(0);
		solrQuery.setRows(20);
		solrQuery.set("df", "item_title");
		solrQuery.setHighlight(true);
		solrQuery.addHighlightField("item_title");
		solrQuery.setHighlightSimplePre("<em>");
		solrQuery.setHighlightSimplePost("</em>");

		QueryResponse queryResponse = solrServer.query(solrQuery);
		SolrDocumentList results = queryResponse.getResults();
		System.out.println(results.getNumFound());
		for (SolrDocument solrDocument : results) {
			System.out.println(solrDocument.get("id"));

			Map<String, Map<String, List<String>>> map = queryResponse.getHighlighting();
			List<String> list = map.get(solrDocument.get("id")).get("item_title");
			String tilte = "";
			if (list != null && list.size() > 0) {
				tilte = list.get(0);
			} else {
				tilte = (String) solrDocument.get("item_title");
			}
			System.out.println(tilte);
			System.out.println(solrDocument.get("item_sell_point"));
			System.out.println(solrDocument.get("item_price"));
			System.out.println(solrDocument.get("item_image"));
			System.out.println(solrDocument.get("item_category_name"));
		}
	}
}
