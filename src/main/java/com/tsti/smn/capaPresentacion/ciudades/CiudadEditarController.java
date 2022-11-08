package com.tsti.smn.capaPresentacion.ciudades;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tsti.smn.capaServicios.CiudadService;
import com.tsti.smn.capaServicios.ProvinciaService;
import com.tsti.smn.pojos.Ciudad;
import com.tsti.smn.pojos.Provincia;


@Controller
@RequestMapping("/ciudadEditar")
public class CiudadEditarController {
	@Autowired
    private CiudadService servicioCiudad;
	@Autowired
    private ProvinciaService servicioProvincia;
     
    @RequestMapping(path = {"", "/{id}"},method=RequestMethod.GET)
    public String preparaForm(Model modelo, @PathVariable("id") Optional<Long> dni) throws Exception {
    	if (dni.isPresent()) {
    		Ciudad entity = servicioCiudad.getById(dni.get());
    		CiudadForm form = new CiudadForm(entity);
			modelo.addAttribute("formBean", form);
		} else {
 
	       modelo.addAttribute("formBean",new CiudadForm());
		}
       return "ciudadEditar";
    }
     
    @ModelAttribute("allProvincias")
    public List<Provincia> getAllProvincias() {
        return this.servicioProvincia.getAll();
    }
	
	@RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
	public String deleteById(Model model, @PathVariable("id") Long id) 
	{
		servicioCiudad.deleteByid(id);
		return "redirect:/ciudadesBuscar";
	}
 
    
    @RequestMapping( method=RequestMethod.POST)
    public String submit(@ModelAttribute("formBean") /*@Valid*/  CiudadForm formBean,BindingResult result, ModelMap modelo,@RequestParam String action) {
    	
    	
    	if(action.equals("Aceptar"))
    	{
    		//FieldError error = new FieldError("formBean","fechaNacimiento","la fecha de nacimiento es incorrecta.");
            //result.addError(error);
//    		ObjectError error = new ObjectError("globalError", "no puede guardar aún");
//            result.addError(error);
//            
    		if(result.hasErrors())
    		{
    			
                
    			modelo.addAttribute("formBean",formBean);
    			 return "ciudadEditar";
    		}
    		else
    		{
    			Ciudad p=formBean.toPojo();
    			p.setProvincia(servicioProvincia.getById(formBean.getIdProvincia()));
    			servicioCiudad.save(p);
    			
    			return "redirect:/ciudadesBuscar";
    		}

    		
        	
        	
    	}
    
    	
    	if(action.equals("Cancelar"))
    	{
    		modelo.clear();
    		return "redirect:/ciudadesBuscar";
    	}
    		
    	return "redirect:/";
    	
    	
    }

 
}
