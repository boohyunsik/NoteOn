package com.bh.noteon;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    // FrameLayout에 각 메뉴의 Fragment를 바꿔줌
    private FragmentManager fragmentManager = getSupportFragmentManager();

    //3개의 메뉴에 들어갈 Fragment들
    private HistoryFragment historyFragment = new HistoryFragment();
    private MathFragment mathFragment = new MathFragment();
    private BiologyFragment biologyFragment = new BiologyFragment();
    private EarthFragment earthFragment = new EarthFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        BottomNavigationView topNavigationView = findViewById(R.id.top_navigation_view);

        //첫화면 지정
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, historyFragment).commitAllowingStateLoss();

        //bottomNavigationView의 아이템이 선택될 때 호출될 리스너 등록
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){
                switch(item.getItemId()){
                    case R.id.bottomNavigation_menu1: {
                        showColorDialog();
                        break;
                    }
                    case R.id.bottomNavigation_menu2: {
                        showStyleDialog();
                        break;
                    }
                    case R.id.bottomNavigation_menu3: {

                        break;
                    }
                }
                return true;
            }
        });

        topNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch(item.getItemId()){
                    case R.id.topNavigation_history: {
                        transaction.replace(R.id.frame_layout, historyFragment).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.topNavigation_math: {
                        transaction.replace(R.id.frame_layout, mathFragment).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.topNavigation_biology: {
                        transaction.replace(R.id.frame_layout, biologyFragment).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.topNavigation_earth: {
                        transaction.replace(R.id.frame_layout, earthFragment).commitAllowingStateLoss();
                        break;
                    }
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_actions, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.getItem(0).setEnabled(true);
        menu.getItem(1).setEnabled(true);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final int id = item.getItemId();
        switch(id) {
            case R.id.action_save:
                return true;
            case R.id.action_info:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showColorDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("색 선택")
                .setMessage("색을 선택하세요.")
                .show();
    }

    private void showStyleDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("펜 스타일 선택")
                .setMessage("스타일을 선택하세요.")
                .show();
    }
}
