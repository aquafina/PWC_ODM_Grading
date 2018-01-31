package model.GradingWeaving.AM;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import model.GradingWeaving.AM.common.PwcOdmGradingWeavingAM;
import model.GradingWeaving.VO.PwcOdmGradingWaveingLinesVOImpl;
import model.GradingWeaving.VO.PwcOdmGradingWeavingHeadersVOImpl;

import oracle.adf.share.ADFContext;

import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewLinkImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Oct 06 11:45:34 EDT 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PwcOdmGradingWeavingAMImpl extends ApplicationModuleImpl implements PwcOdmGradingWeavingAM {
    /**
     * This is the default constructor (do not remove).
     */
    public PwcOdmGradingWeavingAMImpl() {
    }

    /**
     * Container's getter for PwcOdmGradingWeavingHeadersVO1.
     * @return PwcOdmGradingWeavingHeadersVO1
     */
    public PwcOdmGradingWeavingHeadersVOImpl getPwcOdmGradingWeavingHeadersVO1() {
        return (PwcOdmGradingWeavingHeadersVOImpl)findViewObject("PwcOdmGradingWeavingHeadersVO1");
    }

    /**
     * Container's getter for PwcOdmGradingWaveingLinesVO1.
     * @return PwcOdmGradingWaveingLinesVO1
     */
    public PwcOdmGradingWaveingLinesVOImpl getPwcOdmGradingWaveingLinesVO1() {
        return (PwcOdmGradingWaveingLinesVOImpl)findViewObject("PwcOdmGradingWaveingLinesVO1");
    }

    /**
     * Container's getter for PwcOdmGradingWeavingHeaderLinesVL1.
     * @return PwcOdmGradingWeavingHeaderLinesVL1
     */
    public ViewLinkImpl getPwcOdmGradingWeavingHeaderLinesVL1() {
        return (ViewLinkImpl)findViewLink("PwcOdmGradingWeavingHeaderLinesVL1");
    }
    
    // Exceed Total Quantity Method Start

    public void Exceed_TOTALQTY() {

      /*  Double Qty_Rec_Looming = 0.0;
        Double Total_D = 0.0;
        Double TotalQuantity_D = 0.00;

        getDBTransaction().commit();

        System.out.println("In Exceed_TOTALQTY method.... ");

        ViewObject hvo = this.getPwcOdmGradingWeavingHeadersVO1() ;
        // get Quantity in header
        try {
             Qty_Rec_Looming = Double.parseDouble(hvo.getCurrentRow().getAttribute("QtyReceivedLooming").toString());
        }

        catch (Exception ee)
        {   Qty_Rec_Looming = 0.0; }

        System.out.println("Qty_Rec_Looming  .... "+Qty_Rec_Looming);

        ViewObject lvo = this.getPwcOdmGradingWaveingLinesVO1();
        oracle.jbo.RowSetIterator lvoit = lvo.createRowSetIterator("lvoit");

        while (lvoit.hasNext()) {

            Row linesNext = lvoit.next();
            String LineId = null;
            //TotalQuantity_D = 0.00;
            // get id in grading line
            try {
                LineId = linesNext.getAttribute("LineId").toString();
            } catch (Exception e) { ;}
            
            System.out.println("line ID.... " + LineId);
            // get Quantity in grading line
            try {
                Total_D =Double.parseDouble(linesNext.getAttribute("TotalQuantity").toString());
                     System.out.println("Total at line is....Total_D1 " + Total_D);
                 }
             catch (Exception ee)
            {   Total_D = 0.0; }
            
            TotalQuantity_D = Total_D + TotalQuantity_D;
            
            System.out.println("Total at line is.... Total_D" + Total_D);
            System.out.println("Total at line is....TotalQuantity_D " + TotalQuantity_D);
             
             if (TotalQuantity_D > Qty_Rec_Looming) {
                  // Display Warning
               FacesContext context = FacesContext.getCurrentInstance();
                  FacesMessage message =  new FacesMessage(FacesMessage.SEVERITY_ERROR, "Quantity must not exceed from Quantity received from Looming ...",  "");
                  context.addMessage(null, message);
               }
             else {  this.getDBTransaction().commit(); }
             
         }
        lvoit.closeRowSetIterator();*/
    }
    
    public void setSessionValues(String orgId, String userId, String respId, String respAppl, String mfgOrgId) {
        
    //        System.out.println(orgId+" "+userId);
        ADFContext.getCurrent().getSessionScope().put("user_id", userId);
        ADFContext.getCurrent().getSessionScope().put("org_id", orgId);
        ADFContext.getCurrent().getSessionScope().put("resp_id", respId);
        ADFContext.getCurrent().getSessionScope().put("resp_appl_id", respAppl);
        ADFContext.getCurrent().getSessionScope().put("mfg_org_id", mfgOrgId);
    }
 // End of AM
    
 public String callJobCompleteProc(int sqlReturnType, String stmt){
     System.out.println(sqlReturnType+ " "+stmt);
     CallableStatement cst = null;
     String status = null;
     int user_id = Integer.parseInt(ADFContext.getCurrent().getSessionScope().get("user_id")!=null?ADFContext.getCurrent().getSessionScope().get("user_id").toString():"0") ;
     int resp_id = Integer.parseInt(ADFContext.getCurrent().getSessionScope().get("resp_id")!=null?ADFContext.getCurrent().getSessionScope().get("resp_id").toString():"0") ;
     String resp_appl_id = ADFContext.getCurrent().getSessionScope().get("resp_appl_id")!=null?ADFContext.getCurrent().getSessionScope().get("resp_appl_id").toString():"0";
     System.out.println("resp_appl_id = "+ADFContext.getCurrent().getSessionScope().get("resp_appl_id"));
     try {
         cst = this.getDBTransaction().createCallableStatement("{CALL " + stmt + " }", 0);
         //Register dataType for return value
         
         //Pass input parameters value
         ViewObject gradingWaveingLinesVO = this.getPwcOdmGradingWaveingLinesVO1();
         Row currRow = gradingWaveingLinesVO.getCurrentRow();
         cst.setInt(1,Integer.parseInt(currRow.getAttribute("GdId").toString()));
         System.out.println("Gd id = "+Integer.parseInt(currRow.getAttribute("GdId").toString()));
         cst.setInt(2,Integer.parseInt(currRow.getAttribute("OrgId").toString()));
         System.out.println("org id = "+Integer.parseInt(currRow.getAttribute("OrgId").toString()));
         cst.setInt(3,1110);
         System.out.println("user id = "+1110);
         cst.setInt(4,resp_id);
         cst.setInt(5,222);
         System.out.println("resp appl id = "+222);
         cst.registerOutParameter(6, sqlReturnType);
         cst.execute();
         //Finally get returned value
         status = cst.getString(6);
         //System.out.println("Receipt status: "+currRow.getAttribute("ReceiptStatus"));
         //getDBTransaction().commit();
     } catch (SQLException e) {
         throw new JboException(e.getMessage());
     } finally {
         if (cst != null) {
             try {
                 cst.close();
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }
     }
     return status;
//     return "";
 }
}
