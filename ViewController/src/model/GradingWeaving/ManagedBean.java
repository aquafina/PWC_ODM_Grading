package model.GradingWeaving;

import java.sql.SQLException;

import java.sql.Types;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import javax.faces.validator.ValidatorException;

import model.GradingWeaving.AM.PwcOdmGradingWeavingAMImpl;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCDataControl;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputListOfValues;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adf.view.rich.event.ReturnPopupEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;

import oracle.jbo.server.ApplicationModuleImpl;

public class ManagedBean {
    private RichInputText totalQtyInputText;
    private RichInputListOfValues jobLov;

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
    public static PwcOdmGradingWeavingAMImpl getApplicationModule() {
        FacesContext fctx = FacesContext.getCurrentInstance();
        BindingContext bindingContext = BindingContext.getCurrent();
        DCDataControl dc = bindingContext.findDataControl("PwcOdmGradingWeavingAMDataControl");
        return (PwcOdmGradingWeavingAMImpl)dc.getDataProvider();
        }
    public void saveChanges(ActionEvent actionEvent) {
        // Add event code here...
        ApplicationModuleImpl am = getApplicationModule();
        ViewObject currHeadersVO = am.findViewObject("PwcOdmGradingWeavingHeadersVO1");
        ViewObject currLinesVO = am.findViewObject("PwcOdmGradingWaveingLinesVO1");
        Row currRow = currHeadersVO.getCurrentRow();
        System.out.println("total Grade D = "+currLinesVO.getCurrentRow().getAttribute("TotalGraded"));
        System.out.println("Grade D = "+currLinesVO.getCurrentRow().getAttribute("Graded"));
        String jobId = currRow.getAttribute("JobId").toString();
        Double qtyReceivedLooming = Double.parseDouble(currHeadersVO.getCurrentRow().getAttribute("QtyReceivedLooming")!=null?currHeadersVO.getCurrentRow().getAttribute("QtyReceivedLooming").toString():"0.0");
        Double sumTotalQtyValue = Double.parseDouble(currHeadersVO.getCurrentRow().getAttribute("SUMTOTQTY")!=null?currHeadersVO.getCurrentRow().getAttribute("SUMTOTQTY").toString():"0.0");
        if (sumTotalQtyValue.compareTo(qtyReceivedLooming)==1)
            showMessage("Sum of Total Quantities cannot exceed Quantity Received for Looming", 112);
        else {
            RowSetIterator rsi = currLinesVO.createRowSetIterator(null);
            boolean isValid = true;
            while(rsi.next()!=null) {
            currRow = rsi.getCurrentRow();
            currRow.setAttribute("Graded", currRow.getAttribute("TotalGraded"));
            Double totalQty = Double.parseDouble(currRow.getAttribute("TotalQuantity")!=null?currRow.getAttribute("TotalQuantity").toString():"0.0");
            Double gradeAQty = Double.parseDouble(currRow.getAttribute("Gradea")!=null?currRow.getAttribute("Gradea").toString():"0.0");
            Double gradeBQty = Double.parseDouble(currRow.getAttribute("Gradeb")!=null?currRow.getAttribute("Gradeb").toString():"0.0");
            Double gradeCQty = Double.parseDouble(currRow.getAttribute("Gradec")!=null?currRow.getAttribute("Gradec").toString():"0.0");
            Double gradeD0to1Qty = Double.parseDouble(currRow.getAttribute("Attribute1")!=null?currRow.getAttribute("Attribute1").toString():"0.0");
            Double gradeD1to5Qty = Double.parseDouble(currRow.getAttribute("Attribute2")!=null?currRow.getAttribute("Attribute2").toString():"0.0");
            Double gradeD6to19Qty = Double.parseDouble(currRow.getAttribute("Attribute3")!=null?currRow.getAttribute("Attribute3").toString():"0.0");
            Double gradeD20AboveQty = Double.parseDouble(currRow.getAttribute("Attribute4")!=null?currRow.getAttribute("Attribute4").toString():"0.0");
            Double totalGradeQuantities = gradeAQty + gradeBQty + gradeCQty + gradeD0to1Qty + gradeD1to5Qty + gradeD6to19Qty + gradeD20AboveQty;
            //        System.out.println("totalGradeQuantities = "+totalGradeQuantities);
                if (totalGradeQuantities.compareTo(totalQty)!=0) {
                    System.out.println("totalGradeQuantities = "+totalGradeQuantities);
                    System.out.println("totalQty = "+totalQty);
            //                System.out.println("currRowIndex = "+currVO.getC);
                    String message = "Sum of Grade Quantities must be equal to Total Quantity: Line "+rsi.getCurrentRowIndex()+1;
                    showMessage(message,112);
                    isValid = false;
                    break;
                }
            }
            if (isValid)
                am.getTransaction().commit();
            rsi.closeRowSetIterator();
        }
    }

