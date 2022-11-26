package com.tsti.smn.capaPresentacion.clima;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.tsti.smn.capaServicios.CiudadService;
import com.tsti.smn.capaServicios.ClimaServiceImpl;
import com.tsti.smn.capaServicios.EstadoService;
import com.tsti.smn.excepciones.Excepcion;
import com.tsti.smn.pojos.Ciudad;
import com.tsti.smn.pojos.Clima;
import com.tsti.smn.pojos.Estado;

@Controller
@RequestMapping("/climaBuscar")
public class ClimaBuscarController {
	@Autowired
    private ClimaServiceImpl service;
	@Autowired
    private CiudadService serviceCiudad;
	@Autowired
    private EstadoService serviceEstado;
	
	
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
	    
	    @ModelAttribute("allEstados")
	    public List<Estado> getAllEstados() {
	        return this.serviceEstado.findAll();
	    }
	    
	    
	    @RequestMapping( method=RequestMethod.POST)
	    public String submit( @ModelAttribute("formBean") @Valid ClimaBuscarForm formBean,BindingResult result, ModelMap modelo,@RequestParam String action)  {
	    	
	    	
	    	if(action.equals("Buscar"))
	    	{
	    		if(result.hasErrors())
	    		{

	    			modelo.addAttribute("formBean",formBean);
	    			 return "climaEditar";
	    		}else {
	    		
	    		try {
	    		Clima clima = service.getClimaByCiudad(formBean.getIdCiudadSeleccionada());
	        	modelo.addAttribute("formBean",formBean);
	        	modelo.addAttribute("resultados",clima);
	        	return "climaBuscar";
	    		}catch(Excepcion e) {
	    			
	    			ObjectError error = new ObjectError("globalError", e.getMessage());
		            result.addError(error);  
		            modelo.addAttribute("formBean",formBean); 
		        	return "climaBuscar";
	    		}
	    		  
	    		}
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
	    	
	    	if(action.equals("Pronostico extendido"))
	    	{
	    		modelo.clear();
	    		return "redirect:/pronosticosBuscar";
	    	}
	    		
	    	return "redirect:/";
	    	
	    	
	    }

}
