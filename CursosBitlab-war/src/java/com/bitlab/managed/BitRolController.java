package com.bitlab.managed;

import com.bitlab.entities.BitRol;
import com.bitlab.managed.util.JsfUtil;
import com.bitlab.managed.util.JsfUtil.PersistAction;
import com.bitlab.session.BitRolFacade;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@ManagedBean
@ViewScoped
public class BitRolController implements Serializable {

    @EJB
    private BitRolFacade ejbFacade;
    private List<BitRol> items = null;
    private BitRol selected;
    private Calendar date = Calendar.getInstance();

    public BitRolController() {
    }

    public BitRol getSelected() {
        return selected;
    }

    public void setSelected(BitRol selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private BitRolFacade getFacade() {
        return ejbFacade;
    }

    public BitRol prepareCreate() {
        selected = new BitRol();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        selected.setRolId(0);
        selected.setADateCreate(date.getTime());
        selected.setADateChange(date.getTime());
        selected.setAUserChange("System");
        selected.setAUserCreate("System");
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("BitRolCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        selected.setADateChange(date.getTime());
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("BitRolUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("BitRolDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<BitRol> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public BitRol getBitRol(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<BitRol> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<BitRol> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = BitRol.class)
    public static class BitRolControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            BitRolController controller = (BitRolController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "bitRolController");
            return controller.getBitRol(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof BitRol) {
                BitRol o = (BitRol) object;
                return getStringKey(o.getRolId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), BitRol.class.getName()});
                return null;
            }
        }

    }

}
