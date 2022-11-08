package com.tsti.smn.capaPresentacion.ciudades;

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
import com.tsti.smn.capaServicios.ProvinciaService;
import com.tsti.smn.pojos.Ciudad;
import com.tsti.smn.pojos.Provincia;


@Controller
@RequestMapping("/ciudadesBuscar")
public class CiudadesBuscarController {
	@Autowired
    private ProvinciaService servicioProvincia;
   
	@Autowired
    private CiudadService servicioCiudad;
   
	
    @RequestMapping(method=RequestMethod.GET)
    public String preparaForm(Model modelo) {
    	CiudadesBuscarForm form =  new CiudadesBuscarForm();
//    	 form.setProvincias(servicioProvincia.getAll());    //  en lugar de esto hacemos @ModelAttribute("allProvincias")
       modelo.addAttribute("formBean",form);
       return "ciudadesBuscar";
    }
     
    
    @ModelAttribute("allProvincias")
    public List<Provincia> getAllProvincias() {
        return this.servicioProvincia.getAll();
    }
    
    @RequestMapping( method=RequestMethod.POST)
    public String submit( CiudadesBuscarForm formBean,BindingResult result, ModelMap modelo,@RequestParam String action) {
    	
    	
    	if(action.equals("Buscar"))
    	{
    		
    		
    		List<Ciudad> ciudades = servicioCiudad.filter(formBean);
    		
        	modelo.addAttribute("formBean",formBean);
        	modelo.addAttribute("resultados",ciudades);
        	return "ciudadesBuscar";
    	}
    
    	
    	if(action.equals("Cancelar"))
    	{
    		modelo.clear();
    		return "redirect:/";
    	}
    	
    	if(action.equals("Registrar"))
    	{
    		modelo.clear();
    		return "redirect:/ciudadEditar";
    	}
    		
    	return "redirect:/";
    	
    	
    }

 
}
