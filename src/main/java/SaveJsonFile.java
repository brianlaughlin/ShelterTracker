/*
Class will take list of POJO objects and save it to a json file with a given name.
It will use the jackson library to do so.
 */

// import libraries
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class SaveJsonFile {

    public void save(List<Pet> list, String fileName) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(fileName), list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
