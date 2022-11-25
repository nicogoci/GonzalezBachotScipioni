package com.tsti.smn.capaPresentacion.pronostico;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
import com.tsti.smn.capaServicios.PronosticoService;
import com.tsti.smn.pojos.Ciudad;
import com.tsti.smn.pojos.Pronostico;

@Controller
@RequestMapping("/pronosticoEditar")
public class PronosticosEditarController {
	@Autowired
    private PronosticoService service;
	@Autowired
    private CiudadService serviceCiudad;
     
    @RequestMapping(path = {"", "/{idPronostico}"},method=RequestMethod.GET)
    public String preparaForm(Model modelo, @PathVariable("idPronostico") Optional<Long> idPronostico) {
    	if (idPronostico.isPresent()) {
    		Pronostico entity = service.getById(idPronostico.get());
    		PronosticoForm form = new PronosticoForm(entity);
			modelo.addAttribute("formBean", form);
		} else {
 
	       modelo.addAttribute("formBean",new PronosticoForm());
		}
       return "pronosticoEditar";
    }
     
    @ModelAttribute("allCiudades")
    public List<Ciudad> getAllCiudades() {
        return this.serviceCiudad.getAll();
    }
	
    
    @RequestMapping( method=RequestMethod.POST)
    public String submit(@ModelAttribute("formBean") @Valid  PronosticoForm formBean,BindingResult result, ModelMap modelo,@RequestParam String action) {
    	
    	
    	if(action.equals("Aceptar"))
    	{
    		Pronostico pronostico = service.findByCiudadIdAndFechaPronostico(formBean.getIdCiudad(), formBean.getFechaPronostico());
    		if(pronostico!=null) {
    			ObjectError error = new ObjectError("globalError", "Ya existe un pronostico para esta fecha y ciudad");
    			result.addError(error);
    		}
    		if(result.hasErrors())
    		{
    			modelo.addAttribute("formBean",formBean);
    			return "pronosticoEditar";
    		}else
    		{
    			Pronostico p=formBean.toPojo();
    			p.setCiudad(serviceCiudad.getById(formBean.getIdCiudad()));
    			service.save(p);
    			
    			return "redirect:/pronosticoEditar";
    		}
        	
    	}
    
    	
    	if(action.equals("Cancelar"))
    	{
    		modelo.clear();
    		return "redirect:/";
    	}
    		
    	return "redirect:/";
    	
    	
    }
}
