package com.xt.ptus.base.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import com.xt.ptus.base.BaseDao;
import com.xt.ptus.base.BaseEntity;
import com.xt.ptus.constants.SystemConstants;
import com.xt.ptus.obejcts.Pagination;
import com.xt.ptus.util.GenericUtil;

/**
 * dao层基类，实现增，删，改，查等常用功能。
 * 
 */
@Repository
public class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T>{
	
	private static Logger logger = Logger.getLogger(BaseDaoImpl.class);

	@Resource(name = SystemConstants.SESSION_FACTORY_ID)
    private SessionFactory sessionFactory;
	
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl(){
    	try {
    		if(clazz != null){
    			clazz = GenericUtil.getActualClass(this.getClass(), 0);
    			logger.info("initialed service:" + clazz.getSimpleName() +"Service");
    		}
		} catch (Exception e) {
			logger.error(e);
		}
    }

	/**
     * 保存数据
     * 
     * @return void 返回类型
     */
    public void save(T t) {
        getCurrentSession().save(t);
    }

    /**
     * 删除数据
     * 
     * @return void 返回类型
     */
    public void remove(T t) {
        if (t != null)
            getCurrentSession().delete(t);
        else
            new RuntimeException("你要删除的数据不存在").printStackTrace();
        ;
    }

    /**
     * 更新数据
     * 
     * @return void 返回类型
     */
    public void update(T t) {
        getCurrentSession((Class<T>) t.getClass()).update(t);
    }

    /**
     * 根据ID查找数据
     * 
     * @return T 返回类型
     */
    @SuppressWarnings("unchecked")
    public T get(Serializable id, Class<T> clazz) {
        return (T) getCurrentSession(clazz).get(clazz, id);
    }

    /**
     * 查找所有数据
     * 
     * @throws
     * @return List<T> 返回类型
     */
    @SuppressWarnings("unchecked")
    public List<T> getAll(Class<T> clazz) {
        return getCurrentSession(clazz).createCriteria(clazz).list();
    }
    
	@Override
	public Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}
    
    /**
     * 获取session
     * @return
     */
    public Session getCurrentSession(Class<T> cla){
		return this.sessionFactory.getCurrentSession();
    }
    
    /**
	 * 根据入参参数类型获取到复合条件的所有实体信息条数
	 * @param condition
	 * @return
	 */
	public int getRowCountByDetachedCriteria(DetachedCriteria condition){
		Criteria criteria = condition.getExecutableCriteria(getCurrentSession());
		Long totalCount = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
		return totalCount == null ? 0 : totalCount.intValue();
	}
	
	/**
	 * 查询分页数据
	 * @param condition 查询条件
	 * @param page 页数
	 * @param rows 行数
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Pagination<T> findByPagination(DetachedCriteria condition, int page, int rows, String sort) {
		Pagination<T> pagination = new Pagination<T>(page, rows);
		
		Criteria criteria = condition.getExecutableCriteria(getCurrentSession());
        
		int rowCount = Integer.parseInt(criteria.setProjection(Projections.rowCount()).uniqueResult().toString());
        pagination.setTotal(rowCount);
		
        criteria.setProjection(null);
        criteria.setFirstResult((page - 1) * rows);
        criteria.setMaxResults(rows);
        criteria.addOrder(Order.asc(sort));
        
        if(rowCount > 0){
        	List<T> result = criteria.list();
        	pagination.setData(result);
        }
        
		return pagination;
	}

	@Override
	public Pagination<T> findByPagination(DetachedCriteria condition, int page, int rows, Order order) {
		Pagination<T> pagination = new Pagination<T>(page, rows);
		
		Criteria criteria = condition.getExecutableCriteria(getCurrentSession());
        
		int rowCount = Integer.parseInt(criteria.setProjection(Projections.rowCount()).uniqueResult().toString());
        pagination.setTotal(rowCount);
		
        criteria.setProjection(null);
        criteria.setFirstResult((page - 1) * rows);
        criteria.setMaxResults(rows);
        criteria.addOrder(order);
        
        if(rowCount > 0){
        	List<T> result = criteria.list();
        	pagination.setData(result);
        }
        
		return pagination;
	}

}