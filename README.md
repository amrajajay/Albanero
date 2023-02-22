# Assignment : ------
You are tasked with creating a CRUD application in Spring Boot using the Gradle build tool that manages customer data. The customer data should contain the following fields:
● first_name: The first name of the customer. This field is required.
● last_name: The last name of the customer. This field is required.
● address: The address of the customer. This field is required.
● pincode: The pincode of the customer. This field is optional.
● phone_number: The phone number of the customer. This field is required.
● customer_id: A unique identifier for each customer. This field is required and
should be unique.
● city: The city of the customer. This field is required.
● created_on: The date and time when the customer record was created. This field is
required.
 You should also add validations to ensure that the data is entered correctly. For example, the phone number should be in a specific format, and the pincode should be a specific length.
Next, you should create an API that removes duplicate data based on a given input column name. When the API is hit, it should return the first record for each unique value in the input column, and remove any duplicates. For example, if you specify first_name as the input column, the API should return the first record for each unique first name, and remove any duplicates. If there are no duplicates, the API should return all records.
 Finally, you should create an API that allows users to group the data by a given input column value. This API should return the grouped data without removing any records from the database.
