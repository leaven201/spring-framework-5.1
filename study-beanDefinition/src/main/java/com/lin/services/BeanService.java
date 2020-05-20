package com.lin.services;

/**
 * @author LinZebin
 * @date 2020/5/1 2:42 下午
 */
public class BeanService {

	private IndexService indexService;

	public void setIndexService(IndexService indexService) {
		this.indexService = indexService;
	}

	public IndexService getIndexService() {
		return indexService;
	}
}
