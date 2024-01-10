package com.example.banderas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import webservices.Asynchtask;
import webservices.WebService;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = this.getIntent().getExtras();
        Map<String, String> datos2 = new HashMap<String, String>();
        WebService ws= new WebService("http://www.geognos.com/api/en/countries/info/all.json",
                datos2, MainActivity.this, MainActivity.this);
        ws.execute("GET");


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void processFinish(String result) throws JSONException {

        //Parceo JSON
        ArrayList<banderaecua> listapaises = new ArrayList<banderaecua>();
        JSONObject response = new JSONObject(result);
        JSONObject resultsObject = response.getJSONObject("Results");
        listapaises = banderaecua.JsonObjectsBuild(resultsObject);
        adaptadorbandera adaptadorPais = new adaptadorbandera(this, listapaises);
        ListView lstOpciones = (ListView) findViewById(R.id.txtlista);
        lstOpciones.setAdapter(adaptadorPais);

    }
}