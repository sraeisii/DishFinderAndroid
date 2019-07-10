package com.example.benglish.dishfindertest1;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements IMainActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyFragmentPagerAdapter myFragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

        myFragmentPagerAdapter = new MyFragmentPagerAdapter( getSupportFragmentManager() );
        viewPager.setAdapter( myFragmentPagerAdapter );
        tabLayout.setupWithViewPager( viewPager );


  }

  private void findViews() {

      tabLayout = findViewById( R.id.tab_layout );
      viewPager = findViewById( R.id.view_pager );
  }

    @Override
    public void loadDiaryFragment() {
        DiaryFragment diaryFragment=new DiaryFragment();
        getSupportFragmentManager().beginTransaction().add( R.id.category_fragment_container, diaryFragment )
                .commit();
    }

    @Override
    public void loadVegetableFragment() {
        VegetableFragment vegetableFragment=new VegetableFragment();
        getSupportFragmentManager().beginTransaction().add( R.id.category_fragment_container, vegetableFragment )
                .commit();

    }
}
