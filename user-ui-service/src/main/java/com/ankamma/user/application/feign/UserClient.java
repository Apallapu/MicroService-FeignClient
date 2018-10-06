package com.ankamma.user.application.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ankamma.user.application.model.UserExit;
import com.ankamma.user.application.model.UserList;
import com.ankamma.user.application.model.UserRequest;
import com.ankamma.user.application.model.UserResponse;

@FeignClient("http://USERDOMAINSERVICE")
public interface UserClient {
	@PostMapping("/users")
	public UserResponse createUser(@RequestBody UserRequest UserRequest);

	@GetMapping("/user/checkUserExit")
	public UserExit checkUserExit(@RequestParam(value = "username") String username);

	@GetMapping("/user/checkEmailExit")
	public UserExit checkEmailExit(@RequestParam(value = "email") String email);

	@GetMapping(path = "/user/{username}", produces = "application/json")
	public UserList getUserNames(@PathVariable(value = "username") String username);

	@GetMapping(path = "/users", produces = "application/json")
	public List<UserList> getUserList();

}
