package s4.spring.td3.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import s4.spring.td3.entities.Cuser;
import s4.spring.td3.repositories.UserRepositorie;

@RestController
@RequestMapping("/rest/users/api/")
public class RestUsersRepositorie {

	@Autowired
	private UserRepositorie userrepo;
	
	@GetMapping("")
	public List<Cuser> read(){
		return userrepo.findAll();
	}
}
