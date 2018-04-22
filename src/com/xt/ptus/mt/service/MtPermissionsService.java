package com.xt.ptus.mt.service;

import java.util.List;

import com.xt.ptus.base.BaseService;
import com.xt.ptus.mt.entity.MtPermissions;

public interface MtPermissionsService extends BaseService<MtPermissions>{

	List<MtPermissions> getPermissionTree();

}
