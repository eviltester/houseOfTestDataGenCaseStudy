import org.junit.Assert;
import org.junit.Test;
import yhtest.tool.datageneration.DataGeneration;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Alan on 02/03/2016.
 */
public class AlanTest {

    @Test
    public void checkProbabilitiesOfLowercase() throws IOException {

        DataGeneration datagen = new DataGeneration();
        datagen.setToClipBoard(false);

        HashMap<String, Integer> counts = new HashMap<String, Integer>();

        int stringLength = 100;
        int numberOfString = 10000;

        for(int x=0; x<numberOfString; x++){

            String generated = datagen.generateRandomString(stringLength, "l");
            Assert.assertEquals(stringLength, generated.length() );
            System.out.println(generated);

            for(int theChar=0; theChar< generated.length(); theChar++){
                String aChar = String.valueOf(generated.charAt(theChar));

                Integer aCount;

                if(!counts.keySet().contains(aChar)){
                    aCount = 0;
                }else{
                    aCount = counts.get(aChar);
                }

                aCount++;

                counts.put(aChar, aCount);
            }
        }

        System.out.println("\nCounts\n======\n");

        for(String aChar : counts.keySet()){
            System.out.println(aChar + " - " + counts.get(aChar));
        }
    }
}
