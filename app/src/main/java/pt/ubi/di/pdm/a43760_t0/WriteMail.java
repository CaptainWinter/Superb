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

public class WriteMail extends AppCompatActivity{

    ArrayList<String> listaIntro;
    ArrayList<String> listaQuebraGelo;
    ArrayList<String> listaVotos;
    ArrayList<String> listaGoodbye;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_mail);

        //button to go back to the MainActivity
        ImageButton botaoback4 = findViewById(R.id.botaobackmail);
        botaoback4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //list to create/add introductions to the list of Introductions
        listaIntro = new ArrayList<>();
        final EditText intro = findViewById(R.id.intromail);
        ImageButton addintro = findViewById(R.id.botaoaddsaudacaomail);
        addintro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!intro.getText().toString().isEmpty()) {
                    try {
                        //creates the file "intro.txt"
                        write2File(intro.getText().toString(), "intro.txt");
                        Toast.makeText(WriteMail.this, "Salutation added with success!", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(WriteMail.this, "An error occurred, please try again.", Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                }
                else{
                    Toast.makeText(WriteMail.this, "Please write something in \"Salutations\"!", Toast.LENGTH_LONG).show();
                }
            }
        });

        //list to create/add quebra gelos to the list of Goodbyes
        listaQuebraGelo = new ArrayList<>();
        final EditText quebragelotext = findViewById(R.id.quebragelotextmail);
        ImageButton addquebragelo = findViewById(R.id.botaoaddquebragelomail);
        addquebragelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!quebragelotext.getText().toString().isEmpty()) {
                    try {
                        //creates the file "goodbye"
                        write2File(quebragelotext.getText().toString(), "quebragelo.txt");
                        Toast.makeText(WriteMail.this, "Icebreaker added with success!", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(WriteMail.this, "An error occurred, please try again.", Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                }
                else{
                    Toast.makeText(WriteMail.this, "Please write something in \"Icebreaker\"!", Toast.LENGTH_LONG).show();
                }
            }
        });

        //list to create/add votos to the list of Goodbyes
        listaVotos = new ArrayList<>();
        final EditText votostext = findViewById(R.id.votostextmail);
        ImageButton addvotos = findViewById(R.id.botaoaddvotosmail);
        addvotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!votostext.getText().toString().isEmpty()) {
                    try {
                        //creates the file "votos.txt"
                        write2File(votostext.getText().toString(), "votos.txt");
                        Toast.makeText(WriteMail.this, "Votes added with success!", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(WriteMail.this, "An error occurred, please try again.", Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                }
                else{
                    Toast.makeText(WriteMail.this, "Please write something in \"Farewell\"!", Toast.LENGTH_LONG).show();
                }
            }
        });

        //list to create/add goodbyes to the list of Goodbyes
        listaGoodbye = new ArrayList<>();
        final EditText goodbyetext = findViewById(R.id.goodbyetextmail);
        ImageButton addgoodbye = findViewById(R.id.botaoaddgoodbyemail);
        addgoodbye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!goodbyetext.getText().toString().isEmpty()) {
                    try {
                        //creates the file "goodbye.txt"
                        write2File(goodbyetext.getText().toString(), "goodbye.txt");
                        Toast.makeText(WriteMail.this, "Farewell added with success!", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(WriteMail.this, "An error occurred, please try again.", Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                }
                else{
                    Toast.makeText(WriteMail.this, "Please write something in \"Farewell\"!", Toast.LENGTH_LONG).show();
                }
            }
        });

        //introSpinner
        Spinner introspinnermail = findViewById(R.id.introspinnermail);
        String[] arraySpinnerintro = new String[0];
        try {
            arraySpinnerintro = file2array("intro.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //check the type spinner
        ArrayAdapter<String> arrayAdapterintro = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item, arraySpinnerintro);
        introspinnermail.setAdapter(arrayAdapterintro);
        arrayAdapterintro.notifyDataSetChanged();
        introspinnermail.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String string = parent.getItemAtPosition(position).toString();
                intro.setText(string);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });



        //quebrageloSpinner
        Spinner quebragelospinnermail = findViewById(R.id.quebragelospinnermail);
        String[] arraySpinnerquebragelo = new String[0];
        try {
            arraySpinnerquebragelo = file2array("quebragelo.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //check the type spinner
        ArrayAdapter<String> arrayAdapterquebragelo = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item, arraySpinnerquebragelo);
        quebragelospinnermail.setAdapter(arrayAdapterquebragelo);
        arrayAdapterquebragelo.notifyDataSetChanged();
        quebragelospinnermail.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String string = parent.getItemAtPosition(position).toString();
                quebragelotext.setText(string);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });



        //votosSpinner
        Spinner votosspinnermail = findViewById(R.id.spinnervotosmail);
        String[] arraySpinnervotos = new String[0];
        try {
            arraySpinnervotos = file2array("votos.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //check the type spinner
        ArrayAdapter<String> arrayAdaptervotos = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item, arraySpinnervotos);
        votosspinnermail.setAdapter(arrayAdaptervotos);
        arrayAdaptervotos.notifyDataSetChanged();
        votosspinnermail.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String string = parent.getItemAtPosition(position).toString();
                votostext.setText(string);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        //goodbyeSpinner
        Spinner goodbyespinnermail = findViewById(R.id.spinnerdespedidamail);
        String[] arraySpinnergoodbye = new String[0];
        try {
            arraySpinnergoodbye = file2array("goodbye.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //check the type spinner
        ArrayAdapter<String> arrayAdaptergoodbye = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item, arraySpinnergoodbye);
        goodbyespinnermail.setAdapter(arrayAdaptergoodbye);
        arrayAdaptergoodbye.notifyDataSetChanged();
        goodbyespinnermail.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String string = parent.getItemAtPosition(position).toString();
                goodbyetext.setText(string);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        EditText message = findViewById(R.id.messagemail);
        EditText signature = findViewById(R.id.signaturetextmail);
        ImageButton previewbutton = findViewById(R.id.botaopreviewsmail);
        previewbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mailcontent = intro.getText().toString()+"\n\n"+ quebragelotext.getText().toString()+"\n\n"+ message.getText().toString()+"\n\n"+ votostext.getText().toString()+"\n\n"+ goodbyetext.getText().toString()+"\n\n"+ signature.getText().toString();
                if (!(intro.getText().toString().equals("")) &&
                        !(quebragelotext.getText().toString().equals("")) &&
                        !(message.getText().toString().equals("")) &&
                        !(votostext.getText().toString().equals("")) &&
                        !(goodbyetext.getText().toString().equals("")) &&
                        !(signature.getText().toString().equals(""))){
                    writePreview(mailcontent,"preview.txt");
                    previewMessage();
                }
                else{
                    Toast.makeText(WriteMail.this, "Please fill all parameters!", Toast.LENGTH_LONG).show();
                }
            }
        });

        Button sendmail = findViewById(R.id.botaosendmessagemail);
        sendmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(intro.getText().toString().equals("")) &&
                        !(quebragelotext.getText().toString().equals("")) &&
                        !(message.getText().toString().equals("")) &&
                        !(votostext.getText().toString().equals("")) &&
                        !(goodbyetext.getText().toString().equals("")) &&
                        !(signature.getText().toString().equals(""))) {
                    String mailcontent = intro.getText().toString() + "\n\n" + quebragelotext.getText().toString() + "\n\n" + message.getText().toString() + "\n\n" + votostext.getText().toString() + "\n\n" + goodbyetext.getText().toString() + "\n\n" + signature.getText().toString();
                    shareContent(mailcontent);
                }
                else{
                    Toast.makeText(WriteMail.this, "Please fill all parameters!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    //----------------------------------------------------------------------------------------------
    //Public funtions

    public void write2File(String texto, String namefile)
    {
        String textoinput = "\n"+texto;
        try {
            FileOutputStream textfile;
            //the variable "textfile" is initially assigned the MODE_APPEND due to the fact
            //the variable will have the value FALSE in case the file wasn't created before
            textfile = openFileOutput(namefile, getApplicationContext().MODE_APPEND);
            if (textfile == null)
            {
                textfile = openFileOutput(namefile, getApplicationContext().MODE_PRIVATE);
            }
            textfile.write(textoinput.getBytes());
            textfile.close();
        }
        //in case of an unexpected error a message will pop up notifying the user to try agian
        catch (Exception e) {
            Toast.makeText(WriteMail.this, "An error occurred, please try again.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    public String[] file2array(String namefile) throws IOException {
        Scanner scanner = new Scanner(new FileInputStream("/data/data/pt.ubi.di.pdm.a43760_t0/files/"+namefile));
        List<String> arrayList = new ArrayList<String>();
        while(scanner.hasNextLine())
        {
            String line = scanner.nextLine();
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
            Toast.makeText(WriteMail.this, "An error occurred, please try again.", Toast.LENGTH_LONG).show();
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