package com.huflit.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huflit.dto.LoginDto;
import com.huflit.dto.LoginRtnDto;
import com.huflit.dto.RegisterDto;
import com.huflit.dto.RoleDto;
import com.huflit.dto.UserDto;
import com.huflit.dto.UserPackageDto;
import com.huflit.service.AuthService;
import com.huflit.service.RoleService;
import com.huflit.service.UserService;

@RestController
@RequestMapping("api/admin/login")
@CrossOrigin("*")
public class AdminAuthController {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;

	@PostMapping("")
	public Object post(@RequestBody LoginDto loginDto) {
		try {
			String token = authService.login(loginDto);
			UserPackageDto user = userService.findByEmail(loginDto.getEmail());
			
			LoginRtnDto rtnDto = new LoginRtnDto(token, user);
			return new ResponseEntity<Object>(rtnDto, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}
	
//	@GetMapping("/createAdmin")
//	public Object createAdmin() {
//		try {
//			RegisterDto dto = new RegisterDto("admin@gmail.com", "Đinh Tiến Đạt", "123456", "0927269501");
//			userService.addAdmin(dto);
//			return new ResponseEntity<Object>(HttpStatus.OK);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
//	}
//	
//	@GetMapping("/createAllRoles")
//	public Object createRole() {
//		try {
//			RoleDto roleDto = new RoleDto("Admin", "ROLE_ADMIN");
//			roleService.add(roleDto);
//			roleDto = new RoleDto("Moderator", "ROLE_MOD");
//			roleService.add(roleDto);
//			roleDto = new RoleDto("User", "ROLE_USER");
//			roleService.add(roleDto);
//			return new ResponseEntity<Object>(HttpStatus.OK);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
//	}
}
