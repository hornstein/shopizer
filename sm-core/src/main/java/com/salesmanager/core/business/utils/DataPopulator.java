<<<<<<< HEAD
/**
 * 
 */
package com.salesmanager.core.business.utils;

import com.salesmanager.core.business.exception.ConversionException;
import com.salesmanager.core.model.merchant.MerchantStore;
import com.salesmanager.core.model.reference.language.Language;

/**
 * @author Umesh A
 *
 */
public interface DataPopulator<Source,Target>
{


    public Target populate(Source source,Target target, MerchantStore store, Language language) throws ConversionException;
    public Target populate(Source source, MerchantStore store, Language language) throws ConversionException;

   
}
=======
/**
 * 
 */
package com.salesmanager.core.business.utils;

import com.salesmanager.core.business.exception.ConversionException;
import com.salesmanager.core.model.merchant.MerchantStore;
import com.salesmanager.core.model.reference.language.Language;

/**
 * @author Umesh A
 *
 */
public interface DataPopulator<Source,Target>
{


    public Target populate(Source source,Target target, MerchantStore store, Language language) throws ConversionException;
    public Target populate(Source source, MerchantStore store, Language language) throws ConversionException;

   
}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
