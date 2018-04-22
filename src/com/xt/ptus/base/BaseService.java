package com.xt.ptus.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.xt.ptus.obejcts.Pagination;

/**
 * Service层基类，定义通用的增，删，改，查功能接口。
 * 
 * @version 0.0.1
 * @param <T>
 */
public interface BaseService<T> {

    /**
     * 删除数据
     * 
     * @throws
     * @return void 返回类型
     */
    @Transactional
    public void remove(Serializable id);
    
    /**
     * 删除数据
     * @param t
     */
    @Transactional
    public void remove(T t);

    /**
     * 更新数据
     * 
     * @throws
     * @return void 返回类型
     */
    @Transactional
    public void update(T t);

    /**
     * 根据ID获取数据
     * 
     * @throws
     * @return T 返回类型
     */
    @Transactional
    public T get(Serializable id);

    /**
     * 获取所有的数据
     * 
     * @throws
     * @return List<T> 返回类型
     */
    @Transactional
    public List<T> list();
    
    /**
     * 分页数据
     * @param condition
     * @param page
     * @param rows
     * @return
     */
    @Transactional
    public Pagination<T> getWithPagination(DetachedCriteria condition, int page, int rows, String sort);
    
    /**
     * 返回Session
     * @return
     */
    public Session getCurrentSession();
}