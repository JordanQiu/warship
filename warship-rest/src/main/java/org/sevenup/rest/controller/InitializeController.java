package org.sevenup.rest.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sevenup.domain.memo.Memo;
import org.sevenup.domain.user.User;
import org.sevenup.service.memo.MemoService;
import org.sevenup.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/initialize")
@Produces(MediaType.APPLICATION_JSON)
public class InitializeController {
	@Autowired
    private UserService userService;
	@Autowired
    private MemoService memoService;
	@RequestMapping(method = RequestMethod.GET, value = "/user")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<List<User>> initialUser() {
		List<User> users = new ArrayList<User>();
		for(int i=0;i<15;i++){
			User temp = new User();
			temp.setUid("uid"+i);
			temp.setAlt("Alt-"+i);
			temp.setAvatar("avatar-"+i);
			temp.setCreatedTime(new Date());
			temp.setDescription("description-"+i);
			temp.setName("name-"+i);
			users.add(temp);
		}
		users = userService.saveUsers(users);
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/memo")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<List<Memo>> initialMemo() {
		List<Memo> memos = new ArrayList<Memo>();
		for(int i=0;i<15;i++){
			Memo temp = new Memo();
			temp.setCreatedTime(new Date());
			temp.setMemoId("Memo--"+i);
			temp.setTitle("title--"+i);
			memos.add(temp);
		}
		memos = memoService.saveMemos(memos);
		return new ResponseEntity<List<Memo>>(memos,HttpStatus.OK);
	}
}
