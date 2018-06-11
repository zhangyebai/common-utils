package com.yebai.common.utils.bean;

import java.util.List;

public class PageRespEntry<T> {

	private int code;
	private String message;
	private Page<T> page;
	private List<T> data;

	public int getCode() {
		return code;
	}

	public PageRespEntry<T> setCode(int code) {
		this.code = code;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public PageRespEntry<T> setMessage(String message) {
		this.message = message;
		return this;
	}

	public Page<T> getPage() {
		return page;
	}

	public PageRespEntry<T> setPage(Page<T> page) {
		this.page = page;
		return this;
	}

	public List<T> getData() {
		return data;
	}

	public PageRespEntry<T> setData(List<T> data) {
		this.data = data;
		return this;
	}
}
