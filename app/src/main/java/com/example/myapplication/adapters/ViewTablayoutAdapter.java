package com.example.myapplication.adapters;
//
//import androidx.annotation.NonNull;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentPagerAdapter;
//
//public class ViewPagerAdapter extends FragmentPagerAdapter {
//
//    public ViewPagerAdapter(
//            @NonNull FragmentManager fm)
//    {
//        super(fm);
//    }
//
//    @NonNull
//    @Override
//    public Fragment getItem(int position)
//    {
//        Fragment fragment = null;
////        if (position == 0)
////            fragment = new AlgorithmFragment();
////        else if (position == 1)
////            fragment = new CourseFragment();
////        else if (position == 2)
////            fragment = new LoginFragment();
//
//        return fragment;
//    }
//
//    @Override
//    public int getCount()
//    {
//        return 3;
//    }
//
//    @Override
//    public CharSequence getPageTitle(int position)
//    {
//        String title = null;
//        if (position == 0)
//            title = "Algorithm";
//        else if (position == 1)
//            title = "Courses";
//        else if (position == 2)
//            title = "Login";
//        return title;
//    }
//}


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewTablayoutAdapter extends FragmentPagerAdapter {

    private List<Fragment> lstFragment = new ArrayList<>();
    private List<String> lstTitles = new ArrayList<>();

    public ViewTablayoutAdapter(@NonNull @org.jetbrains.annotations.NotNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public Fragment getItem(int position) {
        return lstFragment.get(position);
    }

    @Override
    public int getCount() {
        return lstFragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return lstTitles.get(position);
    }

    public void AddFragment(Fragment fragment, String title)
    {
        lstFragment.add(fragment);
        lstTitles.add(title);
    }
}
