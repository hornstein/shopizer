<<<<<<< HEAD
package com.salesmanager.core.business.services.user;

import java.util.List;
import java.util.Set;

import com.salesmanager.core.business.exception.ServiceException;
import com.salesmanager.core.business.services.common.generic.SalesManagerEntityService;
import com.salesmanager.core.model.user.Group;
import com.salesmanager.core.model.user.GroupType;


public interface GroupService extends SalesManagerEntityService<Integer, Group> {


	List<Group> listGroup(GroupType groupType) throws ServiceException;
	List<Group> listGroupByIds(Set<Integer> ids) throws ServiceException;

}
=======
package com.salesmanager.core.business.services.user;

import java.util.List;
import java.util.Set;

import com.salesmanager.core.business.exception.ServiceException;
import com.salesmanager.core.business.services.common.generic.SalesManagerEntityService;
import com.salesmanager.core.model.user.Group;
import com.salesmanager.core.model.user.GroupType;


public interface GroupService extends SalesManagerEntityService<Integer, Group> {


	List<Group> listGroup(GroupType groupType) throws ServiceException;
	List<Group> listGroupByIds(Set<Integer> ids) throws ServiceException;

}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
