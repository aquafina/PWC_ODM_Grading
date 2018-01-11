package model.BreakDownPaper.BEAN;

import java.sql.SQLException;

import java.text.DecimalFormat;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.share.ADFContext;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.event.PopupFetchEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.dss.crosstab.Total;

import oracle.jbo.domain.Number;

public class ManagedBean {
    private RichInputText construction1Binding;
    private RichInputText constraction2Binding;
    private RichSelectOneChoice yarnTypeBinding;
    private RichInputText warpYarnCountBinding;
    private RichSelectOneChoice yarnBrandBinding;
    private RichInputText yarnLotBinding;
    private RichSelectOneChoice yarnBlendBinding;
    private RichInputText weftCountBinding;
    private RichInputText weftYarnType;
    private RichSelectOneChoice weftYarnBrandBinding;
    private RichSelectOneChoice weftYarnBlendBinding;
    private RichInputText pileYarnCountBinding;
    private RichInputText pileYarnBrandBinding;
    private RichInputText warpYarnCountBind;
    private RichInputText yarnBrandBind;
    private RichInputText yarnLotBind;
    private RichInputText yarnTypeBind;
    private RichInputText yarnBlendBind;
    private RichInputText weftYarnBrandBind;
    private RichInputText weftYarnBlendBind;
    private RichInputText epiBinding;
    private RichInputText finishWidthBinding;
    private RichInputText selvedgeEndsBinding;
    private RichInputText totalEndsBinding;
    private RichInputText beamWidthBinding;
    private RichInputText reedCountBinding;
    private RichInputText endsDentBinding;
    private RichInputText requiredSizeLengthMtrBinding;
    private RichInputText cwPerBinding;
    private RichInputText orderQtyMtrBinding;
    private RichInputText beamLengthValueChangeListener;
    private RichInputText noOfBeamBinding;
    private RichInputText beamLengthBinding;
    private RichInputText wtOfWarpBinding;
    private RichInputText totalWarpReqBinding;
    private RichInputText greyWidthBinding;
    private RichInputText greyEpiBinding;
    private RichInputText selvedgeSizeMM;
    private RichInputText selvedgeEndsDentBinding;
    private RichInputText selvedgeEndsBothSideBinding;
    private RichInputText loomRpmBinding;
    private RichInputText loomEfficencyBinding;
    private RichInputText greyPpiWeavingBinding;
    private RichInputText transSelvedgeEndsBothBinding;
    private RichInputText loomProdPerDayBinding;
    private RichInputText processLossBinding;
    private RichInputText orderQtyYdsBinding;
    private RichInputText totalWeavableLengthBinding;
    private RichInputText planLoomBinding;
    private RichInputText totalProdPerDayYdsBinding;
    private RichInputText wtOfWeftYarmKgYdsBinding;
    private RichInputText dayReqToFinishBinding;
    private RichInputText totalWeftReqKgBinding;
    private RichInputText reedSpaceBinding;
    private RichInputText transHdrCountRatioBinding;
    private RichInputText countFactBinding;

    public ManagedBean() {
    }

    public void warpCountPopupFetchListener(PopupFetchEvent popupFetchEvent) {
        // Add event code here...
    }

