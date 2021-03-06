package model.GradingWeaving.VO;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Jan 17 18:25:41 PKT 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PwcOdmGradingWeavingHeadersVOImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public PwcOdmGradingWeavingHeadersVOImpl() {
    }

    /**
     * Returns the variable value for P_GD_NUMBER.
     * @return variable value for P_GD_NUMBER
     */
    public String getP_GD_NUMBER() {
        return (String)ensureVariableManager().getVariableValue("P_GD_NUMBER");
    }

    /**
     * Sets <code>value</code> for variable P_GD_NUMBER.
     * @param value value to bind as P_GD_NUMBER
     */
    public void setP_GD_NUMBER(String value) {
        ensureVariableManager().setVariableValue("P_GD_NUMBER", value);
    }

    /**
     * Returns the variable value for P_SALES_ORDER_NO.
     * @return variable value for P_SALES_ORDER_NO
     */
    public String getP_SALES_ORDER_NO() {
        return (String)ensureVariableManager().getVariableValue("P_SALES_ORDER_NO");
    }

    /**
     * Sets <code>value</code> for variable P_SALES_ORDER_NO.
     * @param value value to bind as P_SALES_ORDER_NO
     */
    public void setP_SALES_ORDER_NO(String value) {
        ensureVariableManager().setVariableValue("P_SALES_ORDER_NO", value);
    }

    /**
     * Returns the variable value for P_JOB_NO.
     * @return variable value for P_JOB_NO
     */
    public String getP_JOB_NO() {
        return (String)ensureVariableManager().getVariableValue("P_JOB_NO");
    }

    /**
     * Sets <code>value</code> for variable P_JOB_NO.
     * @param value value to bind as P_JOB_NO
     */
    public void setP_JOB_NO(String value) {
        ensureVariableManager().setVariableValue("P_JOB_NO", value);
    }
}
