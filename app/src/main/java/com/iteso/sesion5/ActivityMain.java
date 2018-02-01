package com.iteso.sesion5;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import android.widget.Toast;

public class ActivityMain extends AppCompatActivity {
    public String esco;
    AutoCompleteTextView textView;
    Person persona;
    EditText name;
    EditText phone;
    Spinner degree;
    RadioButton fem;
    RadioButton mas;
    CheckBox sport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.edit_text_name);
        phone = findViewById(R.id.edit_text_phone);
        degree = findViewById(R.id.spinner_degree);
        fem = findViewById(R.id.radio_female);
        mas = findViewById(R.id.radio_male);
        sport = findViewById(R.id.checkbox_sport);
        textView = findViewById(R.id.auto_complete_books);

        String[] books = getResources().getStringArray(R.array.libros);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,books);

        textView.setAdapter(adapter);

        //prueba obtener spinner
        degree.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                esco = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    //Para añadir el boton del menú.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Manejar cuando se presiona un bar item
        if(item.getItemId() == R.id.button_save) {
            savePerson();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void savePerson(){
        String nombre = name.getText().toString();
        String tel = phone.getText().toString();
        String genero;
        String book = textView.getText().toString();

        if (fem.isChecked())
            genero="Femenino";
        else
            genero ="Masculino";
        persona = new Person(nombre,tel,esco,genero,book,sport.isChecked());//      Check if its checked or activated
        Toast.makeText(this,persona.toString(),Toast.LENGTH_SHORT).show();
        clean();

    }

    //Metodo limpiar
    public void limpiar(View v){
        alertClean();
    }
    public void clean(){
        name.setText("");
        phone.setText("");
        textView.setText("");
        //mas.setActivated(false);
        //fem.setActivated(false);
        mas.setChecked(true);
        fem.setChecked(false);
        sport.setChecked(false);
    }
    public void alertClean(){
        new AlertDialog.Builder(ActivityMain.this)
                .setMessage("¿Desea limpiar el contenido?")
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                clean();
                                dialogInterface.cancel();
                            }
                        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }).show();
    }
}