    public void insertRowBeforePageLoad() {
        ApplicationModuleImpl am = getApplicationModule();
        ViewObject currHeadersVO = am.findViewObject("PwcOdmGradingWeavingHeadersVO1");
        RowSetIterator rsi = currHeadersVO.createRowSetIterator(null);
        Row lastRow = rsi.last();
        int lastRowIndex = rsi.getRangeIndexOf(lastRow);
        Row newRow = rsi.createRow();
        newRow.setNewRowState(Row.STATUS_INITIALIZED);
        rsi.insertRowAtRangeIndex(0, newRow); 
        rsi.setCurrentRow(newRow);      
    }

    public void deleteSelectedRows(ActionEvent actionEvent) {
        ApplicationModuleImpl am = getApplicationModule();
        ViewObject linesVO = am.findViewObject("PwcOdmGradingWaveingLinesVO1");
        RowSetIterator rsi = linesVO.createRowSetIterator(null);
        while (rsi.next()!=null) {
            Row currRow = rsi.getCurrentRow();
            if(currRow.getAttribute("SelectedRow")!=null)
            {
                if ((Boolean)currRow.getAttribute("SelectedRow")==true)
                    currRow.remove();
            }
        }
        rsi.closeRowSetIterator();
        am.getDBTransaction().commit();
    }
    
    public String onRowCreate() {
     BindingContainer bindings = BindingContext.getCurrent().getCurrentBindingsEntry();
     //access the name of the iterator the table is bound to. Its "allDepartmentsIterator"
     //in this sample
     DCIteratorBinding dciter = (DCIteratorBinding) bindings.get("allDepartmentsIterator");
     //access the underlying RowSetIterator
     RowSetIterator rsi = dciter.getRowSetIterator();
     //get handle to the last row
     Row lastRow = rsi.last();
     //obtain the index of the last row
     int lastRowIndex = rsi.getRangeIndexOf(lastRow);
     //create a new row
     Row newRow = rsi.createRow();
     //initialize the row
     newRow.setNewRowState(Row.STATUS_INITIALIZED);
     //add row to last index + 1 so it becomes last in the range set
     rsi.insertRowAtRangeIndex(lastRowIndex +1, newRow); 
     //make row the current row so it is displayed correctly
     rsi.setCurrentRow(newRow);                          
     return null;
    }  
    
    public void setTotalQtyInputText(RichInputText totalQtyInputText) {
        this.totalQtyInputText = totalQtyInputText;
    }

    public RichInputText getTotalQtyInputText() {
        return totalQtyInputText;
    }

    public void deleteHeaderRow(ActionEvent actionEvent) {
        ApplicationModuleImpl am = getApplicationModule();
        ViewObject currHeadersVO = am.findViewObject("PwcOdmGradingWeavingHeadersVO1");
        ViewObject linesVO = am.findViewObject("PwcOdmGradingWaveingLinesVO1");
        RowSetIterator rsi = linesVO.createRowSetIterator(null);
        System.out.println("lines = "+rsi.getAllRowsInRange().length);
        if (linesVO.getAllRowsInRange().length>0)
            showMessage("Delete all lines before deleting the header", 112);
//            System.out.println("Delete all lines before deleting the header");        
        else
        {
            currHeadersVO.getCurrentRow().remove();
            am.getDBTransaction().commit();
            rsi = currHeadersVO.createRowSetIterator(null);
            Row lastRow = rsi.last();
            int lastRowIndex = rsi.getRangeIndexOf(lastRow);
            Row newRow = rsi.createRow();
            newRow.setNewRowState(Row.STATUS_INITIALIZED);
            rsi.insertRowAtRangeIndex(0, newRow); 
            rsi.setCurrentRow(newRow);      
        }
    }
    public void completeJobAPIActionListener(ActionEvent actionEvent) {
        /*ApplicationModuleImpl am = getApplicationModule();
        ViewObject currHeadersVO = am.findViewObject("PwcOdmGradingWeavingHeadersVO1");
        Row currRow = currHeadersVO.getCurrentRow();
        if (currRow!=null)
        {
            String jobId = currRow.getAttribute("JobId").toString();
            String stmt = "PWC_ODM_WO_LESS_COMPL_WEAV_API(? " +
                ",?" +
                ",?" +
                ",?" +
                ",?" +
                ",?" +          
                ",?)";
            BindingContainer bindings = getBindingsCont();
            OperationBinding operationBinding = bindings.getOperationBinding("callJobCompleteProc");
            Map params =  operationBinding.getParamsMap();
            params.put("sqlReturnType", Types.VARCHAR);
            params.put("stmt", stmt);
            String result =(String) operationBinding.execute();
                System.out.println("result = "+result);
            if (result != null) {
                if (result.equals("SUCCESSFUL"))
                    showMessage(result+"", 111);
                else
                    showMessage(result+"", 112);
            }
        }*/
    }

    public void setJobLov(RichInputListOfValues jobLov) {
        this.jobLov = jobLov;
    }

    public RichInputListOfValues getJobLov() {
        return jobLov;
    }
}
