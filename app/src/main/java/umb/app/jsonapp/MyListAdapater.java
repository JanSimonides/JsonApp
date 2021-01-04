package umb.app.jsonapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListAdapater extends ArrayAdapter<Car> {

    private ArrayList<Car> data;
    Context context;

    // View lookup cache
    private static class ViewHolder {
        TextView name;
        TextView value;
        TextView color;
    }

    public MyListAdapater(ArrayList<Car> data, Context context) {
        super(context, R.layout.row, data);
        this.data = data;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Car car = getItem(position);
        ViewHolder viewHolder;

        final View res;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row, parent, false);
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.value = (TextView) convertView.findViewById(R.id.value);
            viewHolder.color = (TextView) convertView.findViewById(R.id.color);

            res = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            res = convertView;
        }

        viewHolder.name.setText(car.getName());
        viewHolder.value.setText(car.getValue());
        viewHolder.color.setText(car.getColor());

        return convertView;
    }

}
