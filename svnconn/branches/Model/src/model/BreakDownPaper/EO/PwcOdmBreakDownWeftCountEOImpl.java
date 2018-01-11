package model.BreakDownPaper.EO;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Sep 30 18:57:23 PKT 2017
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class PwcOdmBreakDownWeftCountEOImpl extends EntityImpl {
    private static EntityDefImpl mDefinitionObject;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. Do not modify.
     */
    public enum AttributesEnum {
        HeaderId {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getHeaderId();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setHeaderId((Number)value);
            }
        }
        ,
        WeftCountId {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getWeftCountId();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setWeftCountId((Number)value);
            }
        }
        ,
        Count1 {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getCount1();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setCount1((Number)value);
            }
        }
        ,
        Ply {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getPly();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setPly((Number)value);
            }
        }
        ,
        SingleCount {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getSingleCount();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setSingleCount((Number)value);
            }
        }
        ,
        Type {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getType();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setType((String)value);
            }
        }
        ,
        Ratio {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getRatio();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setRatio((Number)value);
            }
        }
        ,
        Brand {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getBrand();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setBrand((String)value);
            }
        }
        ,
        Blend {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getBlend();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setBlend((String)value);
            }
        }
        ,
        Lot {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getLot();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setLot((String)value);
            }
        }
        ,
        Attribute1 {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getAttribute1();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setAttribute1((String)value);
            }
        }
        ,
        Attribute2 {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getAttribute2();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setAttribute2((String)value);
            }
        }
        ,
        Attribute3 {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getAttribute3();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setAttribute3((String)value);
            }
        }
        ,
        Attribute4 {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getAttribute4();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setAttribute4((String)value);
            }
        }
        ,
        Attribute5 {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getAttribute5();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setAttribute5((String)value);
            }
        }
        ,
        Attribute6 {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getAttribute6();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setAttribute6((String)value);
            }
        }
        ,
        Attribute7 {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getAttribute7();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setAttribute7((String)value);
            }
        }
        ,
        Attribute8 {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getAttribute8();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setAttribute8((String)value);
            }
        }
        ,
        Attribute9 {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getAttribute9();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setAttribute9((String)value);
            }
        }
        ,
        Attribute10 {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getAttribute10();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setAttribute10((String)value);
            }
        }
        ,
        Attribute11 {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getAttribute11();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setAttribute11((String)value);
            }
        }
        ,
        Attribute12 {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getAttribute12();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setAttribute12((String)value);
            }
        }
        ,
        Attribute13 {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getAttribute13();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setAttribute13((String)value);
            }
        }
        ,
        Attribute14 {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getAttribute14();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setAttribute14((String)value);
            }
        }
        ,
        Attribute15 {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getAttribute15();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setAttribute15((String)value);
            }
        }
        ,
        CreatedBy {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getCreatedBy();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setCreatedBy((Number)value);
            }
        }
        ,
        CreationDate {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getCreationDate();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setCreationDate((Date)value);
            }
        }
        ,
        LastUpdatedBy {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getLastUpdatedBy();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setLastUpdatedBy((Number)value);
            }
        }
        ,
        LastUpdateDate {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getLastUpdateDate();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setLastUpdateDate((Date)value);
            }
        }
        ,
        LastUpdateLogin {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getLastUpdateLogin();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setLastUpdateLogin((Number)value);
            }
        }
        ,
        Enable {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getEnable();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setEnable((String)value);
            }
        }
        ,
        Status {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getStatus();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setStatus((String)value);
            }
        }
        ,
        ReqInKg {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getReqInKg();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setReqInKg((Number)value);
            }
        }
        ,
        AllocateInKg {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getAllocateInKg();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setAllocateInKg((Number)value);
            }
        }
        ,
        AvailableStock {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getAvailableStock();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setAvailableStock((Number)value);
            }
        }
        ,
        BalYarmRemaining {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getBalYarmRemaining();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setBalYarmRemaining((Number)value);
            }
        }
        ,
        Purchase {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getPurchase();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setPurchase((Number)value);
            }
        }
        ,
        ItemId {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getItemId();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setItemId((Number)value);
            }
        }
        ,
        PwcOdmBreakDownHdrEO {
            public Object get(PwcOdmBreakDownWeftCountEOImpl obj) {
                return obj.getPwcOdmBreakDownHdrEO();
            }

            public void put(PwcOdmBreakDownWeftCountEOImpl obj, Object value) {
                obj.setPwcOdmBreakDownHdrEO((PwcOdmBreakDownHdrEOImpl)value);
            }
        }
        ;
        private static AttributesEnum[] vals = null;
        private static int firstIndex = 0;

        public abstract Object get(PwcOdmBreakDownWeftCountEOImpl object);

        public abstract void put(PwcOdmBreakDownWeftCountEOImpl object,
                                 Object value);

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int HEADERID = AttributesEnum.HeaderId.index();
    public static final int WEFTCOUNTID = AttributesEnum.WeftCountId.index();
    public static final int COUNT1 = AttributesEnum.Count1.index();
    public static final int PLY = AttributesEnum.Ply.index();
    public static final int SINGLECOUNT = AttributesEnum.SingleCount.index();
    public static final int TYPE = AttributesEnum.Type.index();
    public static final int RATIO = AttributesEnum.Ratio.index();
    public static final int BRAND = AttributesEnum.Brand.index();
    public static final int BLEND = AttributesEnum.Blend.index();
    public static final int LOT = AttributesEnum.Lot.index();
    public static final int ATTRIBUTE1 = AttributesEnum.Attribute1.index();
    public static final int ATTRIBUTE2 = AttributesEnum.Attribute2.index();
    public static final int ATTRIBUTE3 = AttributesEnum.Attribute3.index();
    public static final int ATTRIBUTE4 = AttributesEnum.Attribute4.index();
    public static final int ATTRIBUTE5 = AttributesEnum.Attribute5.index();
    public static final int ATTRIBUTE6 = AttributesEnum.Attribute6.index();
    public static final int ATTRIBUTE7 = AttributesEnum.Attribute7.index();
    public static final int ATTRIBUTE8 = AttributesEnum.Attribute8.index();
    public static final int ATTRIBUTE9 = AttributesEnum.Attribute9.index();
    public static final int ATTRIBUTE10 = AttributesEnum.Attribute10.index();
    public static final int ATTRIBUTE11 = AttributesEnum.Attribute11.index();
    public static final int ATTRIBUTE12 = AttributesEnum.Attribute12.index();
    public static final int ATTRIBUTE13 = AttributesEnum.Attribute13.index();
    public static final int ATTRIBUTE14 = AttributesEnum.Attribute14.index();
    public static final int ATTRIBUTE15 = AttributesEnum.Attribute15.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int LASTUPDATEDATE = AttributesEnum.LastUpdateDate.index();
    public static final int LASTUPDATELOGIN = AttributesEnum.LastUpdateLogin.index();
    public static final int ENABLE = AttributesEnum.Enable.index();
    public static final int STATUS = AttributesEnum.Status.index();
    public static final int REQINKG = AttributesEnum.ReqInKg.index();
    public static final int ALLOCATEINKG = AttributesEnum.AllocateInKg.index();
    public static final int AVAILABLESTOCK = AttributesEnum.AvailableStock.index();
    public static final int BALYARMREMAINING = AttributesEnum.BalYarmRemaining.index();
    public static final int PURCHASE = AttributesEnum.Purchase.index();
    public static final int ITEMID = AttributesEnum.ItemId.index();
    public static final int PWCODMBREAKDOWNHDREO = AttributesEnum.PwcOdmBreakDownHdrEO.index();

    /**
     * This is the default constructor (do not remove).
     */
    public PwcOdmBreakDownWeftCountEOImpl() {
    }


    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        if (mDefinitionObject == null) {
            mDefinitionObject = EntityDefImpl.findDefObject("model.BreakDownPaper.EO.PwcOdmBreakDownWeftCountEO");
        }
        return mDefinitionObject;
    }

    /**
     * Gets the attribute value for HeaderId, using the alias name HeaderId.
     * @return the HeaderId
     */
    public Number getHeaderId() {
        return (Number)getAttributeInternal(HEADERID);
    }

    /**
     * Sets <code>value</code> as the attribute value for HeaderId.
     * @param value value to set the HeaderId
     */
    public void setHeaderId(Number value) {
        setAttributeInternal(HEADERID, value);
    }

    /**
     * Gets the attribute value for WeftCountId, using the alias name WeftCountId.
     * @return the WeftCountId
     */
    public Number getWeftCountId() {
        return (Number)getAttributeInternal(WEFTCOUNTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for WeftCountId.
     * @param value value to set the WeftCountId
     */
    public void setWeftCountId(Number value) {
        setAttributeInternal(WEFTCOUNTID, value);
    }

    /**
     * Gets the attribute value for Count1, using the alias name Count1.
     * @return the Count1
     */
    public Number getCount1() {
        return (Number)getAttributeInternal(COUNT1);
    }

    /**
     * Sets <code>value</code> as the attribute value for Count1.
     * @param value value to set the Count1
     */
    public void setCount1(Number value) {
        setAttributeInternal(COUNT1, value);
    }

    /**
     * Gets the attribute value for Ply, using the alias name Ply.
     * @return the Ply
     */
    public Number getPly() {
        return (Number)getAttributeInternal(PLY);
    }

    /**
     * Sets <code>value</code> as the attribute value for Ply.
     * @param value value to set the Ply
     */
    public void setPly(Number value) {
        setAttributeInternal(PLY, value);
    }

    /**
     * Gets the attribute value for SingleCount, using the alias name SingleCount.
     * @return the SingleCount
     */
    public Number getSingleCount() {
        return (Number)getAttributeInternal(SINGLECOUNT);
    }

    /**
     * Sets <code>value</code> as the attribute value for SingleCount.
     * @param value value to set the SingleCount
     */
    public void setSingleCount(Number value) {
        setAttributeInternal(SINGLECOUNT, value);
    }

    /**
     * Gets the attribute value for Type, using the alias name Type.
     * @return the Type
     */
    public String getType() {
        return (String)getAttributeInternal(TYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Type.
     * @param value value to set the Type
     */
    public void setType(String value) {
        setAttributeInternal(TYPE, value);
    }

    /**
     * Gets the attribute value for Ratio, using the alias name Ratio.
     * @return the Ratio
     */
    public Number getRatio() {
        return (Number)getAttributeInternal(RATIO);
    }

    /**
     * Sets <code>value</code> as the attribute value for Ratio.
     * @param value value to set the Ratio
     */
    public void setRatio(Number value) {
        setAttributeInternal(RATIO, value);
    }

    /**
     * Gets the attribute value for Brand, using the alias name Brand.
     * @return the Brand
     */
    public String getBrand() {
        return (String)getAttributeInternal(BRAND);
    }

    /**
     * Sets <code>value</code> as the attribute value for Brand.
     * @param value value to set the Brand
     */
    public void setBrand(String value) {
        setAttributeInternal(BRAND, value);
    }

    /**
     * Gets the attribute value for Blend, using the alias name Blend.
     * @return the Blend
     */
    public String getBlend() {
        return (String)getAttributeInternal(BLEND);
    }

    /**
     * Sets <code>value</code> as the attribute value for Blend.
     * @param value value to set the Blend
     */
    public void setBlend(String value) {
        setAttributeInternal(BLEND, value);
    }

    /**
     * Gets the attribute value for Lot, using the alias name Lot.
     * @return the Lot
     */
    public String getLot() {
        return (String)getAttributeInternal(LOT);
    }

    /**
     * Sets <code>value</code> as the attribute value for Lot.
     * @param value value to set the Lot
     */
    public void setLot(String value) {
        setAttributeInternal(LOT, value);
    }

    /**
     * Gets the attribute value for Attribute1, using the alias name Attribute1.
     * @return the Attribute1
     */
    public String getAttribute1() {
        return (String)getAttributeInternal(ATTRIBUTE1);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute1.
     * @param value value to set the Attribute1
     */
    public void setAttribute1(String value) {
        setAttributeInternal(ATTRIBUTE1, value);
    }

    /**
     * Gets the attribute value for Attribute2, using the alias name Attribute2.
     * @return the Attribute2
     */
    public String getAttribute2() {
        return (String)getAttributeInternal(ATTRIBUTE2);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute2.
     * @param value value to set the Attribute2
     */
    public void setAttribute2(String value) {
        setAttributeInternal(ATTRIBUTE2, value);
    }

    /**
     * Gets the attribute value for Attribute3, using the alias name Attribute3.
     * @return the Attribute3
     */
    public String getAttribute3() {
        return (String)getAttributeInternal(ATTRIBUTE3);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute3.
     * @param value value to set the Attribute3
     */
    public void setAttribute3(String value) {
        setAttributeInternal(ATTRIBUTE3, value);
    }

    /**
     * Gets the attribute value for Attribute4, using the alias name Attribute4.
     * @return the Attribute4
     */
    public String getAttribute4() {
        return (String)getAttributeInternal(ATTRIBUTE4);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute4.
     * @param value value to set the Attribute4
     */
    public void setAttribute4(String value) {
        setAttributeInternal(ATTRIBUTE4, value);
    }

    /**
     * Gets the attribute value for Attribute5, using the alias name Attribute5.
     * @return the Attribute5
     */
    public String getAttribute5() {
        return (String)getAttributeInternal(ATTRIBUTE5);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute5.
     * @param value value to set the Attribute5
     */
    public void setAttribute5(String value) {
        setAttributeInternal(ATTRIBUTE5, value);
    }

    /**
     * Gets the attribute value for Attribute6, using the alias name Attribute6.
     * @return the Attribute6
     */
    public String getAttribute6() {
        return (String)getAttributeInternal(ATTRIBUTE6);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute6.
     * @param value value to set the Attribute6
     */
    public void setAttribute6(String value) {
        setAttributeInternal(ATTRIBUTE6, value);
    }

    /**
     * Gets the attribute value for Attribute7, using the alias name Attribute7.
     * @return the Attribute7
     */
    public String getAttribute7() {
        return (String)getAttributeInternal(ATTRIBUTE7);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute7.
     * @param value value to set the Attribute7
     */
    public void setAttribute7(String value) {
        setAttributeInternal(ATTRIBUTE7, value);
    }

    /**
     * Gets the attribute value for Attribute8, using the alias name Attribute8.
     * @return the Attribute8
     */
    public String getAttribute8() {
        return (String)getAttributeInternal(ATTRIBUTE8);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute8.
     * @param value value to set the Attribute8
     */
    public void setAttribute8(String value) {
        setAttributeInternal(ATTRIBUTE8, value);
    }

    /**
     * Gets the attribute value for Attribute9, using the alias name Attribute9.
     * @return the Attribute9
     */
    public String getAttribute9() {
        return (String)getAttributeInternal(ATTRIBUTE9);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute9.
     * @param value value to set the Attribute9
     */
    public void setAttribute9(String value) {
        setAttributeInternal(ATTRIBUTE9, value);
    }

    /**
     * Gets the attribute value for Attribute10, using the alias name Attribute10.
     * @return the Attribute10
     */
    public String getAttribute10() {
        return (String)getAttributeInternal(ATTRIBUTE10);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute10.
     * @param value value to set the Attribute10
     */
    public void setAttribute10(String value) {
        setAttributeInternal(ATTRIBUTE10, value);
    }

    /**
     * Gets the attribute value for Attribute11, using the alias name Attribute11.
     * @return the Attribute11
     */
    public String getAttribute11() {
        return (String)getAttributeInternal(ATTRIBUTE11);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute11.
     * @param value value to set the Attribute11
     */
    public void setAttribute11(String value) {
        setAttributeInternal(ATTRIBUTE11, value);
    }

    /**
     * Gets the attribute value for Attribute12, using the alias name Attribute12.
     * @return the Attribute12
     */
    public String getAttribute12() {
        return (String)getAttributeInternal(ATTRIBUTE12);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute12.
     * @param value value to set the Attribute12
     */
    public void setAttribute12(String value) {
        setAttributeInternal(ATTRIBUTE12, value);
    }

    /**
     * Gets the attribute value for Attribute13, using the alias name Attribute13.
     * @return the Attribute13
     */
    public String getAttribute13() {
        return (String)getAttributeInternal(ATTRIBUTE13);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute13.
     * @param value value to set the Attribute13
     */
    public void setAttribute13(String value) {
        setAttributeInternal(ATTRIBUTE13, value);
    }

    /**
     * Gets the attribute value for Attribute14, using the alias name Attribute14.
     * @return the Attribute14
     */
    public String getAttribute14() {
        return (String)getAttributeInternal(ATTRIBUTE14);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute14.
     * @param value value to set the Attribute14
     */
    public void setAttribute14(String value) {
        setAttributeInternal(ATTRIBUTE14, value);
    }

    /**
     * Gets the attribute value for Attribute15, using the alias name Attribute15.
     * @return the Attribute15
     */
    public String getAttribute15() {
        return (String)getAttributeInternal(ATTRIBUTE15);
    }

    /**
     * Sets <code>value</code> as the attribute value for Attribute15.
     * @param value value to set the Attribute15
     */
    public void setAttribute15(String value) {
        setAttributeInternal(ATTRIBUTE15, value);
    }

    /**
     * Gets the attribute value for CreatedBy, using the alias name CreatedBy.
     * @return the CreatedBy
     */
    public Number getCreatedBy() {
        return (Number)getAttributeInternal(CREATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for CreatedBy.
     * @param value value to set the CreatedBy
     */
    public void setCreatedBy(Number value) {
        setAttributeInternal(CREATEDBY, value);
    }

    /**
     * Gets the attribute value for CreationDate, using the alias name CreationDate.
     * @return the CreationDate
     */
    public Date getCreationDate() {
        return (Date)getAttributeInternal(CREATIONDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for CreationDate.
     * @param value value to set the CreationDate
     */
    public void setCreationDate(Date value) {
        setAttributeInternal(CREATIONDATE, value);
    }

    /**
     * Gets the attribute value for LastUpdatedBy, using the alias name LastUpdatedBy.
     * @return the LastUpdatedBy
     */
    public Number getLastUpdatedBy() {
        return (Number)getAttributeInternal(LASTUPDATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for LastUpdatedBy.
     * @param value value to set the LastUpdatedBy
     */
    public void setLastUpdatedBy(Number value) {
        setAttributeInternal(LASTUPDATEDBY, value);
    }

    /**
     * Gets the attribute value for LastUpdateDate, using the alias name LastUpdateDate.
     * @return the LastUpdateDate
     */
    public Date getLastUpdateDate() {
        return (Date)getAttributeInternal(LASTUPDATEDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for LastUpdateDate.
     * @param value value to set the LastUpdateDate
     */
    public void setLastUpdateDate(Date value) {
        setAttributeInternal(LASTUPDATEDATE, value);
    }

    /**
     * Gets the attribute value for LastUpdateLogin, using the alias name LastUpdateLogin.
     * @return the LastUpdateLogin
     */
    public Number getLastUpdateLogin() {
        return (Number)getAttributeInternal(LASTUPDATELOGIN);
    }

    /**
     * Sets <code>value</code> as the attribute value for LastUpdateLogin.
     * @param value value to set the LastUpdateLogin
     */
    public void setLastUpdateLogin(Number value) {
        setAttributeInternal(LASTUPDATELOGIN, value);
    }

    /**
     * Gets the attribute value for Enable, using the alias name Enable.
     * @return the Enable
     */
    public String getEnable() {
        return (String)getAttributeInternal(ENABLE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Enable.
     * @param value value to set the Enable
     */
    public void setEnable(String value) {
        setAttributeInternal(ENABLE, value);
    }

    /**
     * Gets the attribute value for Status, using the alias name Status.
     * @return the Status
     */
    public String getStatus() {
        return (String)getAttributeInternal(STATUS);
    }

    /**
     * Sets <code>value</code> as the attribute value for Status.
     * @param value value to set the Status
     */
    public void setStatus(String value) {
        setAttributeInternal(STATUS, value);
    }

    /**
     * Gets the attribute value for ReqInKg, using the alias name ReqInKg.
     * @return the ReqInKg
     */
    public Number getReqInKg() {
        return (Number)getAttributeInternal(REQINKG);
    }

    /**
     * Sets <code>value</code> as the attribute value for ReqInKg.
     * @param value value to set the ReqInKg
     */
    public void setReqInKg(Number value) {
        setAttributeInternal(REQINKG, value);
    }

    /**
     * Gets the attribute value for AllocateInKg, using the alias name AllocateInKg.
     * @return the AllocateInKg
     */
    public Number getAllocateInKg() {
        return (Number)getAttributeInternal(ALLOCATEINKG);
    }

    /**
     * Sets <code>value</code> as the attribute value for AllocateInKg.
     * @param value value to set the AllocateInKg
     */
    public void setAllocateInKg(Number value) {
        setAttributeInternal(ALLOCATEINKG, value);
    }

    /**
     * Gets the attribute value for AvailableStock, using the alias name AvailableStock.
     * @return the AvailableStock
     */
    public Number getAvailableStock() {
        return (Number)getAttributeInternal(AVAILABLESTOCK);
    }

    /**
     * Sets <code>value</code> as the attribute value for AvailableStock.
     * @param value value to set the AvailableStock
     */
    public void setAvailableStock(Number value) {
        setAttributeInternal(AVAILABLESTOCK, value);
    }

    /**
     * Gets the attribute value for BalYarmRemaining, using the alias name BalYarmRemaining.
     * @return the BalYarmRemaining
     */
    public Number getBalYarmRemaining() {
        return (Number)getAttributeInternal(BALYARMREMAINING);
    }

    /**
     * Sets <code>value</code> as the attribute value for BalYarmRemaining.
     * @param value value to set the BalYarmRemaining
     */
    public void setBalYarmRemaining(Number value) {
        setAttributeInternal(BALYARMREMAINING, value);
    }

    /**
     * Gets the attribute value for Purchase, using the alias name Purchase.
     * @return the Purchase
     */
    public Number getPurchase() {
        return (Number)getAttributeInternal(PURCHASE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Purchase.
     * @param value value to set the Purchase
     */
    public void setPurchase(Number value) {
        setAttributeInternal(PURCHASE, value);
    }

    /**
     * Gets the attribute value for ItemId, using the alias name ItemId.
     * @return the ItemId
     */
    public Number getItemId() {
        return (Number)getAttributeInternal(ITEMID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ItemId.
     * @param value value to set the ItemId
     */
    public void setItemId(Number value) {
        setAttributeInternal(ITEMID, value);
    }

    /**
     * getAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param attrDef the attribute

     * @return the attribute value
     * @throws Exception
     */
    protected Object getAttrInvokeAccessor(int index,
                                           AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            return AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].get(this);
        }
        return super.getAttrInvokeAccessor(index, attrDef);
    }

    /**
     * setAttrInvokeAccessor: generated method. Do not modify.
     * @param index the index identifying the attribute
     * @param value the value to assign to the attribute
     * @param attrDef the attribute

     * @throws Exception
     */
    protected void setAttrInvokeAccessor(int index, Object value,
                                         AttributeDefImpl attrDef) throws Exception {
        if ((index >= AttributesEnum.firstIndex()) && (index < AttributesEnum.count())) {
            AttributesEnum.staticValues()[index - AttributesEnum.firstIndex()].put(this, value);
            return;
        }
        super.setAttrInvokeAccessor(index, value, attrDef);
    }

    /**
     * @return the associated entity PwcOdmBreakDownHdrEOImpl.
     */
    public PwcOdmBreakDownHdrEOImpl getPwcOdmBreakDownHdrEO() {
        return (PwcOdmBreakDownHdrEOImpl)getAttributeInternal(PWCODMBREAKDOWNHDREO);
    }

    /**
     * Sets <code>value</code> as the associated entity PwcOdmBreakDownHdrEOImpl.
     */
    public void setPwcOdmBreakDownHdrEO(PwcOdmBreakDownHdrEOImpl value) {
        setAttributeInternal(PWCODMBREAKDOWNHDREO, value);
    }


    /**
     * @param weftCountId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Number weftCountId) {
        return new Key(new Object[]{weftCountId});
    }

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
    protected void create(AttributeList attributeList) {
        super.create(attributeList);
    }

    /**
     * Add entity remove logic in this method.
     */
    public void remove() {
        super.remove();
    }

    /**
     * Add locking logic here.
     */
    public void lock() {
        super.lock();
    }

    /**
     * Custom DML update/insert/delete logic here.
     * @param operation the operation type
     * @param e the transaction event
     */
    protected void doDML(int operation, TransactionEvent e) {
        super.doDML(operation, e);
    }
}
