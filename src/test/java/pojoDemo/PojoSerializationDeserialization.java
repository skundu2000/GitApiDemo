package pojoDemo;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import payload.Employee;

public class PojoSerializationDeserialization {
  @Test(priority =1)
  public void serializeEmployee() throws JsonProcessingException {
	  
	  Employee employee = new Employee();
	  employee.setFirstName("Harry");
	  employee.setLastName("Potter");
	  employee.setAge(25);
	  employee.setSalary(60000.0);
	  
	  // converting java class object to  JSON payload as String
	  ObjectMapper objectmapper = new ObjectMapper();
	  
	  String value = objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
	  System.out.println(value); // output in JSON format	  
	  
  }
  @Test(priority =2)
  public void deserializeEmployee() throws JsonProcessingException {
	  Employee employee = new Employee();
	  employee.setFirstName("Ron");
	  employee.setLastName("Weasely");
	  employee.setAge(26);
	  employee.setSalary(50000.0);
	  
	  // converting java class object to  JSON payload as String
	  ObjectMapper objectmapper = new ObjectMapper();
	  String empData = objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
	  System.out.println(empData);
	  
	  //converting JSON payload to Java object
	  Employee empObject = objectmapper.readValue(empData, Employee.class);
	  System.out.println("Firstname: " + empObject.getFirstName());
	  System.out.println("Lastname: " + empObject.getLastName());
	  System.out.println("Age: " + empObject.getAge());
	  System.out.println("salary: " + empObject.getSalary());
	  
	  
  }
  
  
  
}

