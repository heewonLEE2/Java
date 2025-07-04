package pub2504.exoop;

public class Patient {

	private  String name;
	private int age;
	private String diseaseName;
	// 입원 날짜
	private String hospitalizationDate;
	// 퇴원 날짜
	private String dischargeDate;
	// 담당의사
	private String doctorInCharge;
	
	public Patient() {
	}
	
	public Patient(String name, int age, String diseaseName, String hospitalizationDate, String dischargeDate,
			String doctorInCharge) {
		this.name = name;
		this.age = age;
		this.diseaseName = diseaseName;
		this.hospitalizationDate = hospitalizationDate;
		this.dischargeDate = dischargeDate;
		this.doctorInCharge = doctorInCharge;
	}

	public  String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDiseaseName() {
		return diseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	public String getHospitalizationDate() {
		return hospitalizationDate;
	}

	public void setHospitalizationDate(String hospitalizationDate) {
		this.hospitalizationDate = hospitalizationDate;
	}

	public String getDischargeDate() {
		return dischargeDate;
	}

	public void setDischargeDate(String dischargeDate) {
		this.dischargeDate = dischargeDate;
	}

	public String getDoctorInCharge() {
		return doctorInCharge;
	}

	public void setDoctorInCharge(String doctorInCharge) {
		this.doctorInCharge = doctorInCharge;
	}
	
	@Override
	public String toString() {
		return   "---환자 정보--- \n" + "이름 : " + this.name +"\n"	+
					"병명 : " + this.diseaseName  +"\n"	+
					"입원 날짜 : " + this.hospitalizationDate  +"\n"	+
					"퇴원 날짜 : " + this.dischargeDate + "\n" +
					"담당 의사 : " + this.doctorInCharge + "\n"
			;
	}
} // class
