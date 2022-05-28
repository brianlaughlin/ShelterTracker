import com.google.gson.JsonObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SpiderOcGov {

    public static final List<String> imageUrls = new ArrayList<>();
    // declare variables
    private String url;

    public SpiderOcGov(String url) {
        this.url = url;
    }

    public SpiderOcGov() {
    }

    // parse the html page for pet information
    public List<Pet> parsePetInfo(String url) throws IOException {

        String petType = deterinePetTypeFromUrl(url);

        // Request API using url nd receive Json data
        String json = Jsoup.connect(url).ignoreContentType(true).execute().body();

        // parse the json data
        List<Pet> pets = new ArrayList<>();
        // parse json data animals find animal_id and pet.setId(animal_id)
        JsonObject jsonObject = SpiderOcGov.parseJson(json);
        // parse json data animals find animal_name and pet.setName(animal_name)
        String animal_name = jsonObject.get("animal_name").getAsString();
        // parse json data animals find animal_age and pet.setAge(animal_age)
        String animal_age = jsonObject.get("animal_age").getAsString();
//        JsonParser parser = new JsonParser();
//        JsonObject jsonObject = parser.parse(json).getAsJsonObject();

        Pet pet = new Pet();
        pet.setType(petType);


        pets.add(pet);
        return pets;
    }

    private static JsonObject parseJson(String json) {
        JsonObject jsonObject = new JsonObject();
        return jsonObject;
    }

    // todo: refactor this out into a utility class or super class
    private String deterinePetTypeFromUrl(String url) {
        if (url.contains("DOG")) return "Dog";
        else if (url.contains("CAT")) return "Cat";
        else return "";
    }

}


