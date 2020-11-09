package newveela.mydoctor.app.activity;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import newveela.mydoctor.app.R;
import newveela.mydoctor.app.adapter.HomeAdapter;
import newveela.mydoctor.app.model.Item;
import newveela.mydoctor.app.util.AutoFitGridLayoutManager;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements HomeAdapter.ItemListener{

    private RecyclerView recyclerView;
    private ArrayList<Item> arrayList;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        arrayList = new ArrayList<>();

        arrayList.add(new Item("Blood Pressure", R.drawable.ic_arm, "#DA3C1A"));
        arrayList.add(new Item("Diabetes", R.drawable.diabetis, "#3E51B1"));
        arrayList.add(new Item("Eye", R.drawable.ic_eyecare, "#673BB7"));
        arrayList.add(new Item("Ear", R.drawable.ic_ear, "#4BAA50"));
        arrayList.add(new Item("Skin", R.drawable.skin, "#F94336"));
        arrayList.add(new Item("Hair Fall", R.drawable.hairfall, "#0A9B88"));
        arrayList.add(new Item("Teeth", R.drawable.teeth, "#F94363"));

        HomeAdapter adapter = new HomeAdapter(this, arrayList, this);
        recyclerView.setAdapter(adapter);


        /**
         AutoFitGridLayoutManager that auto fits the cells by the column width defined.
         **/

        //AutoFitGridLayoutManager layoutManager = new AutoFitGridLayoutManager(this, 500);
        //recyclerView.setLayoutManager(layoutManager);


        /**
         Simple GridLayoutManager that spans two columns
         **/
        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    public void onItemClick(Item item) {
        Toast.makeText(getApplicationContext(), item.text + "  clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       //https://www.journaldev.com/13792/android-gridlayoutmanager-example
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
