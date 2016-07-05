package com.ecan.service;

import com.ecan.model.YqUsers;
import java.util.List;
public interface YqUsersService {

	//增加实体
	public int addEntity(YqUsers model) throws Exception;

	//删除实体
	public int deleteEntity(YqUsers model) throws Exception;

	//修改实体
	public int updateEntity(YqUsers model) throws Exception;

	//查询实体
	public YqUsers findEntity(YqUsers model) throws Exception;

	//查询实体List
	public List<YqUsers> findEntityList(YqUsers model) throws Exception;

}
