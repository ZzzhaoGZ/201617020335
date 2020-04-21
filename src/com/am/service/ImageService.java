package com.am.service;

import java.awt.image.BufferedImage;

import javax.servlet.http.HttpServletRequest;

public interface ImageService {
	
	public BufferedImage getImage(HttpServletRequest request, int width_,
			int height_, int fontSize_, int codeLength_);
	
	public BufferedImage getImage(HttpServletRequest request);

}
