package com.xt.ptus.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.xt.ptus.obejcts.Pagination;

/**
 * dao层基类，实现增，删，改，查等常用功能。
 * 
 */
@Repository
public interface BaseDao<T extends BaseEntity>{
	

	/**
     * 保存数据
     * 
     * @return void 返回类型
     */
    public void save(T t);

    /**
     * 删除数据
     * 
     * @return void 返回类型
     */
    public void remove(T t);

    /**
     * 更新数据
     * 
     * @return void 返回类型
     */
    public void update(T t);

    /**
     * 根据ID查找数据
     * 
     * @return T 返回类型
     */
    @SuppressWarnings("unchecked")
    public T get(Serializable id, Class<T> clazz);

    /**
     * 查找所有数据
     * 
     * @throws
     * @return List<T> 返回类型
     */
    @SuppressWarnings("unchecked")
    public List<T> getAll(Class<T> clazz);
    
    /**
     * 获取session
     * @return
     */
    public Session getCurrentSession();
    
    /**
     * 获取session
     * @return
     */
    public Session getCurrentSession(Class<T> clazz);
    
    /**
	 * 根据入参参数类型获取到复合条件的所有实体信息条数
	 * @param condition
	 * @return
	 */
	public int getRowCountByDetachedCriteria(DetachedCriteria condition);
	
	/**
	 * 查询分页数据
	 * @param condition 查询条件
	 * @param page 页数
	 * @param rows 行数
	 * @param sort 默认排序
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Pagination<T> findByPagination(DetachedCriteria condition, int page, int rows, String sort);
	
	/**
	 * 查询分页数据
	 * @param condition 查询条件
	 * @param page 页数
	 * @param rows 行数
	 * @param sort 排序
	 * @return
	 */
	public Pagination<T> findByPagination(DetachedCriteria condition, int page, int rows, Order order);
	
}
