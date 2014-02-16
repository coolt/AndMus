package com.andmus.app;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements OnItemClickListener {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            populateDirectoriesListView();
            // registerClickCallback();
        }

        private void populateDirectoriesListView() {
            String[] directories = {"Toy Dolls","Massia Sound System","Sophie Hunger","Eric Satie"};
            FragmentActivity activity = getActivity();
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity, R.layout.directories_item, directories);
            ListView list = (ListView) activity.findViewById(R.id.directories);
            list.setAdapter(adapter);
            list.setOnItemClickListener(this);
       }
/*
        private void registerClickCallback(){
            FragmentActivity activity = getActivity();
            ListView list = (ListView) activity.findViewById(R.id.directories);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {

                    TextView itemView = (TextView) viewClicked;
                    String message = itemView.getText().toString();
                    FragmentActivity activity = getActivity();
                    Toast.makeText(activity, message, Toast.LENGTH_LONG).show();

                    FragmentActivity activity = getActivity();
                    Toast.makeText(activity, "abcd", Toast.LENGTH_LONG).show();
                    ListView listView = (ListView) parent;
                    listView.showDetails(position);
                }
            });
        }
*/
        public void onItemClick(AdapterView l, View v, int position, long id) {
            FragmentActivity activity = getActivity();
            Toast.makeText(activity, "abcd", Toast.LENGTH_LONG).show();
            showFiles(position);
        }

        void showFiles(int position)  {
            Intent intent = new Intent();
            intent.setClass(getActivity(), FilesActivity.class);
            intent.putExtra("index", position);
            startActivity(intent);
        }
    }

    public class FilesActivity extends ActionBarActivity{

    }

}
