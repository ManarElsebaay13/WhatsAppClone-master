package com.manarelsebaay.whatsApp.Adapters;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.manarelsebaay.whatsApp.Activities.ChatActivity;
import com.manarelsebaay.whatsApp.Activities.MainActivity;
import com.manarelsebaay.whatsApp.Activities.ProfileDialogActivity;
import com.manarelsebaay.whatsApp.Model.Chat;
import com.manarelsebaay.whatsApp.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatsAdapter extends RecyclerView.Adapter<ChatsAdapter.ChatsViewHolder> {
	
	private Context context;
	private ArrayList<Chat> chats;
	
	public ChatsAdapter(Context context, ArrayList<Chat> chats) {
		this.context = context;
		this.chats = chats;
	}
	
	@NonNull
	@Override
	public ChatsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
		return new ChatsViewHolder(LayoutInflater.from(context).inflate(R.layout.chat_row, viewGroup, false));
	}
	
	@Override
	public void onBindViewHolder(@NonNull ChatsViewHolder chatsViewHolder, int i) {
		
		Chat chat = chats.get(i);
		
		if (chat.getName() == null) {
			//It is just a footer
			chatsViewHolder.chatLayoutContainer.setVisibility(View.INVISIBLE);
		}
		
		Glide.with(context)
			.load(chat.getImage())
			.apply(new RequestOptions().placeholder(R.drawable.profile))
			.into(chatsViewHolder.profilePic);
		
		chatsViewHolder.tvName.setText(chat.getName());
		chatsViewHolder.tvMsg.setText(chat.getLastMessage());
		chatsViewHolder.tvTime.setText(chat.getLastMessageTime());
		
		
	}
	
	@Override
	public int getItemCount() {
		if (chats != null) {
			return chats.size();
		}
		return 0;
	}
	
	class ChatsViewHolder extends RecyclerView.ViewHolder{
		CircleImageView profilePic;
		TextView tvName;
		TextView tvMsg;
		TextView tvTime;
		RelativeLayout chatLayoutContainer;
		
		ChatsViewHolder(@NonNull final View itemView) {
			super(itemView);
		
			profilePic = itemView.findViewById(R.id.profile_image);
			tvName = itemView.findViewById(R.id.tvName);
			tvMsg = itemView.findViewById(R.id.tvLastMsg);
			tvTime = itemView.findViewById(R.id.tvTime);
			chatLayoutContainer = itemView.findViewById(R.id.chat_row_container);

			profilePic.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(final View view) {
					Intent i = new Intent(new Intent(context, ProfileDialogActivity.class));
					i.putExtra("url", chats.get(getAdapterPosition()).getImage());
					ActivityOptions options = ActivityOptions
							.makeSceneTransitionAnimation((Activity)context, view, "transition");
					context.startActivity(i, options.toBundle());


				}
			});
			
			itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {

					Intent i = new Intent(new Intent(context, ChatActivity.class));

					context.startActivity(i);



				}
			});
			
			
			
			
			
			
		}

	}



}
