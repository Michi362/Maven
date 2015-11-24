package de.gremmelmaier;

import java.util.List;

import de.gremmelmaier.Resident;

/**
 * @author Stefan Betermieux
 */
public interface ResidentRepository {

  List<Resident> getResidents();

}