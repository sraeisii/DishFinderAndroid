package com.example.benglish.dishfindertest1;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.benglish.dishfindertest1.Adapters.MyFragmentPagerAdapter;
import com.example.benglish.dishfindertest1.IngredientFragments.BeanFragment;
import com.example.benglish.dishfindertest1.IngredientFragments.DiaryFragment;
import com.example.benglish.dishfindertest1.IngredientFragments.MeatFragment;
import com.example.benglish.dishfindertest1.IngredientFragments.ShowDishFragment;
import com.example.benglish.dishfindertest1.IngredientFragments.VegetableFragment;
import com.example.benglish.dishfindertest1.models.Ingredient;

import java.util.ArrayList;

class MainActivity extends AppCompatActivity implements IMainActivity {

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
//////////selectedIngredient
    @Override
    public ArrayList<Ingredient> getSelectedIngredients() {
        return selectedIngredients;
    }

    @Override
    public void setSelectedIngredients(Ingredient ingredient) {
        selectedIngredients.add( ingredient );
    }

    @Override
    public void removeSelectedIngredient(Ingredient ingredient) {
        selectedIngredients.remove( ingredient );
    }

    @Override
    public Boolean isIngredientChecked(Ingredient ingredient) {
        for (int i = 0; i < selectedIngredients.size(); i++)
        {
            if(selectedIngredients.get( i ).getId() == ingredient.getId())
                return true;
        }

        return false;
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

    @Override
    public void loadMeatFragment() {
        MeatFragment meatFragment= new MeatFragment();
        getSupportFragmentManager().beginTransaction().add( R.id.category_fragment_container, meatFragment )
                .commit();
    }

    @Override
    public void loadBeanFragment() {
        BeanFragment beanFragment= new BeanFragment();
        getSupportFragmentManager().beginTransaction().add( R.id.category_fragment_container, beanFragment )
                .commit();
    }

    @Override
    public void loadShowDish() {
        ShowDishFragment showDishFragment= new ShowDishFragment();
        getSupportFragmentManager().beginTransaction().add( R.id.dish_fragment_container, showDishFragment )
        .commit();
    }
}
