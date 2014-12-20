package org.sevenup.rest.controller.user;

import java.util.List;
import java.util.UUID;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sevenup.domain.user.User;
import org.sevenup.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserController {
    private final UserService userService;
    
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<List<User>> getUsers() {
		List<User> userList =  userService.findUsers();
		return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<User> viewUser(@PathVariable String id) {
		User user = userService.findUserById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user,UriComponentsBuilder builder) {
		UUID idKey = UUID.randomUUID();
		userService.saveUser(user);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/user/{id}").buildAndExpand(idKey.toString()).toUri());
		return new ResponseEntity<User>(user, headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		UUID idKey = UUID.randomUUID();
		userService.saveUser(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable String id) {
		UUID idKey = UUID.randomUUID();
		userService.deleteUser(id);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "signIn")
	@ResponseBody
	public boolean signIn(@RequestBody User User) {
		return true;
	}

	@RequestMapping(method = RequestMethod.POST, value = "signUp")
	public ResponseEntity<User> signUp(@RequestBody User User) {
		return new ResponseEntity<User>(User, HttpStatus.OK);
	}
}
