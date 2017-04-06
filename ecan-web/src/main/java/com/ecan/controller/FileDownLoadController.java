package com.ecan.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecan.service.business.impl.FileLoadServiceImple;

@RestController
@RequestMapping("/")
public class FileDownLoadController {

	@Autowired
	private FileLoadServiceImple fleLoadServiceImple;
	
	@RequestMapping(value="/file",method=RequestMethod.GET)
	public void downLoadFile(HttpServletResponse response){
		fleLoadServiceImple.fileDownLoad(response);
	}
}