    public void warpDialogListener(DialogEvent dialogEvent) {
        // Add event code here...
        if(dialogEvent.getOutcome().name().equals("ok")){
            BindingContext bindingContext1 = BindingContext.getCurrent();
            BindingContainer bindingContainer1 =  bindingContext1.getCurrentBindingsEntry();
            OperationBinding ob = bindingContainer1.getOperationBinding("warpDialogListener");
            // system.out.println("OK....");
            ob.execute();
            AdfFacesContext adfFaceContext = AdfFacesContext.getCurrentInstance();
            adfFaceContext.addPartialTarget(this.getConstruction1Binding());
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getWarpYarnCountBind());
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getYarnTypeBind());
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getYarnBlendBind());
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getYarnBrandBind());
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getYarnLotBind());
            
            double result =  this.getWtOfWarpKgYrd() ;
            try{
                this.getWtOfWarpBinding().setValue(new Number(result));
            }catch(SQLException e){
                this.getWtOfWarpBinding().setValue(new Number(0));    
            }            
            AdfFacesContext.getCurrentInstance().addPartialTarget(this.getWtOfWarpBinding());
        }
        else if(dialogEvent.getOutcome().name().equals("cancel")){
            ;
        }
    }

    public void setConstruction1Binding(RichInputText construction1Binding) {
        this.construction1Binding = construction1Binding;
    }

    public RichInputText getConstruction1Binding() {
        return construction1Binding;
    }

    public void weftDialogListener(DialogEvent dialogEvent) {
        // Add event code here...
        if(dialogEvent.getOutcome().name().equals("ok")){
            BindingContext bindingContext1 = BindingContext.getCurrent();
            BindingContainer bindingContainer1 =  bindingContext1.getCurrentBindingsEntry();
            OperationBinding ob = bindingContainer1.getOperationBinding("weftDialogListener");
            // system.out.println("OK....");
            ob.execute();
            AdfFacesContext adfFaceContext = AdfFacesContext.getCurrentInstance();
            adfFaceContext.addPartialTarget(this.getConstraction2Binding());
            adfFaceContext.addPartialTarget(this.getWeftCountBinding());
            adfFaceContext.addPartialTarget(this.getWeftYarnBlendBind());
            adfFaceContext.addPartialTarget(this.getWeftYarnBrandBind());
            adfFaceContext.addPartialTarget(this.getWeftYarnType());
        }
        else if(dialogEvent.getOutcome().name().equals("cancel")){
            ;
        }
    }

    public void setConstraction2Binding(RichInputText constraction2Binding) {
        this.constraction2Binding = constraction2Binding;
    }

    public RichInputText getConstraction2Binding() {
        return constraction2Binding;
    }

    public void setYarnTypeBinding(RichSelectOneChoice yarnTypeBinding) {
        this.yarnTypeBinding = yarnTypeBinding;
    }

    public RichSelectOneChoice getYarnTypeBinding() {
        return yarnTypeBinding;
    }

    public void setWarpYarnCountBinding(RichInputText warpYarnCountBinding) {
        this.warpYarnCountBinding = warpYarnCountBinding;
    }

    public RichInputText getWarpYarnCountBinding() {
        return warpYarnCountBinding;
    }

    public void setYarnBrandBinding(RichSelectOneChoice yarnBrandBinding) {
        this.yarnBrandBinding = yarnBrandBinding;
    }

    public RichSelectOneChoice getYarnBrandBinding() {
        return yarnBrandBinding;
    }

    public void setYarnLotBinding(RichInputText yarnLotBinding) {
        this.yarnLotBinding = yarnLotBinding;
    }

    public RichInputText getYarnLotBinding() {
        return yarnLotBinding;
    }

    public void setYarnBlendBinding(RichSelectOneChoice yarnBlendBinding) {
        this.yarnBlendBinding = yarnBlendBinding;
    }

    public RichSelectOneChoice getYarnBlendBinding() {
        return yarnBlendBinding;
    }

    public void setWeftCountBinding(RichInputText weftCountBinding) {
        this.weftCountBinding = weftCountBinding;
    }

    public RichInputText getWeftCountBinding() {
        return weftCountBinding;
    }

    public void setWeftYarnType(RichInputText weftYarnType) {
        this.weftYarnType = weftYarnType;
    }

    public RichInputText getWeftYarnType() {
        return weftYarnType;
    }

    public void setWeftYarnBrandBinding(RichSelectOneChoice weftYarnBrandBinding) {
        this.weftYarnBrandBinding = weftYarnBrandBinding;
    }

    public RichSelectOneChoice getWeftYarnBrandBinding() {
        return weftYarnBrandBinding;
    }

    public void setWeftYarnBlendBinding(RichSelectOneChoice weftYarnBlendBinding) {
        this.weftYarnBlendBinding = weftYarnBlendBinding;
    }

    public RichSelectOneChoice getWeftYarnBlendBinding() {
        return weftYarnBlendBinding;
    }

    public void pileYarnCountDialogListener(DialogEvent dialogEvent) {
        // Add event code here...
        if(dialogEvent.getOutcome().name().equals("ok"))
        {
            BindingContext bindingContext1 = BindingContext.getCurrent();
            BindingContainer bindingContainer1 =  bindingContext1.getCurrentBindingsEntry();
            OperationBinding ob = bindingContainer1.getOperationBinding("pileYarnCountDialogListener");
            // system.out.println("OK....");
            ob.execute();
            AdfFacesContext adfFaceContext = AdfFacesContext.getCurrentInstance();
            adfFaceContext.addPartialTarget(this.getPileYarnCountBinding());
            adfFaceContext.addPartialTarget(this.getPileYarnBrandBinding());
        }
        else if(dialogEvent.getOutcome().name().equals("cancel"))
        {
            ;
        }
    }

    public void setPileYarnCountBinding(RichInputText pileYarnCountBinding) {
        this.pileYarnCountBinding = pileYarnCountBinding;
    }

    public RichInputText getPileYarnCountBinding() {
        return pileYarnCountBinding;
    }

    public void setPileYarnBrandBinding(RichInputText pileYarnBrandBinding) {
        this.pileYarnBrandBinding = pileYarnBrandBinding;
    }

    public RichInputText getPileYarnBrandBinding() {
        return pileYarnBrandBinding;
    }

    public void setWarpYarnCountBind(RichInputText warpYarnCountBind) {
        this.warpYarnCountBind = warpYarnCountBind;
    }

    public RichInputText getWarpYarnCountBind() {
        return warpYarnCountBind;
    }

    public void setYarnBrandBind(RichInputText yarnBrandBind) {
        this.yarnBrandBind = yarnBrandBind;
    }

    public RichInputText getYarnBrandBind() {
        return yarnBrandBind;
    }

    public void setYarnLotBind(RichInputText yarnLotBind) {
        this.yarnLotBind = yarnLotBind;
    }

    public RichInputText getYarnLotBind() {
        return yarnLotBind;
    }

    public void setYarnTypeBind(RichInputText yarnTypeBind) {
        this.yarnTypeBind = yarnTypeBind;
    }

    public RichInputText getYarnTypeBind() {
        return yarnTypeBind;
    }

    public void setYarnBlendBind(RichInputText yarnBlendBind) {
        this.yarnBlendBind = yarnBlendBind;
    }

    public RichInputText getYarnBlendBind() {
        return yarnBlendBind;
    }

    public void setWeftYarnBrandBind(RichInputText weftYarnBrandBind) {
        this.weftYarnBrandBind = weftYarnBrandBind;
    }

    public RichInputText getWeftYarnBrandBind() {
        return weftYarnBrandBind;
    }

    public void setWeftYarnBlendBind(RichInputText weftYarnBlendBind) {
        this.weftYarnBlendBind = weftYarnBlendBind;
    }

    public RichInputText getWeftYarnBlendBind() {
        return weftYarnBlendBind;
    }

    public void setEpiBinding(RichInputText epiBinding) {
        this.epiBinding = epiBinding;
    }

    public RichInputText getEpiBinding() {
        return epiBinding;
    }

    public void epiValueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        double result = this.getTotalEnds();
        try{
            this.getTotalEndsBinding().setValue(new Number(result));
        }catch(SQLException e){
            this.getTotalEndsBinding().setValue(new Number(0));    
        }
        //AdfFacesContext.getCurrentInstance().addPartialTarget(this.getTotalEndsBinding());
        result = this.getBeamWidth();
        try{
            this.getBeamWidthBinding().setValue(new Number(result));
        }catch(SQLException e){
            this.getBeamWidthBinding().setValue(new Number(0));    
        }
    }


    public void setFinishWidthBinding(RichInputText finishWidthBinding) {
        this.finishWidthBinding = finishWidthBinding;
    }

    public RichInputText getFinishWidthBinding() {
        return finishWidthBinding;
    }

    public void setSelvedgeEndsBinding(RichInputText selvedgeEndsBinding) {
        this.selvedgeEndsBinding = selvedgeEndsBinding;
    }

    public RichInputText getSelvedgeEndsBinding() {
        return selvedgeEndsBinding;
    }
    
    public double getTotalEnds(){
        double epi = 0.00;
        double finishWidth = 0.00;
        double selvedgeEnds = 0.00;
        try{
            epi = Double.parseDouble(this.getEpiBinding().getValue().toString());
        }
        catch(NullPointerException e){
            epi = 0.00;
        }
        try{
            finishWidth = Double.parseDouble(this.getFinishWidthBinding().getValue().toString());
        }catch(NullPointerException e){
            finishWidth = 0.00;
        }
        try{
            selvedgeEnds = Double.parseDouble(this.getSelvedgeEndsBinding().getValue().toString());    
        }catch(NullPointerException e){
            selvedgeEnds = 0.00;
        }
        double result = Math.ceil((epi * finishWidth) + selvedgeEnds) ;
        return result;
    }

    public void setTotalEndsBinding(RichInputText totalEndsBinding) {
        this.totalEndsBinding = totalEndsBinding;
    }

    public RichInputText getTotalEndsBinding() {
        return totalEndsBinding;
    }

    public void finishWidthValueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        double result = this.getTotalEnds();
        try{
            this.getTotalEndsBinding().setValue(new Number(result));
        }catch(SQLException e){
            this.getTotalEndsBinding().setValue(new Number(0));;    
        }
        result = this.getBeamWidth();
        try{
            this.getBeamWidthBinding().setValue(new Number(result));
        }catch(SQLException e){
            this.getBeamWidthBinding().setValue(new Number(0));    
        }
    }

    public void selvedgeEndsValueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        double result = this.getTotalEnds();
        try{
            this.getTotalEndsBinding().setValue(new Number(result));
        }catch(SQLException e){
            this.getTotalEndsBinding().setValue(0);    
        }
        result = this.getBeamWidth();
        try{
            this.getBeamWidthBinding().setValue(new Number(result));
        }catch(SQLException e){
            this.getBeamWidthBinding().setValue(new Number(0));    
        }
        result = this.getGreyEPI();
        try{
            this.getGreyEpiBinding().setValue(new Number(result));
        }catch(SQLException e)
        {
            this.getGreyEpiBinding().setValue(new Number(0));    
        }
        result = this.getReedSpace();
        try{
            this.getReedSpaceBinding().setValue(new Number(result));
        }catch(SQLException e)
        {
            this.getReedSpaceBinding().setValue(new Number(0));    
        }
    }

    public void totalEndsValueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if(valueChangeEvent.getNewValue() == null){
            this.getBeamWidthBinding().setValue(new Number(0));
        }else if(Double.parseDouble(valueChangeEvent.getNewValue().toString()) == 0){
            this.getBeamWidthBinding().setValue(new Number(0));
        }else{
            double result = this.getBeamWidth();
            try{
                this.getBeamWidthBinding().setValue(new Number(result));
            }catch(SQLException e){
                this.getBeamWidthBinding().setValue(new Number(0));    
            }
            result = this.getGreyEPI();
            try{
                this.getGreyEpiBinding().setValue(new Number(result));
            }catch(SQLException e)
            {
                this.getGreyEpiBinding().setValue(new Number(0));    
            }
            result = this.getWtOfWarpKgYrd() ;
            try{
                this.getWtOfWarpBinding().setValue(new Number(result));
            }catch(SQLException e){
                this.getWtOfWarpBinding().setValue(new Number(0));    
            }            
        }
        double result = this.getReedSpace();
        try
        {
            this.getReedSpaceBinding().setValue(new Number(result));
        }catch(SQLException e){
            this.getReedSpaceBinding().setValue(new Number(0));
        }
        
    }

    public void setBeamWidthBinding(RichInputText beamWidthBinding) {
        this.beamWidthBinding = beamWidthBinding;
    }

    public RichInputText getBeamWidthBinding() {
        return beamWidthBinding;
    }

    public void reedCountValueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        System.out.println("reedCountValueChangeListener");
        System.out.println("New Value "+valueChangeEvent.getNewValue());
        if(valueChangeEvent.getNewValue() == null){
            this.getBeamWidthBinding().setValue(new Number(0));
            this.getSelvedgeEndsBothSideBinding().setValue(new Number(0));    
        }else if(Double.parseDouble(valueChangeEvent.getNewValue().toString()) == 0){
            this.getBeamWidthBinding().setValue(new Number(0));
            this.getSelvedgeEndsBothSideBinding().setValue(new Number(0));    
        }else{
            double result = this.getBeamWidth();
            try{
                this.getBeamWidthBinding().setValue(new Number(result));
            }catch(SQLException e){
                this.getBeamWidthBinding().setValue(new Number(0));    
            }
            result = this.getSelvedgeEndsBothside();
            try{
                this.getSelvedgeEndsBothSideBinding().setValue(new Number(result));
            }catch(SQLException e)
            {
                this.getSelvedgeEndsBothSideBinding().setValue(new Number(0));    
            }
            result = this.getReedSpace();
            try{
                this.getReedSpaceBinding().setValue(new Number(result));
            }catch(SQLException e)
            {
                this.getReedSpaceBinding().setValue(new Number(0));    
            }
        }
    }

    public void setReedCountBinding(RichInputText reedCountBinding) {
        this.reedCountBinding = reedCountBinding;
    }

    public RichInputText getReedCountBinding() {
        return reedCountBinding;
    }

    public void endsDentValueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if(valueChangeEvent.getNewValue() == null){
            this.getBeamWidthBinding().setValue(new Number(0));
        }else if(Double.parseDouble(valueChangeEvent.getNewValue().toString()) == 0){
            this.getBeamWidthBinding().setValue(new Number(0));
        }else{
            double result = this.getBeamWidth();
            try{
                this.getBeamWidthBinding().setValue(new Number(result));
            }catch(SQLException e){
                this.getBeamWidthBinding().setValue(new Number(0));    
            }
            result = this.getReedSpace();
            try
            {
                this.getReedSpaceBinding().setValue(new Number(result));
            }catch(SQLException e){
                this.getReedSpaceBinding().setValue(new Number(0));
            }
        }
        double result = this.getSelvedgeEnds();
        try
        {
            this.getSelvedgeEndsBinding().setValue(new Number(result));
        }catch(SQLException e){
            this.getSelvedgeEndsBinding().setValue(new Number(0));
        }
    }

    public void setEndsDentBinding(RichInputText endsDentBinding) {
        this.endsDentBinding = endsDentBinding;
    }

    public RichInputText getEndsDentBinding() {
        return endsDentBinding;
    }
    
    public double getBeamWidth(){
        
        double totalEnds = 0.00;
        double reedCount = 0.00;
        double endsDent  = 0.00;
        
        try{
            totalEnds = Double.parseDouble(this.getTotalEndsBinding().getValue().toString());
            System.out.println("totalEnds "+totalEnds);
        }
        catch(NullPointerException e){
            totalEnds = 0.00;
        }
        try{
            reedCount = Double.parseDouble(this.getReedCountBinding().getValue().toString());
            System.out.println("reedCount "+reedCount);
        }catch(NullPointerException e){
            reedCount = 0.00;
        }
        try{
            endsDent = Double.parseDouble(this.getEndsDentBinding().getValue().toString());    
            System.out.println("endsDent "+endsDent);
        }catch(NullPointerException e){
            endsDent = 0.00;
        }
        
        double result = 0.00 ;
        
        try{
            if(reedCount != 0.0 && endsDent != 0.0){
                result = Math.round(((totalEnds * 2) / (reedCount * endsDent) ) * 100.00 ) / 100.00;
            }else{
                result = 0;    
            }
            //result = (totalEnds * 2) / (reedCount * endsDent);
            System.out.println("result "+result);
        }catch(ArithmeticException e){
            result = 0;    
        }
        
        return  result;    
    }

    public void setRequiredSizeLengthMtrBinding(RichInputText requiredSizeLengthMtrBinding) {
        this.requiredSizeLengthMtrBinding = requiredSizeLengthMtrBinding;
    }

    public RichInputText getRequiredSizeLengthMtrBinding() {
        return requiredSizeLengthMtrBinding;
    }

    public void setCwPerBinding(RichInputText cwPerBinding) {
        this.cwPerBinding = cwPerBinding;
    }

    public RichInputText getCwPerBinding() {
        return cwPerBinding;
    }

    public void cwPerValueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        double result = this.getRequiredSizeLengthMtr();
        try{
            this.getRequiredSizeLengthMtrBinding().setValue(new Number(result));
        }catch(SQLException e){
            this.getRequiredSizeLengthMtrBinding().setValue(new Number(0));    
        }
    }

    public void setOrderQtyMtrBinding(RichInputText orderQtyMtrBinding) {
        this.orderQtyMtrBinding = orderQtyMtrBinding;
    }

    public RichInputText getOrderQtyMtrBinding() {
        return orderQtyMtrBinding;
    }

    public void orderQtyMtrValueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        double result = this.getRequiredSizeLengthMtr();
        try{
            this.getRequiredSizeLengthMtrBinding().setValue(new Number(result));
        }catch(SQLException e){
            this.getRequiredSizeLengthMtrBinding().setValue(new Number(0));    
        }
    }
    
    public double getRequiredSizeLengthMtr(){
        
        double result = 0.00;
        double cwPer = 0.00;
        double orderQtyMtr = 0.00;
        try{
            orderQtyMtr = Double.parseDouble(this.getOrderQtyMtrBinding().getValue().toString());
        }catch(Exception e){
            orderQtyMtr = 0.0;
        }
        try{
            cwPer = Double.parseDouble(this.getCwPerBinding().getValue().toString());
        }catch(Exception e){
            cwPer = 0.0;
        }
        
        result = Math.ceil(orderQtyMtr / (1 - cwPer) * 1.09361);
        
        return result;    
    }

    public void rqrdSizeLngthMtrValueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if(valueChangeEvent.getNewValue() == null){
            this.getBeamLengthBinding().setValue(new Number(0));
            this.getTotalWarpReqBinding().setValue(new Number(0));
        }else if(Double.parseDouble(valueChangeEvent.getNewValue().toString()) == 0){
            this.getBeamLengthBinding().setValue(new Number(0));
            this.getTotalWarpReqBinding().setValue(new Number(0));
        }else{
            double result = this.getBeamLength();
            try{
                this.getBeamLengthBinding().setValue(new Number(result));
            }catch(SQLException e){
                this.getBeamLengthBinding().setValue(new Number(0));    
            }
            result = getWtOfWarp();        
            try{
                this.getTotalWarpReqBinding().setValue(new Number(result));
            }catch(SQLException e){
                ;    
            }
        }
    }
    
    

    public void noOfBeamValueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if(valueChangeEvent.getNewValue() == null){
            this.getBeamLengthBinding().setValue(new Number(0));
        }else if(Double.parseDouble(valueChangeEvent.getNewValue().toString()) == 0){
            this.getBeamLengthBinding().setValue(new Number(0));
        }else{
            double result = this.getBeamLength();
            try{
                this.getBeamLengthBinding().setValue(new Number(result));
            }catch(SQLException e){
                this.getBeamLengthBinding().setValue(new Number(0));    
            }
        }
    }

    public void setBeamLengthValueChangeListener(RichInputText beamLengthValueChangeListener) {
        this.beamLengthValueChangeListener = beamLengthValueChangeListener;
    }

    public RichInputText getBeamLengthValueChangeListener() {
        return beamLengthValueChangeListener;
    }
    
    public void setNoOfBeamBinding(RichInputText noOfBeamBinding) {
        this.noOfBeamBinding = noOfBeamBinding;
    }

    public RichInputText getNoOfBeamBinding() {
        return noOfBeamBinding;
    }

    public void setBeamLengthBinding(RichInputText beamLengthBinding) {
        this.beamLengthBinding = beamLengthBinding;
    }

    public RichInputText getBeamLengthBinding() {
        return beamLengthBinding;
    }

    public void setWtOfWarpBinding(RichInputText wtOfWarpBinding) {
        this.wtOfWarpBinding = wtOfWarpBinding;
    }

    public RichInputText getWtOfWarpBinding() {
        return wtOfWarpBinding;
    }

    public void wtOfWarpValueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if(valueChangeEvent.getNewValue() == null){
            this.getTotalWarpReqBinding().setValue(new Number(0));
        }else if(Double.parseDouble(valueChangeEvent.getNewValue().toString()) == 0){
            this.getTotalWarpReqBinding().setValue(new Number(0));
        }else{
            double result = getWtOfWarp();        
            try{
                this.getTotalWarpReqBinding().setValue(new Number(result));
            }catch(SQLException e){
                ;    
            }
        }
    }
    
    public double getWtOfWarp(){
        
        double result = 0.00;
        double reqdSizeLength = 0.00;
        double wtOfWarp = 0.00;
        
        try{
            wtOfWarp = Double.parseDouble(this.getWtOfWarpBinding().getValue().toString());
        }catch(NullPointerException e){
            wtOfWarp = 0.00;
        }
        try{
            reqdSizeLength = Double.parseDouble(this.getRequiredSizeLengthMtrBinding().getValue().toString());
        }catch(NullPointerException e){
            reqdSizeLength = 0.00;  
        }
        DecimalFormat df = new DecimalFormat("#.##");
        result = wtOfWarp * reqdSizeLength;
        result = Double.parseDouble(df.format(result));
        return result;    
    }

    public void setTotalWarpReqBinding(RichInputText totalWarpReqBinding) {
        this.totalWarpReqBinding = totalWarpReqBinding;
    }

    public RichInputText getTotalWarpReqBinding() {
        return totalWarpReqBinding;
    }

    public void setGreyWidthBinding(RichInputText greyWidthBinding) {
        this.greyWidthBinding = greyWidthBinding;
    }

    public RichInputText getGreyWidthBinding() {
        return greyWidthBinding;
    }

    public void greyWidthValueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if(valueChangeEvent.getNewValue() == null){
            this.getGreyEpiBinding().setValue(new Number(0));    
        }else if(Double.parseDouble(valueChangeEvent.getNewValue().toString()) == 0){
            this.getGreyEpiBinding().setValue(new Number(0));    
        }else{
            double result = this.getGreyEPI();
            try{
                this.getGreyEpiBinding().setValue(new Number(result));
            }catch(SQLException e)
            {
                this.getGreyEpiBinding().setValue(new Number(0));    
            }
        }
    }

    public void setGreyEpiBinding(RichInputText greyEpiBinding) {
        this.greyEpiBinding = greyEpiBinding;
    }

    public RichInputText getGreyEpiBinding() {
        return greyEpiBinding;
    }

    public double getBeamLength(){
        double result = 0.00;
        double rqrdSizeLngth = 0.00;
        double noOfBeam = 0.00;
        try{
            rqrdSizeLngth = Double.parseDouble(this.getRequiredSizeLengthMtrBinding().getValue().toString());
        }catch(NullPointerException e){
            rqrdSizeLngth = 0.00;
        }
        try{
            noOfBeam = Double.parseDouble(this.getNoOfBeamBinding().getValue().toString());
        }catch(NullPointerException e){
            noOfBeam = 0.00;
        }
        if(noOfBeam != 0.00){
            result = Math.round(rqrdSizeLngth / noOfBeam);
        }else{
            result = 0.00;    
        }
        return result ;
    }
    
    public double getGreyEPI(){
        
        System.out.println("getGreyEPI...");
        double result = 0.0;
        double selvedgeEnds = 0.0;
        double greyWidth = 0.0;
        double totalEnds = 0.0;
        try {
            selvedgeEnds = Double.parseDouble(this.getSelvedgeEndsBinding().getValue().toString());    
            System.out.println("selvedgeEnds "+selvedgeEnds);
        } catch (Exception e) {
            selvedgeEnds = 0.0;
        }
        try {
            greyWidth = Double.parseDouble(this.getGreyWidthBinding().getValue().toString());    
            System.out.println("greyWidth "+greyWidth);
        } catch (Exception e) {
            greyWidth = 0.0;
        }
        try {
            totalEnds = Double.parseDouble(this.getTotalEndsBinding().getValue().toString());    
            System.out.println("totalEnds "+totalEnds);
        } catch (Exception e) {
            totalEnds = 0.00;
        }
        if(greyWidth != 0.0){
            try {
                result = Math.round((totalEnds - selvedgeEnds) / greyWidth);    
            } catch (Exception e) {
                result = 0.0;
            }    
        }
        else{
            result = 0.0;    
        }
        
        return result;
            
    }

    public void setSelvedgeSizeMM(RichInputText selvedgeSizeMM) {
        this.selvedgeSizeMM = selvedgeSizeMM;
    }

    public RichInputText getSelvedgeSizeMM() {
        return selvedgeSizeMM;
    }

    public void selvedgeSizeMMValueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if(valueChangeEvent.getNewValue() == null){
            this.getSelvedgeEndsBothSideBinding().setValue(new Number(0));        
        }else if(Double.parseDouble(valueChangeEvent.getNewValue().toString()) == 0){
            this.getSelvedgeEndsBothSideBinding().setValue(new Number(0));    
        }else{
            double result = this.getSelvedgeEndsBothside();
            try{
                this.getSelvedgeEndsBothSideBinding().setValue(new Number(result));
            }catch(SQLException e)
            {
                this.getSelvedgeEndsBothSideBinding().setValue(new Number(0));    
            }
        }
    }

    public void setSelvedgeEndsDentBinding(RichInputText selvedgeEndsDentBinding) {
        this.selvedgeEndsDentBinding = selvedgeEndsDentBinding;
    }

    public RichInputText getSelvedgeEndsDentBinding() {
        return selvedgeEndsDentBinding;
    }

    public void selvedgeEndDentValueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        if(valueChangeEvent.getNewValue() == null){
            this.getSelvedgeEndsBothSideBinding().setValue(new Number(0));        
        }else if(Double.parseDouble(valueChangeEvent.getNewValue().toString()) == 0){
            this.getSelvedgeEndsBothSideBinding().setValue(new Number(0));        
        }else{
            double result = this.getSelvedgeEndsBothside();
            try{
                this.getSelvedgeEndsBothSideBinding().setValue(new Number(result));
            }catch(SQLException e)
            {
                this.getSelvedgeEndsBothSideBinding().setValue(new Number(0));    
            }
        }
    }

    public void setSelvedgeEndsBothSideBinding(RichInputText selvedgeEndsBothSideBinding) {
        this.selvedgeEndsBothSideBinding = selvedgeEndsBothSideBinding;
    }

    public RichInputText getSelvedgeEndsBothSideBinding() {
        return selvedgeEndsBothSideBinding;
    }
    
    public double getSelvedgeEndsBothside(){
        double result = 0.00;
        double reedCount = 0.00;
        double selvedgeSizeMM = 0.00;
        double selvedgeEndsDent = 0.00;
        
        try {
            reedCount = Double.parseDouble(this.getReedCountBinding().getValue().toString());    
            
        } catch (Exception e) {
            reedCount = 0.0;
        }
        try {
            selvedgeSizeMM = Double.parseDouble(this.getSelvedgeSizeMM().getValue().toString());    
            
        } catch (Exception e) {
            selvedgeSizeMM = 0.0;
        }
        try {
            selvedgeEndsDent = Double.parseDouble(this.getSelvedgeEndsDentBinding().getValue().toString());    
            
        } catch (Exception e) {
            selvedgeEndsDent = 0.00;
        }
        
        result = Math.round(((reedCount / 50.8) * selvedgeSizeMM) * (selvedgeEndsDent * 2)) ;
        return result;
    }

    public void setLoomRpmBinding(RichInputText loomRpmBinding) {
        this.loomRpmBinding = loomRpmBinding;
    }

    public RichInputText getLoomRpmBinding() {
        return loomRpmBinding;
    }

    public void loomRpmValueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        double loomProdPerday = this.getLoomProdPerDay();
        try
        {
            this.getLoomProdPerDayBinding().setValue(new Number(loomProdPerday));
        }catch(SQLException e){
            this.getLoomProdPerDayBinding().setValue(new Number(0));
        }
        double result = this.getTotalProdPerDayYds();
        try
        {
            this.getTotalProdPerDayYdsBinding().setValue(new Number(result));
        }catch(SQLException e){
            this.getTotalProdPerDayYdsBinding().setValue(new Number(0));
        }
    }

    public void setLoomEfficencyBinding(RichInputText loomEfficencyBinding) {
        this.loomEfficencyBinding = loomEfficencyBinding;
    }

    public RichInputText getLoomEfficencyBinding() {
        return loomEfficencyBinding;
    }

    public void loomEfficiencyBinding(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        double loomProdPerday = this.getLoomProdPerDay();
        try
        {
            this.getLoomProdPerDayBinding().setValue(new Number(loomProdPerday));
        }catch(SQLException e){
            this.getLoomProdPerDayBinding().setValue(new Number(0));
        }
        double result = this.getTotalProdPerDayYds();
        try
        {
            this.getTotalProdPerDayYdsBinding().setValue(new Number(result));
        }catch(SQLException e){
            this.getTotalProdPerDayYdsBinding().setValue(new Number(0));
        }
    }

    public void setGreyPpiWeavingBinding(RichInputText greyPpiWeavingBinding) {
        this.greyPpiWeavingBinding = greyPpiWeavingBinding;
    }

    public RichInputText getGreyPpiWeavingBinding() {
        return greyPpiWeavingBinding;
    }

    public void greyPpiWaevingValueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        double loomProdPerday = this.getLoomProdPerDay();
        try
        {
            this.getLoomProdPerDayBinding().setValue(new Number(loomProdPerday));
        }catch(SQLException e){
            this.getLoomProdPerDayBinding().setValue(new Number(0));
        }
        double result = this.getTotalProdPerDayYds();
        try
        {
            this.getTotalProdPerDayYdsBinding().setValue(new Number(result));
        }catch(SQLException e){
            this.getTotalProdPerDayYdsBinding().setValue(new Number(0));
        }
    }

    public void greyPpiWeavingValueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        double loomProdPerday = this.getLoomProdPerDay();
        try
        {
            this.getLoomProdPerDayBinding().setValue(new Number(loomProdPerday));
        }catch(SQLException e){
            this.getLoomProdPerDayBinding().setValue(new Number(0));
        }
        double result = this.getTotalProdPerDayYds();
        try
        {
            this.getTotalProdPerDayYdsBinding().setValue(new Number(result));
        }catch(SQLException e){
            this.getTotalProdPerDayYdsBinding().setValue(new Number(0));
        }
    }

    public void setTransSelvedgeEndsBothBinding(RichInputText transSelvedgeEndsBothBinding) {
        this.transSelvedgeEndsBothBinding = transSelvedgeEndsBothBinding;
    }

    public RichInputText getTransSelvedgeEndsBothBinding() {
        return transSelvedgeEndsBothBinding;
    }

    public void setLoomProdPerDayBinding(RichInputText loomProdPerDayBinding) {
        this.loomProdPerDayBinding = loomProdPerDayBinding;
    }

    public RichInputText getLoomProdPerDayBinding() {
        return loomProdPerDayBinding;
    }
    
    public double getLoomProdPerDay(){
        double result = 0.00;
        double loomRpm = 0.00;
        double loomEfficiency = 0.00;
        double greyPpi = 0.00;
        try {
            loomRpm = Double.parseDouble(this.getLoomRpmBinding().getValue().toString());    
            
        } catch (Exception e) {
            loomRpm = 0.0;
        }
        try {
            loomEfficiency = Double.parseDouble(this.getLoomEfficencyBinding().getValue().toString());    
            
        } catch (Exception e) {
            loomEfficiency = 0.0;
        }
        try {
            greyPpi = Double.parseDouble(this.getGreyPpiWeavingBinding().getValue().toString());    
            
        } catch (Exception e) {
            greyPpi = 0.00;
        }
        
        
        result = (greyPpi==0.00?0:Math.round((loomRpm * 1440 * loomEfficiency) / (greyPpi * 36)));
        
        
        return result;    
    }


    public void OrderQtyYdsValueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        double result = this.getTotalWeaveableLength();
        try
        {
            this.getTotalWeavableLengthBinding().setValue(new Number(result));
        }catch(SQLException e){
            this.getTotalWeavableLengthBinding().setValue(new Number(0));
        }
        result = this.getDaysReqToFinish();
        try
        {
            this.getDayReqToFinishBinding().setValue(new Number(result));
        }catch(SQLException e){
            this.getDayReqToFinishBinding().setValue(new Number(0));
        }
        result = this.getTotalWeftReqKg();
        try
        {
            this.getTotalWeftReqKgBinding().setValue(new Number(result));
        }catch(SQLException e){
            this.getTotalWeftReqKgBinding().setValue(new Number(0));
        }
    }

    public void processLossValueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        System.out.println("processLossValueChangeListener");
        double result = this.getTotalWeaveableLength();
        try
        {
            this.getTotalWeavableLengthBinding().setValue(new Number(result));
        }catch(SQLException e){
            this.getTotalWeavableLengthBinding().setValue(new Number(0));
        }
        if(valueChangeEvent.getNewValue() == null){
            this.getBeamWidthBinding().setValue(new Number(0));
        }else if(Double.parseDouble(valueChangeEvent.getNewValue().toString()) == 0){
            this.getBeamWidthBinding().setValue(new Number(0));
        }else{
            result = this.getWtOfWarpKgYrd() ;
            try{
                this.getWtOfWarpBinding().setValue(new Number(result));
            }catch(SQLException e){
                this.getWtOfWarpBinding().setValue(new Number(0));    
            }
        }
    }
    
    public double getTotalWeaveableLength(){
        double result = 0.00;
        double orderQtyYds = 0.00;
        double processloss = 0.00;
        try {
            orderQtyYds = Double.parseDouble(this.getOrderQtyYdsBinding().getValue().toString());    
            
        } catch (Exception e) {
            orderQtyYds = 0.0;
        }
        try {
            processloss = Double.parseDouble(this.getProcessLossBinding().getValue().toString());    
            
        } catch (Exception e) {
            processloss = 0.0;
        }
        
        
        result = Math.round(orderQtyYds * (1 + processloss));
        
        return result ;
        
    }

    public void setProcessLossBinding(RichInputText processLossBinding) {
        this.processLossBinding = processLossBinding;
    }

    public RichInputText getProcessLossBinding() {
        return processLossBinding;
    }

    public void setOrderQtyYdsBinding(RichInputText orderQtyYdsBinding) {
        this.orderQtyYdsBinding = orderQtyYdsBinding;
    }

    public RichInputText getOrderQtyYdsBinding() {
        return orderQtyYdsBinding;
    }

    public void setTotalWeavableLengthBinding(RichInputText totalWeavableLengthBinding) {
        this.totalWeavableLengthBinding = totalWeavableLengthBinding;
    }

    public RichInputText getTotalWeavableLengthBinding() {
        return totalWeavableLengthBinding;
    }

    public void loomProdPerDayYdsValueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        double result = this.getTotalProdPerDayYds();
        try
        {
            this.getTotalProdPerDayYdsBinding().setValue(new Number(result));
        }catch(SQLException e){
            this.getTotalProdPerDayYdsBinding().setValue(new Number(0));
        }
    }

    public void planLoomValueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        double result = this.getTotalProdPerDayYds();
        try
        {
            this.getTotalProdPerDayYdsBinding().setValue(new Number(result));
        }catch(SQLException e){
            this.getTotalProdPerDayYdsBinding().setValue(new Number(0));
        }
    }
    
    public double getTotalProdPerDayYds(){
        double result = 0.00;
        double loomProdPerDay = 0.00;
        double planLoom = 0.00;
        try {
            loomProdPerDay = Double.parseDouble(this.getLoomProdPerDayBinding().getValue().toString());    
            
        } catch (Exception e) {
            loomProdPerDay = 0.0;
        }
        try {
            planLoom = Double.parseDouble(this.getPlanLoomBinding().getValue().toString());    
            
        } catch (Exception e) {
            planLoom = 0.0;
        }
        DecimalFormat df = new DecimalFormat("#.##");
        result = Double.parseDouble(df.format(loomProdPerDay * planLoom));
        
        return result;     
    }

    public void setPlanLoomBinding(RichInputText planLoomBinding) {
        this.planLoomBinding = planLoomBinding;
    }

    public RichInputText getPlanLoomBinding() {
        return planLoomBinding;
    }

    public void setTotalProdPerDayYdsBinding(RichInputText totalProdPerDayYdsBinding) {
        this.totalProdPerDayYdsBinding = totalProdPerDayYdsBinding;
    }

    public RichInputText getTotalProdPerDayYdsBinding() {
        return totalProdPerDayYdsBinding;
    }

    public void wtOfWeftYarnKgYdsValueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        double result = this.getTotalWeftReqKg();
        try
        {
            this.getTotalWeftReqKgBinding().setValue(new Number(result));
        }catch(SQLException e){
            this.getTotalWeftReqKgBinding().setValue(new Number(0));
        }
    }

    public void setWtOfWeftYarmKgYdsBinding(RichInputText wtOfWeftYarmKgYdsBinding) {
        this.wtOfWeftYarmKgYdsBinding = wtOfWeftYarmKgYdsBinding;
    }

    public RichInputText getWtOfWeftYarmKgYdsBinding() {
        return wtOfWeftYarmKgYdsBinding;
    }

    public void totalProdPerDayYdsValueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        double result = this.getDaysReqToFinish();
        try
        {
            this.getDayReqToFinishBinding().setValue(new Number(result));
        }catch(SQLException e){
            this.getDayReqToFinishBinding().setValue(new Number(0));
        }
    }
    
    public double getTotalWeftReqKg(){
        double result = 0.00;
        double wtOfWeftYarmKgYds = 0.00;
        double OrderQtyYds = 0.00;
        try {
            wtOfWeftYarmKgYds = Double.parseDouble(this.getWtOfWeftYarmKgYdsBinding().getValue().toString());    
            
        } catch (Exception e) {
            wtOfWeftYarmKgYds = 0.0;
        }
        try {
            OrderQtyYds = Double.parseDouble(this.getOrderQtyYdsBinding().getValue().toString());    
            
        } catch (Exception e) {
            OrderQtyYds = 0.0;
        }
        DecimalFormat df = new DecimalFormat("#.##");
        result = Double.parseDouble(df.format(wtOfWeftYarmKgYds * OrderQtyYds));
        
        return result;
        
    }
    
    
    
    public double getDaysReqToFinish(){
        double result = 0.00;
        
        double orderQtyYds = 0.00;
        double totalProdPerdayYds = 0.00;
        try {
            orderQtyYds = Double.parseDouble(this.getOrderQtyYdsBinding().getValue().toString());    
            
        } catch (Exception e) {
            orderQtyYds = 0.0;
        }
        try {
            totalProdPerdayYds = Double.parseDouble(this.getTotalProdPerDayYdsBinding().getValue().toString());    
            
        } catch (Exception e) {
            totalProdPerdayYds = 0.0;
        }
        
        result = totalProdPerdayYds==0.0?0:Math.ceil(orderQtyYds / totalProdPerdayYds);
        
        return result;    
    };

    public void setDayReqToFinishBinding(RichInputText dayReqToFinishBinding) {
        this.dayReqToFinishBinding = dayReqToFinishBinding;
    }

    public RichInputText getDayReqToFinishBinding() {
        return dayReqToFinishBinding;
    }

    public void setTotalWeftReqKgBinding(RichInputText totalWeftReqKgBinding) {
        this.totalWeftReqKgBinding = totalWeftReqKgBinding;
    }

    public RichInputText getTotalWeftReqKgBinding() {
        return totalWeftReqKgBinding;
    }

    public void selvedgeEndsBothSideValueChangeListener(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        double result = this.getSelvedgeEnds();
        try
        {
            this.getSelvedgeEndsBinding().setValue(new Number(result));
        }catch(SQLException e){
            this.getSelvedgeEndsBinding().setValue(new Number(0));
        }
    }
    
    public double getSelvedgeEnds(){
        double result = 0.00;
        double selvedgeEndsBothside = 0.00;
        double endsPerDent = 0.00;
        double selvedgeEndsPerDent = 0.00;
        
        try {
            selvedgeEndsBothside = Double.parseDouble(this.getSelvedgeEndsBothSideBinding().getValue().toString());    
        } catch (Exception e) {
            selvedgeEndsBothside = 0.0;
        }
        try {
            endsPerDent = Double.parseDouble(this.getEndsDentBinding().getValue().toString());    
        } catch (Exception e) {
            endsPerDent = 0.0;
        }
        try {
            selvedgeEndsPerDent = Double.parseDouble(this.getSelvedgeEndsDentBinding().getValue().toString());    
        } catch (Exception e) {
            selvedgeEndsPerDent = 0.0;
        }
        
        result = selvedgeEndsBothside * (1 - (selvedgeEndsPerDent==0.0?0:endsPerDent / selvedgeEndsPerDent));

        
        return result;
    }
    
    public double getReedSpace(){
        System.out.println("getReedSpace");
        double result = 0.00;
        double totalEnds = 0.00;
        double selvedgeEnds = 0.00;
        double EndDents = 0.00;
        double reedCount = 0.00;
        try {
            totalEnds = Double.parseDouble(this.getTotalEndsBinding().getValue().toString());
            System.out.println("totalEnds "+totalEnds);
        } catch (Exception e) {
            totalEnds = 0.0;
        }
        try {
            selvedgeEnds = Double.parseDouble(this.getSelvedgeEndsBinding().getValue().toString());    
            System.out.println("selvedgeEnds");
        } catch (Exception e) {
            selvedgeEnds = 0.0;
        }
        try {
            EndDents = Double.parseDouble(this.getEndsDentBinding().getValue().toString());    
            System.out.println("EndDents "+EndDents);
        } catch (Exception e) {
            EndDents = 0.0;
        }
        try {
            reedCount = Double.parseDouble(this.getReedCountBinding().getValue().toString());    
            System.out.println("reedCount "+reedCount);
        } catch (Exception e) {
            reedCount = 0.0;
        }
        
        result = EndDents == 0.0 ? 0: reedCount == 0.0 ? 0 : ((totalEnds- selvedgeEnds) * 2)/ ( EndDents * reedCount);
        System.out.println("result "+result);
        
        return result;
        
    }


    public void setReedSpaceBinding(RichInputText reedSpaceBinding) {
        this.reedSpaceBinding = reedSpaceBinding;
    }

    public RichInputText getReedSpaceBinding() {
        return reedSpaceBinding;
    }

    public void setTransHdrCountRatioBinding(RichInputText transHdrCountRatioBinding) {
        this.transHdrCountRatioBinding = transHdrCountRatioBinding;
    }

    public RichInputText getTransHdrCountRatioBinding() {
        return transHdrCountRatioBinding;
    }

    public void setCountFactBinding(RichInputText countFactBinding) {
        this.countFactBinding = countFactBinding;
    }

    public RichInputText getCountFactBinding() {
        return countFactBinding;
    }
    
    public double getWtOfWarpKgYrd(){
    
        double transHdrCountRatio = 0.00;  
        double totalEnds =  0.00;
        double processLoss  = 0.0;
        double result = 0.0;
        double countFact = 0.00;
        try{    
            transHdrCountRatio = Double.parseDouble(this.getTransHdrCountRatioBinding().getValue().toString());
            System.out.println("transHdrCountRatio "+transHdrCountRatio);
        }catch(NullPointerException e)
        {
            transHdrCountRatio = 0.0;    
        }
        try{
            totalEnds = Double.parseDouble(this.getTotalEndsBinding().getValue().toString());
            System.out.println("totalEnds "+totalEnds);
        }catch(NullPointerException e){
            totalEnds = 0.0;    
        }
        try{
            processLoss = Double.parseDouble(this.getProcessLossBinding().getValue().toString());
            System.out.println("processLoss "+ processLoss);
        }catch(NullPointerException e){
            processLoss = 0.0;
        }
        try{
            countFact = Double.parseDouble(this.getCountFactBinding().getValue().toString());
        }catch(NullPointerException e){
            countFact = 0.0;
        }
        result = (transHdrCountRatio == 0.0 ? 0 : totalEnds / transHdrCountRatio) * ((1 + processLoss) * countFact);
        System.out.println("result "+result);
        System.out.println("Hello3");
        return result;
    }
}
