package com.mrwang.search.service.impl;

import java.util.List;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrwang.common.pojo.SearchItem;
import com.mrwang.common.utils.E3Result;
import com.mrwang.search.mapper.ItemMapper;
import com.mrwang.search.service.SearchItemService;

@Service
public class SearchItemServiceImpl implements SearchItemService {

	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private SolrServer solrServer;

	@Override
	public E3Result importAllItems() {
		//
		try {
			List<SearchItem> itemList = itemMapper.getItemList();
			for (SearchItem searchItem : itemList) {
				SolrInputDocument document = new SolrInputDocument();
				document.addField("id", searchItem.getId());
				document.addField("item_title", searchItem.getTitle());
				document.addField("item_sell_point", searchItem.getSell_point());
				document.addField("item_price", searchItem.getPrice());
				document.addField("item_image", searchItem.getImage());
				document.addField("item_category_name", searchItem.getCat_name());

				solrServer.add(document);
			}
			solrServer.commit();
			return E3Result.ok();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			return E3Result.build(500, "数据导入时发生异常");
		}
	}

}
