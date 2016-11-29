package com.ecan.service.impl;

import com.ecan.model.VmanPerm;
import com.ecan.mapper.VmanPermMapper;
import com.ecan.service.VmanPermService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * mapper文件，系统自动生成
 * @author: TaneRoom
 * @since: 2016-11-29 22:20:48
 */
@Service("vmanPermService")
public class VmanPermServiceImpl implements VmanPermService {

	private Logger log = Logger.getLogger(VmanPermServiceImpl.class);

	@Autowired
	private VmanPermMapper vmanPermMapper;

	@Override
	public int addEntity(VmanPerm model) throws Exception {
		try {
			log.info("addEntity");
			vmanPermMapper.addEntity(model);
			return 0;
		} catch(Exception e) {
			log.info("addEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int deleteEntity(VmanPerm model) throws Exception {
		try {
			log.info("deleteEntity");
			return vmanPermMapper.deleteEntity(model);
		} catch(Exception e) {
			log.info("deleteEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int updateEntity(VmanPerm model) throws Exception {
		try {
			log.info("updateEntity");
			vmanPermMapper.updateEntity(model);
			return 0;
		} catch(Exception e) {
			log.info("updateEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public VmanPerm findEntity(VmanPerm model) throws Exception {
		try {
			log.info("findEntity");
			return vmanPermMapper.findEntity(model);
		} catch(Exception e) {
			log.info("findEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<VmanPerm> findEntityList(VmanPerm model) throws Exception {
		try {
			log.info("findEntityList");
			return vmanPermMapper.findEntityList(model);
		} catch(Exception e) {
			log.info("findEntityList异常");
			e.printStackTrace();
			throw e;
		}
	}

}
