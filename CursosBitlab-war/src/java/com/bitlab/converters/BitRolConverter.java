/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.converters;

import com.bitlab.entities.BitRequest;
import com.bitlab.entities.BitRol;
import com.bitlab.session.BitRequestFacade;
import com.bitlab.session.BitRolFacade;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Maury
 */
@FacesConverter("rolConverter")
public class BitRolConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        BitRolFacade controller = new BitRolFacade();
        System.out.println("Convirtiendo a objeto : " + value);
        try {
            return controller.find(new BitRol());
        } catch (Exception ex) {
            Logger.getLogger(BitRolConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println("Convirtiendo a texto: " + ((BitRol)value).getRolId().toString());
        return ((BitRol)value).getRolId().toString();
    }
    
}
