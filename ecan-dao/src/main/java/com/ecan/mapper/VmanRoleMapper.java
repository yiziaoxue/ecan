package com.ecan.mapper;

import com.ecan.model.VmanRole;
import java.util.List;

/**
 * mapper文件，系统自动生成
 * @author: TaneRoom
 * @since: 2016-11-29 22:20:47
 */
public interface VmanRoleMapper {

	public int addEntity(VmanRole model);

	public int deleteEntity(VmanRole model);

	public int updateEntity(VmanRole model);

	public VmanRole findEntity(VmanRole model);

	public List<VmanRole> findEntityList(VmanRole model);

}
