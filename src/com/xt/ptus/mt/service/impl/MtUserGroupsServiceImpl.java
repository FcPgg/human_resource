package  com.xt.ptus.mt.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xt.ptus.base.impl.BaseServiceImpl;
import com.xt.ptus.mt.dao.MtPermissionsDao;
import com.xt.ptus.mt.dao.MtUserGroupMappingDao;
import com.xt.ptus.mt.dao.MtUserGroupsDao;
import com.xt.ptus.mt.entity.MtPermissions;
import com.xt.ptus.mt.entity.MtUserGroupMapping;
import com.xt.ptus.mt.entity.MtUserGroups;
import com.xt.ptus.mt.service.MtUserGroupsService;
import com.xt.ptus.util.StringUtil;

@Service
public class MtUserGroupsServiceImpl extends BaseServiceImpl<MtUserGroups> implements MtUserGroupsService{
	
	@Autowired
	private MtUserGroupMappingDao userGroupMappingDao;
	
	@Autowired 
	private MtUserGroupsDao groupDao;
	
	@Autowired 
	private MtPermissionsDao permissionsDao;
	
	/**
	 * 更新分组后，更新分组映射
	 */
	public void afterUpdate(MtUserGroups t) {
		if(t.getGroupPermission() != null && t.getGroupPermission().size() > 0){
			
			for(MtUserGroupMapping userGroupMapping : t.getGroupPermission()){
				if(!StringUtil.IsNullOrEmpty(userGroupMapping.getId()) && Integer.parseInt(userGroupMapping.getId()) > 0){
					userGroupMappingDao.update(userGroupMapping);
					} else {
						t.setCreateTime(new Date());
						t.setMasterId(1);
						userGroupMapping.setGroupId(Integer.parseInt(t.getId()));
						userGroupMappingDao.save(userGroupMapping);
				}
			}
		}
		
	}

	/**
	 * 获取某个分组的权限
	 */
	@Override
	public MtUserGroups getGroupInfoById(String id) {
		MtUserGroups userGroups = groupDao.get(id, MtUserGroups.class);
		List<MtUserGroupMapping> GroupMapping = userGroupMappingDao.getPermission(id);
		userGroups.setGroupPermission(GroupMapping);
		//??????有问题
		List<MtPermissions> permission = permissionsDao.getAll(MtPermissions.class) ;
		
		
		return userGroups;
	}

}
