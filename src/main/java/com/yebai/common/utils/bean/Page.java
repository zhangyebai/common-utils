package com.yebai.common.utils.bean;

import com.github.pagehelper.PageInfo;

import java.util.List;

public class Page<T> {

	private int page;
	private int size;
	private int pages;
	private long total;

	public Page(){

	}

	public Page(List<T> data){
		if(null != data) {
			PageInfo<T> info = new PageInfo<T>(data);
			this.page = info.getPageNum();
			this.size = info.getPageSize();
			this.pages = info.getPages();
			this.total = info.getTotal();
		}
	}

	public Page(int page, int size, int pages, long total){
		this.page = page;
		this.size = size;
		this.pages = pages;
		this.total = total;
	}

	public int getPage() {
		return page;
	}

	public Page<T> setPage(int page) {
		this.page = page;
		return this;
	}

	public int getSize() {
		return size;
	}

	public Page<T> setSize(int size) {
		this.size = size;
		return this;
	}

	public int getPages() {
		return pages;
	}

	public Page<T> setPages(int pages) {
		this.pages = pages;
		return this;
	}

	public long getTotal() {
		return total;
	}

	public Page<T> setTotal(long total) {
		this.total = total;
		return this;
	}

	@Override
	public String toString() {
		return "Page{" +
				"page=" + page +
				", size=" + size +
				", pages=" + pages +
				", total=" + total +
				'}';
	}
}
