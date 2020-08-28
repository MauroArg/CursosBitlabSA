/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.converters;

import com.bitlab.entities.BitEnvironment;
import com.bitlab.session.BitEnvironmentFacade;
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
@FacesConverter("enviromentConverter")
public class BitEnviromentConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        BitEnvironmentFacade controller = new BitEnvironmentFacade();
        System.out.println("Convirtiendo a objeto : " + value);
        try {
            return controller.find(new BitEnvironment());
        } catch (Exception ex) {
            Logger.getLogger(BitEnviromentConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println("Convirtiendo a texto: " + ((BitEnvironment)value).getEnvId().toString());
        return ((BitEnvironment)value).getEnvId().toString();
    }
    
}