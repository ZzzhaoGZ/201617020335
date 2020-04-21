package com.am.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.am.pojo.LoginVO;
import com.am.pojo.TUser;
import com.am.service.ImageService;
import com.am.service.UserService;
import com.am.util.AMResult;
import com.am.util.CheckBoxVO;
import com.am.util.EasyUIResult;
import com.am.util.StaticKey;

@Controller
public class UserController {

	/**
	 * 用于处理Date类型参数处理
	 * 
	 * @return
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));

	}

	@Autowired
	private UserService userService;
	@Autowired
	private ImageService imageService;

	@RequestMapping("/user/userlogin")
	@ResponseBody
	public AMResult login(LoginVO login, HttpServletRequest request) {
		AMResult result = new AMResult();
		try {
			result = userService.login(login, request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping("/user/register")
	@ResponseBody
	public AMResult register(TUser tUser) {
		AMResult result = new AMResult();
		try {
			tUser.setCreatetime(new Date());
			result = userService.register(tUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping(value = "/user/getimage")
	public void getImage(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// 禁止图像缓存。
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		response.setContentType("image/jpeg");
		// 将图像输出到Servlet输出流中。
		ServletOutputStream sos = response.getOutputStream();
		ImageIO.write(imageService.getImage(request), "jpeg", sos);
		sos.close();
	}

	@RequestMapping("/user/updatepd")
	@ResponseBody
	public AMResult register(String newuserloginpasswd,
			HttpServletRequest request) {
		AMResult result = new AMResult();
		try {
			TUser user = (TUser) request.getSession().getAttribute(
					StaticKey.LOGIN_USER);
			if (user == null) {
				return AMResult.build(201, "session没有登录用户");
			}
			if (newuserloginpasswd == null || "".endsWith(newuserloginpasswd)) {
				return AMResult.build(202, "新密码不能为空");
			}
			user.setUserloginpasswd(newuserloginpasswd);
			result = userService.updatePd(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping("/user/getusers")
	@ResponseBody
	public EasyUIResult getUsers(TUser tUser) {
		EasyUIResult result = userService.getUsers(tUser);
		return result;
	}

	@RequestMapping("/user/adduser")
	@ResponseBody
	public AMResult addUser(TUser tUser) {
		return userService.addUser(tUser);
	}

	@RequestMapping("/user/updateuser")
	@ResponseBody
	public AMResult updateUser(TUser tUser) {
		return userService.updateUser(tUser);
	}

	@RequestMapping("/user/deleteuser")
	@ResponseBody
	public AMResult updateUser(Integer userid) {
		return userService.deleteUser(userid);
	}

	@RequestMapping("/user/getUserCheckBoxData")
	@ResponseBody
	public List<CheckBoxVO> getUserCheckBoxData() {

		List<CheckBoxVO> checkList = new ArrayList<CheckBoxVO>();
		EasyUIResult result = userService.getUsers(null);
		List<TUser> list = (List<TUser>) result.getRows();
		if (list != null && list.size() > 0) {
			for (TUser tUser : list) {
				CheckBoxVO vo = new CheckBoxVO();
				vo.setId(String.valueOf(tUser.getUserid()));
				vo.setText(tUser.getUserloginid());
				checkList.add(vo);
			}
		}
		return checkList;

	}
}