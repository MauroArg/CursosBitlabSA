/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.converters;

import com.bitlab.entities.BitActivity;
import com.bitlab.session.BitActivityFacade;
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
@FacesConverter("activityConverter")
public class BitActivityConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        BitActivityFacade controller = new BitActivityFacade();
        System.out.println("Convirtiendo a objeto : " + value);
        try {
            return controller.find(new BitActivity());
        } catch (Exception ex) {
            Logger.getLogger(BitActivityConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println("Convirtiendo a texto: " + ((BitActivity)value).getActId().toString());
        return ((BitActivity)value).getActId().toString();
    }
    
}
