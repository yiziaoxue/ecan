package com.ecan.mapper;

import com.ecan.model.VmanRolePermRela;
import java.util.List;

/**
 * mapper文件，系统自动生成
 * @author: TaneRoom
 * @since: 2016-11-29 22:20:47
 */
public interface VmanRolePermRelaMapper {

	public int addEntity(VmanRolePermRela model);

	public int deleteEntity(VmanRolePermRela model);

	public int updateEntity(VmanRolePermRela model);

	public VmanRolePermRela findEntity(VmanRolePermRela model);

	public List<VmanRolePermRela> findEntityList(VmanRolePermRela model);

}
