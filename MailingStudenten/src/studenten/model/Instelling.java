package studenten.model;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Instelling {
    private String docentVoornaam;
    private String docentAchternaam;
    private String linkAfspraak;

    public Instelling() throws IOException, ParseException, URISyntaxException {
        JSONParser parser = new JSONParser();

        URL resource = getClass().getResource("/files/settings.json");
        File file = new File(resource.toURI());

        Object jsonObj = parser.parse(new FileReader(file.getAbsolutePath()));
        JSONObject jsonObject = (JSONObject) jsonObj;

        this.docentVoornaam = (String) jsonObject.get("docentVoornaam");
        this.docentAchternaam = (String) jsonObject.get("docentAchternaam");
        this.linkAfspraak = (String) jsonObject.get("linkAfspraak");
    }

    public String getDocentVoornaam() {
        return docentVoornaam;
    }

    public String getDocentAchternaam() {
        return docentAchternaam;
    }

    public String getLinkAfspraak() {
        return linkAfspraak;
    }

    public void opslaan() {
        JSONObject obj = new JSONObject();
        obj.put("docentVoornaam", "test");
        obj.put("docentAchternaam", "test");
        obj.put("linkAfspraak", "test");
        try {
            URL resource = getClass().getResource("/files/settings.json");
            File file = new File(resource.toURI());

            FileWriter fileWriter = new FileWriter(file.getAbsolutePath());
            fileWriter.write(obj.toJSONString());
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDocentVoornaam(String docentVoornaam) {
        this.docentVoornaam = docentVoornaam;
    }

    public void setDocentAchternaam(String docentAchternaam) {
        this.docentAchternaam = docentAchternaam;
    }

    public void setLinkAfspraak(String linkAfspraak) {
        this.linkAfspraak = linkAfspraak;
    }
}
