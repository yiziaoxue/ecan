package com.ecan.service.impl;

import com.ecan.model.VmanPermcolumn;
import com.ecan.mapper.VmanPermcolumnMapper;
import com.ecan.service.VmanPermcolumnService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * mapper文件，系统自动生成
 * @author: TaneRoom
 * @since: 2016-07-22 00:56:22
 */
@Service("vmanPermcolumnService")
public class VmanPermcolumnServiceImpl implements VmanPermcolumnService {

	private Logger log = Logger.getLogger(VmanPermcolumnServiceImpl.class);

	@Autowired
	private VmanPermcolumnMapper vmanPermcolumnMapper;

	@Override
	public int addEntity(VmanPermcolumn model) throws Exception {
		try {
			log.info("addEntity");
			vmanPermcolumnMapper.addEntity(model);
			return 0;
		} catch(Exception e) {
			log.info("addEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int deleteEntity(VmanPermcolumn model) throws Exception {
		try {
			log.info("deleteEntity");
			return vmanPermcolumnMapper.deleteEntity(model);
		} catch(Exception e) {
			log.info("deleteEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int updateEntity(VmanPermcolumn model) throws Exception {
		try {
			log.info("updateEntity");
			vmanPermcolumnMapper.updateEntity(model);
			return 0;
		} catch(Exception e) {
			log.info("updateEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public VmanPermcolumn findEntity(VmanPermcolumn model) throws Exception {
		try {
			log.info("findEntity");
			return vmanPermcolumnMapper.findEntity(model);
		} catch(Exception e) {
			log.info("findEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<VmanPermcolumn> findEntityList(VmanPermcolumn model) throws Exception {
		try {
			log.info("findEntityList");
			return vmanPermcolumnMapper.findEntityList(model);
		} catch(Exception e) {
			log.info("findEntityList异常");
			e.printStackTrace();
			throw e;
		}
	}

}
