/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.converters;

import com.bitlab.entities.BitEnglish;
import com.bitlab.session.BitDetailFacade;
import com.bitlab.session.BitEnglishFacade;
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
@FacesConverter("englishConverter")
public class BitEnglishConverter implements Converter
{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        BitEnglishFacade controller = new BitEnglishFacade();
        System.out.println("Convirtiendo a objeto : " + value);
        try {
            return controller.find(new BitEnglish());
        } catch (Exception ex) {
            Logger.getLogger(BitEnglishConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println("Convirtiendo a texto: " + ((BitEnglish)value).getEngId().toString());
        return ((BitEnglish)value).getEngId().toString();
    }
    
    
}
