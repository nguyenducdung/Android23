package BTVN_buoi3_bai1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.TextView;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.dungnd.android23.R;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.GroupViewHolder> {

    private List<Group> groupList = null;
    Context context;

    public GroupAdapter(List<Group> grouplist, Context context) {
        this.context = context;
        this.groupList = grouplist;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    @NonNull
    @Override
    public GroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bai1, parent, false);
        return new GroupViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull GroupViewHolder holder, int position) {
        holder.setData(groupList.get(position));
    }

    @Override
    public int getItemCount() {

        return groupList != null ? groupList.size() : 0;
    }

    class GroupViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView title;
        private TextView fan;
        private TextView post;
        private TextView close;

        public GroupViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            fan = itemView.findViewById(R.id.fan);
            post = itemView.findViewById(R.id.post);
            close = itemView.findViewById(R.id.close);

        }

        public void setData(Group group) {
            image.setImageDrawable(ContextCompat.getDrawable(context, group.getImage()));
            title.setText(group.getTitle());
            fan.setText(group.getFan());
            post.setText(group.getPost());
            close.setText(group.getClose());

            if(group.getClose().equals("NHÓM ĐÓNG")){
                close.setTextColor(ContextCompat.getColor(context, R.color.black));
            }else if(group.getClose().equals("NHÓM KÍN")){
                close.setTextColor(ContextCompat.getColor(context, R.color.purple_200));
            }else{
                close.setTextColor(ContextCompat.getColor(context, R.color.purple_500));
            }


        }

    }

}