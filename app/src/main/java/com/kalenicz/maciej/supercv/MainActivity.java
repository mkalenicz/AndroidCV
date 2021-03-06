package com.kalenicz.maciej.supercv;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, SnackBarShower {
//public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
//Travis
//    private RecyclerView recyclerView;
//    private RecyclerView.Adapter adapter;
//private List<SkillsItems> skillsItemsList;

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @BindView(R.id.container)
    FrameLayout container;
    @BindView(R.id.navigationView)
    NavigationView navigationView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.snackbar_attach)
    CoordinatorLayout snackBarAttachLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PasswordFragment.newInstance().show(getSupportFragmentManager(), "");
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupToolbar();


        navigationView.setNavigationItemSelectedListener(this);

//        recyclerView = (RecyclerView)findViewById(R.id.sklillsRecyclerView);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        skillsItemsList = new ArrayList<>();
//
//        for (int i = 0; i<=10; i++){
//            SkillsItems skillsItems = new SkillsItems("Skill"  + i+1);
//            skillsItemsList.add(skillsItems);
//        }
//        adapter = new AdapterSkills(skillsItemsList, this);
//        recyclerView.setAdapter(adapter);


//        toolbar.setOnClickListener(this);
    }

    @OnClick(R.id.floatingActionButton)
    public void onFabClicked() {
//        Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show();

        addToContacts();
    }

//    protected void showSnackbar(String message) {
//        Snackbar.make(snackBarAttachLayout, message, Snackbar.LENGTH_SHORT).show();
//    }

    private void addToContacts() {
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
//        intent.putExtra(ContactsContract.Intents.Insert.NAME, "Maciej Kalenicz");
//        intent.putExtra(ContactsContract.Intents.Insert.PHONE, "+48602393632");

        intent.setType(ContactsContract.Contacts.CONTENT_TYPE)
                .putExtra(ContactsContract.Intents.Insert.NAME, Constants.NAME)
                .putExtra(ContactsContract.Intents.Insert.PHONE, Constants.PHONE_NUMBER)
                .putExtra(ContactsContract.Intents.Insert.EMAIL, Constants.EMAIL);
        startActivity(intent);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        navigationView.getMenu().performIdentifierAction(R.id.menu_contact, 0);
    }


    private void setupToolbar() {
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle adidas = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(adidas);
        adidas.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.options_info:

                showInfoDialog();
//                Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showInfoDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("Confidentiality clause")
                .setIcon(R.drawable.ic_info_black_24dp)
                .setMessage("I hereby declare that all the facts and information provided for this cover letter and CV are true. I allow my personal data stated in the abovementioned applications to be processed for the purpose of recruitment, in accordance with the Personal Data Protection Act dated 29/08/1997 (Dz.Ust.No.133, item 883)")
                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        toolbar.setTitle(item.getTitle());
        item.setChecked(true);
        openFragment(item);
        drawerLayout.closeDrawer(Gravity.LEFT);
        return false;
    }

    private void openFragment(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_contact:
                openFragment(ContactFragment.newInstance());
                break;
            case R.id.menu_experience:
                openFragment(ExperienceFragment.newInstance());
                break;
            case R.id.menu_skills:
                openFragment(SkillsFragment.newInstance());
                break;
            case R.id.menu_notes:
                openFragment(NotesFragment.newInstance());
                break;
            case R.id.menu_education:
                openFragment(EducationFragment.newInstance());
                break;
            case R.id.menu_profile:
                openFragment(ProfileFragment.newInstance());

        }
    }

    private void openFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    @Override
    public void showSnackBar(String message) {
        Snackbar.make(snackBarAttachLayout, message, Snackbar.LENGTH_SHORT).show();
    }
}
