package s4.spring.td3.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import s4.spring.td3.entities.Cgroupe;
import s4.spring.td3.repositories.GroupRepositorie;

@RestController
@RequestMapping("/rest/groupes/api/")
public class RestGroupesController {

	@Autowired
	private GroupRepositorie groupesrepo;
	
	@GetMapping("")
	public List<Cgroupe> read(){
		return groupesrepo.findAll();
	}
}
