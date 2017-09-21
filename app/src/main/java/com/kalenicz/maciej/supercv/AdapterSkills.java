package com.kalenicz.maciej.supercv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maciej on 21.09.2017.
 */

public class AdapterSkills extends RecyclerView.Adapter<AdapterSkills.ViewHolder>{
    private List<SkillsItems> skills;
    private Context context;

    public AdapterSkills(List<SkillsItems> skills, Context context){
        this.skills = skills;
        this.context = context;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_skill, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    SkillsItems skillsItems = skills.get(position);
        holder.textViewContent.setText(skillsItems.getSkill());
    }

    @Override
    public int getItemCount() {
        return skills.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewContent;
        public ViewHolder(View itemView) {
            super(itemView);
            textViewContent = (TextView) itemView.findViewById(R.id.content);

        }
    }
}
