/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.converters;

import com.bitlab.entities.BitTest;
import com.bitlab.entities.BitTestType;
import com.bitlab.session.BitTestFacade;
import com.bitlab.session.BitTestTypeFacade;
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
@FacesConverter("testTypeConverter")
public class BitTestTypeConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        BitTestTypeFacade controller = new BitTestTypeFacade();
        System.out.println("Convirtiendo a objeto : " + value);
        try {
            return controller.find(new BitTestType());
        } catch (Exception ex) {
            Logger.getLogger(BitTestTypeConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println("Convirtiendo a texto: " + ((BitTestType)value).getTytId().toString());
        return ((BitTestType)value).getTytId().toString();
    }
    
}
