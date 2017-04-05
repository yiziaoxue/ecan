package com.ecan.service.business.impl;

import com.ecan.service.business.FileLoadService;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

@Service
public class FileLoadServiceImple implements FileLoadService{
	public final static String separator = System.getProperties().getProperty("file.separator");
	public final static String systempath = System.getProperty("user.dir");

	@Override
	public void fileDownLoad(HttpServletResponse response) {
		System.out.println(new Date()+"  开始进入ftpDownload定时器");
        
		try {  
            String filePath = "/data/android.apk";// 文件路径  
            String [] fp =   filePath.split("/");  
            String fileName = fp[fp.length-1];// 文件名称  
            System.out.println("-------------------------------上传文件名为="+fileName);  
              
            //下载机器码文件  
            response.setHeader("conent-type", "application/octet-stream");  
            response.setContentType("application/octet-stream");  
            response.setHeader("Content-Disposition", "attachment; filename=" + new String(fileName.getBytes("ISO-8859-1"), "UTF-8"));  
              
            OutputStream os = response.getOutputStream();  
            BufferedOutputStream bos = new BufferedOutputStream(os);  
              
            InputStream is = null;  
  
            is = new FileInputStream(filePath);  
            BufferedInputStream bis = new BufferedInputStream(is);  
  
            int length = 0;  
            byte[] temp = new byte[1 * 1024 * 10];  
  
            while ((length = bis.read(temp)) != -1) {  
                bos.write(temp, 0, length);  
            }  
            bos.flush();  
            bis.close();  
            bos.close();  
            is.close();           
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
	}
}
