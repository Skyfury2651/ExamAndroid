package com.example.activityproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.activityproject.ContactAdapter;
import com.example.activityproject.ContactModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IOnChildItemClick {

    private ListView lvContact;
    private List<ContactModel> listContacts = new ArrayList<>();
    private ImageView ivUser;
    private TextView tvName;
    private ContactAdapter mAdapter;

    private static final String LOG_TAG = "AndroidExample";
    private static final int MY_PERMISSION_REQUEST_CODE_CALL_PHONE = 555;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();

        lvContact = (ListView) findViewById(R.id.lvContact);

        mAdapter = new ContactAdapter(this, listContacts);
        mAdapter.registerChildItemClick(this);
        lvContact.setAdapter(mAdapter);
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ContactModel contactModel = listContacts.get(position);
                Toast.makeText(MainActivity.this, contactModel.getName() + contactModel.getPhone(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        lvContact = (ListView) findViewById(R.id.lvContact);
        ivUser = (ImageView) findViewById(R.id.ivUser);
        tvName = (TextView) findViewById(R.id.tvName);
    }

    private void initData() {
        ContactModel contact = new ContactModel("Con vit con", "05837882362", R.drawable.ic_avatar1);
        listContacts.add(contact);
        contact = new ContactModel("Con vit con 1", "05837882362", R.drawable.ic_avatar1);
        listContacts.add(contact);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAdapter.unRegisterChildItemClick();
    }

    @Override
    public void onItemChildClick(int position) {
        ContactModel contactModel = listContacts.get(position);
        ivUser.setImageResource(contactModel.getImage());
        tvName.setText(contactModel.getName());
    }
}