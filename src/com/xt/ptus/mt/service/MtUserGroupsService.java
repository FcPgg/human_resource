package com.xt.ptus.mt.service;

import java.util.List;

import com.xt.ptus.base.BaseService;
import com.xt.ptus.mt.entity.MtUserGroups;

public interface MtUserGroupsService extends BaseService<MtUserGroups>{

	public MtUserGroups getGroupInfoById(String id);

}
