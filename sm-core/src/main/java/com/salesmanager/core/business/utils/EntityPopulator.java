<<<<<<< HEAD
/**
 * 
 */
package com.salesmanager.core.business.utils;

import com.salesmanager.core.business.exception.ConversionException;
import com.salesmanager.core.model.merchant.MerchantStore;

/**
 * @author Umesh A
 *
 */
public interface EntityPopulator<Source,Target>
{

    public Target populateToEntity(Source source, Target target, MerchantStore store)  throws ConversionException;
    public Target populateToEntity(Source source) throws ConversionException;
}
=======
/**
 * 
 */
package com.salesmanager.core.business.utils;

import com.salesmanager.core.business.exception.ConversionException;
import com.salesmanager.core.model.merchant.MerchantStore;

/**
 * @author Umesh A
 *
 */
public interface EntityPopulator<Source,Target>
{

    public Target populateToEntity(Source source, Target target, MerchantStore store)  throws ConversionException;
    public Target populateToEntity(Source source) throws ConversionException;
}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
