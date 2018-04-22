package com.xt.ptus.mt.dao;

import java.util.List;

import com.xt.ptus.base.BaseDao;
import com.xt.ptus.mt.entity.MtPermissions;

public interface MtPermissionsDao extends BaseDao<MtPermissions>{

	List<MtPermissions> getActionById(int permissionId);

}
