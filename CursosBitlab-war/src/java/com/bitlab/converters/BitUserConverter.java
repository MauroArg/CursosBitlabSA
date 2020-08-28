/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.converters;

import com.bitlab.entities.BitTestType;
import com.bitlab.entities.BitUser;
import com.bitlab.session.BitTestTypeFacade;
import com.bitlab.session.BitUserFacade;
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
public class BitUserConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        BitUserFacade controller = new BitUserFacade();
        System.out.println("Convirtiendo a objeto : " + value);
        try {
            return controller.find(new BitUser());
        } catch (Exception ex) {
            Logger.getLogger(BitUserConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println("Convirtiendo a texto: " + ((BitUser)value).getUsrId().toString());
        return ((BitUser)value).getUsrId().toString();
    }
    
}
