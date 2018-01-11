package model.GradingWeaving;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import model.GradingWeaving.AM.PwcOdmGradingWeavingAMImpl;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCDataControl;

import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.ApplicationModule;
import oracle.jbo.ViewObject;

import oracle.jbo.server.ApplicationModuleImpl;

public class ManagedBean {
    public ManagedBean() { }

    /*****Generic Method to Get BindingContainer**/
    public BindingContainer getBindingsCont() {
     return BindingContext.getCurrent().getCurrentBindingsEntry();
    }

    /**
     * Generic Method to execute operation
     * */
    public OperationBinding executeOperation(String operation) {
    OperationBinding createParam = getBindingsCont().getOperationBinding(operation);
    return createParam;
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

    public void TotalQty_ValueChange(ValueChangeEvent valueChangeEvent) {
        // Calling Operation Binding with AM
        /*valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
        // Customzied Method Name 
        OperationBinding operationBinding =  executeOperation("Exceed_TOTALQTY");
        operationBinding.execute();*/
        ApplicationModuleImpl am = getApplicationModule();
        ViewObject currVO = am.findViewObject("PwcOdmGradingWeavingHeadersVO1");
        Double qtyReceivedLooming = Double.parseDouble(currVO.getCurrentRow().getAttribute("QtyReceivedLooming").toString());
        Double newTotalQtyValue = Double.parseDouble(valueChangeEvent.getNewValue()!=null?valueChangeEvent.getNewValue().toString():"0.0");
        /*if (newTotalQtyValue > qtyReceivedLooming) {
            showMessage("Total Quantity cannot exceed Quantity Received for Looming", 112);
        }*/
    }
    
    
    public static PwcOdmGradingWeavingAMImpl getApplicationModule() {
        FacesContext fctx = FacesContext.getCurrentInstance();
        BindingContext bindingContext = BindingContext.getCurrent();
        DCDataControl dc = bindingContext.findDataControl("PwcOdmGradingWeavingAMDataControl");
        return (PwcOdmGradingWeavingAMImpl)dc.getDataProvider();
        }
    
    public void totalQtyValidator(FacesContext facesContext,
                                  UIComponent uIComponent, Object object) {
        oracle.jbo.domain.Number totalQty = (oracle.jbo.domain.Number)object;
        ApplicationModuleImpl am = getApplicationModule();
        ViewObject currVO = am.findViewObject("PwcOdmGradingWeavingHeadersVO1");
        Double qtyReceivedLooming = Double.parseDouble(currVO.getCurrentRow().getAttribute("QtyReceivedLooming").toString());
        oracle.jbo.domain.Number qtyReceivedLoomingNumber = new oracle.jbo.domain.Number(0);
        try {
            qtyReceivedLoomingNumber = new oracle.jbo.domain.Number(qtyReceivedLooming);
            System.out.println("qtyReceivedLoomingNumber = "+qtyReceivedLoomingNumber);
            if (totalQty.compareTo(qtyReceivedLoomingNumber)==1) {
                FacesMessage message =
                       new FacesMessage(FacesMessage.SEVERITY_ERROR,
                       "Invalid Value",
                       "Total Quantity cannot exceed Quantity Received for Looming");
                       facesContext.addMessage(uIComponent.getClientId(facesContext),
                       message);
                ((RichInputText)uIComponent).setValid(false);
            }
        } catch (SQLException e) {
        }
        System.out.println("totalQty = "+totalQty);
    }
    
    
}
