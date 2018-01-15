package com.levert.kabe.picknpay.Fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.levert.kabe.picknpay.R;


public class OthersFragment extends Fragment {


    public OthersFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_others, container, false);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.othersTab);
        tabLayout.addTab(tabLayout.newTab().setText("Baby Stuff"));
        tabLayout.addTab(tabLayout.newTab().setText("Household Cleaning"));
        //tabLayout.addTab(tabLayout.newTab().setText("Milk Shake"));
        tabLayout.setTabTextColors(Color.parseColor("#ff5722"), Color.parseColor("#ff8a65"));

        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager_others);
        viewPager.setAdapter(new CustomAdapter(getChildFragmentManager(),
                tabLayout.getTabCount()));

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }

    private class CustomAdapter extends FragmentStatePagerAdapter {
        int numberOfTabs;

        public CustomAdapter(FragmentManager fragmentManager, int numberOfTabs) {
            super( fragmentManager);
            this.numberOfTabs = numberOfTabs;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position)
            {
                case 0:
                    BabyStuffFragment babyStuffFragment = new BabyStuffFragment();
                    return babyStuffFragment;
                case 1:
                    HouseholdFragment householdFragment = new HouseholdFragment();
                    return householdFragment;
                case 2:
                    MilkShakeFragment milkShake = new MilkShakeFragment();
                    return milkShake;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {

            return numberOfTabs;
        }
    }
}
