package com.mrwang.common.pojo;

import java.io.Serializable;
import java.util.List;

public class SearchResult implements Serializable{
	private long recordCount;
	private int totalPages;
	private List<SearchItem> items;

	public long getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<SearchItem> getItems() {
		return items;
	}

	public void setItems(List<SearchItem> items) {
		this.items = items;
	}

}
