/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.converters;

import com.bitlab.entities.BitCouStatus;
import com.bitlab.session.BitCouStatusFacade;
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
@FacesConverter("couStatusConverter")
public class BitCouStatusConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        BitCouStatusFacade controller = new BitCouStatusFacade();
        System.out.println("Convirtiendo a objeto : " + value);
        try {
            return controller.find(new BitCouStatus());
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(BitCouStatusConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println("Convirtiendo a texto: " + ((BitCouStatus)value).getCosId().toString());
        return ((BitCouStatus)value).getCosId().toString();
    }
    
}
