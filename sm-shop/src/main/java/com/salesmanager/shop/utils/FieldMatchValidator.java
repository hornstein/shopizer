<<<<<<< HEAD
package com.salesmanager.shop.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object>
{
    
    private static final Logger LOG=LoggerFactory.getLogger(FieldMatchValidator.class);
    private String firstFieldName;
    private String secondFieldName;
    private BeanUtils beanUtils;

    @Override
    public void initialize(final FieldMatch constraintAnnotation)
    {
        this.firstFieldName = constraintAnnotation.first();
        this.secondFieldName = constraintAnnotation.second();
        this.beanUtils=BeanUtils.newInstance();
    }

    @SuppressWarnings( "nls" )
    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context)
    {
        try
        {
            final Object firstObj = this.beanUtils.getPropertyValue(value, this.firstFieldName);
            final Object secondObj = this.beanUtils.getPropertyValue(value, this.secondFieldName);
            return firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
        }
        catch (final Exception ex)
        {
            LOG.info( "Error while getting values from object", ex );
            return false;
           
        }
       
    }
}
=======
package com.salesmanager.shop.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object>
{
    
    private static final Logger LOG=LoggerFactory.getLogger(FieldMatchValidator.class);
    private String firstFieldName;
    private String secondFieldName;
    private BeanUtils beanUtils;

    @Override
    public void initialize(final FieldMatch constraintAnnotation)
    {
        this.firstFieldName = constraintAnnotation.first();
        this.secondFieldName = constraintAnnotation.second();
        this.beanUtils=BeanUtils.newInstance();
    }

    @SuppressWarnings( "nls" )
    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context)
    {
        try
        {
            final Object firstObj = this.beanUtils.getPropertyValue(value, this.firstFieldName);
            final Object secondObj = this.beanUtils.getPropertyValue(value, this.secondFieldName);
            return firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
        }
        catch (final Exception ex)
        {
            LOG.info( "Error while getting values from object", ex );
            return false;
           
        }
       
    }
}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
