/*
Create a class called Spider that spiders animal pictures from a website.
The url will be passed to this class as a parameter.
All pictures will be saved to a folder called "animals"
 */

// import libraries

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SpiderCityOfIrvine {

    public static final String PETHARBOR_BASE_URL = "https://petharbor.com/";
    public static final List<String> imageUrls = new ArrayList<>();
    // declare variables
    private String url;


    // constructor
    public SpiderCityOfIrvine(String url) {
        this.url = url;
//        this.imageUrls = new ArrayList<>();

    }

    public SpiderCityOfIrvine() {
    }

    // method to get all image urls from a website
    public void getImageUrls() throws IOException {
        // get the html source code from the website
        Document doc = Jsoup.connect(url).get();
        Elements images = doc.select("img");

        for (Element image : images) {
            // get the image url and include base url
            // todo: refactor this so other sites can use this method.
            String imageUrl = PETHARBOR_BASE_URL + image.attr("src");

            imageUrls.add(imageUrl);
        }
    }

    public void getImageUrls(String url) throws IOException {
        // get the html source code from the website
        Document doc = Jsoup.connect(url).get();
        Elements images = doc.select("img");

        for (Element image : images) {
            // get the image url and include base url
            // todo: refactor this so other sites can use this method.
            String imageUrl = PETHARBOR_BASE_URL + image.attr("src");
            // add the image url to the list
            imageUrls.add(imageUrl);
        }
    }

    public List<Pet> parsePetInfo(String url) throws IOException {
        // Determine petType by searching for word "dog" or "cat" in url
        String petType = deterinePetTypeFromUrl(url);

        // get the html source code from the website and find each pet in class"gridResult"

        List<Pet> pets = new ArrayList<>();
        Document doc = Jsoup.connect(url).get();
        Elements petInfo = doc.select("div.gridResult");
        for (Element petElement : petInfo) {
            Pet pet = new Pet();
            // get the image url and include base url
            pet.setImage(PETHARBOR_BASE_URL + petElement.select("img").attr("src"));
            // get the pet name in class "gridText" with tab <b>
            pet.setName(petElement.select("b").text());
            pet.setType(petType);
            pet.setId(petElement.child(1).childNode(2).toString());
            pet.setSex(petElement.child(2).text());
            pet.setBreed(petElement.child(3).text());
            pet.setAge(petElement.child(4).text());

            pets.add(pet);

        }
        return pets;

    }

    private String deterinePetTypeFromUrl(String url) {
        if (url.contains("DOG")) return "Dog";
        else if (url.contains("CAT")) return "Cat";
        else return "";
    }


    // method to download all the images
    public void downloadImages() {
        // loop through the image urls
        for (String imageUrl : imageUrls) {
            // download the image
            String folder = "animalpictures";
            DownloadImage.download(imageUrl, folder);
        }
    }

    // print image urls
    public void printImageUrls() {
        for (String imageUrl : imageUrls) {
            System.out.println(imageUrl);
        }
    }


    private static class DownloadImage {
        public static void download(String imageUrl, String folder) {
            // create a new folder if it doesn't exist
            boolean isDirectoryCreated = new java.io.File(folder).mkdir() ||
                    new java.io.File(folder).isDirectory();

            // create unique UUID for the file name
            java.io.File file = new java.io.File(folder + "/" + java.util.UUID.randomUUID() + ".jpg");
            // download the image
            try {
                org.jsoup.Connection.Response response = org.jsoup.Jsoup.connect(imageUrl).ignoreContentType(true).execute();
                java.io.FileOutputStream fos = new java.io.FileOutputStream(file);
                fos.write(response.bodyAsBytes());
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
