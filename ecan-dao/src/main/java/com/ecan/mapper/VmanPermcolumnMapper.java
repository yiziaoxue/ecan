package com.ecan.mapper;

import com.ecan.model.VmanPermcolumn;
import java.util.List;

/**
 * mapper文件，系统自动生成
 * @author: TaneRoom
 * @since: 2016-07-22 00:56:22
 */
public interface VmanPermcolumnMapper {

	public int addEntity(VmanPermcolumn model);

	public int deleteEntity(VmanPermcolumn model);

	public int updateEntity(VmanPermcolumn model);

	public VmanPermcolumn findEntity(VmanPermcolumn model);

	public List<VmanPermcolumn> findEntityList(VmanPermcolumn model);

}
