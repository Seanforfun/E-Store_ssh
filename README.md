# E-Stroe_ssh
An E-store based on Struts2, Hibernate and Spring.

## STEP1: Database design:
	DataBase Design:
		User table:
			user_id
			user_username,
			user_password,
			user_phone,
			user_e-mail,
			user_name,
			user_gender,
			user_address,
			user_status(if activative),
			user_activative_code
			
		Classification table:
			level1 table:
				level1_id,
				level1_name
				
			level2 table:
				level2_id,
				level2_name,
				level2_belonging(refer to level1 table)
				
		Product table:
			product_id,
			product_name,
			product_store_price,
			product_advice_price,
			product_desc,
			product_photo,
			product_belonging(refer to level2 table)
			
		Order table:
			order_id,
			order_time,
			order_address,
			order_total_price,
			order_status,
			order_belonging(refer to user)
			
		Product_Order_Middle table:
			middle_id,
			middle_product_id,
			middle_order_id,
			middle_number,
			middle_subtotal

![](https://github.com/Seanforfun/E-Stroe_ssh/raw/master/readme_resource/Database_relationship.jpg)
	
## STEP2: Import Jar , configuration files and static web page:
	Import jar for struts, hibernate and spring.	
		antlr-2.7.6.jar
		asm-3.3.jar
		asm-commons-3.3.jar
		asm-tree-3.3.jar
		com.springsource.com.mchange.v2.c3p0-0.9.1.2.jar
		com.springsource.org.aopalliance-1.0.0.jar
		com.springsource.org.apache.commons.logging-1.1.1.jar
		com.springsource.org.apache.log4j-1.2.15.jar
		com.springsource.org.aspectj.tools-1.6.6.RELEASE.jar
		com.springsource.org.aspectj.weaver-1.6.8.RELEASE.jar
		commons-beanutils-1.8.3.jar
		commons-collections-3.1.jar
		commons-fileupload-1.3.jar
		commons-io-2.0.1.jar
		commons-lang3-3.1.jar
		commons-logging-1.1.1.jar
		commons-logging-1.1.3.jar
		dom4j-1.6.1.jar
		freemarker-2.3.19.jar
		hibernate-jpa-2.0-api-1.0.1.Final.jar
		hibernate3.jar
		javassist-3.11.0.GA.jar
		javassist-3.12.0.GA.jar
		jta-1.1.jar
		log4j-1.2.17.jar
		mysql-connector-java-5.0.8-bin.jar
		mysql-connector-java-5.1.28-bin.jar
		ognl-3.0.6.jar
		ojdbc14.jar
		slf4j-api-1.6.1.jar
		slf4j-log4j12-1.7.2.jar
		spring-aop-3.2.0.RELEASE.jar
		spring-aspects-3.2.0.RELEASE.jar
		spring-beans-3.2.0.RELEASE.jar
		spring-context-3.2.0.RELEASE.jar
		spring-core-3.2.0.RELEASE.jar
		spring-expression-3.2.0.RELEASE.jar
		spring-jdbc-3.2.0.RELEASE.jar
		spring-orm-3.2.0.RELEASE.jar
		spring-test-3.2.0.RELEASE.jar
		spring-tx-3.2.0.RELEASE.jar
		spring-web-3.2.0.RELEASE.jar
		struts2-convention-plugin-2.3.15.1.jar
		struts2-core-2.3.15.1.jar
		struts2-junit-plugin-2.3.15.1.jar
		struts2-spring-plugin-2.3.15.1.jar
		xwork-core-2.3.15.1.jar
		
	Import configuration files:
		applicationContext.xml
		hibernate.cfg.xml
		log4j.properties
		struts.xml
## STEP3: Create index page and login page.
