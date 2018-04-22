package com.xt.ptus.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.xt.ptus.constants.Constants;
import com.xt.ptus.obejcts.Result;
import com.xt.ptus.util.GenericUtil;

public class BaseController<E extends BaseEntity> {
	private static Logger logger = Logger.getLogger(BaseController.class);

	private Class<E> entityClass;

	@Autowired
	private BaseService<E> baseService;
	
	@SuppressWarnings("unchecked")
	public BaseController() {
		try {
			entityClass = GenericUtil.getActualClass(this.getClass(), 0);
			logger.info("initialized controller:" + entityClass.getSimpleName() + "Controller");
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public Class<E> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<E> entityClass) {
		this.entityClass = entityClass;
	}
	
	@RequestMapping(Constants.VERB_PAGE)
	public ModelAndView goPage(@RequestParam("pagePath") String pagePath, @RequestParam("title") String title, HttpServletRequest request){
		ModelAndView mav = new ModelAndView(pagePath);
		mav.addObject("title", title);
		return mav;
	}

	/**
	 * 查询单条数据
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = Constants.VERB_GET)
	public Result doGet(@RequestParam("id") String id) {
		Result result = new Result();
		try {
			result.setData(this.baseService.get(id));
			result.setSuccess(true);
			result.setMessage("查询数据成功!");
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage("查询数据失败!");
			result.setError(e.getMessage());
			logger.error(e);
		}
		return result;
	}

	/**
	 * 查询所有数据
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = Constants.VERB_LIST)
	public Result doList(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result();
		try {
			result.setData(this.baseService.list());
			result.setSuccess(true);
			result.setMessage("获取数据成功!");
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage("获取数据失败!");
			result.setError(e.getMessage());
			logger.error(e);
		}
		return result;
	}
	
	/**
	 * 更新数据
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = Constants.VERB_UPDATE)
	public Result doUpdate(E e, HttpServletRequest request) {
		Result result = new Result();
		try {
			this.baseService.update(e);
			result.setData(e);
			result.setSuccess(true);
			result.setMessage("更新成功!");
		} catch (Exception ex) {
			result.setSuccess(false);
			result.setMessage("更新失败!");
			result.setError(ex.getMessage());
			logger.error(ex);
		}
		return result;
	}
	
	/**
	 * 删除数据
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = Constants.VERB_REMOVE)
	public Result doRemove(@RequestParam("id") String id) {
		Result result = new Result();
		try {
			this.baseService.remove(id);
			result.setSuccess(true);
			result.setMessage("删除成功!");
		} catch (Exception ex) {
			result.setSuccess(false);
			result.setMessage("删除失败!");
			result.setError(ex.getMessage());
			logger.error(ex);
		}
		return result;
	}
	
	/**
	 * 获取无条件的分页数据
	 * @param rows
	 * @param page
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = Constants.VERB_PAGINATION)
	public Result doPagination(@RequestParam("rows") String rows,  @RequestParam("page") String page){
		Result result = new Result();
		int pageInt = 1;
		int rowsInt = 10;
		try {
			pageInt = Integer.parseInt(page);
			rowsInt = Integer.parseInt(rows);
		} catch (Exception e) {
			result.setMessage("转换数据类型异常，使用默认分页数据");
			logger.error(result.getMessage());
		}
		try {
			DetachedCriteria condition = DetachedCriteria.forClass(this.entityClass);
			result.setData(this.baseService.getWithPagination(condition, pageInt, rowsInt, "id"));
			result.setSuccess(true);
			result.setMessage("分页成功!");
		} catch (Exception ex) {
			result.setSuccess(false);
			result.setMessage("分页失败!");
			result.setError(ex.getMessage());
			logger.error(ex);
		}
		return result;
	}
	
	/**
	 * 对象转换json
	 * @param obj
	 * @return
	 */
	public static String toJSON(Object obj){
		Gson gson = getGsonObject();
		return gson.toJson(obj);
	}
	
	/**
	 * json转换对象
	 * @param jsonStr
	 * @param cls
	 * @return
	 */
	public static <T> Object fromJSON(String jsonStr, Class<T> cls){
		Gson gson = getGsonObject();
		return gson.fromJson(jsonStr, cls);
	}
	
	private static Gson getGsonObject(){
		Gson gson = new GsonBuilder()  
        .enableComplexMapKeySerialization() //支持Map的key为复杂对象的形式  
        .serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss:SSS")//时间转化为特定格式    
        .setPrettyPrinting() //对json结果格式化.  
        .setVersion(1.0)    //有的字段不是一开始就有的,会随着版本的升级添加进来,那么在进行序列化和返序列化的时候就会根据版本号来选择是否要序列化.  
                            //@Since(版本号)能完美地实现这个功能.还的字段可能,随着版本的升级而删除,那么  
                            //@Until(版本号)也能实现这个功能,GsonBuilder.setVersion(double)方法需要调用.  
        .create();  
		return gson;
	}
}
