package com.tsti.smn.capaPresentacion.alerta;



import java.time.LocalDate;
import java.time.ZoneId;

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


import com.tsti.smn.capaServicios.AlertaService;
import com.tsti.smn.capaServicios.CiudadService;
import com.tsti.smn.capaServicios.PersonaService;
import com.tsti.smn.pojos.Alerta;
import com.tsti.smn.pojos.Ciudad;
import com.tsti.smn.pojos.Persona;

@Controller
@RequestMapping("/alertaMetereologica")
public class AlertaRegistrarController {

			@Autowired
		    private AlertaService servicioAlerta;
			@Autowired
		    private CiudadService serviceCiudad;
			@Autowired
		    private PersonaService servicePersona;
			
		    @ModelAttribute("allCiudades")
		    public List<Ciudad> getAllCiudades() {
		        return this.serviceCiudad.getAll();
		    }
			
		    @RequestMapping(path = {"", "/{idAlerta}"},method=RequestMethod.GET)
		    public String preparaForm(Model modelo, @PathVariable("idAlerta") Optional<Long> idAlerta) throws Exception {
		    	if (idAlerta.isPresent()) {
		    		Alerta entity = servicioAlerta.getById(idAlerta.get());
		    		AlertaForm form = new AlertaForm(entity);
					modelo.addAttribute("formBean", form);
				} else {
		 
			       modelo.addAttribute("formBean",new AlertaForm());
				}
		       return "alertaMetereologica";
		    }
		     

		    @RequestMapping( method=RequestMethod.POST)
		    public String submit(@ModelAttribute("formBean") /*@Valid*/  AlertaForm formBean,BindingResult result, ModelMap modelo,@RequestParam String action) throws Exception {
		    	
		    	
		    	if(action.equals("Aceptar"))
		    	{
		            
		    		if(result.hasErrors())
		    		{
		    			
		                
		    			modelo.addAttribute("formBean",formBean);
		    			 return "alertaMetereologica";
		    		}
		    		else
		    		{
		    			Alerta p=formBean.toPojo();
		    			p.setCiudad(serviceCiudad.getById(formBean.getidCiudad()));
		    			
		    			LocalDate fechaHoy=LocalDate.now(ZoneId.of("GMT+03:00"));	
		    			
		    			if(formBean.getFechaAlerta().equalsIgnoreCase("Hoy")) {

		    				p.setFechaAlerta(fechaHoy);
		    			}
		    			else if(formBean.getFechaAlerta().equalsIgnoreCase("Manana")) {
		    				p.setFechaAlerta(fechaHoy.plusDays(1));
		    			}	
		    			servicioAlerta.save(p);
		    			List<Persona> personas = servicePersona.getPersonaByIdCiudad(formBean.getidCiudad());
		            	modelo.addAttribute("resultados",personas);
		    			for(Persona persona : personas) {
		    				System.out.println(persona.getMail());
		    			}
		    			
		    			return "redirect:/alertaMetereologica";
		    			
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
