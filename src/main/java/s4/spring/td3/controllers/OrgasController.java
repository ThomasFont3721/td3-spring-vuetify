package s4.spring.td3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.jeemv.springboot.vuejs.VueJS;
import io.github.jeemv.springboot.vuejs.utilities.Http;
import s4.spring.td3.repositories.OrgasRepositorie;

@Controller
@RequestMapping("/rest/orgas/")
public class OrgasController {

	@Autowired
	private OrgasRepositorie orgarepo;

	@Autowired
	private VueJS vue;
	
	@GetMapping("")
	public String read(ModelMap model){
		vue.addData("items", orgarepo.findAll());
		vue.addMethod("loadGroupes", "let self=this;"+Http.get("/rest/groupes/api/", "self.items=response.data;"));
		vue.addMethod("loadOrgas", "let self=this;"+Http.get("/rest/orgas/api/", "self.items=response.data;"));
		vue.addMethod("loadUsers", "let self=this;"+Http.get("/rest/users/api/", "self.items=response.data;"));
		model.put("vue", vue);
		return "spa";
	}
	
	@GetMapping("read")
	public String readd(ModelMap map) {
		map.put("message", "Hello there");
		return "index";
	}
	
	@GetMapping("read/{message}")
	public String readId(@PathVariable String message, ModelMap model) {
		vue.addData("message", "1");
		vue.addMethod("increment", "this.message=parseInt(this.message)+10");
		model.put("vue", vue);
		return "index";
	}

}
