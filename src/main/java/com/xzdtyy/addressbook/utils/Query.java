package com.xzdtyy.addressbook.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * 查询参数
 */
public class Query extends LinkedHashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	// 数据偏移量
	private int offset;

	// 每页条数
	private int limit;

	public Query(Map<String, Object> params) {
		// 放入所有参数
	    this.putAll(params);

		// 分页参数
		this.offset = Integer.parseInt(params.get("offset").toString());
		this.limit = Integer.parseInt(params.get("limit").toString());

		this.put("offset", offset);

		// 计算当前请求数据的偏移量
		this.put("page", offset / limit + 1);
		this.put("limit", limit);
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.put("offset", offset);
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
}
