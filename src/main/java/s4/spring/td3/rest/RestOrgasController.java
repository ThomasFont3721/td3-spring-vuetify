package s4.spring.td3.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import s4.spring.td3.entities.Corganization;
import s4.spring.td3.repositories.OrgasRepositorie;

@RestController
@RequestMapping("/rest/orgas/api/")
public class RestOrgasController {

	@Autowired
	private OrgasRepositorie orgarepo;
	
	
	@GetMapping("")
	public List<Corganization> read(){
		return orgarepo.findAll();
	}
	
	@GetMapping("{id}")
	public @ResponseBody Corganization read(@PathVariable String id){
		Optional<Corganization> org =orgarepo.findById(Long.parseLong(id));
		if (org.isPresent()) {
			return org.get();
		}
		return null;
	}
	
	@PostMapping("create")
	public @ResponseBody Corganization create(@RequestBody Corganization orga){
		orgarepo.save(orga);
		return orga;
	}
	
	@PutMapping("update")
	public @ResponseBody Corganization update(@RequestBody Corganization orga) {
		orgarepo.save(orga);
		return orga;
	}
	
	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable String id) {
		orgarepo.deleteById(Long.parseLong(id));
	}
	
	@GetMapping("membre/{member}/{id}")
	public @ResponseBody Object member(@PathVariable String member, @PathVariable String id) {
		Optional<Corganization> org =orgarepo.findById(Long.parseLong(id));
		if (org.isPresent()) {
			Corganization orga =org.get();
			 switch (member) {
				case "groupes":
					return orga.getGroupes();
				case "users":
						return orga.getUsers();
				default:
					return "Member not found";
			 }
		}
		return "Organisation not found";
	}
}
