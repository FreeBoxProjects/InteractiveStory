package com.example.henrique.interactivestory.list;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.henrique.interactivestory.R;
import com.example.henrique.interactivestory.ui.StoryActivity;

import java.util.ArrayList;
import java.util.List;

public class StoryList extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_list);
        // Cada Objeto é uma Historia
        Stories saturno = new Stories(R.drawable.ic_launcher, "A viagem a aturno",
                "Cleiton é um macaco muito loco que sempre sonhou em viajar pelo espaço, até que ele ganha uma chance, ele rouba uma nave e se aventura pelo espaço sideral", StoryActivity.class);

        Stories urano = new Stories(R.drawable.ic_launcher, "A viagem a uranu",
                "Cleiton está de volta é um macaco muito loco que sempre sonhou em viajar pelo espaço, até que ele ganha uma chance, ele rouba uma nave e se aventura pelo espaço sideral", StoryActivity.class);

        Stories plutão = new Stories(R.drawable.ic_launcher, "A viagem a uranu",
                "Cleiton está de volta é um macaco muito loco que sempre sonhou em viajar pelo espaço, até que ele ganha uma chance, ele rouba uma nave e se aventura pelo espaço sideral", StoryActivity.class);

        Stories sol = new Stories(R.drawable.ic_launcher, "A viagem a uranu",
                "Cleiton está de volta é um macaco muito loco que sempre sonhou em viajar pelo espaço, até que ele ganha uma chance, ele rouba uma nave e se aventura pelo espaço sideral", StoryActivity.class);

        // Refazer denovo
        Stories[] stories = {saturno, urano, plutão, sol};

        ListView listView = (ListView)findViewById(R.id.storiesList);
        Adapter customAdapter = new Adapter(this, stories);
        listView.setAdapter(customAdapter);


    }

}
