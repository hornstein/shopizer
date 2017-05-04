<<<<<<< HEAD
package com.salesmanager.core.business.modules.cms.content;


import com.salesmanager.core.business.exception.ServiceException;
import com.salesmanager.core.business.modules.cms.common.ImageRemove;
import com.salesmanager.core.model.content.FileContentType;

public interface ContentImageRemove extends ImageRemove {
	
	
	
	public void removeImage(final String merchantStoreCode,final FileContentType imageContentType, final String imageName) throws ServiceException;

}
=======
package com.salesmanager.core.business.modules.cms.content;


import com.salesmanager.core.business.exception.ServiceException;
import com.salesmanager.core.business.modules.cms.common.ImageRemove;
import com.salesmanager.core.model.content.FileContentType;

public interface ContentImageRemove extends ImageRemove {
	
	
	
	public void removeImage(final String merchantStoreCode,final FileContentType imageContentType, final String imageName) throws ServiceException;

}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
