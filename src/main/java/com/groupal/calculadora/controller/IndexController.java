package com.groupal.calculadora.controller;

import java.security.Principal;
import java.lang.Math; 
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

	@RequestMapping(value="/")
    public String index(){
        return "index";
    }
	
	@RequestMapping(value="/calcular", method=RequestMethod.GET)
	protected @ResponseBody String calcular(HttpServletRequest request, Principal principal, @RequestParam( value = "sgn1") Integer sgn1, 
				@RequestParam( value = "sgn2") Integer sgn2, @RequestParam( value = "sgn3") Integer sgn3, @RequestParam( value = "sgn4") Integer sgn4,
				@RequestParam(defaultValue="0", value = "n1") float n1, @RequestParam(defaultValue="0", value = "n2") float n2, @RequestParam(defaultValue="0", value = "n3") float n3,
			    @RequestParam(defaultValue="0", value = "n4") float n4, @RequestParam( value = "op") Integer op){ 	
		
		String resultado = "";
		
		if(sgn1 == 2) {
			n1 = n1 *(-1); 
		}
		if(sgn2 == 2) {
			n2 = n2 *(-1); 
		}
		if(sgn3 == 2) {
			n3 = n3 *(-1); 
		}
		if(sgn4 == 2) {
			n4 = n4 *(-1); 
		}
		
		float x = 0;
		float y = 0;
		float xy1 = 0;
		float xy2 = 0;
		
		switch(op) {
		  case 1: //si es suma	    
			  x = n1 + n3;
			  y = n2 + n4;
			  resultado = "El resultado de la operación es: "+x+" "+(y<0 ? "-" : "+")+" "+(Math.abs(y))+"i"; 
			  break;
		  case 2:
			  x = n1 - n3;
			  y = n2 - n4;
			  resultado = "El resultado de la operación es: "+x+" "+(y<0 ? "-" : "+")+" "+(Math.abs(y))+"i";
			  break;
		  case 3:
			  x = n1 * n3;
			  xy1 = n1 * n4;
			  xy2 = n2 * n3;
			  y = n2 * n4;
			  resultado = "El resultado de la operación es: "+(x+(y*(-1))) +" "+((xy1+xy2)<0 ? "-" : "+")+" "+(Math.abs(xy1+xy2))+"i";
			  break;
		  case 4:
			    //primero calculo el conjugado del denominador
			  float c2y = n4*(-1);
			  	
			  	//multiplico arriba por el conjugado
			  float nx = n1 * n3;
			  float nxy1 = n1 * c2y;
			  float nxy2 = n2 * n3;
			  float ny = n2 * c2y;
			  	
			  	resultado = "El resultado de la operación es: ("+(nx+(ny*(-1))) +" "+((nxy1+nxy2)<0 ? "-" : "+")+" "+(Math.abs(nxy1+nxy2))+"i) /"+((n3*n3)+((n4*c2y)*(-1)));
			  	
			    break;
		  default:
			  resultado = "Se produjo un error la operacion no pudo ser realizada.";
		}
	        
				
		return resultado;

	 }
 
}

