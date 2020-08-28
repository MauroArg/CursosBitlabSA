/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.converters;

import com.bitlab.entities.BitStudent;
import com.bitlab.entities.BitTest;
import com.bitlab.session.BitStudentFacade;
import com.bitlab.session.BitTestFacade;
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

@FacesConverter("testConverter")
public class BitTestConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        BitTestFacade controller = new BitTestFacade();
        System.out.println("Convirtiendo a objeto : " + value);
        try {
            return controller.find(new BitTest());
        } catch (Exception ex) {
            Logger.getLogger(BitTestConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println("Convirtiendo a texto: " + ((BitTest)value).getTesId().toString());
        return ((BitTest)value).getTesId().toString();
    }
    
}