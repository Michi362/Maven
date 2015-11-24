package de.gremmelmaier;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ResidentServiceTest {
	private static final ResidentRepositoryStub rep = new ResidentRepositoryStub();
	private static final BaseResidentService service = new BaseResidentService();
	
	@BeforeClass
	public static void initialize(){
		service.setResidentRepository(rep);
	}
	
	
	@Test(expected=ResidentServiceException.class)
	public void uniqueResidentExceptionTest() throws ResidentServiceException{
		//service.setResidentRepository(rep);
		service.getUniqueResident(new Resident(null,null,null,null,null));
	}
	
	@Test(expected=ResidentServiceException.class)
	public void uniqueResidentWildcarsTest() throws ResidentServiceException{
		//service.setResidentRepository(rep);
		service.getUniqueResident(new Resident("*",null,null,null,null));
	}
	
	@Test(expected=ResidentServiceException.class)
	public void uniqueResidentWildcarsTest2() throws ResidentServiceException{
		//service.setResidentRepository(rep);
		service.getUniqueResident(new Resident("Name","*",null,null,null));
	}
	
	@Test(expected=ResidentServiceException.class)
	public void uniqueResidentWildcarsTest3() throws ResidentServiceException{
		//service.setResidentRepository(rep);
		service.getUniqueResident(new Resident("Name","Familie","*",null,null));
	}
	
	@Test
	public void uniqueResidentErfolgTest() throws ResidentServiceException{
		//service.setResidentRepository(rep);
		assertEquals(service.getUniqueResident(new Resident("Name",null,null,null,null)).getGivenName(),"Name");
		assertEquals(service.getUniqueResident(new Resident("Name",null,null,null,null)).getFamilyName(),"Familie");
		assertEquals(service.getUniqueResident(new Resident("Name",null,null,null,null)).getStreet(),"Straße");
		assertEquals(service.getUniqueResident(new Resident("Name",null,null,null,null)).getCity(),"Stadt");
	}
	
	@Test
	public void getFilteredResidentsListWildcardTest(){
		int size = service.getFilteredResidentsList(new Resident("T*","T*","T*","*",null)).size();
		assertEquals(size,4);
	}
	
	@Test
	public void getFilteredResidentsListLeerTest(){
		int size = service.getFilteredResidentsList(new Resident("Hans",null,null,null,null)).size(); 
		assertEquals(size,0);
	}
	
	@Test
	public void getFilteredResidentsListLeer2Test(){
		int size = service.getFilteredResidentsList(new Resident("T*","T*","Hans",null,null)).size(); 
		assertEquals(size,0);
	}
	
	@Test
	public void getFilteredResidentsListLeer3Test(){
		int size = service.getFilteredResidentsList(new Resident("T*","T","Hans",null,null)).size(); 
		assertEquals(size,0);
	}
	
	@Test
	public void getFilteredResidentsListNullTest(){
		int size = service.getFilteredResidentsList(new Resident(null,null,null,null,null)).size(); 
		assertEquals(size,5);
	}
	

}
