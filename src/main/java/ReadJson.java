/*
Convert this python code to Java code:
class ReadJson():
    def __init__(self):
        self.url = "https://petadoption.ocpetinfo.com/Adopt/Service/adoptlist.php?type=DOG"
        self.json_data = self.get_json()
        self.animals = self.parse_json()

    def get_json(self):
        '''
        Get the json data from the url
        '''
        response = requests.get(self.url)
        return response.json()

    def parse_json(self):
        '''
        Parse the json data into a list of dictionaries
        '''
        animals = []
        for animal in self.json_data['animals']:
            animals.append(animal)
        return animals

    def print_animals(self):
        '''
        Print the animals
        '''
        for animal in self.animals:
            print(animal)

    def write_animals(self):
        '''
        Write the animals to a file
        '''
        with open('animals.txt', 'w') as f:
            for animal in self.animals:
                f.write(str(animal) + '\n')


if __name__ == '__main__':
    read_json = ReadJson()
    read_json.print_animals()
    read_json.write_animals()
    print('Done')
 */

// import libraries

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ReadJson {
    // declare variables
    private String url;
    private List<String> animals = new ArrayList<>();
    private List<String> animal_info = new ArrayList<>();
    private List<String> animal_info_list = new ArrayList<>();

    // constructor
    public ReadJson() {
        this.url = "https://petadoption.ocpetinfo.com/Adopt/Service/adoptlist.php?type=DOG";
        this.animals = this.parse_json();
    }

    private List<String> parse_json() {
        // get json data
        String json_data = this.get_json();
        // parse json data
        List<String> animals = new ArrayList<>();
        for (String animal : json_data.split("\\{")) {
            if (animal.length() > 0) {
                animals.add(animal);
            }
        }
        return animals;
    }

    private String get_json() {
        // get json data from url
        String json_data = "";
        try {
            Scanner sc = new Scanner(new java.net.URL(this.url).openStream());
            while (sc.hasNext()) {
                json_data += sc.nextLine();
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json_data;
    }

    public void print_animals() {
        // print animals
        for (String animal : this.animals) {
            System.out.println(animal);
        }
    }

    public void write_animals() {
        // write animals to file
        try {
            File file = new File("animals.txt");
            FileWriter fw = new FileWriter(file);
            for (String animal : this.animals) {
                fw.write(animal + "\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void get_animal_info() {
        // get animal info
        for (String animal : this.animals) {
            String[] animal_info = animal.split("\\},\\{");
            for (String info : animal_info) {
                this.animal_info.add(info);
            }
        }
    }

    public void get_animal_info_list() {
        // get animal info list
        for (String animal : this.animal_info) {
            String[] animal_info_list = animal.split(",");
            for (String info : animal_info_list) {
                this.animal_info_list.add(info);
            }
        }
    }

}
