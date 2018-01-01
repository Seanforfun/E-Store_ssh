# E-Stroe_ssh
An E-store based on Struts2, Hibernate and Spring.

##STEP1: Database design:
	DataBase Design:
		User table:
			user_id
			user_username,
			user_password,
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