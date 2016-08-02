package com.ecan.service;

import com.ecan.model.VmanPerm;
import java.util.List;

/**
 * mapper文件，系统自动生成
 * @author: TaneRoom
 * @since: 2016-07-30 20:39:08
 */
public interface VmanPermService {

	//增加实体
	public int addEntity(VmanPerm model) throws Exception;

	//删除实体
	public int deleteEntity(VmanPerm model) throws Exception;

	//修改实体
	public int updateEntity(VmanPerm model) throws Exception;

	//查询实体
	public VmanPerm findEntity(VmanPerm model) throws Exception;

	//查询实体List
	public List<VmanPerm> findEntityList(VmanPerm model) throws Exception;

}
