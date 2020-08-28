/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.converters;

import com.bitlab.entities.BitSkill;
import com.bitlab.session.BitActivityFacade;
import com.bitlab.session.BitSkillFacade;
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
@FacesConverter("skillsConverter")
public class BitSkillsConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        BitSkillFacade controller = new BitSkillFacade();
        System.out.println("Convirtiendo a objeto : " + value);
        try {
            return controller.find(new BitSkill());
        } catch (Exception ex) {
            Logger.getLogger(BitSkillsConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println("Convirtiendo a texto: " + ((BitSkill)value).getSkiId().toString());
        return ((BitSkill)value).getSkiId().toString();
    }
    
}
