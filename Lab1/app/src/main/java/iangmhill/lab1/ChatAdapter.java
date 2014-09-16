package iangmhill.lab1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by ihill on 9/11/2014.
 */
public class ChatAdapter extends ArrayAdapter{
    private List<MessageItem> chats = new ArrayList<MessageItem>();
    private int resource;
    private Context context;

    public ChatAdapter(Context context, List<MessageItem> chats, int resource){
        super(context, R.layout.chat_item);
        this.context = context;
        this.resource = resource;

        addChats(chats);
    }

    private class ChatHolder {
        TextView message, sender;
        View background;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ChatHolder holder;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(resource,parent,false);
        holder = new ChatHolder();

        //TextViews
        holder.message = (TextView) view.findViewById(R.id.chat_item_message);
        holder.sender = (TextView) view.findViewById(R.id.chat_item_user);

        fillViews(holder, chats.get(position));

        return view;
    }

    public int getCount() {
        return this.chats.size();
    }

    public void fillViews(ChatHolder holder, MessageItem chat){
        holder.sender.setText(chat.sender);
        holder.message.setText(chat.message);
    }

    public void addChats(List<MessageItem> newChats){
        this.chats.addAll(newChats);
        notifyDataSetChanged();
    }

    public void addChat(MessageItem chat){
        this.chats.add(chat);
        notifyDataSetChanged();
    }


}
