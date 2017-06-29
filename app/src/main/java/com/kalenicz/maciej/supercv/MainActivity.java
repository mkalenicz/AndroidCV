package com.kalenicz.maciej.supercv;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
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
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kalenicz.maciej.supercv.Model.DialogItem;
import com.kalenicz.maciej.supercv.Model.MailItem;
import com.kalenicz.maciej.supercv.Model.NoActionItem;
import com.kalenicz.maciej.supercv.Model.PhoneItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.kalenicz.maciej.supercv.R.styleable.CoordinatorLayout;
import static com.kalenicz.maciej.supercv.R.styleable.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
//public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

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
    CoordinatorLayout snacBarAttachLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PasswordFragment.newInstance().show(getSupportFragmentManager(), "");
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupToolbar();

        navigationView.setNavigationItemSelectedListener(this);
//        toolbar.setOnClickListener(this);
    }

    @OnClick(R.id.floatingActionButton)
    public void onFabClicked() {
//        Snackbar.make(snacBarAttachLayout, "Test", Snackbar.LENGTH_SHORT).show();
//        Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show();

        addToContacts();
    }

    private void addToContacts() {
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
//        intent.putExtra(ContactsContract.Intents.Insert.NAME, "Maciej Kalenicz");
//        intent.putExtra(ContactsContract.Intents.Insert.PHONE, "+48602393632");

        intent.setType(ContactsContract.Contacts.CONTENT_TYPE)
                .putExtra(ContactsContract.Intents.Insert.NAME, "Maciej Kalenicz")
                .putExtra(ContactsContract.Intents.Insert.PHONE, "+48602393632")
                .putExtra(ContactsContract.Intents.Insert.EMAIL, "maciej.kalenicz@gmail.com");
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
                .setTitle("Tesla")
                .setIcon(R.drawable.ic_phone_black_24dp)
                .setMessage("Kierownik sprzedaży")
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
            case R.id.menu_hobby:
                openFragment(HobbyFragment.newInstance());

        }
    }

    private void openFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }
}
