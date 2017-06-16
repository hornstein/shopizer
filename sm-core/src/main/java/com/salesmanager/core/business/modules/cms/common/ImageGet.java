<<<<<<< HEAD
package com.salesmanager.core.business.modules.cms.common;

import java.util.List;

import com.salesmanager.core.business.exception.ServiceException;
import com.salesmanager.core.model.content.FileContentType;
import com.salesmanager.core.model.content.OutputContentFile;

public interface ImageGet
{

    public List<OutputContentFile> getImages( final String merchantStoreCode, FileContentType imageContentType )
        throws ServiceException;

}
=======
package com.salesmanager.core.business.modules.cms.common;

import java.util.List;

import com.salesmanager.core.business.exception.ServiceException;
import com.salesmanager.core.model.content.FileContentType;
import com.salesmanager.core.model.content.OutputContentFile;

public interface ImageGet
{

    public List<OutputContentFile> getImages( final String merchantStoreCode, FileContentType imageContentType )
        throws ServiceException;

}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
