package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DiscoveryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DiscoveryFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private List<Friend> friendList = new ArrayList<>();
    public DiscoveryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DiscoveryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DiscoveryFragment newInstance(String param1, String param2) {
        DiscoveryFragment fragment = new DiscoveryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.discovery, container, false);
        View view = inflater.inflate(R.layout.discovery, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.RecyclerView);
        initFrd();
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        MyAdapter2 adapter = new MyAdapter2(friendList);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void initFrd() {
        for(int i = 0; i < 10; i++) {
            Friend frdGaga=new Friend(i, R.drawable.lady_gaga, "Lady Gaga");
            friendList.add(frdGaga);
            Friend frdAdam=new Friend(i, R.drawable.adam, "Adam Levin");
            friendList.add(frdAdam);
            Friend frdAdele=new Friend(i, R.drawable.adele, "Adele Adkins");
            friendList.add(frdAdele);
            Friend frdGreyson=new Friend(i, R.drawable.greyson, "Greyson Chance");
            friendList.add(frdGreyson);
            Friend frdRihanna=new Friend(i, R.drawable.myrihanna, "Rihanna Fenty");
            friendList.add(frdRihanna);
            Friend frdLana=new Friend(i, R.drawable.lana, "Lana Del Rey");
            friendList.add(frdLana);
            Friend frdKaty=new Friend(i, R.drawable.katy, "Lady Gaga");
            friendList.add(frdKaty);
            Friend frdLorde=new Friend(i, R.drawable.lorde, "Katy Perry");
            friendList.add(frdLorde);
            Friend frdBruno=new Friend(i, R.drawable.bruno_mars, "Bruno Mars");
            friendList.add(frdBruno);
            Friend frdTroye=new Friend(i, R.drawable.troye, "Troye Sivan");
            friendList.add(frdTroye);

        }
    }
}