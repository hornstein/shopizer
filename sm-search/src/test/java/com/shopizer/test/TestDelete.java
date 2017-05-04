<<<<<<< HEAD
package com.shopizer.test;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.shopizer.search.services.SearchService;


@ContextConfiguration(locations = {
		"classpath:spring/spring-context-test.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
	DependencyInjectionTestExecutionListener.class
})

/**
 * @author carlsamson
 */
@Ignore
public class TestDelete {
	
	@Inject
	private SearchService searchService;
	
	@Test
	public void testDelete() throws Exception {

		searchService.deleteObject("product_en_default", "product_en", "1");
		
		System.out.println("Done !");
		
	}

}
=======
package com.shopizer.test;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.shopizer.search.services.SearchService;


@ContextConfiguration(locations = {
		"classpath:spring/spring-context-test.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
	DependencyInjectionTestExecutionListener.class
})

/**
 * @author carlsamson
 */
@Ignore
public class TestDelete {
	
	@Inject
	private SearchService searchService;
	
	@Test
	public void testDelete() throws Exception {

		searchService.deleteObject("product_en_default", "product_en", "1");
		
		System.out.println("Done !");
		
	}

}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
