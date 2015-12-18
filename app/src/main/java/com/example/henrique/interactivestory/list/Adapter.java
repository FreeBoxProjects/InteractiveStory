package com.example.henrique.interactivestory.list;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.henrique.interactivestory.R;
import com.example.henrique.interactivestory.ui.StoryActivity;

import org.w3c.dom.Text;

public class Adapter extends ArrayAdapter<Stories> {
    private Stories mItem;
    private Context mContext;

    public Adapter(Context context, Stories[] stories) {
        super(context, R.layout.my_file, stories);
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.my_file, parent, false);

        mItem = getItem(position);
        ImageView image = (ImageView) customView.findViewById(R.id.storyImage);
        TextView title = (TextView) customView.findViewById(R.id.storyTitle);
        TextView description = (TextView) customView.findViewById(R.id.description);
        TextView button = (TextView) customView.findViewById(R.id.button);

        image.setImageResource(mItem.getImage());
        title.setText(mItem.getTitle());
        description.setText(mItem.getDescription());
        button.setText("CONTINUAR");



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Class destine = mItem.getDestine();
                if(destine == StoryActivity.class) {
                    mContext.startActivity(new Intent(mContext, StoryActivity.class));
                }

            }
        });

        return customView;
    }
}


