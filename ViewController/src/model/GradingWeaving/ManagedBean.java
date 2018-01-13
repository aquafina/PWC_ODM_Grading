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
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
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
        Double sumTotalQtyValue = Double.parseDouble(currVO.getCurrentRow().getAttribute("SUMTOTQTY").toString());
        /*if (sumTotalQtyValue > qtyReceivedLooming) {
            showMessage("Sum of Total Quantities cannot exceed Quantity Received for Looming", 112);
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
        System.out.println("object = "+object.toString());
        ApplicationModuleImpl am = getApplicationModule();
        ViewObject currVO = am.findViewObject("PwcOdmGradingWeavingHeadersVO1");
        Double qtyReceivedLooming = Double.parseDouble(currVO.getCurrentRow().getAttribute("QtyReceivedLooming").toString());
        Double sumTotalQtyValue = Double.parseDouble(currVO.getCurrentRow().getAttribute("SUMTOTQTY").toString());
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
            /*else if (sumTotalQtyValue > qtyReceivedLooming) {
                FacesMessage message =
                       new FacesMessage(FacesMessage.SEVERITY_ERROR,
                       "Invalid Value",
                       "Sum of Total Quantities cannot exceed Quantity Received for Looming");
                       facesContext.addMessage(uIComponent.getClientId(facesContext),
                       message);
                ((RichInputText)uIComponent).setValid(false);
                //showMessage("Sum of Total Quantities cannot exceed Quantity Received for Looming", 112);
            }*/
            
            System.out.println("SUMTOTQTY = "+getSumTotalQuantities(am,totalQty));
            
        } catch (SQLException e) {
        }
        System.out.println("totalQty = "+totalQty);
    }


    public void gradeAQtyValidator(FacesContext facesContext,
                                   UIComponent uIComponent, Object object) {
        // Add event code here...
        oracle.jbo.domain.Number gradeAQty = (oracle.jbo.domain.Number)object;
        ApplicationModuleImpl am = getApplicationModule();
        ViewObject currVO = am.findViewObject("PwcOdmGradingWaveingLinesVO1");
        Double totalQty = Double.parseDouble(currVO.getCurrentRow().getAttribute("TotalQuantity")!=null?currVO.getCurrentRow().getAttribute("TotalQuantity").toString():"0.0");
        Double gradeBQty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Gradeb")!=null?currVO.getCurrentRow().getAttribute("Gradeb").toString():"0.0");
        Double gradeCQty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Gradec")!=null?currVO.getCurrentRow().getAttribute("Gradec").toString():"0.0");
        Double gradeDQty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Graded")!=null?currVO.getCurrentRow().getAttribute("Graded").toString():"0.0");
        oracle.jbo.domain.Number totalQtyNumber = new oracle.jbo.domain.Number(0);
        oracle.jbo.domain.Number totalGradeQuantitiesNumber = new oracle.jbo.domain.Number(0);
        try {
            totalQtyNumber = new oracle.jbo.domain.Number(totalQty);
            totalGradeQuantitiesNumber = new oracle.jbo.domain.Number(gradeBQty + gradeCQty + gradeDQty);
//            System.out.println("qtyReceivedLoomingNumber = "+qtyReceivedLoomingNumber);
            if (totalGradeQuantitiesNumber.compareTo(totalQtyNumber)==1) {
                FacesMessage message =
                       new FacesMessage(FacesMessage.SEVERITY_ERROR,
                       "Invalid Value",
                       "Total Grade Quantities cannot exceed the Total Quantity");
                       facesContext.addMessage(uIComponent.getClientId(facesContext),
                       message);
                ((RichInputText)uIComponent).setValid(false);
            }
        } catch (SQLException e) {
        }
    }

    public void gradeBQtyValidator(FacesContext facesContext,
                                   UIComponent uIComponent, Object object) {
        // Add event code here...
    }

    public void gradeCQtyValidator(FacesContext facesContext,
                                   UIComponent uIComponent, Object object) {
        // Add event code here...
    }

    public void gradeDQtyValidator(FacesContext facesContext,
                                   UIComponent uIComponent, Object object) {
        // Add event code here...
    }
    
    public oracle.jbo.domain.Number getSumTotalQuantities(ApplicationModule am, oracle.jbo.domain.Number changedValue) {
        ViewObject currVO = am.findViewObject("PwcOdmGradingWaveingLinesVO1");
        RowSetIterator iter = currVO.createRowSetIterator(null);
        Double sum = 0.0;
        int i=0;
        while (iter.next()!=null) {
            System.out.println("row no = "+ ++i);
            sum = sum + Double.parseDouble(iter.getCurrentRow().getAttribute("TotalQuantity")!=null?iter.getCurrentRow().getAttribute("TotalQuantity").toString():"0.0");
            System.out.println("sum = "+sum);
        }
        /*if (rows.length>0) {
            System.out.println("length = "+rows.length);
            for (int i=0;i<rows.length;i++) {
                sum = sum + Double.parseDouble(rows[i].getAttribute("TotalQuantity")!=null?rows[i].getAttribute("TotalQuantity").toString():"0.0");
                System.out.println("sum = "+sum);
            }
//            System.out.println("sum = "+sum);
        }*/
        return new oracle.jbo.domain.Number(0);
    }
}
