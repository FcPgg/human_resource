package com.xt.ptus.obejcts;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Pagination<T> {
	
	private Class<T> clazz;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Pagination() {
        // 子类
        Class cla = getClass();
        // 通过子类获取到父类 
        // 泛型参数
        Type type = cla.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType) type;
            this.clazz = (Class<T>) pType.getActualTypeArguments()[0];
        }
    }
    
    public Pagination(int page, int rows) {
    	this.page = page;
    	this.limit = rows;
    }

	private int total;
    
    private int page;
    
    private int limit;
    
    private int totalPageNum;
    
    private List<T> data = new ArrayList<T>();

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
		this.totalPageNum = (total  +  this.limit  - 1) / this.limit;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getTotalPageNum() {
		return totalPageNum;
	}

	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}
}
