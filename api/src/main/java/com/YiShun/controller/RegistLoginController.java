package com.YiShun.controller;

import com.YiShun.pojo.Users;
import com.YiShun.pojo.vo.UsersVO;
import com.YiShun.service.UserService;
import com.YiShun.utils.JSONResult;
import com.YiShun.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Api(value = "用户注册登录的借口", tags = {"注册和登录的controller"})
public class RegistLoginController extends BasicController {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "用户注册", notes = "用户注册的借口")
	@PostMapping("/regist")
	public JSONResult regist(@RequestBody Users user) throws Exception {

		// 1.判断用户名和密码不为空
		if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
			return JSONResult.errorMsg("用户名和密码不能为空！");
		}

		// 2.判断用户名是否存在
		boolean usernameIsExist = userService.queryUsernameIsExist(user.getUsername());

		// 3.保存用户的注册信息
		if (!usernameIsExist) {
			user.setNickname(user.getUsername());
			user.setPassword(MD5Utils.getMD5Str(user.getPassword()));
			user.setFansCounts(0);
			user.setReceiveLikeCounts(0);
			user.setFollowCounts(0);
			userService.saveUser(user);
		} else {
			return JSONResult.errorMsg("用户名已存在！");
		}

		user.setPassword("");

//		String uniqueToken = UUID.randomUUID().toString();
//		redis.set(USER_REDIS_SESSION + ":" + user.getId(), uniqueToken, 1000 * 60 * 30);
//
//		UsersVO userVO = new UsersVO();
//		BeanUtils.copyProperties(user, userVO);
//		userVO.setUserToken(uniqueToken);
// 		写到一个方法里


		UsersVO userVO = setUserRedisSessionToken(user);

		return JSONResult.ok(userVO);
	}

	public UsersVO setUserRedisSessionToken(Users userModel) {
		String uniqueToken = UUID.randomUUID().toString();
		redis.set(USER_REDIS_SESSION + ":" + userModel.getId(), uniqueToken, 1000 * 60 * 30);

		UsersVO userVO = new UsersVO();
		BeanUtils.copyProperties(userModel, userVO);
		userVO.setUserToken(uniqueToken);
		return userVO;
	}

	@ApiOperation(value = "用户登录", notes = "用户登录的接口")
	@PostMapping("/login")
	public JSONResult login(@RequestBody Users user) throws Exception {
		String username = user.getUsername();
		String password = user.getPassword();

		// 1.判断用户名和密码必须不为空
		if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
			return JSONResult.ok("用户名和密码不能为空！");
		}

		// 2.判断用户是否存在
		Users userResult = userService.queryUserForLogin(username,MD5Utils.getMD5Str(user.getPassword()));

		// 3.返回
		if (userResult != null) {
			userResult.setPassword("");
			UsersVO userVO = setUserRedisSessionToken(userResult);
			return JSONResult.ok(userVO);
		} else {
			return JSONResult.errorMsg("用户名或密码不正确！");
		}

	}

	@ApiOperation(value = "用户注销", notes = "用户注销的接口")
	@ApiImplicitParam(name = "userId", value = "用户Id", required = true, dataType = "String", paramType = "query")
	@PostMapping("/logout")
	public JSONResult logout(String userId) throws Exception {
		redis.del(USER_REDIS_SESSION + ":" + userId	);
		return JSONResult.ok();
	}

}
