/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.converters;

import com.bitlab.entities.BitUser;
import com.bitlab.entities.BitUsrStatus;
import com.bitlab.session.BitUserFacade;
import com.bitlab.session.BitUsrStatusFacade;
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
@FacesConverter("userConverter")
public class BitUsrStatusConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       BitUsrStatusFacade controller = new BitUsrStatusFacade();
        System.out.println("Convirtiendo a objeto : " + value);
        try {
            return controller.find(new BitUsrStatus());
        } catch (Exception ex) {
            Logger.getLogger(BitUserConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println("Convirtiendo a texto: " + ((BitUsrStatus)value).getUssId().toString());
        return ((BitUsrStatus)value).getUssId().toString();
    }
    
}
