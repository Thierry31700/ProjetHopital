package dao;

import model.Patient;


public interface IDAOPatient extends IDAO<Patient,Integer>{

	Patient findByIdWithVisites(int secu);

}
