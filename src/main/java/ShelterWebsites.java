import lombok.Getter;

@Getter
public class ShelterWebsites {

    public String pet_harbor = "https://petharbor.com/results.asp?searchtype=ADOPT&start=4&grid=1&friends=1&samaritans=1&nosuccess=0&orderby=Name&rows=96&imght=200&imgres=Detail&tWidth=200&view=sysadm.v_irvn1&nobreedreq=1&bgcolor=ffffff&text=000000&link=04509c&alink=056dd3&vlink=04509c&fontface=verdana&fontsize=11&col_hdr_bg=04509c&col_hdr_fg=ffffff&col_bg=ffffff&col_bg2=9ddfed&col_fg=black&zip=92606&miles=10&shelterlist=%27IRVN%27&atype=&where=type_DOG";
    public String pet_harbor_cats = "https://petharbor.com/results.asp?searchtype=ADOPT&start=4&grid=1&friends=1&samaritans=1&nosuccess=0&orderby=Name&rows=96&imght=120&imgres=Detail&tWidth=200&view=sysadm.v_irvn1&nobreedreq=1&bgcolor=ffffff&text=000000&link=04509c&alink=056dd3&vlink=04509c&fontface=verdana&fontsize=11&col_hdr_bg=04509c&col_hdr_fg=ffffff&col_bg=ffffff&col_bg2=9ddfed&col_fg=black&zip=92606&miles=10&shelterlist=%27IRVN%27&atype=&where=type_CAT&PAGE=1";
    public String shamrock = "https://www.shamrockrescue.org/animals/browse?Page=1&Status=Available,Sponsorship";
    public String adobt_a_pet = "https://www.adoptapet.com/pet-search?clan_id=1&geo_range=50&location=Tustin,%20CA&page=2#";
    public String petConnect = "https://24petconnect.com/";
    public String OcAnimalCare = "http://petadoption.ocpetinfo.com/Adopt/#/list/DOG";

    // Oc Animal Care
    public String OcAnimalCareAPIDog = "https://petadoption.ocpetinfo.com/Adopt/Service/adoptlist.php?type=DOG";
    public String OcAnimalCareAPICat = "https://petadoption.ocpetinfo.com/Adopt/Service/adoptlist.php?type=CAT";
    // how to create the image link:
    // http://petadoption.ocpetinfo.com/Adopt/img/servicethumb.php?tab=adopt&detailid=A1738196

    private String[] websites;


    public ShelterWebsites() {
        loadWebsites();
    }

    public String[] getWebsites() {
        return websites;
    }

    private void loadWebsites() {
        websites = new String[]{pet_harbor, pet_harbor_cats, shamrock};
    }

}
