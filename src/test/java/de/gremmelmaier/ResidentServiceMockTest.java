package de.gremmelmaier;

import static org.junit.Assert.assertEquals;
import static org.easymock.EasyMock.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ResidentServiceMockTest {
	List<Resident> residents = new ArrayList<Resident>();
	ResidentRepository rep;
	BaseResidentService service = new BaseResidentService();
	
	@Before
	public void vorher(){
		List<Resident> residents = new ArrayList<Resident>();
		residents.add(new Resident("TestName","TestFamilie","TestStraße","TestStadt",null));
		residents.add(new Resident("TestName2","TestFamilie2","TestStraße2","TestStadt2",null));
		residents.add(new Resident("TestName3","TestFamilie3","TestStraße3","TestStadt3",null));
		residents.add(new Resident("TestName4","TestFamilie4","TestStraße4","TestStadt4",null));
		residents.add(new Resident("Name","Familie","Straße","Stadt",new Date()));
		rep = createMock(ResidentRepository.class);
		expect(rep.getResidents()).andReturn(residents);
		service.setResidentRepository(rep);
		replay(rep);
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
		Resident r = service.getUniqueResident(new Resident("Name",null,null,null,null));
		assertEquals(r.getGivenName(),"Name");
		assertEquals(r.getFamilyName(),"Familie");
		assertEquals(r.getStreet(),"Straße");
		assertEquals(r.getCity(),"Stadt");
		verify(rep);
	}
	
	@Test
	public void getFilteredResidentsListWildcardTest(){
		int size = service.getFilteredResidentsList(new Resident("T*","T*","T*","*",null)).size();
		assertEquals(size,4);
		verify(rep);
	}
	
	@Test
	public void getFilteredResidentsListLeerTest(){
		int size = service.getFilteredResidentsList(new Resident("Hans",null,null,null,null)).size(); 
		assertEquals(size,0);
		verify(rep);
	}
	
	@Test
	public void getFilteredResidentsListLeer2Test(){
		int size = service.getFilteredResidentsList(new Resident("T*","T*","Hans",null,null)).size(); 
		assertEquals(size,0);
		verify(rep);
	}
	
	@Test
	public void getFilteredResidentsListLeer3Test(){
		int size = service.getFilteredResidentsList(new Resident("T*","T","Hans",null,null)).size(); 
		assertEquals(size,0);
		verify(rep);
	}
	
	@Test
	public void getFilteredResidentsListNullTest(){
		int size = service.getFilteredResidentsList(new Resident(null,null,null,null,null)).size(); 
		assertEquals(size,5);
		verify(rep);
	}
}
