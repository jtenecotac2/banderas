package com.example.banderas;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class banderaecua {
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getUrlLogo() {
        return UrlLogo;
    }

    public void setUrlLogo(String urlLogo) {
        UrlLogo = urlLogo;
    }
    public banderaecua(JSONObject a, String CountryCode) throws JSONException {
        Nombre = a.getString("Name").toString();
        UrlLogo = "http://www.geognos.com/api/en/countries/flag/" + CountryCode + ".png";
    }
    public static ArrayList<banderaecua> JsonObjectsBuild(JSONObject datos) throws JSONException {
        ArrayList<banderaecua> lstpaises = new ArrayList<>();
        Iterator<String> keys = datos.keys();
        while (keys.hasNext()) {
            String CountryCode = keys.next();
            JSONObject a = datos.getJSONObject(CountryCode);
            lstpaises.add(new banderaecua(a, CountryCode));
        }
        return lstpaises;
    }
    String Nombre,  UrlLogo;
}
