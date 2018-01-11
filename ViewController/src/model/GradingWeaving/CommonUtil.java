package view.classes;

import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import model.GradingWeaving.AM.PwcOdmGradingWeavingAMImpl;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCDataControl;

public class CommonUtil {
    public CommonUtil() {
        super();
    }
    public static PwcOdmGradingWeavingAMImpl getApplicationModule() {
        FacesContext fctx = FacesContext.getCurrentInstance();
        BindingContext bindingContext = BindingContext.getCurrent();
        DCDataControl dc = bindingContext.findDataControl("PwcOdmGradingWeavingAMDataControl");
        return (PwcOdmGradingWeavingAMImpl)dc.getDataProvider();
}
    public static void redirect(String pageName) {
            FacesContext fctx = FacesContext.getCurrentInstance();
            ExternalContext ec = fctx.getExternalContext();
            HttpServletRequest request = (HttpServletRequest)ec.getRequest();
            HttpServletResponse response = (HttpServletResponse)ec.getResponse();

            try {
                response.sendRedirect(pageName);
            } catch (IOException e) {
                showMessage("Problem resolving pag. Please contact System Administrator" + e.getMessage(),
                            112);
            } finally {
                fctx.responseComplete();
            }
    }
    
    public static void showMessage(String message, int code) {

            FacesMessage.Severity s = null;
            if (code == 112) {
                s = FacesMessage.SEVERITY_ERROR;
            } else if (code == 111) {
                s = FacesMessage.SEVERITY_INFO;
            }

            FacesMessage msg = new FacesMessage(s, message, "");
            FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}