package com.dungnd.android23.buoi4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.MergeAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.dungnd.android23.R;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewMergeAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_merge_adapter);
        RecyclerView rcvData = findViewById(R.id.rcvData);

        ProductAdapter productAdapter = new ProductAdapter(createProducts());
        SupportAdapter supportAdapter = new SupportAdapter(createSupportList());

        MergeAdapter adapter = new MergeAdapter(productAdapter, supportAdapter);
        rcvData.setLayoutManager(new GridLayoutManager(this, 2));
        rcvData.setAdapter(adapter);
    }

    private List<Product> createProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Hũ vàng", 10000000L));
        products.add(new Product("Chứng khoán", 10000000L));
        products.add(new Product("Đầu tư quỹ", 10000000L));
        products.add(new Product("Tích luỹ", 10000000L));
        products.add(new Product("Ngân hàng", 10000000L));
        
        return products;
    }

    private List<Support> createSupportList() {
        List<Support> supports = new ArrayList<>();
        supports.add(new Support("Hướng dẫn người mới"));
        supports.add(new Support("Hướng dẫn người mới2"));
        supports.add(new Support("Hướng dẫn người mới3"));
        supports.add(new Support("Hướng dẫn người mới4"));
        supports.add(new Support("Hướng dẫn người mới5"));
        supports.add(new Support("Hướng dẫn người mới6"));
        return supports;
    }
}