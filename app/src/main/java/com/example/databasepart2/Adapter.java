package com.example.databasepart2;

import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class Adapter   extends RecyclerView.Adapter<Adapter.ViewHolder> {

    CardView cardView;
    Context context;
    ArrayList<Model> models;
    FirebaseFirestore fb=FirebaseFirestore.getInstance();
    public Adapter(Context context, ArrayList<Model> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.roomDetail.setText(models.get(i).getRoomDetail());
        viewHolder.complaint.setText(models.get(i).getComplaint());
        viewHolder.ch1.setChecked(true);
        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                builder.setTitle("Otp Verification")
                        .setMessage("Your otp is : ")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .create()
                .show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView roomDetail,complaint;
        CheckBox ch1,ch2,ch3;
        LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            roomDetail=itemView.findViewById(R.id.roomDetailsText);
            complaint=itemView.findViewById(R.id.complaintDetailsText);
            ch1=itemView.findViewById(R.id.check1);
            ch2=itemView.findViewById(R.id.check2);
            ch3=itemView.findViewById(R.id.check3);
            linearLayout=itemView.findViewById(R.id.linearLayout);
        }
    }
}
