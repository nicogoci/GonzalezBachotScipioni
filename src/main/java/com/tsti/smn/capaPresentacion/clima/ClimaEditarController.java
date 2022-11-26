package com.tsti.smn.capaPresentacion.clima;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
import com.tsti.smn.capaServicios.ClimaService;
import com.tsti.smn.capaServicios.EstadoService;
import com.tsti.smn.pojos.Ciudad;
import com.tsti.smn.pojos.Clima;
import com.tsti.smn.pojos.Estado;
@Controller
@RequestMapping("/climaEditar")
public class ClimaEditarController {

	@Autowired
    private ClimaService service;
	@Autowired
	private CiudadService serviceCiudad;
	@Autowired
	private EstadoService serviceEstado; 
	
	
	@RequestMapping(path = {"", "/{id}"},method=RequestMethod.GET)
    public String preparaForm(Model modelo, @PathVariable("id") Optional<Long> idClima) throws Exception {
    	if (idClima.isPresent()) {
    		Clima entity = service.getClimaById(idClima.get());
    		ClimaForm form = new ClimaForm(entity);
			modelo.addAttribute("formBean", form);
		} else {
 
	       modelo.addAttribute("formBean",new ClimaForm());
		}
       return "climaUpdate";
    }
	
	 @ModelAttribute("allCiudades")
	    public List<Ciudad> getAllCiudades() {
	        return this.serviceCiudad.getAll();
	    }
	    
	    @ModelAttribute("allEstados")
	    public List<Estado> getAllEstados() {
	        return this.serviceEstado.findAll();
	    }
	    
	   // @ModelAttribute("ciudad")
	   // public Ciudad ciudad(Long id) {
	     //   return this.serviceCiudad.getById(id);
	    //}
	    	
 
    @RequestMapping( method=RequestMethod.POST)
    public String submit(@ModelAttribute("formBean") @Valid ClimaForm formBean,BindingResult result, ModelMap modelo,@RequestParam String action) throws Exception {
    	
    	
    	if(action.equals("Aceptar"))
    	{
    	
    		if(result.hasErrors())
    		{	
                
    			modelo.addAttribute("formBean",formBean);
    			 return "climaEditar";
    		}
    		else
    		{
    			Clima c=formBean.toPojo();
    			c.setCiudad(serviceCiudad.getById(formBean.getIdCiudad()));
    			c.setEstado(serviceEstado.getById(formBean.getEstado()));
    			service.saveOrUpdate(c);
    			
    			return "redirect:/climaBuscar";
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
