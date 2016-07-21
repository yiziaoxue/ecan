package com.ecan.mapper;

import com.ecan.model.VmanRole;
import java.util.List;

/**
 * mapper文件，系统自动生成
 * @author: TaneRoom
 * @since: 2016-07-22 00:56:22
 */
public interface VmanRoleMapper {

	public int addEntity(VmanRole model);

	public int deleteEntity(VmanRole model);

	public int updateEntity(VmanRole model);

	public VmanRole findEntity(VmanRole model);

	public List<VmanRole> findEntityList(VmanRole model);

}
