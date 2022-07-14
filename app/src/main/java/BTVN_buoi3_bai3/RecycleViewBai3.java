package BTVN_buoi3_bai3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.dungnd.android23.R;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewBai3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_group);
        RecyclerView rcvData = findViewById(R.id.rcvData);
        AdapterBai3 adapterBai3 = new AdapterBai3(createListBai3());
        rcvData.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcvData.setAdapter(adapterBai3);
    }

    private List<Bai3> createListBai3() {
        List<Bai3> bai3List = new ArrayList<>();
        bai3List.add(new Bai3("Video"));
        bai3List.add(new Bai3("Android"));
        bai3List.add(new Bai3("Applock"));
        bai3List.add(new Bai3("Books"));
        bai3List.add(new Bai3("map"));
        bai3List.add(new Bai3("Authenticate Using Google..."));
        bai3List.add(new Bai3("New folder"));
        bai3List.add(new Bai3("New folder 1"));
        return bai3List;
    }
}