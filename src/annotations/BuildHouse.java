//$Id$
package annotations;

public class BuildHouse {

	@DevelopersTool ("Alice")
	  public void aliceMethod() {
	    System.out.println("This method is written by Alice");
	  }
	  @DevelopersTool ("Popeye")
	  public void buildHouse() {
	    System.out.println("This method is written by Popeye");
	  }
}
