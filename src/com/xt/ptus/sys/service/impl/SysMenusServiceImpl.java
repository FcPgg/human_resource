package com.xt.ptus.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.ptus.base.impl.BaseServiceImpl;
import com.xt.ptus.mt.dao.MtChoiceGroupDao;
import com.xt.ptus.mt.dao.MtPermissionsDao;
import com.xt.ptus.mt.dao.MtUserGroupMappingDao;
import com.xt.ptus.mt.entity.MtChoiceGroup;
import com.xt.ptus.mt.entity.MtPermissions;
import com.xt.ptus.mt.entity.MtUserGroupMapping;
import com.xt.ptus.sys.entity.SysMenus;
import com.xt.ptus.sys.service.SysMenusService;

@Service
public class SysMenusServiceImpl extends BaseServiceImpl<SysMenus> implements SysMenusService {

	@Autowired
	private MtChoiceGroupDao choiceGroupDap;
	@Autowired
	private MtUserGroupMappingDao userGroupMappingDao;
	@Autowired
	private MtPermissionsDao permissionDao;

	@Override
	public List<SysMenus> getSysMenusWithTreeStructure(String userId) throws Exception {
		List<MtPermissions> permissions = null;
		List<MtChoiceGroup> choiceGroup = choiceGroupDap.getGroupByUserId(userId);
		ArrayList<String> lists = new ArrayList<String>();
		for (MtChoiceGroup group : choiceGroup) {
			List<MtUserGroupMapping> userGroupMapping = userGroupMappingDao.getPermissionByGroupId(group.getGroupId());
			for (MtUserGroupMapping groupMapping : userGroupMapping) {
				permissions = permissionDao.getActionById(groupMapping.getPermissionId());
				for (MtPermissions action : permissions) {
					lists.add(action.getAction());
				}
			}
		}
		for (int i = 0; i < lists.size(); i++) {
			System.out.println("action=" + lists.get(i));
		}

		List<SysMenus> menuList = new ArrayList<SysMenus>();
		List<SysMenus> data = new ArrayList<SysMenus>();
		try {
			Session session = this.getCurrentSession();
			Criteria criteria = session.createCriteria(SysMenus.class);
			criteria.addOrder(Order.asc("level"));
			List<SysMenus> list = criteria.list();
			System.out.println("afdadfasfd" + list);
			for (SysMenus menu : list) {
				for (int i = 0; i < lists.size(); i++) {
					if (menu.getAction().equals(lists.get(i))) {
						menuList.add(menu);
						break;
					}
				}
			}
			if (menuList != null) {
				for (SysMenus sysMenu : menuList) {
					if (sysMenu.getPid() == -1) {
						findChildren(menuList, sysMenu);
						data.add(sysMenu);
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return data;
	}

	/**
	 * 递归寻找菜单
	 * 
	 * @param src
	 * @param sysMenu
	 */
	private void findChildren(List<SysMenus> src, SysMenus sysMenu) {
		for (SysMenus item : src) {
			if (item.getPid() == Integer.parseInt(sysMenu.getId())) {
				sysMenu.getChildren().add(item);
				// 开始递归查找数据
				findChildren(src, item);
			}
		}
	}
}
