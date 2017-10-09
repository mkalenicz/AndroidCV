package com.kalenicz.maciej.supercv.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kalenicz.maciej.supercv.ExperienceItems;
import com.kalenicz.maciej.supercv.R;

import java.util.List;

/**
 * Created by maciej on 22.09.2017.
 */

public class AdapterExperience extends RecyclerView.Adapter<AdapterExperience.ViewHolder> {

    private List<ExperienceItems> experienceItemsList;
    private Context context;

    public AdapterExperience(List<ExperienceItems> experienceItemsList, Context context){
        this.experienceItemsList = experienceItemsList;
        this.context = context;

    }
    @Override
    public AdapterExperience.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_experience, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdapterExperience.ViewHolder holder, int position) {
        ExperienceItems experienceItems = experienceItemsList.get(position);
        holder.textViewCompanyNameExperience.setText(experienceItems.getCompanyNameExperience());
        holder.textViewCompanyDescriptionExperience.setText(experienceItems.getCompanyDescriptionExperience());
        holder.textViewDateExperience.setText(experienceItems.getCompanyDatesExperience());
        holder.imageViewLogoExperience.setImageResource(experienceItems.getLogoIdExperience());
    }

    @Override
    public int getItemCount() {
        return experienceItemsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewCompanyNameExperience;
        public TextView textViewCompanyDescriptionExperience;
        public TextView textViewDateExperience;
        public ImageView imageViewLogoExperience;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewCompanyNameExperience = (TextView) itemView.findViewById(R.id.company_name_experience);
            textViewCompanyDescriptionExperience = (TextView) itemView.findViewById(R.id.company_description_experience);
            textViewDateExperience = (TextView) itemView.findViewById(R.id.date_experience_item);
            imageViewLogoExperience = (ImageView) itemView.findViewById(R.id.company_logo_experience);

        }
    }
}
