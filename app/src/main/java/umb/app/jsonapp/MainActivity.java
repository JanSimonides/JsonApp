package umb.app.jsonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            BufferedReader jsonReader = new BufferedReader(new InputStreamReader(this.getResources().openRawResource(R.raw.auta_data)));
            StringBuilder jsonBuilder = new StringBuilder();
            for (String row = null; (row = jsonReader.readLine()) != null; ) {
                jsonBuilder.append(row);
            }

            JSONArray jsonArray = new JSONArray(jsonBuilder.toString());

            ListView listView = findViewById(R.id.list);
            ArrayList<Car> dataModels= new ArrayList<Car>();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                dataModels.add(new Car(jsonObject.getString("name"), jsonObject.getString("value"), jsonObject.getString("farba")));
            }

            MyListAdapater adapter = new MyListAdapater(dataModels,getApplicationContext());
            listView.setAdapter(adapter);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
