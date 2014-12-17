//$Id$
package enumanalysis;

public class EnumNameAnalysis {

	public enum SALARY {      

	    BASIC_PAY("basic pay STRING"),

	    MEDICAL_ALLOWANCE("Medical Allowance");

	private String name;

	private SALARY(String stringVal) {
	    name=stringVal;
	}
	public String toString(){
	    return name;
	}

	}
	public static void main(String [] arg)
	{
//		SALARY.getEnumByString("Basic Pay");
		System.out.println(SALARY.BASIC_PAY.name());
		System.out.println( SALARY.BASIC_PAY.toString() );
	}
}
