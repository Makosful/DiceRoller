package com.github.makosful.diceroller.gui.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.makosful.diceroller.R;

import java.util.List;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ViewHolder>
{
    private List<String> resultList;
    private Context context;

    public ResultAdapter(List<String> resultList, Context context)
    {
        this.resultList = resultList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.recycle_list_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i)
    {
        String dr = resultList.get(i);

        viewHolder.result.setText(dr);
    }

    @Override
    public int getItemCount()
    {
        return resultList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        public TextView result;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            result = itemView.findViewById(R.id.tv_Result);
        }
    }
}
