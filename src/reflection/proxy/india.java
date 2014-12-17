package reflection.proxy;

public class india implements cricket {

    
    public String getPlayerState(String playerName) {
        
        String state = null;
        
        if ( playerName.equals("sachin") || playerName.equals("dravid") )
        {
            state = "maharastra";
        }
        else if ( playerName.equals("dada") )
        {
            state = "west bengal";
        }
        else if ( playerName.equals("virat") )
        {
            state = "delhi";
        }
        
        return state;
    }
    
}
