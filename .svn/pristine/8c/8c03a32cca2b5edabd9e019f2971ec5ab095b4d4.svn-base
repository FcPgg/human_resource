package com.xt.ptus.base.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import com.xt.ptus.base.BaseDao;
import com.xt.ptus.base.BaseEntity;
import com.xt.ptus.base.BaseService;
import com.xt.ptus.obejcts.Pagination;
import com.xt.ptus.util.GenericUtil;
import com.xt.ptus.util.StringUtil;

/**
 * Service层基类实现类。该类是一个抽象类。
 * @version 0.0.1
 * @param <T>
 */
@Transactional
public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {
	
	private static Logger logger = Logger.getLogger(BaseServiceImpl.class);
   
	@Autowired
	@Qualifier("baseDaoImpl")
	private BaseDao<T> baseDao;

    private Class<T> clazz;
    
    @SuppressWarnings("unchecked")
	protected BaseServiceImpl(){
    	try {
    		clazz = GenericUtil.getActualClass(this.getClass(), 0);
    		logger.info("initialed service:" + clazz.getSimpleName() +"Service");
		} catch (Exception e) {
			logger.error(e);
		}
    }

    /**
     * 根据ID删除数据
     * @throws 
     */
    @Override
    public void remove(Serializable id) {
    	T t = get(id);
    	beforeRemove(t);
        baseDao.remove(t);
        afterRemove(t);
    }
    
    /**
     * 删除数据
     */
    public void remove(T t) {
    	beforeRemove(t);
        baseDao.remove(t);
        afterRemove(t);
    }
    
    /**
     * 删除数据之前
     * @param t
     */
    public void beforeRemove(T t){
    	
    }
    
    /**
     * 删除数据之后
     * @param t
     */
    public void afterRemove(T t){
    	
    }
    
    /**
     * 添加数据之前
     * @param t
     */
    public void beforeInsert(T t){
    	
    }
    
    /**
     * 添加数据之后
     * @param t
     */
    public void afterInsert(T t){
    	
    }

    /**
     * 更新数据
     * @throws 
     */
    @Override
    public void update(T t) {
    	beforeUpdate(t);
    	onUpdate(t);
    	afterUpdate(t);
    }
    
    /**
     * 更新之前
     * @param t
     */
    public void beforeUpdate(T t){
    	
    }
    
    /**
     * 更新数据
     * @param t
     */
    private void onUpdate(T t){
    	if(t instanceof BaseEntity){
    		BaseEntity ent = (BaseEntity) t;
    		
    		if(StringUtil.IsNullOrEmpty(ent.getId()) || 0 >= Integer.parseInt(ent.getId())){
    			beforeInsert(t);
    			baseDao.save(t);
    			afterInsert(t);
    		} else {
    			baseDao.update(t);
    		}
    	}
    }
    
    /**
     * 更新之后
     * @param t
     */
    public void afterUpdate(T t){
    	
    }

    /**
     * 根据ID获得数据
     * @throws 
     */
    @Override
    public T get(Serializable id) {
        return (T) baseDao.get(id, clazz);
    }

    /**
     * 获取所有的数据
     * @throws 
     */
    @Override
    public List<T> list() {
        return baseDao.getAll(clazz);
    }

    /**
     * 获取分页数据
     */
	@Override
	public Pagination<T> getWithPagination(DetachedCriteria condition, int page, int rows, String sort) {
		return baseDao.findByPagination(condition, page, rows, sort);
	}

	/**
	 * 获取currentSession
	 */
	@Override
	public Session getCurrentSession() {
		return baseDao.getCurrentSession();
	}
}