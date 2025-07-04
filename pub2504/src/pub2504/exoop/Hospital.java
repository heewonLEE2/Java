package pub2504.exoop;

public class Hospital {

	private String name;
	private String area;
	private Doctor Doctor;
	private Nurse Nurse;
	private Patient Patient;
	private Chemist Chemist;
	private Nutritionist Nutritionist;

	public Hospital() {
	}

	public Hospital(String name, String area, Doctor doctor, Nurse nurse, Patient patient, Chemist chemist,
			Nutritionist nutritionist) {
		this.name = name;
		this.area = area;
		Doctor = doctor;
		Nurse = nurse;
		Patient = patient;
		Chemist = chemist;
		Nutritionist = nutritionist;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Doctor getDoctor() {
		return Doctor;
	}

	public void setDoctor(Doctor doctor) {
		Doctor = doctor;
	}

	public Nurse getNurse() {
		return Nurse;
	}

	public void setNurse(Nurse nurse) {
		Nurse = nurse;
	}

	public Patient getPatient() {
		return Patient;
	}

	public void setPatient(Patient patient) {
		Patient = patient;
	}

	public Chemist getChemist() {
		return Chemist;
	}

	public void setChemist(Chemist chemist) {
		Chemist = chemist;
	}

	public Nutritionist getNutritionist() {
		return Nutritionist;
	}

	public void setNutritionist(Nutritionist nutritionist) {
		Nutritionist = nutritionist;
	}
	
} // class
