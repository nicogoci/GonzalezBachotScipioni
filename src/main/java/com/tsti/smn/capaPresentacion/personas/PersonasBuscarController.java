package com.tsti.smn.capaPresentacion.personas;

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

import com.tsti.smn.capaServicios.CiudadService;
import com.tsti.smn.capaServicios.PersonaService;
import com.tsti.smn.pojos.Ciudad;
import com.tsti.smn.pojos.Persona;


@Controller
@RequestMapping("/personasBuscar")
public class PersonasBuscarController {
	@Autowired
    private PersonaService service;
	@Autowired
    private CiudadService serviceCiudad;
     
    @RequestMapping(method=RequestMethod.GET)
    public String preparaForm(Model modelo) {
    	PersonasBuscarForm form =  new PersonasBuscarForm();
    	form.setIdCiudadSeleccionada(1L); //Esto es por ejemplo, si quisiera setear un valor por defecto en el filtro de ciudad 
//    	 form.setCiudades(serviceCiudad.getAll());    //  en lugar de esto hacemos @ModelAttribute("allCiudades")
       modelo.addAttribute("formBean",form);
       return "personasBuscar";
    }
     
    
    @ModelAttribute("allCiudades")
    public List<Ciudad> getAllCiudades() {
        return this.serviceCiudad.getAll();
    }
    
    @RequestMapping( method=RequestMethod.POST)
    public String submit( PersonasBuscarForm formBean,BindingResult result, ModelMap modelo,@RequestParam String action) {
    	
    	
    	if(action.equals("Buscar"))
    	{
    		
    		
    		List<Persona> personas = service.filter(formBean);
    		
        	modelo.addAttribute("formBean",formBean);
        	modelo.addAttribute("resultados",personas);
        	return "personasBuscar";
    	}
    
    	
    	if(action.equals("Cancelar"))
    	{
    		modelo.clear();
    		return "redirect:/";
    	}
    	
    	if(action.equals("Registrar"))
    	{
    		modelo.clear();
    		return "redirect:/personasEditar";
    	}
    		
    	return "redirect:/";
    	
    	
    }

 
}
