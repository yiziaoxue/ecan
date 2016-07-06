package com.ecan.service;

import com.ecan.model.YqUsers;
import java.util.List;

/**
 * mapper文件，系统自动生成
 * @author: TaneRoom
 * @date: 2016-07-07 00:08:49
 */
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
