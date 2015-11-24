package de.gremmelmaier;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class ResidentRepositoryStub implements ResidentRepository{
	List<Resident> residents = new ArrayList<Resident>();
	
	ResidentRepositoryStub(){
		residents.add(new Resident("TestName","TestFamilie","TestStraße","TestStadt",null));
		residents.add(new Resident("TestName2","TestFamilie2","TestStraße2","TestStadt2",null));
		residents.add(new Resident("TestName3","TestFamilie3","TestStraße3","TestStadt3",null));
		residents.add(new Resident("TestName4","TestFamilie4","TestStraße4","TestStadt4",null));
		residents.add(new Resident("Name","Familie","Straße","Stadt",new Date()));
	}
	
	public List<Resident> getResidents() {
		// TODO Auto-generated method stub
		return residents;
	}
	
}
