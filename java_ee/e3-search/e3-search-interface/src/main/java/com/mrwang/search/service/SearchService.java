package com.mrwang.search.service;

import com.mrwang.common.pojo.SearchResult;

public interface SearchService {
	SearchResult search(String keyword, int page, int rows) throws Exception;
}
