package com.ecan.mapper;

import com.ecan.model.VmanUserRoleRela;
import java.util.List;

/**
 * mapper文件，系统自动生成
 * @author: TaneRoom
 * @since: 2016-11-29 22:20:47
 */
public interface VmanUserRoleRelaMapper {

	public int addEntity(VmanUserRoleRela model);

	public int deleteEntity(VmanUserRoleRela model);

	public int updateEntity(VmanUserRoleRela model);

	public VmanUserRoleRela findEntity(VmanUserRoleRela model);

	public List<VmanUserRoleRela> findEntityList(VmanUserRoleRela model);

}
