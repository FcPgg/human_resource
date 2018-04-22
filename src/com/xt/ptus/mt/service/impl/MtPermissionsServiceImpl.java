package  com.xt.ptus.mt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Service;

import com.xt.ptus.base.impl.BaseServiceImpl;
import com.xt.ptus.mt.entity.MtPermissions;
import com.xt.ptus.mt.service.MtPermissionsService;
import com.xt.ptus.sys.entity.SysMenus;

@Service
public class MtPermissionsServiceImpl extends BaseServiceImpl<MtPermissions> implements MtPermissionsService{

	@Override
	public List<MtPermissions> getPermissionTree() {
		List<MtPermissions> data = new ArrayList<MtPermissions>();
		try {
			Session session = this.getCurrentSession();
			Criteria criteria = session.createCriteria(MtPermissions.class);
			criteria.addOrder(Order.asc("id"));
			List<MtPermissions> list = criteria.list();
			if (list != null) {
				for (MtPermissions permission : list) {
					if (permission.getPid() == -1) {
						findChildren(list, permission);
						data.add(permission);
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return data;
	}
	
	/**
	 * 递归寻找菜单权限
	 * 
	 * @param src
	 * @param sysMenu
	 */
	private void findChildren(List<MtPermissions> src, MtPermissions permission) {
		for (MtPermissions item : src) {
			if (item.getPid() == Integer.parseInt(permission.getId())) {
				permission.getChildren().add(item);
				// 开始递归查找数据
				findChildren(src, item);
			}
		}
	}
}
