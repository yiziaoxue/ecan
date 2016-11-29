package com.ecan.service;

import com.ecan.model.VmanUser;
import java.util.List;

/**
 * mapper文件，系统自动生成
 * @author: TaneRoom
 * @since: 2016-11-29 22:20:47
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
