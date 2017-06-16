<<<<<<< HEAD
package com.salesmanager.test.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.salesmanager.core.model"})
@ComponentScan({"com.salesmanager.core.business.services","com.salesmanager.core.business.utils"})
@ImportResource("spring/test-shopizer-context.xml")
public class ConfigurationTest {

}
=======
package com.salesmanager.test.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.salesmanager.core.model"})
@ComponentScan({"com.salesmanager.core.business.services","com.salesmanager.core.business.utils"})
@ImportResource("spring/test-shopizer-context.xml")
public class ConfigurationTest {

}
>>>>>>> 2859f238d2d6bffecb4d317fd3c845ed1cd0db23
