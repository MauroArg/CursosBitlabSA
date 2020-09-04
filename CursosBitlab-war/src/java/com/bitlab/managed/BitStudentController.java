package com.bitlab.managed;

import com.bitlab.entities.BitStudent;
import com.bitlab.entities.BitUser;
import com.bitlab.managed.util.JsfUtil;
import com.bitlab.managed.util.JsfUtil.PersistAction;
import com.bitlab.session.BitStudentFacade;
import com.bitlab.util.UploadFile;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
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
import org.primefaces.model.file.UploadedFile;

@ManagedBean
@ViewScoped
public class BitStudentController implements Serializable {

    @EJB
    private BitStudentFacade ejbFacade;
    private List<BitStudent> items = null;
    private BitStudent selected;
    private Calendar date = Calendar.getInstance();
    private UploadedFile file;
    private String destination;
    
    private UploadFile uf = new UploadFile();
    public BitStudentController() {
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
    
        
    public BitStudent getSelected() {
        return selected;
    }

    public void setSelected(BitStudent selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private BitStudentFacade getFacade() {
        return ejbFacade;
    }

    public BitStudent prepareCreate() {
        selected = new BitStudent();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        selected.setStuId(0);
        selected.setADateCreate(date.getTime());
        selected.setADateChange(date.getTime());
        selected.setAUserChange("System");
        selected.setAUserCreate("System");
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("BitStudentCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    
    public void create(BitUser usrId) {
        selected.setStuId(0);
        selected.setUsrId(usrId);
        selected.setADateCreate(date.getTime());
        selected.setADateChange(date.getTime());
        selected.setAUserChange("System");
        selected.setAUserCreate("System");
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("BitStudentCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        selected.setADateChange(date.getTime());
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("BitStudentUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("BitStudentDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<BitStudent> getItems() {
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

    public BitStudent getBitStudent(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<BitStudent> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<BitStudent> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = BitStudent.class)
    public static class BitStudentControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            BitStudentController controller = (BitStudentController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "bitStudentController");
            return controller.getBitStudent(getKey(value));
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
            if (object instanceof BitStudent) {
                BitStudent o = (BitStudent) object;
                return getStringKey(o.getStuId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), BitStudent.class.getName()});
                return null;
            }
        }

    }
    
    public void newDocument(){
        if(uf.upload(this.getFile(), selected.getStuId())){
            selected.setStuImg(uf.SEPARATOR + destination);
            create();
            destination = "";
        }
    }
    
    @PostConstruct
    public void init(){
        selected = new BitStudent();
    }
}
