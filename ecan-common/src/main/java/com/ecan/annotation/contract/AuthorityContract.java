package com.ecan.annotation.contract;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.ecan.annotation.Authority;
import com.ecan.exception.AuthorityException;

/**
 * 权限验证算法
 * @author TaneRoom
 * @since 2016年7月21日 上午10:46:34 
 * @version v1.0
 */
public class AuthorityContract {

	private static final ThreadLocal<Set<String>> roles = new ThreadLocal<Set<String>>();
    private static final ThreadLocal<Set<String>> perms = new ThreadLocal<Set<String>>();
    
    public static void set(Set<String> rs, Set<String> ps) {
        roles.set(rs);
        perms.set(ps);
    }
    
    public static Set<String> getRoles() {
        return roles.get();
    }
    
    public static Set<String> getPerms() {
        return perms.get();
    }
    
    public static void clear() {
        roles.set(null);
        perms.set(null);
    }
    
    public static void checkPermission(Authority auth) {
        if (checkRoles(auth) && checkPerms(auth)) {
            return;
        }
        
        throw new AuthorityException("访问操作拒绝!");
    }
    
    private static boolean checkRoles(Authority auth) {
        if (auth == null) {
            return true;
        }
        
        String[] roles = auth.role();
        if (roles == null || roles.length == 0) {
            return true;
        }
        List<String> list = new ArrayList<String>();
        for (String role : roles) {
            if (role != null && role.trim().length() > 0) {
                list.add(role.trim());
            }
        }
        if (list.isEmpty()) {
            return true;
        }
        
        Set<String> rs = getRoles();
        //如果角色集为空，则不允许获取权限
        if(rs == null){
        	return false;
        }
        
        if (auth.roleOr()) {
            for (String role : roles) {
                if (rs.contains(role)) {
                    return true;
                }
            }
        } else {
            for (String role : roles) {
                if (!rs.contains(role)) {
                    return false;
                }
            }
            return true;
        }
        
        return false;
    }
    
    private static boolean checkPerms(Authority auth) {
        if (auth == null) {
            return true;
        }
        
        String[] perms = auth.perm();
        if (perms == null || perms.length == 0) {
            return true;
        }
        List<String> list = new ArrayList<String>();
        for (String perm : perms) {
            if (perm != null && perm.trim().length() > 0) {
                list.add(perm.trim());
            }
        }
        if (list.isEmpty()) {
            return true;
        }
        
        Set<String> ps = getPerms();
        if (auth.permOr()) {
            for (String perm : perms) {
                if (ps.contains(perm)) {
                    return true;
                }
            }
        } else {
            for (String perm : perms) {
                if (!ps.contains(perm)) {
                    return false;
                }
            }
            return true;
        }
        
        return false;
    }
	
}
