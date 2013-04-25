package com.resqsoft.biz;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.impl.CriteriaImpl;
import org.hibernate.impl.CriteriaImpl.CriterionEntry;

/**
 * This class is used to convert from the abstract <code>SearchCriteria</code> to Hibernate-specific search criteria
 * implementation.
 *
 * The main inconvenient of this class is that it needs to be update every time there is a new Expression in
 * com.resqsoft.biz package.
 *
 * This class is supposed to be used by Hibernate DAO classes only and <b>should NOT</b> be used elsewhere, such as in
 * the business or UI packages.
 *
 * @author ResQSoft Engineer
 * @version 1.0
 *
 */
public class HibernateSearchCriteria {

    private final SearchCriteria criteria;

    public HibernateSearchCriteria(final SearchCriteria sc) {

        this.criteria = sc;
    }

    /**
     * Populates given Hibernate's Criteria object with information represented in abstract SearchCriteria specified in
     * constructor.
     *
     * @param hibCrt
     */
    public void convert(final Criteria hibCrt) {

        if (this.criteria.getComment() != null) {
            hibCrt.setComment(this.criteria.getComment());
        }

        if (this.criteria.getExample() != null) {
            this.setExample(hibCrt);
        }

        this.setExpressions(hibCrt);

        if (this.criteria.getFirstResult() != null) {
            hibCrt.setFirstResult(this.criteria.getFirstResult().intValue());
        }

        if (this.criteria.getMaxResults() != null) {
            hibCrt.setMaxResults(this.criteria.getMaxResults().intValue());
        }

        this.setOrders(hibCrt);

        if (this.criteria.getTimeout() != null) {
            hibCrt.setTimeout(this.criteria.getTimeout().intValue());
        }
    }

    /**
     * @param hibCrt
     */
    private void setOrders(final Criteria hibernateCriteria) {

        final Iterator it = this.criteria.getOrders().iterator();

        while (it.hasNext()) {
            final Order o = (Order) it.next();

            if (o.isAscending().booleanValue()) {
                hibernateCriteria.addOrder(org.hibernate.criterion.Order.asc(o.getPropertyName()));
            } else {
                hibernateCriteria.addOrder(org.hibernate.criterion.Order.desc(o.getPropertyName()));
            }
        }
    }

    /**
     * @param hibCrt
     */
    private void setExpressions(final Criteria hibernateCriteria) {

        final Iterator it = this.criteria.getExpressions().iterator();

        while (it.hasNext()) {
            final Expression ex = (Expression) it.next();
            processExpression(hibernateCriteria, ex);
        }
    }

    /**
     * @param hibernateCriteria
     * @param ex
     */
    private void processExpression(final Criteria hibernateCriteria, final Expression ex) {

        if (ex instanceof PropertyValueExpression) {
            this.setPropertyValueExpression(ex, hibernateCriteria);
        } else if (ex instanceof PropertyOtherPropertyExpression) {
            this.setPropertyOtherPropertyExpression(ex, hibernateCriteria);
        } else if (ex instanceof LogicalExpression) {
            this.setLogicalExpression((LogicalExpression) ex, hibernateCriteria);
        } else if (ex instanceof UnaryExpression) {
            this.setUnaryExpression((UnaryExpression) ex, hibernateCriteria);
        } else {
            this.setExpression(ex, hibernateCriteria);
        }
    }

    /**
     * @param expression
     * @param hibernateCriteria
     */
    private void setUnaryExpression(UnaryExpression expression, Criteria hibernateCriteria) {

        final CriteriaImpl criteriaImpl = new CriteriaImpl(null, null);

        final Expression operand = expression.getOperand();

        processExpression(criteriaImpl, operand);

        final Criterion criterion = ((CriterionEntry) criteriaImpl.iterateExpressionEntries().next()).getCriterion();

        if (expression instanceof NotExpression) {
            hibernateCriteria.add(Restrictions.not(criterion));
        } else
            throw new IllegalStateException("Unknown implementation of unary expression");
    }

    /**
     * @param expression
     * @param hibernateCriteria
     */
    private void setLogicalExpression(LogicalExpression expression, Criteria hibernateCriteria) {

        final CriteriaImpl lhsC = new CriteriaImpl(null, null);
        final CriteriaImpl rhsC = new CriteriaImpl(null, null);

        final Expression lhsE = expression.getLeftHandSide();
        final Expression rhsE = expression.getRightHandSide();

        processExpression(lhsC, lhsE);
        processExpression(rhsC, rhsE);

        final Criterion lhsCon = ((CriterionEntry) lhsC.iterateExpressionEntries().next()).getCriterion();
        final Criterion rhsCon = ((CriterionEntry) rhsC.iterateExpressionEntries().next()).getCriterion();

        if (expression instanceof AndExpression) {
            hibernateCriteria.add(Restrictions.and(lhsCon, rhsCon));
        } else if (expression instanceof OrExpression) {
            hibernateCriteria.add(Restrictions.or(lhsCon, rhsCon));
        } else
            throw new IllegalStateException("Unknown implementation of logical expression");
    }

