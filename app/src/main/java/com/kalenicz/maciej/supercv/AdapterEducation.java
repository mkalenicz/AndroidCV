package com.kalenicz.maciej.supercv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by maciej on 22.09.2017.
 */

public class AdapterEducation extends RecyclerView.Adapter<AdapterEducation.ViewHolder> {

    private List<EducationItems> educationItemsList;
    private Context context;

    public AdapterEducation(List<EducationItems> educationItemsList, Context context){
        this.educationItemsList = educationItemsList;
        this.context = context;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_education, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        EducationItems educationItems = educationItemsList.get(position);
        holder.textViewCompanyNameEducation.setText(educationItems.getCompanyName());
        holder.textViewCompanyDescriptionEducation.setText(educationItems.getCompanyDescription());
        holder.textViewCompanyDetailsEducation.setText(educationItems.getCompanyDetails());
        holder.textViewDateEducation.setText(educationItems.getCompanyDates());
        holder.imageViewLogoEducation.setImageResource(educationItems.getLogoId());



    }

    @Override
    public int getItemCount() {
        return educationItemsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewCompanyNameEducation;
        public TextView textViewCompanyDescriptionEducation;
        public TextView textViewCompanyDetailsEducation;
        public TextView textViewDateEducation;
        public ImageView imageViewLogoEducation;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewCompanyNameEducation = (TextView) itemView.findViewById(R.id.company_name_education);
            textViewCompanyDescriptionEducation = (TextView) itemView.findViewById(R.id.company_description_education);
            textViewCompanyDetailsEducation = (TextView) itemView.findViewById(R.id.company_details_education);
            textViewDateEducation = (TextView) itemView.findViewById(R.id.date_education_item);
            imageViewLogoEducation = (ImageView) itemView.findViewById(R.id.company_logo_education);



        }
    }
}
