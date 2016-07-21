package com.ecan.service;

import com.ecan.model.VmanUser;
import java.util.List;

/**
 * mapper文件，系统自动生成
 * @author: TaneRoom
 * @date: 2016-07-21 18:06:54
 */
public interface VmanUserService {

	//增加实体
	public int addEntity(VmanUser model) throws Exception;

	//删除实体
	public int deleteEntity(VmanUser model) throws Exception;

	//修改实体
	public int updateEntity(VmanUser model) throws Exception;

	//查询实体
	public VmanUser findEntity(VmanUser model) throws Exception;

	//查询实体List
	public List<VmanUser> findEntityList(VmanUser model) throws Exception;

}
