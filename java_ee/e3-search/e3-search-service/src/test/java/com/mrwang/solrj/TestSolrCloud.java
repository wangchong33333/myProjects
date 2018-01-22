package com.mrwang.solrj;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class TestSolrCloud {

	@Test
	public void testAddDocument() throws Exception {
		CloudSolrServer solrServer = new CloudSolrServer("192.168.25.125:2181,192.168.25.125:2182,192.168.25.125:2183");
		solrServer.setDefaultCollection("collection2");

		SolrInputDocument document = new SolrInputDocument();
		document.setField("id", "solrcloud01");
		document.setField("item_title", "测试商品01");
		document.setField("item_price", 123);

		solrServer.add(document);
		solrServer.commit();
	}

	@Test
	public void testQueryDocument() throws Exception {
		CloudSolrServer solrServer = new CloudSolrServer("192.168.25.125:2181,192.168.25.125:2182,192.168.25.125:2183");
		solrServer.setDefaultCollection("collection2");

		SolrQuery query = new SolrQuery();
		query.setQuery("*:*");
		QueryResponse response = solrServer.query(query);
		SolrDocumentList solrDocumentList = response.getResults();
		System.out.println(solrDocumentList.getNumFound());

		for (SolrDocument solrDocument : solrDocumentList) {
			System.out.println(solrDocument.get("id"));
			System.out.println(solrDocument.get("title"));
			System.out.println(solrDocument.get("item_title"));
			System.out.println(solrDocument.get("item_price"));
		}

	}
}
