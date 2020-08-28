/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.converters;

import com.bitlab.entities.BitScholarship;
import com.bitlab.entities.BitStudent;
import com.bitlab.session.BitScholarshipFacade;
import com.bitlab.session.BitStudentFacade;
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

@FacesConverter("studentConverter")
public class BitStudentConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        BitStudentFacade controller = new BitStudentFacade();
        System.out.println("Convirtiendo a objeto : " + value);
        try {
            return controller.find(new BitStudent());
        } catch (Exception ex) {
            Logger.getLogger(BitStudentConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println("Convirtiendo a texto: " + ((BitStudent)value).getStuId().toString());
        return ((BitStudent)value).getStuId().toString();
    }
    
}
