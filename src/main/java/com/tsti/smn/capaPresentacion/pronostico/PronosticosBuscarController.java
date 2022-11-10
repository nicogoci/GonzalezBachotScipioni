package com.tsti.smn.capaPresentacion.pronostico;

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
import com.tsti.smn.capaServicios.PronosticoService;
import com.tsti.smn.pojos.Ciudad;
import com.tsti.smn.pojos.Pronostico;

@Controller
@RequestMapping("/pronosticosBuscar")
public class PronosticosBuscarController {
	@Autowired
    private PronosticoService service;
	@Autowired
    private CiudadService serviceCiudad;
     
    @RequestMapping(method=RequestMethod.GET)
    public String preparaForm(Model modelo) {
    	PronosticosBuscarForm form =  new PronosticosBuscarForm();
    	form.setIdCiudadSeleccionada(1L); 
       modelo.addAttribute("formBean",form);
       return "pronosticosBuscar";
    }
     
    
    @ModelAttribute("allCiudades")
    public List<Ciudad> getAllCiudades() {
        return this.serviceCiudad.getAll();
    }
    
    @RequestMapping( method=RequestMethod.POST)
    public String submit( PronosticosBuscarForm formBean,BindingResult result, ModelMap modelo,@RequestParam String action) {
    	
    	
    	if(action.equals("Buscar"))
    	{
    		
    		
    		List<Pronostico> pronosticos = service.filter(formBean);
    		
        	modelo.addAttribute("formBean",formBean);
        	modelo.addAttribute("resultados",pronosticos);
        	return "pronosticosBuscar";
    	}
    
    	
    	if(action.equals("Cancelar"))
    	{
    		modelo.clear();
    		return "redirect:/";
    	}
    	
    	if(action.equals("Registrar"))
    	{
    		modelo.clear();
    		return "redirect:/pronosticosEditar";
    	}
    		
    	return "redirect:/";
    	
    	
    }

 
}
