package BTVN_buoi3_bai1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.dungnd.android23.R;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewBai1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_group);
        RecyclerView rcvData = findViewById(R.id.rcvData);
        GroupAdapter adapter = new GroupAdapter(createGrouplist(), this);
        rcvData.setAdapter(adapter);
        rcvData.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }


    private List<Group> createGrouplist() {
        List<Group> groupList = new ArrayList<>();
        groupList.add(new Group(R.drawable.ic_mobile, "Mua bán có tâm", "8K Fan", "+10 bài viết mới nhất", "NHÓM ĐÓNG"));
        groupList.add(new Group(R.drawable.pic2, "Ăn để lăn", "8K Fan", "+10 bài viết mới nhất", "NHÓM KÍN"));
        groupList.add(new Group(R.drawable.treem, "Chia sẻ kiến thức tài liệu Montessori", "1,7K Fan", "+10 bài viết mới nhất", "NHÓM MỞ"));
        groupList.add(new Group(R.drawable.ic_food, "Thực đơn Eat-Clean giảm cân khỏe đẹp", "11K Fan", "+20 bài viết mới nhất", "NHÓM MỞ"));
        groupList.add(new Group(R.drawable.menu, "Easy Kento for busy People", "8K Fan", "+10 bài viết mới nhất", "NHÓM KÍN"));
        groupList.add(new Group(R.drawable.car, "OFFB", "8K Fan", "+10 bài viết mới nhất", "NHÓM MỞ"));
        groupList.add(new Group(R.drawable.ic_food, "Thực đơn Eat-Clean giảm cân khỏe đẹp", "11K Fan", "+20 bài viết mới nhất", "NHÓM MỞ"));
        groupList.add(new Group(R.drawable.menu, "Easy Kento for busy People", "8K Fan", "+10 bài viết mới nhất", "NHÓM KÍN"));
        return groupList;
    }
}