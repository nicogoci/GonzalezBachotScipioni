package com.tsti.smn.capaPresentacion.clima;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tsti.smn.capaPresentacion.pronostico.PronosticosBuscarForm;
import com.tsti.smn.capaServicios.CiudadService;
import com.tsti.smn.capaServicios.ClimaServiceImpl;
import com.tsti.smn.capaServicios.PronosticoService;
import com.tsti.smn.pojos.Ciudad;
import com.tsti.smn.pojos.Clima;
import com.tsti.smn.pojos.Pronostico;

@Controller
@RequestMapping("/climaBuscar")
public class ClimaBuscarController {
	@Autowired
    private ClimaServiceImpl service;
	@Autowired
    private CiudadService serviceCiudad;
	
	 @RequestMapping(method=RequestMethod.GET)
	    public String preparaForm(Model modelo) {
	    	ClimaBuscarForm form =  new ClimaBuscarForm();
	    	modelo.addAttribute("formBean",form);
	    	return "climaBuscar";
	    }
	     
	    
	    @ModelAttribute("allCiudades")
	    public List<Ciudad> getAllCiudades() {
	        return this.serviceCiudad.getAll();
	    }
	    
	    @RequestMapping( method=RequestMethod.POST)
	    public String submit( ClimaBuscarForm formBean,BindingResult result, ModelMap modelo,@RequestParam String action) {
	    	
	 
	    	if(action.equals("Buscar"))
	    	{
	    		Clima clima = service.clima(formBean);
	        	modelo.addAttribute("formBean",formBean);
	        	modelo.addAttribute("resultados",clima);
	        	return "climaBuscar";
	    	}
	    
	    	
	    	if(action.equals("Cancelar"))
	    	{
	    		modelo.clear();
	    		return "redirect:/";
	    	}
	    	
	    	if(action.equals("Registrar"))
	    	{
	    		modelo.clear();
	    		return "redirect:/climaEditar";
	    	}
	    		
	    	return "redirect:/";
	    	
	    	
	    }

}
