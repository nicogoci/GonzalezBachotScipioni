package com.tsti.smn.capaPresentacion.personas;

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

import com.tsti.smn.capaServicios.CiudadService;
import com.tsti.smn.capaServicios.PersonaService;
import com.tsti.smn.pojos.Ciudad;
import com.tsti.smn.pojos.Persona;


@Controller
@RequestMapping("/personasEditar")
public class PersonasEditarController {
	@Autowired
    private PersonaService service;
	@Autowired
    private CiudadService serviceCiudad;
     
    @RequestMapping(path = {"", "/{id}"},method=RequestMethod.GET)
    public String preparaForm(Model modelo, @PathVariable("id") Optional<Long> dni) throws Exception {
    	if (dni.isPresent()) {
    		Persona entity = service.getPersonaById(dni.get());
    		PersonaForm form = new PersonaForm(entity);
			modelo.addAttribute("formBean", form);
		} else {
 
	       modelo.addAttribute("formBean",new PersonaForm());
		}
       return "personasEditar";
    }
     
    @ModelAttribute("allCiudades")
    public List<Ciudad> getAllCiudades() {
        return this.serviceCiudad.getAll();
    }
	
	@RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
	public String deletePersonaById(Model model, @PathVariable("id") Long id) 
	{
		service.deletePersonaByid(id);
		return "redirect:/personasBuscar";
	}
 
    
    @RequestMapping( method=RequestMethod.POST)
    public String submit(@ModelAttribute("formBean") /*@Valid*/  PersonaForm formBean,BindingResult result, ModelMap modelo,@RequestParam String action) {
    	
    	
    	if(action.equals("Aceptar"))
    	{
    		//FieldError error = new FieldError("formBean","fechaNacimiento","la fecha de nacimiento es incorrecta.");
            //result.addError(error);
//    		ObjectError error = new ObjectError("globalError", "no puede guardar aún");
//            result.addError(error);
            
    		if(result.hasErrors())
    		{
    			
                
    			modelo.addAttribute("formBean",formBean);
    			 return "personasEditar";
    		}
    		else
    		{
    			Persona p=formBean.toPojo();
    			p.setCiudad(serviceCiudad.getById(formBean.getIdCiudad()));
    			service.save(p);
    			
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
