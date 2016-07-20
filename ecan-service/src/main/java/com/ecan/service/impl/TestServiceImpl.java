package com.ecan.service.impl;

import org.springframework.stereotype.Service;

import com.ecan.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService {
	
	private String service = TestServiceImpl.class.getName();
    
    /** 
     * @see com.aboy.SecurityService.test.annotation.service.AnnotationService#createService()
     */
    public void createService(String service) {
        this.service = service;
    }
    
    /** 
     * @return
     * @see com.aboy.SecurityService.test.annotation.service.AnnotationService#getService()
     */
    public String getService() {
        return this.service;
    }
    
    /** 
     * @return
     * @see com.aboy.SecurityService.test.annotation.service.AnnotationService#getServiceName()
     */
    public String getServiceName() {
        return "ServiceName";
    }
    
    public static void main(String[] args) {
		TestServiceImpl test = new TestServiceImpl();
		System.out.println(test.getService());
	}
    
}
