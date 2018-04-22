package com.xt.ptus.mt.controller.params;

/**
 * 订单参数结构
 * @author Administrator
 *
 */
public class MtOrderGoodsParam {
	
	/**
	 * 商品编号
	 */
	private String goodsId;
	
	/**
	 * 规格编号
	 */
	private String specId;
	
	private int count;

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getSpecId() {
		return specId;
	}

	public void setSpecId(String specId) {
		this.specId = specId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
