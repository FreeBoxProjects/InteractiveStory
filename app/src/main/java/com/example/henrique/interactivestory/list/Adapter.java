package com.example.henrique.interactivestory.list;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.henrique.interactivestory.R;

import org.w3c.dom.Text;

public class Adapter extends ArrayAdapter<Stories> {

    public Adapter(Context context, Stories[] stories) {
        super(context, R.layout.my_file, stories);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.my_file, parent, false);

        Stories item = getItem(position);
        ImageView image = (ImageView) customView.findViewById(R.id.storyImage);
        TextView title = (TextView) customView.findViewById(R.id.storyTitle);
        TextView description = (TextView) customView.findViewById(R.id.description);
        TextView button = (TextView) customView.findViewById(R.id.button);

        image.setImageResource(R.drawable.ic_launcher);
        title.setText(item.getTitle());
        description.setText(item.getDescription());
        button.setText("CONTINUAR");

        return customView;
    }
}


