package pub2504.exoop;

public class HospitalMain {

	public static void main(String[] args) {
		
		Doctor doctor1=new Doctor("홍길동", 55, 20, "외과");
		Patient patient1 = new Patient("환자1", 40,"팔꿈치 골절", "2025-02-10", "2025-06-30",doctor1.getName());
		Nurse nurse1 = new Nurse("홍길순", 30, 5, true, patient1.getName());
		Chemist chemist1= new Chemist("홍약동",50,true, "감기약");
		Nutritionist nutritionist1 = new Nutritionist("홍길밥",40,true,"한식");
		
		Hospital hospital1 = new Hospital("홍길동 병원", "서울", doctor1, nurse1, patient1, chemist1, nutritionist1);
			
		System.out.println(hospital1.getDoctor());
		System.out.println(hospital1.getPatient());
		System.out.println(hospital1.getNurse());
		System.out.println(hospital1.getChemist());
		System.out.println(hospital1.getNutritionist());
		System.out.println(hospital1.getNutritionist().getName());
	
		
	} // main
} // class














