package com.github.makosful.diceroller.gui.model;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.github.makosful.diceroller.R;
import com.github.makosful.diceroller.be.Die;

import java.util.List;

public class DiceGridApadter extends ArrayAdapter<Die>
{

    private final Context context;
    private final int resource;
    private final List<Die> data;

    public DiceGridApadter(Context context, int resource, List<Die> data)
    {
        super(context, resource, data);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View row = convertView;
        ViewHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(resource, parent, false);
            holder = new ViewHolder();
            holder.imageView = (ImageView) row.findViewById(R.id.iv_diceImage);
            row.setTag(holder);
        }
        else {
            holder = (ViewHolder) row.getTag();
        }

        Die die = data.get(position);
        holder.imageView.setImageDrawable(die.getDrawable());
        return row;
    }

    class ViewHolder
    {
        ImageView imageView;
    }
}
