package com.ecan.service.impl;

import com.ecan.model.YqUsers;
import com.ecan.mapper.YqUsersMapper;
import com.ecan.service.YqUsersService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("yqUsersService")
public class YqUsersServiceImpl implements YqUsersService {

	private Logger log = Logger.getLogger(YqUsersServiceImpl.class);

	@Autowired
	private YqUsersMapper yqUsersMapper;

	@Override
	public int addEntity(YqUsers model) throws Exception {
		try {
			log.info("addEntity");
			yqUsersMapper.addEntity(model);
			return 0;
		} catch(Exception e) {
			log.info("addEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int deleteEntity(YqUsers model) throws Exception {
		try {
			log.info("deleteEntity");
			return yqUsersMapper.deleteEntity(model);
		} catch(Exception e) {
			log.info("deleteEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int updateEntity(YqUsers model) throws Exception {
		try {
			log.info("updateEntity");
			yqUsersMapper.updateEntity(model);
			return 0;
		} catch(Exception e) {
			log.info("updateEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public YqUsers findEntity(YqUsers model) throws Exception {
		try {
			log.info("findEntity");
			return yqUsersMapper.findEntity(model);
		} catch(Exception e) {
			log.info("findEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<YqUsers> findEntityList(YqUsers model) throws Exception {
		try {
			log.info("findEntityList");
			return yqUsersMapper.findEntityList(model);
		} catch(Exception e) {
			log.info("findEntityList异常");
			e.printStackTrace();
			throw e;
		}
	}

}
