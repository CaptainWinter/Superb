package pt.ubi.di.pdm.a43760_t0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WriteMessage extends AppCompatActivity {

    ArrayList<String> listaIntro;
    ArrayList<String> listaGoodbye;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_message);

        //button to go back to the MainActivity
        //variables
        ImageButton botaoback3 = (ImageButton) findViewById(R.id.botaoback);
        botaoback3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });

        //list to create/add salutations to the list of Salutations
        listaIntro = new ArrayList<>();
        final EditText intro = findViewById(R.id.intro);
        ImageButton addintro = findViewById(R.id.botaoaddsaudacao);
        addintro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!intro.getText().toString().isEmpty()) {
                    try {
                        write2File(intro.getText().toString().toString(), "intro.txt");
                        Toast.makeText(WriteMessage.this, "Salutation added with success!", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(WriteMessage.this, "An error occurred, please try again.", Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                }
                else{
                    Toast.makeText(WriteMessage.this, "Please write something in \"Salutations\"!", Toast.LENGTH_LONG).show();
                }
            }
        });

        //list to create/add farewells to the list of Farewells
        listaGoodbye = new ArrayList<>();
        final EditText goodbyetext = findViewById(R.id.goodbyetext);
        ImageButton addgoodbye = findViewById(R.id.botaoaddgoodbye);
        addgoodbye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!goodbyetext.getText().toString().isEmpty()) {
                    try {
                        //creates the file "goodbye"
                        write2File(goodbyetext.getText().toString(), "goodbye.txt");
                        Toast.makeText(WriteMessage.this, "Farewell added with success!", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(WriteMessage.this, "An error occurred, please try again.", Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                }
                else{
                    Toast.makeText(WriteMessage.this, "Please write something in \"Farewell\"!", Toast.LENGTH_LONG).show();
                }
            }
        });

        //introSpinner
        Spinner introspinner = findViewById(R.id.introspinner);
        String[] arraySpinnerintro = new String[0];
        try {
            arraySpinnerintro = file2array("intro.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //check the type spinner
        ArrayAdapter<String> arrayAdapterintro = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item, arraySpinnerintro);
        introspinner.setAdapter(arrayAdapterintro);
        arrayAdapterintro.notifyDataSetChanged();
        introspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String string = parent.getItemAtPosition(position).toString();
                intro.setText(string);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        //goodbyeSpinner
        Spinner goodbyespinner = findViewById(R.id.spinnerdespedida);
        String[] arraySpinnergoodbye = new String[0];
        try {
            arraySpinnergoodbye = file2array("goodbye.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //check the type spinner
        ArrayAdapter<String> arrayAdaptergoodbye = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item, arraySpinnergoodbye);
        goodbyespinner.setAdapter(arrayAdaptergoodbye);
        arrayAdaptergoodbye.notifyDataSetChanged();
        goodbyespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String string = parent.getItemAtPosition(position).toString();
                goodbyetext.setText(string);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        //write file preview.txt with the content of the message
        EditText message = findViewById(R.id.message);
        EditText signature = findViewById(R.id.signaturetext);
        ImageButton previewbutton = findViewById(R.id.botaopreview);
        previewbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mailcontent = intro.getText().toString()+"\n\n"+message.getText().toString()+"\n\n"+goodbyetext.getText().toString()+"\n\n"+ signature.getText().toString();
                if (!(intro.getText().toString().equals("")) &&
                        !(message.getText().toString().equals("")) &&
                        !(goodbyetext.getText().toString().equals("")) &&
                        !(signature.getText().toString().equals(""))){
                    writePreview( mailcontent,"preview.txt");
                    previewMessage();
                }
                else{
                    Toast.makeText(WriteMessage.this, "Please fill all parameters!", Toast.LENGTH_LONG).show();
                }
            }
        });

        Button sendmail = findViewById(R.id.botaosendmessage);
        sendmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(intro.getText().toString().equals("")) &&
                        !(message.getText().toString().equals("")) &&
                        !(goodbyetext.getText().toString().equals("")) &&
                        !(signature.getText().toString().equals(""))) {
                    String mailcontent = intro.getText().toString() + "\n\n" + message.getText().toString() + "\n\n" + goodbyetext.getText().toString() + "\n\n" + signature.getText().toString();
                    shareContent(mailcontent);
                }
                else{
                    Toast.makeText(WriteMessage.this, "Please fill all parameters!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    //----------------------------------------------------------------------------------------------
    //Public funtions

    //function to write text to files, taking the text itself and the name of the file as inputs,
    //writing the text in the file
    public void write2File(String texto, String namefile) {
        String textoinput = "\n"+texto;
        try {
            FileOutputStream introfile;
            //the variable "introfile" is initially assigned the MODE_APPEND due to the fact
            //the variable will have the value FALSE in case the file wasn't created before
            introfile = openFileOutput(namefile, getApplicationContext().MODE_APPEND);
            if (introfile == null)
            {
                introfile = openFileOutput(namefile, getApplicationContext().MODE_PRIVATE);
            }
            introfile.write(textoinput.getBytes());
            introfile.close();
        }
        //in case of an unexpected error a message will pop up notifying the user to try agian
        catch (Exception e) {
            Toast.makeText(WriteMessage.this, "An error occurred, please try again.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    public String[] file2array(String namefile) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream("/data/data/pt.ubi.di.pdm.a43760_t0/files/"+namefile));
        List<String> arrayList = new ArrayList<String>();
        while(scanner.hasNextLine())
        {
            String line = scanner.nextLine();;
            arrayList.add(line);
        }
        return arrayList.toArray(new String[0]);
    }

    public void previewMessage(){
        Intent intent = new Intent(this, Preview.class);
        startActivity(intent);
    }

    public void writePreview(String texto, String namefile){
        try {
            FileOutputStream previewfile;
            File originalfile = new File("/data/data/pt.ubi.di.pdm.a43760_t0/files/"+namefile);
            //the variable "previewfile" is initially assigned the MODE_APPEND due to the fact
            //the variable will have the value FALSE in case the file wasn't created before

            if (originalfile.exists())
            {
                originalfile.delete();
                previewfile = openFileOutput(namefile, getApplicationContext().MODE_APPEND);
            }
            else{
                previewfile = openFileOutput(namefile, getApplicationContext().MODE_PRIVATE);
            }
            previewfile.write(texto.getBytes());
            previewfile.close();
        } catch (Exception e){
            Toast.makeText(WriteMessage.this, "An error occurred, please try again.", Toast.LENGTH_LONG).show();
        }
    }

    public void shareContent(String content){
        String share = content;
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");
        intent.putExtra(Intent.EXTRA_TEXT, share);
        startActivity(Intent.createChooser(intent, "Share Via"));
    }
}