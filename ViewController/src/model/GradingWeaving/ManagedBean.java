package model.GradingWeaving;

import java.sql.SQLException;

import java.sql.Types;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import model.GradingWeaving.AM.PwcOdmGradingWeavingAMImpl;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCDataControl;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.input.RichInputListOfValues;
import oracle.adf.view.rich.component.rich.input.RichInputText;

import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.event.ReturnPopupEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;

import oracle.jbo.server.ApplicationModuleImpl;
import oracle.adf.view.rich.event.DialogEvent.Outcome;

public class ManagedBean {
    private RichInputText totalQtyInputText;
    private RichInputListOfValues jobLov;
    private RichPopup completeJobPopup;
    private RichPopup returnJobPopup;

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
            String rollNumbers = "";
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
                    if (rsi.getCurrentRowIndex()==0)
                        rollNumbers = rollNumbers + currRow.getAttribute("RollNumber");
                    else rollNumbers = rollNumbers + ","+currRow.getAttribute("RollNumber");
            //                System.out.println("currRowIndex = "+currVO.getC);
                    isValid = false;
                }
            }
            if (isValid)
                am.getTransaction().commit();
            else {
                String message = "Sum of Grade Quantities must be equal to Total Quantity: Roll Number(s) = "+rollNumbers;
                showMessage(message,112);
            }
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
                if (currRow.getAttribute("RequestStatus")!=null)
                {
                    if(currRow.getAttribute("RequestStatus").equals("S"))
                        showMessage("Completed Line(s) cannot be deleted",112);
                    else 
                    {
                        if ((Boolean)currRow.getAttribute("SelectedRow")==true)
                            currRow.remove();
                    }
                }
                else 
                {
                    if ((Boolean)currRow.getAttribute("SelectedRow")==true)
                        currRow.remove();
                }
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
        if (isJobCompleted())
            showMessage("Job cannot be deleted because it's completed", 112);
        else
        {
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
    }

    public void setJobLov(RichInputListOfValues jobLov) {
        this.jobLov = jobLov;
    }

    public RichInputListOfValues getJobLov() {
        return jobLov;
    }

    public void setCompleteJobPopup(RichPopup completeJobPopup) {
        this.completeJobPopup = completeJobPopup;
    }

    public RichPopup getCompleteJobPopup() {
        return completeJobPopup;
    }
    
    public void setReturnJobPopup(RichPopup returnJobPopup) {
        this.returnJobPopup = returnJobPopup;
    }

    public RichPopup getReturnJobPopup() {
        return returnJobPopup;
    }
    
    public void completeJobAPIActionListener(ActionEvent actionEvent) {
        if (isJobCompleted()) {
            showMessage("Job already completed.", 112);
        }
        else
        {
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            completeJobPopup.show(hints);
        }
    }
    
    public void returnJobAPIActionListener(ActionEvent actionEvent) {
        if (checkIfAnyRowSelected())
        {
            if (isJobReturned()) {
                showMessage("Job not completed yet", 112);
            }
            else
            {
                RichPopup.PopupHints hints = new RichPopup.PopupHints();
                returnJobPopup.show(hints);
            }
        }
        else showMessage("No line(s) selected", 112);
    }
    
    public Boolean isJobCompleted() {
        Boolean result = true;
        ApplicationModuleImpl am = getApplicationModule();
        ViewObject gradingWaveingLinesVO = am.findViewObject("PwcOdmGradingWaveingLinesVO1");
        RowSetIterator rsi = gradingWaveingLinesVO.createRowSetIterator(null);
        while (rsi.next()!=null) {
            Row currRow = rsi.getCurrentRow();
            if (currRow.getAttribute("RequestStatus")==null) {
                result = false;
                break;
            }
            else if (currRow.getAttribute("RequestStatus").equals("R"))
            {
                result = false;
                break;
            }
        }
        return result;
    }

    public Boolean isJobReturned() {
        Boolean result = true;
        ApplicationModuleImpl am = getApplicationModule();
        ViewObject gradingWaveingLinesVO = am.findViewObject("PwcOdmGradingWaveingLinesVO1");
        RowSetIterator rsi = gradingWaveingLinesVO.createRowSetIterator(null);
        while (rsi.next()!=null) {
            Row currRow = rsi.getCurrentRow();
            if ((Boolean)currRow.getAttribute("SelectedRow")==Boolean.TRUE)
            {
                if (currRow.getAttribute("RequestStatus").equals("S")) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public void completeJobDialogListener(DialogEvent dialogEvent) {
        Outcome outcome = dialogEvent.getOutcome();
        if (outcome == Outcome.yes) {
            ApplicationModuleImpl am = getApplicationModule();
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
                OperationBinding operationBinding = bindings.getOperationBinding("callAPIProc");
                Map params =  operationBinding.getParamsMap();
                params.put("sqlReturnType", Types.VARCHAR);
                params.put("stmt", stmt);
                params.put("requestStatus", "S");
                String result =(String) operationBinding.execute();
                    System.out.println("result = "+result);
                if (result != null) {
                    if (result.equals("SUCCESSFUL"))
                        showMessage("Job Completed Successfully!", 111);
                    else
                        showMessage(result+"", 112);
                }
            }
            else showMessage("No job found", 112);
            completeJobPopup.hide();
        }
        else {
            completeJobPopup.hide();
        }
    }

    public void returnJobDialogListener(DialogEvent dialogEvent) {
        Outcome outcome = dialogEvent.getOutcome();
        if (outcome == Outcome.yes) {
            ApplicationModuleImpl am = getApplicationModule();
            ViewObject currHeadersVO = am.findViewObject("PwcOdmGradingWeavingHeadersVO1");
            Row currRow = currHeadersVO.getCurrentRow();
            if (currRow!=null)
            {
                String jobId = currRow.getAttribute("JobId").toString();
                String stmt = "PWC_ODM_WO_LESS_RET_WEAV_API(? " +
                    ",?" +
                    ",?" +
                    ",?" +
                    ",?" +
                    ",?" +          
                    ",?)";
                BindingContainer bindings = getBindingsCont();
                OperationBinding operationBinding = bindings.getOperationBinding("callAPIProc");
                Map params =  operationBinding.getParamsMap();
                params.put("sqlReturnType", Types.VARCHAR);
                params.put("stmt", stmt);
                params.put("requestStatus", "R");
                String result =(String) operationBinding.execute();
                    System.out.println("result = "+result);
                if (result != null) {
                    if (result.equals("SUCCESSFUL"))
                        showMessage("Line(s) Returned Successfully!", 111);
                    else
                        showMessage(result+"", 112);
                }
            }
            else showMessage("No job found", 112);
            returnJobPopup.hide();
        }
        else {
            returnJobPopup.hide();
        }
    }
    
    public Boolean checkIfAnyRowSelected() {
        Boolean result = false;
        ApplicationModuleImpl am = getApplicationModule();
        ViewObject gradingWaveingLinesVO = am.findViewObject("PwcOdmGradingWaveingLinesVO1");
        RowSetIterator rsi = gradingWaveingLinesVO.createRowSetIterator(null);
        while (rsi.next()!=null) {
            Row currRow = rsi.getCurrentRow();
            if ((Boolean)currRow.getAttribute("SelectedRow")==Boolean.TRUE)
            {
                result = true;
                break;
            }
        }
        return result;
    }
}