    /**
     * @param ex
     * @param hibernateCriteria
     */
    private void setExpression(final Expression ex, final Criteria hibernateCriteria) {

        if (ex instanceof BetweenExpression) {
            final BetweenExpression be = (BetweenExpression) ex;
            hibernateCriteria.add(Restrictions.between(be.getPropertyName(), be.getLow(), be.getHi()));

            return;
        }

        if (ex instanceof ILikeExpression) {
            final ILikeExpression be = (ILikeExpression) ex;
            hibernateCriteria.add(Restrictions.ilike(be.getPropertyName(), be.getValue(), this.convertMatchMode(be.getMatchMode())));

            return;
        }

        if (ex instanceof InExpression) {
            final InExpression be = (InExpression) ex;
            hibernateCriteria.add(Restrictions.in(be.getPropertyName(), be.getValue()));

            return;
        }

        if (ex instanceof IsEmptyExpression) {
            hibernateCriteria.add(Restrictions.isEmpty(ex.getPropertyName()));

            return;
        }

        if (ex instanceof IsNotEmptyExpression) {
            hibernateCriteria.add(Restrictions.isNotEmpty(ex.getPropertyName()));

            return;
        }

        if (ex instanceof IsNotNullExpression) {
            hibernateCriteria.add(Restrictions.isNotNull(ex.getPropertyName()));

            return;
        }

        if (ex instanceof IsNullExpression) {
            hibernateCriteria.add(Restrictions.isNull(ex.getPropertyName()));

            return;
        }

        if (ex instanceof LikeExpression) {
            final LikeExpression be = (LikeExpression) ex;
            hibernateCriteria.add(Restrictions.like(be.getPropertyName(), be.getValue(), this.convertMatchMode(be.getMatchMode())));

            return;
        }

        throw new IllegalStateException("Unknown Expression implementation:" + ex);
    }

    /**
     * @param ex
     * @param hibernateCriteria
     */
    private void setPropertyValueExpression(final Expression ex, final Criteria hibernateCriteria) {

        final PropertyValueExpression pve = (PropertyValueExpression) ex;

        if (pve instanceof GreaterThanExpression) {
            hibernateCriteria.add(Restrictions.gt(pve.getPropertyName(), pve.getValue()));

            return;
        }

        if (pve instanceof LessThanExpression) {
            hibernateCriteria.add(Restrictions.lt(pve.getPropertyName(), pve.getValue()));

            return;
        }

        if (pve instanceof NotEqualExpression) {
            hibernateCriteria.add(Restrictions.ne(pve.getPropertyName(), pve.getValue()));

            return;
        }

        if (pve instanceof EqualExpression) {
            hibernateCriteria.add(Restrictions.eq(pve.getPropertyName(), pve.getValue()));

            return;
        }

        if (pve instanceof LessThanOrEqualExpression) {
            hibernateCriteria.add(Restrictions.le(pve.getPropertyName(), pve.getValue()));

            return;
        }

        if (pve instanceof GreaterThanOrEqualExpression) {
            hibernateCriteria.add(Restrictions.ge(pve.getPropertyName(), pve.getValue()));

            return;
        }

        throw new IllegalStateException("Unknown Expression implementation:" + ex);
    }

    private void setPropertyOtherPropertyExpression(final Expression ex, final Criteria hibernateCriteria) {

        final PropertyOtherPropertyExpression pve = (PropertyOtherPropertyExpression) ex;
        final SimpleProperty prop1 = new SimpleProperty(pve.getPropertyName());
        final SimpleProperty prop2 = new SimpleProperty(pve.getOtherPropertyName());

        if (prop1.hasAlias()) {
            hibernateCriteria.createAlias(prop1.getAlias(), prop1.getAlias());
        }

        if (prop2.hasAlias()) {
            hibernateCriteria.createAlias(prop2.getAlias(), prop2.getAlias());
        }

        if (pve instanceof EqualPropertiesExpression) {
            hibernateCriteria.add(Restrictions.eqProperty(pve.getPropertyName(), pve.getOtherPropertyName()));

            return;
        }

        if (pve instanceof NotEqualPropertiesExpression) {
            hibernateCriteria.add(Restrictions.neProperty(pve.getPropertyName(), pve.getOtherPropertyName()));

            return;
        }

        if (pve instanceof GreaterThanPropertyExpression) {
            hibernateCriteria.add(Restrictions.gtProperty(pve.getPropertyName(), pve.getOtherPropertyName()));

            return;
        }

        if (pve instanceof LessThanPropertyExpression) {
            hibernateCriteria.add(Restrictions.ltProperty(pve.getPropertyName(), pve.getOtherPropertyName()));

            return;
        }

        if (pve instanceof GreaterThanOrEqualPropertyExpression) {
            hibernateCriteria.add(Restrictions.geProperty(pve.getPropertyName(), pve.getOtherPropertyName()));

            return;
        }

        if (pve instanceof LessThanOrEqualPropertyExpression) {
            hibernateCriteria.add(Restrictions.leProperty(pve.getPropertyName(), pve.getOtherPropertyName()));

            return;
        }

        throw new IllegalStateException("Unknown Expression implementation:" + ex);
    }

