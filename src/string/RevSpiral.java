//$Id$
package string;

public class RevSpiral {
	
    public static final int RIGHT = 4, DOWN = 1, LEFT = 2, UP = 3;
    public static int[][] output = null;
    public static int posX = 0, posY = 0;

    public static void main(String[] args) {
        int input = 27;
        
        int[] inputNsqrt = findExactInput(input);
        input = inputNsqrt[0];
        int sqrt = inputNsqrt[1];
        int middleColVal = sqrt % 2 == 0 ? ( sqrt /2 ) - 1: sqrt / 2; 
        posX = middleColVal;
        posY = middleColVal;
        
        output = new int[sqrt][sqrt];
        
        int ran = 1;
        int needle = 1;
        int runtime = 1;
        int runtill = 1;
        for ( int j = 1; j <= input; j++  )
        {
        	output[posX][posY] = j;
        	changeDirection(needle);
        	
        	ran = ran - 1;
        	if ( ran == 0 )
        	{	
        		if ( runtime == 2 )
            	{
        			runtill++;
            		runtime = 1;
            		ran = runtill;
            	}
            	else
            	{
            		runtime++;
                	ran = runtill;
            	}
            	
        		needle++;
            	if ( needle == RIGHT + 1)
            	{
            		needle = DOWN;
            	}
            	
        	}
        }
        
        /*print output*/
        for (int m = 0; m < sqrt; m++) {
            for (int n = 0; n < sqrt; n++) {
                System.out.print(output[n][m] + "\t");
            }
            System.out.print("\n\n");
        }
    }

    public static void changeDirection(int needle) {

        
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
        
    }
    
    private static int[] findExactInput ( int input )
    {
    	int sqrt = (int) Math.sqrt(input);
    	
    	if ( input > sqrt * sqrt )
        {
        	input = sqrt * sqrt;
        }
    	
    	return new int[]{input, sqrt};
    }
}
