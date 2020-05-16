package sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.pmdmrec03.R;

public class Persistencia extends AppCompatActivity {

    private BaseDatos baseDatos;
    private SQLiteDatabase consultas;

    private void consultas(){
        findViewById(R.id.buttonInvitado).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (baseDatos==null){
                    baseDatos = new BaseDatos(getApplicationContext());
                    SQLiteDatabase consultas = baseDatos.getWritableDatabase();
                    baseDatos.setSQLiteDatabase(consultas);

                    Toast.makeText(getApplicationContext(), "Bd abierta", Toast.LENGTH_LONG).show();
                }
            }
        });

        findViewById(R.id.buttonAdmin)
            .setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (baseDatos!=null){
                        baseDatos.close();
                        baseDatos = null;
                        Toast.makeText(getApplicationContext(),"BD cerrada",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        consultas();
    }
}
