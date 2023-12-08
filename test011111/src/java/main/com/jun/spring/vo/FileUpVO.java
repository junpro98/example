package com.jun.spring.vo;

import org.springframework.web.multipart.MultipartFile;

public class FileUpVO {
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	private MultipartFile file;
}
