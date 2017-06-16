<<<<<<< HEAD
package com.salesmanager.core.business.services.shipping;

import com.salesmanager.core.business.services.common.generic.SalesManagerEntityService;
import com.salesmanager.core.model.merchant.MerchantStore;
import com.salesmanager.core.model.shipping.ShippingOrigin;

/**
 * ShippingOrigin object if different from MerchantStore address.
 * Can be managed through this service.
 * @author carlsamson
 *
 */
public interface ShippingOriginService  extends SalesManagerEntityService<Long, ShippingOrigin> {

	ShippingOrigin getByStore(MerchantStore store);



}
=======
package com.salesmanager.core.business.services.shipping;

import com.salesmanager.core.business.services.common.generic.SalesManagerEntityService;
import com.salesmanager.core.model.merchant.MerchantStore;
import com.salesmanager.core.model.shipping.ShippingOrigin;

/**
 * ShippingOrigin object if different from MerchantStore address.
 * Can be managed through this service.
 * @author carlsamson
 *
 */
public interface ShippingOriginService  extends SalesManagerEntityService<Long, ShippingOrigin> {

	ShippingOrigin getByStore(MerchantStore store);



}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
