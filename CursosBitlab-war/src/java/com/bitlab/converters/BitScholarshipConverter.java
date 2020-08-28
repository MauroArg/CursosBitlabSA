/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.converters;

import com.bitlab.entities.BitScholarship;
import com.bitlab.session.BitScholarshipFacade;
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
@FacesConverter("scolarshipConverter")
public class BitScholarshipConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        BitScholarshipFacade controller = new BitScholarshipFacade();
        System.out.println("Convirtiendo a objeto : " + value);
        try {
            return controller.find(new BitScholarship());
        } catch (Exception ex) {
            Logger.getLogger(BitScholarshipConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println("Convirtiendo a texto: " + ((BitScholarship)value).getSchId().toString());
        return ((BitScholarship)value).getSchId().toString();
    }
    
}
