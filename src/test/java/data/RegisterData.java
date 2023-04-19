package data;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RegisterData {

    public String firstName,lastName,email,password;

    public void readData() throws IOException, ParseException {
        File file=new File("src/test/java/data/register.json");
        JSONParser parser=new JSONParser();
       JSONArray jsonArray =(JSONArray) parser.parse(new FileReader(file));
       for(Object obj : jsonArray)
       {
           JSONObject data=(JSONObject) obj;
           firstName=(String)data.get("firstname");
           lastName= (String) data.get("lastname");
           email= (String) data.get("email");
           password= (String) data.get("password");
       }


    }


}
