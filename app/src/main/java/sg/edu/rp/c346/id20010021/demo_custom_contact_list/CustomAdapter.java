package sg.edu.rp.c346.id20010021.demo_custom_contact_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Contact> contactList;

    public CustomAdapter(Context context, int resoucre, ArrayList<Contact> objects){
        super(context, resoucre, objects);
        parent_context=context;
        layout_id=resoucre;
        contactList=objects;



    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) parent_context.
                getSystemService(parent_context.LAYOUT_INFLATER_SERVICE);


        View rowView = inflater.inflate(layout_id, parent, false);
        ImageView ivGender=rowView.findViewById(R.id.imageViewGender);

        TextView tvName = rowView.findViewById(R.id.tvName);
        TextView tvCode = rowView.findViewById(R.id.tvCode);
        TextView tvNum = rowView.findViewById(R.id.tvNum);

        Contact currentItem = contactList.get(position);
        tvName.setText(currentItem.getName());
        tvCode.setText("+"+currentItem.getCountryCode());
        tvNum.setText(currentItem.getPhoneNum()+"");

        if (currentItem.getGender()=='f'|| currentItem.getGender()=='F'){
            ivGender.setImageResource(R.drawable.female);
        } else if(currentItem.getGender()=='m'||currentItem.getGender()=='M'){
            ivGender.setImageResource(R.drawable.male);
        }


        return rowView;
    }
}