    /**
     * @param hibCrt
     */
    private void setExample(final Criteria hibernateCriteria) {

        final Example ex = this.criteria.getExample();
        final Object obj = ex.getExampleObject();

        if (obj == null)
            throw new IllegalArgumentException("No object specified in Example");

        final org.hibernate.criterion.Example hibEx = org.hibernate.criterion.Example.create(obj);

        if (ex.isEnableLike().booleanValue()) {
            if (ex.getLikeMatchMode() == null) {
                hibEx.enableLike();
            } else {
                hibEx.enableLike(this.convertMatchMode(ex.getLikeMatchMode()));
            }
        }

        if (ex.isExcludeNone().booleanValue()) {
            hibEx.excludeNone();
        }

        if (ex.isExcludeZeroes().booleanValue()) {
            hibEx.excludeZeroes();
        }

        if (ex.isIgnoreCase().booleanValue()) {
            hibEx.ignoreCase();
        }

        hibernateCriteria.add(hibEx);

        this.processAssociatedObjects(hibernateCriteria);
    }

    /**
     * @param hibCrt
     */
    private void processAssociatedObjects(final Criteria hibernateCriteria) {

        final Example ex = this.criteria.getExample();
        final Object obj = ex.getExampleObject();

        try {
            final PropertyDescriptor[] descriptors = PropertyUtils.getPropertyDescriptors(obj);

            for (final PropertyDescriptor descriptor : descriptors) {
                final String propName = descriptor.getName();
                final Class propClass = descriptor.getPropertyType();

                if ((propClass != null) && BusinessObject.class.isAssignableFrom(propClass)
                        && (descriptor.getWriteMethod() != null)) {
                    final Object propValue = PropertyUtils.getSimpleProperty(obj, propName);

                    if (propValue != null) {
                        this.setAssociatedObjectCriteria(hibernateCriteria, propName, (BusinessObject) propValue);
                    }
                }
            }
        } catch (final IllegalAccessException e) {
            e.printStackTrace();
        } catch (final InvocationTargetException e) {
            e.printStackTrace();
        } catch (final NoSuchMethodException e) {
            e.printStackTrace();
        } catch (final InstantiationException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param hibernateCriteria
     * @param propName
     * @param propValue
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private void setAssociatedObjectCriteria(final Criteria hibernateCriteria, final String propName, final BusinessObject propValue)
            throws InstantiationException, IllegalAccessException {

        /*
         * if (propName.length() > 1) { propName = propName.substring(0, 1).toLowerCase() + propName.substring(1); }
         * else { propName = propName.toLowerCase(); }
         */
        final Criteria assHc = hibernateCriteria.createCriteria(propName);
        final org.hibernate.criterion.Example hibEx = org.hibernate.criterion.Example.create(this
                .cloneBusinessObjectWithPKOnly(propValue));
        assHc.add(hibEx);
    }

    /**
     * Creates a new instance of an object of the same class type and then copies primary key value of the given object
     * to the newly created one.
     *
     * @param propValue
     *            given business object
     * @return newly created with only primary key populated.
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private BusinessObject cloneBusinessObjectWithPKOnly(final BusinessObject bo) throws InstantiationException,
            IllegalAccessException {

        final Class cl = bo.getClass();
        final BusinessObject newBo = (BusinessObject) cl.newInstance();
        newBo.setPrimaryKey(bo.getPrimaryKey());

        return newBo;
    }

    /**
     * @param likeMatchMode
     * @return
     */
    private org.hibernate.criterion.MatchMode convertMatchMode(final MatchMode likeMatchMode) {

        if (likeMatchMode.equals(MatchMode.ANYWHERE))
            return org.hibernate.criterion.MatchMode.ANYWHERE;

        if (likeMatchMode.equals(MatchMode.END))
            return org.hibernate.criterion.MatchMode.END;

        if (likeMatchMode.equals(MatchMode.EXACT))
            return org.hibernate.criterion.MatchMode.EXACT;

        if (likeMatchMode.equals(MatchMode.START))
            return org.hibernate.criterion.MatchMode.START;

        throw new IllegalStateException("Unknown match mode:" + likeMatchMode);
    }

    /*
     * Interprets property "prop.subprop" as alias -> prop, propertyName -> subprop, "prop" as alias -> null,
     * propertyName->prop
     */
    class SimpleProperty {

        private String propertyName;

        private String alias;

        public SimpleProperty(final String property) {

            final String[] strs = property.split("\\.");

            if (strs.length > 1) {
                this.alias = strs[0];
                this.propertyName = strs[1];
            } else {
                this.propertyName = strs[0];
            }
        }

        public String getPropertyName() {

            return this.propertyName;
        }

        public String getAlias() {

            return this.alias;
        }

        public boolean hasAlias() {

            return this.alias != null;
        }
    }
}
