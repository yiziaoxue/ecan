package com.ecan.service.impl;

import com.ecan.model.VmanUserRoleRela;
import com.ecan.mapper.VmanUserRoleRelaMapper;
import com.ecan.service.VmanUserRoleRelaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * mapper文件，系统自动生成
 * @author: TaneRoom
 * @since: 2016-11-29 22:20:48
 */
@Service("vmanUserRoleRelaService")
public class VmanUserRoleRelaServiceImpl implements VmanUserRoleRelaService {

	private Logger log = Logger.getLogger(VmanUserRoleRelaServiceImpl.class);

	@Autowired
	private VmanUserRoleRelaMapper vmanUserRoleRelaMapper;

	@Override
	public int addEntity(VmanUserRoleRela model) throws Exception {
		try {
			log.info("addEntity");
			vmanUserRoleRelaMapper.addEntity(model);
			return 0;
		} catch(Exception e) {
			log.info("addEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int deleteEntity(VmanUserRoleRela model) throws Exception {
		try {
			log.info("deleteEntity");
			return vmanUserRoleRelaMapper.deleteEntity(model);
		} catch(Exception e) {
			log.info("deleteEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int updateEntity(VmanUserRoleRela model) throws Exception {
		try {
			log.info("updateEntity");
			vmanUserRoleRelaMapper.updateEntity(model);
			return 0;
		} catch(Exception e) {
			log.info("updateEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public VmanUserRoleRela findEntity(VmanUserRoleRela model) throws Exception {
		try {
			log.info("findEntity");
			return vmanUserRoleRelaMapper.findEntity(model);
		} catch(Exception e) {
			log.info("findEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<VmanUserRoleRela> findEntityList(VmanUserRoleRela model) throws Exception {
		try {
			log.info("findEntityList");
			return vmanUserRoleRelaMapper.findEntityList(model);
		} catch(Exception e) {
			log.info("findEntityList异常");
			e.printStackTrace();
			throw e;
		}
	}

}
