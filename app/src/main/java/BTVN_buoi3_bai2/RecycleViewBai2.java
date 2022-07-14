package BTVN_buoi3_bai2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.dungnd.android23.R;

import java.util.ArrayList;
import java.util.List;

import BTVN_buoi3_bai1.GroupAdapter;

public class RecycleViewBai2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_group);
        RecyclerView rcvData = findViewById(R.id.rcvData);
        AdapterPDF adapterPDF = new AdapterPDF(createAdapterList());
        rcvData.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcvData.setAdapter(adapterPDF);

    }

    private List<PDF> createAdapterList() {
        List<PDF> listPDF = new ArrayList<>();
        listPDF.add(new PDF("To Kill a Mockingbird "));
        listPDF.add(new PDF("To Kill a Mockingbird "));
        listPDF.add(new PDF("To Kill a Mockingbird "));
        listPDF.add(new PDF("To Kill a Mockingbird "));
        listPDF.add(new PDF("To Kill a Mockingbird "));
        return listPDF;
    }

}