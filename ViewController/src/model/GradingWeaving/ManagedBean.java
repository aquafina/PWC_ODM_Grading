package model.GradingWeaving;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
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
    private RichInputText totalQtyInputText;

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
        Double totalQty = Double.parseDouble(valueChangeEvent.getNewValue().toString());
        ApplicationModuleImpl am = getApplicationModule();
        ViewObject currVO = am.findViewObject("PwcOdmGradingWeavingHeadersVO1");
        Double qtyReceivedLooming = Double.parseDouble(currVO.getCurrentRow().getAttribute("QtyReceivedLooming")!=null?currVO.getCurrentRow().getAttribute("QtyReceivedLooming").toString():"0.0");
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
        Double totalQty = Double.parseDouble(object.toString());
        ApplicationModuleImpl am = getApplicationModule();
        ViewObject currHeadersVO = am.findViewObject("PwcOdmGradingWeavingHeadersVO1");
        ViewObject currLinesVO = am.findViewObject("PwcOdmGradingWaveingLinesVO1");
        Double qtyReceivedLooming = Double.parseDouble(currHeadersVO.getCurrentRow().getAttribute("QtyReceivedLooming")!=null?currHeadersVO.getCurrentRow().getAttribute("QtyReceivedLooming").toString():"0.0");
        Double sumTotalQtyValue = Double.parseDouble(currHeadersVO.getCurrentRow().getAttribute("SUMTOTQTY")!=null?currHeadersVO.getCurrentRow().getAttribute("SUMTOTQTY").toString():"0.0");
        if (totalQty.compareTo(qtyReceivedLooming)==1) {
            FacesMessage message =
                   new FacesMessage(FacesMessage.SEVERITY_ERROR,
                   "Invalid Value",
                   "Total Quantity cannot exceed Quantity Received for Looming");
                   facesContext.addMessage(uIComponent.getClientId(facesContext),
                   message);
            ((RichInputText)uIComponent).setValid(false);
        }
        System.out.println("totalQty = "+totalQty);
}


    public void gradeAQtyValidator(FacesContext facesContext,
                                   UIComponent uIComponent, Object object) {
        // Add event code here...
        Double gradeAQty = Double.parseDouble(object.toString());
        ApplicationModuleImpl am = getApplicationModule();
        ViewObject currVO = am.findViewObject("PwcOdmGradingWaveingLinesVO1");
        Double totalQty = Double.parseDouble(currVO.getCurrentRow().getAttribute("TotalQuantity")!=null?currVO.getCurrentRow().getAttribute("TotalQuantity").toString():"0.0");
        Double gradeBQty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Gradeb")!=null?currVO.getCurrentRow().getAttribute("Gradeb").toString():"0.0");
        Double gradeCQty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Gradec")!=null?currVO.getCurrentRow().getAttribute("Gradec").toString():"0.0");
        Double gradeD0to1Qty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Attribute1")!=null?currVO.getCurrentRow().getAttribute("Attribute1").toString():"0.0");
        Double gradeD1to5Qty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Attribute2")!=null?currVO.getCurrentRow().getAttribute("Attribute2").toString():"0.0");
        Double gradeD6to19Qty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Attribute3")!=null?currVO.getCurrentRow().getAttribute("Attribute3").toString():"0.0");
        Double gradeD20AboveQty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Attribute4")!=null?currVO.getCurrentRow().getAttribute("Attribute4").toString():"0.0");
        Double totalGradeQuantities = gradeAQty + gradeBQty + gradeCQty + gradeD0to1Qty + gradeD1to5Qty + gradeD6to19Qty + gradeD20AboveQty;
        System.out.println("totalGradeQuantities = "+totalGradeQuantities);
            if (totalGradeQuantities.compareTo(totalQty)==1) {
                FacesMessage message =
                       new FacesMessage(FacesMessage.SEVERITY_ERROR,
                       "Invalid Value",
                       "Total Grade Quantities cannot exceed the Total Quantity");
                       facesContext.addMessage(uIComponent.getClientId(facesContext),
                       message);
                ((RichInputText)uIComponent).setValid(false);
            }
    } 

    public void gradeBQtyValidator(FacesContext facesContext,
                                   UIComponent uIComponent, Object object) {
        // Add event code here...
        Double gradeBQty = Double.parseDouble(object.toString());
        ApplicationModuleImpl am = getApplicationModule();
        ViewObject currVO = am.findViewObject("PwcOdmGradingWaveingLinesVO1");
        Double totalQty = Double.parseDouble(currVO.getCurrentRow().getAttribute("TotalQuantity")!=null?currVO.getCurrentRow().getAttribute("TotalQuantity").toString():"0.0");
        Double gradeAQty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Gradea")!=null?currVO.getCurrentRow().getAttribute("Gradea").toString():"0.0");
        Double gradeCQty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Gradec")!=null?currVO.getCurrentRow().getAttribute("Gradec").toString():"0.0");
        Double gradeD0to1Qty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Attribute1")!=null?currVO.getCurrentRow().getAttribute("Attribute1").toString():"0.0");
        Double gradeD1to5Qty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Attribute2")!=null?currVO.getCurrentRow().getAttribute("Attribute2").toString():"0.0");
        Double gradeD6to19Qty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Attribute3")!=null?currVO.getCurrentRow().getAttribute("Attribute3").toString():"0.0");
        Double gradeD20AboveQty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Attribute4")!=null?currVO.getCurrentRow().getAttribute("Attribute4").toString():"0.0");
        Double totalGradeQuantities = gradeAQty + gradeBQty + gradeCQty + gradeD0to1Qty + gradeD1to5Qty + gradeD6to19Qty + gradeD20AboveQty;
        System.out.println("totalGradeQuantities = "+totalGradeQuantities);
            if (totalGradeQuantities.compareTo(totalQty)==1) {
                FacesMessage message =
                       new FacesMessage(FacesMessage.SEVERITY_ERROR,
                       "Invalid Value",
                       "Total Grade Quantities cannot exceed the Total Quantity");
                       facesContext.addMessage(uIComponent.getClientId(facesContext),
                       message);
                ((RichInputText)uIComponent).setValid(false);
            }
    }

    public void gradeCQtyValidator(FacesContext facesContext,
                                   UIComponent uIComponent, Object object) {
        // Add event code here...
        Double gradeCQty = Double.parseDouble(object.toString());
        ApplicationModuleImpl am = getApplicationModule();
        ViewObject currVO = am.findViewObject("PwcOdmGradingWaveingLinesVO1");
        Double totalQty = Double.parseDouble(currVO.getCurrentRow().getAttribute("TotalQuantity")!=null?currVO.getCurrentRow().getAttribute("TotalQuantity").toString():"0.0");
        Double gradeBQty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Gradeb")!=null?currVO.getCurrentRow().getAttribute("Gradeb").toString():"0.0");
        Double gradeAQty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Gradea")!=null?currVO.getCurrentRow().getAttribute("Gradea").toString():"0.0");
        Double gradeD0to1Qty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Attribute1")!=null?currVO.getCurrentRow().getAttribute("Attribute1").toString():"0.0");
        Double gradeD1to5Qty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Attribute2")!=null?currVO.getCurrentRow().getAttribute("Attribute2").toString():"0.0");
        Double gradeD6to19Qty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Attribute3")!=null?currVO.getCurrentRow().getAttribute("Attribute3").toString():"0.0");
        Double gradeD20AboveQty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Attribute4")!=null?currVO.getCurrentRow().getAttribute("Attribute4").toString():"0.0");
        Double totalGradeQuantities = gradeAQty + gradeBQty + gradeCQty + gradeD0to1Qty + gradeD1to5Qty + gradeD6to19Qty + gradeD20AboveQty;
        System.out.println("totalGradeQuantities = "+totalGradeQuantities);
            if (totalGradeQuantities.compareTo(totalQty)==1) {
                FacesMessage message =
                       new FacesMessage(FacesMessage.SEVERITY_ERROR,
                       "Invalid Value",
                       "Total Grade Quantities cannot exceed the Total Quantity");
                       facesContext.addMessage(uIComponent.getClientId(facesContext),
                       message);
                ((RichInputText)uIComponent).setValid(false);
            }
    }

    public void gradeD0to1QtyValidator(FacesContext facesContext,
                                   UIComponent uIComponent, Object object) {
        // Add event code here...
        Double gradeD0to1Qty = Double.parseDouble(object.toString());
        ApplicationModuleImpl am = getApplicationModule();
        ViewObject currVO = am.findViewObject("PwcOdmGradingWaveingLinesVO1");
        Double totalQty = Double.parseDouble(currVO.getCurrentRow().getAttribute("TotalQuantity")!=null?currVO.getCurrentRow().getAttribute("TotalQuantity").toString():"0.0");
        Double gradeBQty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Gradeb")!=null?currVO.getCurrentRow().getAttribute("Gradeb").toString():"0.0");
        Double gradeCQty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Gradec")!=null?currVO.getCurrentRow().getAttribute("Gradec").toString():"0.0");
        Double gradeAQty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Gradea")!=null?currVO.getCurrentRow().getAttribute("Gradea").toString():"0.0");
        Double gradeD1to5Qty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Attribute2")!=null?currVO.getCurrentRow().getAttribute("Attribute2").toString():"0.0");
        Double gradeD6to19Qty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Attribute3")!=null?currVO.getCurrentRow().getAttribute("Attribute3").toString():"0.0");
        Double gradeD20AboveQty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Attribute4")!=null?currVO.getCurrentRow().getAttribute("Attribute4").toString():"0.0");
        Double totalGradeQuantities = gradeAQty + gradeBQty + gradeCQty + gradeD0to1Qty + gradeD1to5Qty + gradeD6to19Qty + gradeD20AboveQty;        
        System.out.println("totalGradeQuantities = "+totalGradeQuantities);
            if (totalGradeQuantities.compareTo(totalQty)==1) {
                FacesMessage message =
                       new FacesMessage(FacesMessage.SEVERITY_ERROR,
                       "Invalid Value",
                       "Total Grade Quantities cannot exceed the Total Quantity");
                       facesContext.addMessage(uIComponent.getClientId(facesContext),
                       message);
                ((RichInputText)uIComponent).setValid(false);
            }
    }
    
    public void gradeD1to5QtyValidator(FacesContext facesContext,
                                   UIComponent uIComponent, Object object) {
        // Add event code here...
        Double gradeD1to5Qty = Double.parseDouble(object.toString());
        ApplicationModuleImpl am = getApplicationModule();
        ViewObject currVO = am.findViewObject("PwcOdmGradingWaveingLinesVO1");
        Double totalQty = Double.parseDouble(currVO.getCurrentRow().getAttribute("TotalQuantity")!=null?currVO.getCurrentRow().getAttribute("TotalQuantity").toString():"0.0");
        Double gradeBQty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Gradeb")!=null?currVO.getCurrentRow().getAttribute("Gradeb").toString():"0.0");
        Double gradeCQty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Gradec")!=null?currVO.getCurrentRow().getAttribute("Gradec").toString():"0.0");
        Double gradeAQty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Gradea")!=null?currVO.getCurrentRow().getAttribute("Gradea").toString():"0.0");
        Double gradeD0to1Qty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Attribute1")!=null?currVO.getCurrentRow().getAttribute("Attribute1").toString():"0.0");
        Double gradeD6to19Qty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Attribute3")!=null?currVO.getCurrentRow().getAttribute("Attribute3").toString():"0.0");
        Double gradeD20AboveQty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Attribute4")!=null?currVO.getCurrentRow().getAttribute("Attribute4").toString():"0.0");
        Double totalGradeQuantities = gradeAQty + gradeBQty + gradeCQty + gradeD0to1Qty + gradeD1to5Qty + gradeD6to19Qty + gradeD20AboveQty;        
        System.out.println("totalGradeQuantities = "+totalGradeQuantities);
            if (totalGradeQuantities.compareTo(totalQty)==1) {
                FacesMessage message =
                       new FacesMessage(FacesMessage.SEVERITY_ERROR,
                       "Invalid Value",
                       "Total Grade Quantities cannot exceed the Total Quantity");
                       facesContext.addMessage(uIComponent.getClientId(facesContext),
                       message);
                ((RichInputText)uIComponent).setValid(false);
            }
    }

    public void gradeD6to19QtyValidator(FacesContext facesContext,
                                   UIComponent uIComponent, Object object) {
        // Add event code here...
        Double gradeD6to19Qty = Double.parseDouble(object.toString());
        ApplicationModuleImpl am = getApplicationModule();
        ViewObject currVO = am.findViewObject("PwcOdmGradingWaveingLinesVO1");
        Double totalQty = Double.parseDouble(currVO.getCurrentRow().getAttribute("TotalQuantity")!=null?currVO.getCurrentRow().getAttribute("TotalQuantity").toString():"0.0");
        Double gradeBQty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Gradeb")!=null?currVO.getCurrentRow().getAttribute("Gradeb").toString():"0.0");
        Double gradeCQty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Gradec")!=null?currVO.getCurrentRow().getAttribute("Gradec").toString():"0.0");
        Double gradeAQty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Gradea")!=null?currVO.getCurrentRow().getAttribute("Gradea").toString():"0.0");
        Double gradeD0to1Qty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Attribute1")!=null?currVO.getCurrentRow().getAttribute("Attribute1").toString():"0.0");
        Double gradeD1to5Qty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Attribute2")!=null?currVO.getCurrentRow().getAttribute("Attribute2").toString():"0.0");
        Double gradeD20AboveQty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Attribute4")!=null?currVO.getCurrentRow().getAttribute("Attribute4").toString():"0.0");
        Double totalGradeQuantities = gradeAQty + gradeBQty + gradeCQty + gradeD0to1Qty + gradeD1to5Qty + gradeD6to19Qty + gradeD20AboveQty;
        System.out.println("totalGradeQuantities = "+totalGradeQuantities);
            if (totalGradeQuantities.compareTo(totalQty)==1) {
                FacesMessage message =
                       new FacesMessage(FacesMessage.SEVERITY_ERROR,
                       "Invalid Value",
                       "Total Grade Quantities cannot exceed the Total Quantity");
                       facesContext.addMessage(uIComponent.getClientId(facesContext),
                       message);
                ((RichInputText)uIComponent).setValid(false);
            }
    }    
    
    public void gradeD20AboveQtyValidator(FacesContext facesContext,
                                   UIComponent uIComponent, Object object) {
        // Add event code here...
        Double gradeD20AboveQty = Double.parseDouble(object.toString());
        ApplicationModuleImpl am = getApplicationModule();
        ViewObject currVO = am.findViewObject("PwcOdmGradingWaveingLinesVO1");
        Double totalQty = Double.parseDouble(currVO.getCurrentRow().getAttribute("TotalQuantity")!=null?currVO.getCurrentRow().getAttribute("TotalQuantity").toString():"0.0");
        Double gradeBQty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Gradeb")!=null?currVO.getCurrentRow().getAttribute("Gradeb").toString():"0.0");
        Double gradeCQty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Gradec")!=null?currVO.getCurrentRow().getAttribute("Gradec").toString():"0.0");
        Double gradeAQty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Gradea")!=null?currVO.getCurrentRow().getAttribute("Gradea").toString():"0.0");
        Double gradeD0to1Qty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Attribute1")!=null?currVO.getCurrentRow().getAttribute("Attribute1").toString():"0.0");
        Double gradeD1to5Qty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Attribute2")!=null?currVO.getCurrentRow().getAttribute("Attribute2").toString():"0.0");
        Double gradeD6to19Qty = Double.parseDouble(currVO.getCurrentRow().getAttribute("Attribute3")!=null?currVO.getCurrentRow().getAttribute("Attribute3").toString():"0.0");
        Double totalGradeQuantities = gradeAQty + gradeBQty + gradeCQty + gradeD0to1Qty + gradeD1to5Qty + gradeD6to19Qty + gradeD20AboveQty;
        System.out.println("totalGradeQuantities = "+totalGradeQuantities);
            if (totalGradeQuantities.compareTo(totalQty)==1) {
                FacesMessage message =
                       new FacesMessage(FacesMessage.SEVERITY_ERROR,
                       "Invalid Value",
                       "Total Grade Quantities cannot exceed the Total Quantity");
                       facesContext.addMessage(uIComponent.getClientId(facesContext),
                       message);
                ((RichInputText)uIComponent).setValid(false);
            }
    }
    /*public Double getSumTotalQuantities(ApplicationModule am, Double changedValue) {
        ViewObject currVO = am.findViewObject("PwcOdmGradingWaveingLinesVO1");
        RowSetIterator iter = currVO.createRowSetIterator(null);
        Double sum = 0.0;
        int i=0;
        while (iter.next()!=null) {
                sum += Double.parseDouble(iter.getCurrentRow().getAttribute("TotalQuantity")!=null?iter.getCurrentRow().getAttribute("TotalQuantity").toString():"0.0");
        }
        /*if (rows.length>0) {
            System.out.println("length = "+rows.length);
            for (int i=0;i<rows.length;i++) {
                sum = sum + Double.parseDouble(rows[i].getAttribute("TotalQuantity")!=null?rows[i].getAttribute("TotalQuantity").toString():"0.0");
                System.out.println("sum = "+sum);
            }
//            System.out.println("sum = "+sum);
        }
        return sum+changedValue;
    }*/

    public void setTotalQtyInputText(RichInputText totalQtyInputText) {
        this.totalQtyInputText = totalQtyInputText;
    }

    public RichInputText getTotalQtyInputText() {
        return totalQtyInputText;
    }

    public void saveChanges(ActionEvent actionEvent) {
        // Add event code here...
        ApplicationModuleImpl am = getApplicationModule();
        ViewObject currHeadersVO = am.findViewObject("PwcOdmGradingWeavingHeadersVO1");
        ViewObject currLinesVO = am.findViewObject("PwcOdmGradingWaveingLinesVO1");
        Double qtyReceivedLooming = Double.parseDouble(currHeadersVO.getCurrentRow().getAttribute("QtyReceivedLooming")!=null?currHeadersVO.getCurrentRow().getAttribute("QtyReceivedLooming").toString():"0.0");
        Double sumTotalQtyValue = Double.parseDouble(currHeadersVO.getCurrentRow().getAttribute("SUMTOTQTY")!=null?currHeadersVO.getCurrentRow().getAttribute("SUMTOTQTY").toString():"0.0");
        if (sumTotalQtyValue.compareTo(qtyReceivedLooming)==1)
            showMessage("Sum of Total Quantities cannot exceed Quantity Received for Looming", 112);
        else am.getTransaction().commit();
    }

    public void deleteSelectedRows(ActionEvent actionEvent) {
        ApplicationModuleImpl am = getApplicationModule();
        ViewObject linesVO = am.findViewObject("PwcOdmGradingWaveingLinesVO1");
        RowSetIterator rsi = linesVO.createRowSetIterator(null);
        while (rsi.next()!=null) {
            Row currRow = rsi.getCurrentRow();
            /*if ((Boolean)currRow.getAttribute("SelectedRow")==true)
                currRow.remove();*/
            System.out.println("selected row = "+currRow.getAttribute("SelectedRow")); 
        }
        rsi.closeRowSetIterator();
        am.getDBTransaction().commit();
    }
}
