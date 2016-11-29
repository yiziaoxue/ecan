package com.ecan.service.impl;

import com.ecan.model.VmanOrder;
import com.ecan.mapper.VmanOrderMapper;
import com.ecan.service.VmanOrderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * mapper文件，系统自动生成
 * @author: TaneRoom
 * @since: 2016-11-29 22:20:48
 */
@Service("vmanOrderService")
public class VmanOrderServiceImpl implements VmanOrderService {

	private Logger log = Logger.getLogger(VmanOrderServiceImpl.class);

	@Autowired
	private VmanOrderMapper vmanOrderMapper;

	@Override
	public int addEntity(VmanOrder model) throws Exception {
		try {
			log.info("addEntity");
			vmanOrderMapper.addEntity(model);
			return 0;
		} catch(Exception e) {
			log.info("addEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int deleteEntity(VmanOrder model) throws Exception {
		try {
			log.info("deleteEntity");
			return vmanOrderMapper.deleteEntity(model);
		} catch(Exception e) {
			log.info("deleteEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int updateEntity(VmanOrder model) throws Exception {
		try {
			log.info("updateEntity");
			vmanOrderMapper.updateEntity(model);
			return 0;
		} catch(Exception e) {
			log.info("updateEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public VmanOrder findEntity(VmanOrder model) throws Exception {
		try {
			log.info("findEntity");
			return vmanOrderMapper.findEntity(model);
		} catch(Exception e) {
			log.info("findEntity异常");
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<VmanOrder> findEntityList(VmanOrder model) throws Exception {
		try {
			log.info("findEntityList");
			return vmanOrderMapper.findEntityList(model);
		} catch(Exception e) {
			log.info("findEntityList异常");
			e.printStackTrace();
			throw e;
		}
	}

}
