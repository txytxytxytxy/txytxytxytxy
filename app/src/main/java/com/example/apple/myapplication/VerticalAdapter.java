package com.example.apple.myapplication;


        import android.content.Context;
        import android.support.annotation.NonNull;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import java.util.ArrayList;
        import java.util.List;


public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.VerticalViewHolder> {

    private static final String TAG = VerticalAdapter.class.getSimpleName();//得到类的简写名称，即VerticalAdapter
    private Context mContext;//实例化抽象类（包含activity等抽象对象）
    private List<String> mList = new ArrayList<>();//实例化对象

    public interface OnItemClickListener{
        void onItemClick(View view, int position);//该方法回调到activity或fragment中做相应操作
    }
    private OnItemClickListener itemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener ){
        this.itemClickListener=onItemClickListener;
    }

    public VerticalAdapter(Context context) {//传入参数，形参等于实参
        mContext = context;
    }


    public void setVerticalDataList(List<String> list) {
        Log.d(TAG, "setVerticalDataList: " + list.size());//创建日志
        mList = list;
        notifyDataSetChanged();//动态更新方法调用
    }

    @NonNull
    @Override
    public VerticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.vertical_recycle_item, parent, false);//实例化视图
        return new VerticalViewHolder(view);//返回视图
    }

    @NonNull


    @Override
    public void onBindViewHolder(@NonNull VerticalViewHolder holder, int position) {
        holder.tvNum.setText(position + 1 + "");//设置数字每一次加入一个新的list就加1
        holder.tvContent.setText(mList.get(position));//设置显示内容为list内的文字


    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();//返回list长度
    }

    public class VerticalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvNum, tvContent;//实例化xml文件中的两个文本控件
        View tvview;
        OnItemClickListener mitemClickListener;
        public VerticalViewHolder(View itemView) {

            super(itemView);
            tvNum = itemView.findViewById(R.id.tv_num);
            tvContent = itemView.findViewById(R.id.tv_content);
            this.mitemClickListener=itemClickListener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (mitemClickListener != null) {
                mitemClickListener.onItemClick(itemView,getPosition());
            }

        }
    }

}