package com.example.retrofitex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ListView list;
    public ArrayList  full;
    List<Hero> marvelArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(),"12",Toast.LENGTH_SHORT).show();
        list=(ListView) findViewById(R.id.list);
        marvelArray=new ArrayList<Hero>();
        Retrofit retrofit =new Retrofit.Builder()
                           .baseUrl(Api.baseUrl)
                           .addConverterFactory(GsonConverterFactory.create())
                           .build();
        Api api=retrofit.create(Api.class);
       Call<List<Hero>> call= api.getHeroes();
        Toast.makeText(getApplicationContext(),"123.2fgf",Toast.LENGTH_SHORT).show();
       call.enqueue(new Callback<List<Hero>>() {
           @Override
           public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
               Toast.makeText(getApplicationContext(),"123",Toast.LENGTH_SHORT).show();
               try {
                   marvelArray = response.body();
                   Log.e("Marvel", marvelArray.toString());
                   Log.e("Marvel1", response.body().toString());
                   MyAdapter myAdapter = new MyAdapter(MainActivity.this,marvelArray);
                   list.setAdapter(myAdapter);
               }
               catch (Exception e){
                   e.printStackTrace();
               }

               //for(int i=0;i<response.body().size();i++){

                  // data[i]=response.body().get(i).getName();
                  // list.setAdapter(new ArrayAdapter(getApplicationContext(),
                   //                          android.R.layout.simple_list_item_1,
                    //                          data));
              // }
           }

           @Override
           public void onFailure(Call<List<Hero>> call, Throwable t) {

           }
       });


    }
public class MyAdapter extends  BaseAdapter{

    Context context;
    List<Hero> marvel;
    public MyAdapter(Context context,List<Hero>marvel){
        this.context=context;
        this.marvel=marvel;
    }

    @Override
    public int getCount() {
        return marvel.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView image;
        TextView name;
        TextView realname;
        TextView bio;
        LayoutInflater inflater=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View v=inflater.inflate(R.layout.custom,null);
        name=(TextView)v.findViewById(R.id.tv1);
        name.setText(marvel.get(position).getName());
        realname=(TextView)v.findViewById(R.id.tv2);
        realname.setText(marvel.get(position).getRealname());
        bio=(TextView)v.findViewById(R.id.tv3);
        bio.setText(marvel.get(position).getBio());
        image=(ImageView)v.findViewById(R.id.iv);
        Picasso.with(context).load(marvel.get(position).getImageurl()).into(image);

        return  v;


    }
}
};
