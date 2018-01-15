package model.GradingWeaving.AM;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import model.GradingWeaving.AM.common.PwcOdmGradingWeavingAM;
import model.GradingWeaving.VO.PwcOdmGradingWaveingLinesVOImpl;
import model.GradingWeaving.VO.PwcOdmGradingWeavingHeadersVOImpl;

import oracle.adf.share.ADFContext;

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
}
