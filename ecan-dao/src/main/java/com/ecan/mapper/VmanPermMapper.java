package com.ecan.mapper;

import com.ecan.model.VmanPerm;
import java.util.List;

/**
 * mapper文件，系统自动生成
 * @author: TaneRoom
 * @since: 2016-11-29 22:20:47
 */
public interface VmanPermMapper {

	public int addEntity(VmanPerm model);

	public int deleteEntity(VmanPerm model);

	public int updateEntity(VmanPerm model);

	public VmanPerm findEntity(VmanPerm model);

	public List<VmanPerm> findEntityList(VmanPerm model);

}
