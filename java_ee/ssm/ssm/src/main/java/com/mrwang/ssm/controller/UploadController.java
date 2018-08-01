package com.mrwang.ssm.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.mrwang.ssm.utils.Commons;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

@Controller
@RequestMapping("upload")
public class UploadController {

	@RequestMapping("uploadPic")
	public void uploadPic(HttpServletRequest request, String fileName, PrintWriter out) {
		MultipartHttpServletRequest mh = (MultipartHttpServletRequest) request;
		CommonsMultipartFile cm = (CommonsMultipartFile) mh.getFile(fileName);
		byte[] fbytes = cm.getBytes();

		String newFileName = "";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		newFileName = simpleDateFormat.format(new Date());

		Random random = new Random();
		for (int i = 0; i < 3; i++) {
			newFileName = newFileName + random.nextInt(10);
		}

		String originalFilename = cm.getOriginalFilename();
		String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

		Client client = Client.create();
		WebResource webResource = client.resource(Commons.PIC_HOST + "/upload/" + newFileName + suffix);

		webResource.put(String.class, fbytes);

		String fullPath = Commons.PIC_HOST + "/upload/" + newFileName + suffix;
		String relativePath = "/upload/" + newFileName + suffix;

		String result = "{\"fullPath\":\"" + fullPath + "\",\"relativePath\":\"" + relativePath + "\"}";
		out.print(result);
	}
}
