/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.converters;

import com.bitlab.entities.BitReqStatus;
import com.bitlab.entities.BitRequest;
import com.bitlab.session.BitReqStatusFacade;
import com.bitlab.session.BitRequestFacade;
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

@FacesConverter("requestConverter")
public class BitRequestConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        BitRequestFacade controller = new BitRequestFacade();
        System.out.println("Convirtiendo a objeto : " + value);
        try {
            return controller.find(new BitRequest());
        } catch (Exception ex) {
            Logger.getLogger(BitRequestConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println("Convirtiendo a texto: " + ((BitRequest)value).getReqId().toString());
        return ((BitRequest)value).getReqId().toString();
    }
    
}
