package com.mrwang.solrj;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
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
}
