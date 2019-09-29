package com.example.progandro_final;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Homepage extends Fragment {
    private RecyclerView recyclerView;
    private List<RecyclerViewItem> recyclerViewItems;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        super.onCreateView(inflater,viewGroup,savedInstanceState);
        View rootView = inflater.inflate(R.layout.home_fragment, viewGroup, false);
        recyclerView= rootView.findViewById(R.id.recyclerView);
        RecyclerViewAdapter recycleViewAdapter = new RecyclerViewAdapter(getContext(),recyclerViewItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recycleViewAdapter);
        return rootView;
    }

    //Create a Recycler View for Movie List
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        recyclerViewItems = new ArrayList<>();

        recyclerViewItems.add(new RecyclerViewItem(R.drawable.interstellar,"Interstellar",
                "In Earth's future, a global crop blight and second Dust Bowl are slowly rendering the planet uninhabitable."));

        recyclerViewItems.add(new RecyclerViewItem(R.drawable.adastra, "Ad Astra",
                "Thirty years ago, Clifford McBride led a voyage into deep space, but the ship and crew were never heard from again."));

        recyclerViewItems.add(new RecyclerViewItem(R.drawable.godzilla, "Godzilla",
                "Members of the crypto-zoological agency Monarch face off against a battery of god-sized monsters, including the mighty Godzilla"));

        recyclerViewItems.add(new RecyclerViewItem(R.drawable.american, "American Sniper",
                "U.S. Navy SEAL Chris Kyle (Bradley Cooper) takes his sole mission -- protect his comrades -- to heart and becomes one of the most lethal snipers in American history."));

        recyclerViewItems.add(new RecyclerViewItem(R.drawable.onlythebrave, "Only The Brave",
                "Through hope, determination, sacrifice and the drive to protect families and communities, the Granite Mountain Hotshots become one of the most elite firefighting teams in the United States."));

        recyclerViewItems.add(new RecyclerViewItem(R.drawable.deepwaterhorizon, "Deepwater Horizon",
                "On April 20, 2010, the Deepwater Horizon drilling rig explodes in the Gulf of Mexico, igniting a massive fireball that kills several crew members."));

        recyclerViewItems.add(new RecyclerViewItem(R.drawable.finesthours, "The Finest Hours",
                "On Feb. 18, 1952, a massive storm splits the SS Pendleton in two, trapping more than 30 sailors inside the tanker's sinking stern."));

        recyclerViewItems.add(new RecyclerViewItem(R.drawable.lonesurvivor, "Lone Survivor",
                "In 2005 Afghanistan, Navy SEALs Marcus Luttrell,Michael Murphy,Danny Dietz and Matthew \"Axe\" Axelson deploy on a mission of surveillance and to take out Taliban leader Ahmad Shah."));

        recyclerViewItems.add(new RecyclerViewItem(R.drawable.firstman, "First Man",
                "Hoping to reach the moon by the end of the decade, NASA plans a series of extremely dangerous, unprecedented missions in the early 1960s."));

        recyclerViewItems.add(new RecyclerViewItem(R.drawable.fantasticbeast, "Fantastic Beasts and Where to Find Them",
                "The year is 1926, and Newt Scamander has just completed a global excursion to find and document an extraordinary array of magical creatures."));


    }
}
