package com.dungnd.android23.recycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dungnd.android23.R;

import java.util.List;

//Hiển thị danh sách học sinh trong lớp
//Có 2 cách để truyền dữ liệu vào adapter (dùng constructor, set get)
public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    private List<Student> studentList = null;
    private OnItemClick onItemClick;

    //C1: truyền dữ liệu vào adapter bằng cách dùng constructor
    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    //C2: dùng set để truyền dữ liệu vào adapter
    // Dữ liệu thường sẽ có được sau khi chúng ta khởi tạo adapter
    // Dùng set sẽ thích hợp khi dữ liệu hay bị thay đổi
    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    //Tạo ra item(view holder là 1 cái view để giữ data)
    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Tạo ra một cái view holder bằng cách inflate
        // parent chính là recycle view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        return new StudentViewHolder(view);
    }

    //Set các dữ liệu cần thiết cho view holder vào đây
    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        //C1: set dữ liệu cho các item view
//        holder.tvName.setText(studentList.get(position).getName());
//        holder.tvAge.setText(studentList.get(position).getAge());

        //C2: viết chuyên nghiệp
        //thích hợp khi các bạn làm với nhiều loại view holder
        holder.setData(studentList.get(position));
        holder.tvName.setOnClickListener(view -> {
          onItemClick.clickName(studentList.get(position).getName());
        });
        holder.itemView.setOnClickListener(v -> {
            onItemClick.clickItem();
        });
    }

    //Hiển thị số lượng item mà các bạn muốn (hoặc item mà đề bài yêu cầu)
    @Override
    public int getItemCount() {
        return studentList != null ? studentList.size() : 0;
    }

    protected class StudentViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private TextView tvAge;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvAge = itemView.findViewById(R.id.tvAge);
        }

        public void setData(Student student) {
            tvAge.setText(student.getAge() + "");
            tvName.setText(student.getName());
        }
    }

    public interface OnItemClick {
        //bấm vào tên
       void clickName(String name);

       //Bấm vào tuổi
       void clickAge(String age);

       //Bấm vào cả item
       void clickItem();
    }
}
