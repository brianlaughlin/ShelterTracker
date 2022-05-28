import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShelterTracker {


    public static void main(String[] args) throws IOException {


        ReadJson readJson = new ReadJson();
        readJson.print_animals();

        ShelterWebsites urls = new ShelterWebsites();
        SpiderOcGov spider = new SpiderOcGov();
        spider.parsePetInfo(urls.getOcAnimalCareAPIDog());
        List<Pet> pets = new ArrayList<>();


//        ImagesOnly();
//
//        PetsInfo();
    }

    private static void PetsInfo() throws IOException {
        SpiderCityOfIrvine spiderCityOfIrvine;
        spiderCityOfIrvine = new SpiderCityOfIrvine();
        ShelterWebsites urls = new ShelterWebsites();
        String[] websites = urls.getWebsites();
        SaveJsonFile saveJsonFile = new SaveJsonFile();
        List<Pet> pets = new ArrayList<>();

        // parse pet info from websites
        // Save to json file
        // display pet info
        for (String website : websites) {
            pets.addAll(spiderCityOfIrvine.parsePetInfo(website));
        }

        saveJsonFile.save(pets, "animalpictures/pets.json");

        for (Pet p : pets) {
            System.out.println("Name: " + p.getName());
            System.out.println("Id: " + p.getId());
            System.out.println("Type: " + p.getType());
            System.out.println("Breed: " + p.getBreed());
            System.out.println("Age: " + p.getAge());
            System.out.println("Sex: " + p.getSex());
            System.out.println("Image Url: " + p.getImage());
            System.out.println("--------------------");
        }
    }


    private static void ImagesOnly() throws IOException {
        SpiderCityOfIrvine spiderCityOfIrvine;

        spiderCityOfIrvine = new SpiderCityOfIrvine();
        ShelterWebsites urls = new ShelterWebsites();

        String[] websites = urls.getWebsites();

        for (String website : websites) {
            spiderCityOfIrvine.getImageUrls(website);
        }

        spiderCityOfIrvine.downloadImages();
    }
}
