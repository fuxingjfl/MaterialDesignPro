package mdp.xha.com.materialdesignpro;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigation;
    private NavigationView nv_left;
    private DrawerLayout dl;
    private FragmentManager fm;
    private Fragment currentf;
    private BriefFirearms briefFirearms;
    private ProfileFragment profileFragment;
    private ContentFragment contentFragment2,contentFragment3;
    private FrameLayout fl_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigation= (BottomNavigationView) findViewById(R.id.navigation);
        nv_left= (NavigationView) findViewById(R.id.nv_left);
        dl= (DrawerLayout) findViewById(R.id.dl);
        fl_content=findViewById(R.id.fl_content);
        fm=getSupportFragmentManager();
        if (briefFirearms==null){
            briefFirearms = new BriefFirearms();

        }
        addFragments(briefFirearms,"briefFirearms");

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.qxjs:
                        if (briefFirearms==null){
                            briefFirearms = new BriefFirearms();

                        }
                        addFragments(briefFirearms,"briefFirearms");
                        break;
                    case R.id.rwjj:
                        if (profileFragment==null){
                            profileFragment = new ProfileFragment();
                        }
                        addFragments(profileFragment,"profileFragment");
                        break;
                    case R.id.pjjj:
                        if (contentFragment2==null){
                            contentFragment2 = new ContentFragment();
                            Bundle bundle = new Bundle();
                            bundle.putString("content","配件简介");
                            contentFragment2.setArguments(bundle);
                        }
                        addFragments(contentFragment2,"contentFragment2");
                        break;
                    case R.id.ktjj:
                        if (contentFragment3==null){
                            contentFragment3 = new ContentFragment();
                            Bundle bundle = new Bundle();
                            bundle.putString("content","空投简介");
                            contentFragment3.setArguments(bundle);
                        }
                        addFragments(contentFragment3,"contentFragment3");
                        break;
                }

                return true;
            }
        });

        nv_left.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.menu_qxjj:
                        navigation.setSelectedItemId(navigation.getMenu().getItem(0).getItemId());
                        break;
                    case R.id.menu_rwjj:
                        navigation.setSelectedItemId(navigation.getMenu().getItem(1).getItemId());
                        break;
                    case R.id.menu_pjjj:
                        navigation.setSelectedItemId(navigation.getMenu().getItem(2).getItemId());
                        break;
                    case R.id.menu_ktjj:
                        navigation.setSelectedItemId(navigation.getMenu().getItem(3).getItemId());
                        break;
                    case R.id.menu_bar:
                        Snackbar.make(briefFirearms.rv_list,"底部弹出snackbar",Snackbar.LENGTH_INDEFINITE).setAction("OK", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this,"点击snackbar之后",Toast.LENGTH_SHORT).show();
                            }
                        }).show();
                        break;
                    case R.id.menu_login:
                        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                        startActivity(intent);
                        break;
                }
                dl.closeDrawer(nv_left);
                return true;
            }
        });

    }

    private void addFragments(Fragment f, String tag) {
        if (MainActivity.this!=null){
            // 第二步：开启一个事务
            FragmentTransaction transaction = fm.beginTransaction();

            if (currentf != null) {
                //每次把前一个fragment给隐藏了
                transaction.hide(currentf);
            }
            //isAdded:判断当前的fragment对象是否被加载过
            if (!f.isAdded()) {
                // 第三步：调用添加fragment的方法 第一个参数：容器的id 第二个参数：要放置的fragment的一个实例对象
                transaction.add(R.id.fl_content, f,tag);
            }
            //显示当前的fragment
            transaction.show(f);
            // 第四步：提交
            transaction.commitAllowingStateLoss();
            currentf = f;
        }
    }


}
