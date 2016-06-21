package com.ecan.mapper;

import java.util.List;

import com.ecan.model.User;

/**
 * @Description 测试一下
 * @author TaneRoom
 * @date 2016年6月21日 下午2:42:50 
 * @version v1.0
 */
public interface UserMapper {
	
    public List<User> findUserInfo();
    
}
