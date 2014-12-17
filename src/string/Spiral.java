//$Id$
package string;

public class Spiral {
	
	    public static final int RIGHT = 1, DOWN = 2, LEFT = 3, UP = 4;
	    public static int[][] output = null;
	    public static int posX = 0, posY = 0;

	    public static void main(String[] args) {
	        int input = 7;
	        int needle = 0, serializer = input, counter = input, decerementer = 1, needleChanger = 0;
	        int direction[] = {RIGHT, DOWN, LEFT, UP};
	        output = new int[input][input];

	        for (int i = 1; i <= input * input; i++) {

	            if (serializer == input && counter > 0) {
	                fillArray( direction[needle], i );
	                counter--;
	            } else {
	                if (counter == 0) {
	                    if (decerementer == 1) {
	                        /* for first time, after running the first row ( line )*/
	                        serializer = input - decerementer;
	                        counter = input - decerementer;
	                        decerementer++;
	                        needle++;
	                        needleChanger++;
	                    } else {
	                        if ( needleChanger % 2 == 0 ) {
	                            serializer = input - decerementer;
	                            counter = serializer;
	                            decerementer++;
	                            needle++;
	                            needleChanger = 1;
	                        } else {
	                            counter = serializer;
	                            needle++;
	                            needleChanger++;
	                        }

	                        if (needle == 4) {
	                            needle = 0;
	                        }
	                    }
	                }
	                fillArray( direction[needle], i );
	                counter--;
	            }
	        }

	        /*print output*/
	        for (int m = 0; m < input; m++) {
	            for (int n = 0; n < input; n++) {
	                System.out.print(output[m][n] + "\t");
	            }
	            System.out.print("\n\n");
	        }
	    }

	    public static void fillArray(int needle, int input) {

	        if (needle == RIGHT && output[posX][posY] == 0) /* for the first case when posX and posY are 0 */ {
	            posX = posX == 0 ? -1 : posX;            
	        }

	        switch (needle) {
	            case RIGHT:
	                posX = posX + 1;
	                break;

	            case DOWN:
	                posY = posY + 1;
	                break;

	            case LEFT:
	                posX = posX - 1;
	                break;

	            case UP:
	                posY = posY - 1;
	                break;
	        }
	        
	        output[posY][posX] = input;
	    }
	}
