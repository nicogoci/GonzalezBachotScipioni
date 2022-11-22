package com.tsti.smn.capaPresentacion.clima;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tsti.smn.capaPresentacion.personas.PersonaForm;
import com.tsti.smn.capaServicios.CiudadService;
import com.tsti.smn.capaServicios.ClimaService;
import com.tsti.smn.capaServicios.PersonaService;
import com.tsti.smn.pojos.Ciudad;
import com.tsti.smn.pojos.Clima;
import com.tsti.smn.pojos.Persona;

@Controller
@RequestMapping("/climaEditar")
public class ClimaEditarController {

	@Autowired
    private ClimaService service;
	@Autowired
    private CiudadService serviceCiudad;
     
 
    @RequestMapping( method=RequestMethod.POST)
    public String submit(@ModelAttribute("formBean")  ClimaForm formBean,BindingResult result, ModelMap modelo,@RequestParam String action) {
    	
    	
    	if(action.equals("Aceptar"))
    	{
    	
    		if(result.hasErrors())
    		{
    			
                
    			modelo.addAttribute("formBean",formBean);
    			 return "personasEditar";
    		}
    		else
    		{
    			Clima c=formBean.toPojo();
    			c.setCiudad(serviceCiudad.getById(formBean.getIdCiudad()));
    			service.save(c);
    			
    			return "redirect:/personasBuscar";
    		}
		
    	}
    
    	
    	if(action.equals("Cancelar"))
    	{
    		modelo.clear();
    		return "redirect:/personasBuscar";
    	}
    		
    	return "redirect:/";
    	
    	
    }
}
