package com.example.onlineshopping.ui.home;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.onlineshopping.R;
import com.example.onlineshopping.help;
import com.example.onlineshopping.ui.contact.ContactFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private String URL = "https://my-json-server.typicode.com/shivam0912/json/product";
    private GridLayoutManager gridLayoutManager;
    private List<HomeData> homeData;
    private List<HomeData> tempList;
    private RecyclerView.Adapter adapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home,container,false);
        recyclerView = view.findViewById(R.id.recycle_home);
        recyclerView.setHasFixedSize(true);
        gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);


        loadData();
        homeData = new ArrayList<HomeData>();
        tempList = new ArrayList<HomeData>();

       adapter = new HomeAdapter(getActivity(),homeData);
       recyclerView.setAdapter(adapter);
       adapter.notifyDataSetChanged();
        return view;
    }
   private void loadData(){
       JsonArrayRequest aarRequest = new JsonArrayRequest(Request.Method.GET,URL,null,
               new Response.Listener<JSONArray>() {
                   @Override
                   public void onResponse(JSONArray response) {
                       if (response.length()>0){
                           for (int i =0 ; i<response.length();i++){
                               try {

                                   JSONObject data = response.getJSONObject(i);
                                   HomeData item = new HomeData();
                                   item.setProductName(data.getString("product_name"));
                                   item.setCheckStock(data.getString("product_stock"));
                                   item.setPrice(data.getString("product_price"));
                                   tempList.add(item);
                                   adapter.notifyDataSetChanged();
;

                               } catch (JSONException e) {
                                   Log.e("Shopping","Not Fetching data");
                               }
                           }
                           homeData.clear();
                           homeData.addAll(tempList);
                           adapter.notifyDataSetChanged();

                       }
                   }
               },
               new Response.ErrorListener() {
                   @Override
                   public void onErrorResponse(VolleyError error) {

                   }
               }){

       };
       Volley.newRequestQueue(getActivity()).add(aarRequest);
   }

}

