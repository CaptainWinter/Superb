package pt.ubi.di.pdm.a43760_t0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DropdownContentEditor extends AppCompatActivity {

    ArrayList<String> listaIntro;
    ArrayList<String> listaQuebraGelo;
    ArrayList<String> listaVotos;
    ArrayList<String> listaGoodbye;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dropdown_content_editor);

        //button to go back to the MainActivity
        ImageButton botaoback2 = (ImageButton) findViewById(R.id.botaoback);
        botaoback2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });

        Button concluido = (Button) findViewById(R.id.botaodoneeditor);
        concluido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //list to create/add introductions to the list of Introductions
        listaIntro = new ArrayList<>();
        final EditText intro = findViewById(R.id.intro);
        ImageButton addintro = findViewById(R.id.botaoaddsaudacaoeditor);
        addintro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!intro.getText().toString().isEmpty()) {
                    try {
                        //creates the file "intro.txt"
                        write2File(intro.getText().toString(), "intro.txt");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else{
                    Toast.makeText(DropdownContentEditor.this, "Please write something in \"Salutations\"!", Toast.LENGTH_LONG).show();
                }
            }
        });


        //list to remove introductions to the list of Introductions
        ImageButton removeintro = findViewById(R.id.botaoremovesaudacaoeditor);
        removeintro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!intro.getText().toString().isEmpty()) {
                    try {
                        //deletes an entry in the file "intro.txt"
                        removeFromFile(intro.getText().toString(), "intro.txt");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else{
                    Toast.makeText(DropdownContentEditor.this, "Please write something in \"Salutations\"!", Toast.LENGTH_LONG).show();
                }
            }
        });


        //list to create/add quebra gelos to the list of Goodbyes
        listaQuebraGelo = new ArrayList<>();
        final EditText quebragelotext = findViewById(R.id.quebragelotexteditor);
        ImageButton addquebragelo = findViewById(R.id.botaoaddquebrageloeditor);
        addquebragelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!quebragelotext.getText().toString().isEmpty()) {
                    try {
                        //creates the file "goodbye"
                        write2File(quebragelotext.getText().toString(), "quebragelo.txt");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else{
                    Toast.makeText(DropdownContentEditor.this, "Please write something in \"Icebreaker\"!", Toast.LENGTH_LONG).show();
                }
            }
        });


        //list to remove quebra gelos to the list of Introductions
        ImageButton removequebragelo = findViewById(R.id.botaoremovequebrageloeditor);
        removequebragelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!quebragelotext.getText().toString().isEmpty()) {
                    try {
                        //deletes an entry in the file "quebragelo.txt"
                        removeFromFile(quebragelotext.getText().toString(), "quebragelo.txt");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else{
                    Toast.makeText(DropdownContentEditor.this, "Please write something in \"Icebreaker\"!", Toast.LENGTH_LONG).show();
                }
            }
        });

        //list to create/add votos to the list of Goodbyes
        listaVotos = new ArrayList<>();
        final EditText votostext = findViewById(R.id.votostexteditor);
        ImageButton addvotos = findViewById(R.id.botaoaddvotoseditor);
        addvotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!votostext.getText().toString().isEmpty()) {
                    try {
                        //creates the file "votos.txt"
                        write2File(votostext.getText().toString(), "votos.txt");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else{
                    Toast.makeText(DropdownContentEditor.this, "Please write something in \"Votes\"!", Toast.LENGTH_LONG).show();
                }
            }
        });

        //list to remove votos to the list of Introductions
        ImageButton removevotos = findViewById(R.id.botaoremovevotoseditor);
        removevotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!votostext.getText().toString().isEmpty()) {
                    try {
                        //creates the file "votos.txt"
                        removeFromFile(votostext.getText().toString(), "votos.txt");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else{
                    Toast.makeText(DropdownContentEditor.this, "Please write something in \"Votes\"!", Toast.LENGTH_LONG).show();
                }
            }
        });

        //list to create/add goodbyes to the list of Goodbyes
        listaGoodbye = new ArrayList<>();
        final EditText goodbyetext = findViewById(R.id.goodbyetexteditor);
        ImageButton addgoodbye = findViewById(R.id.botaoaddgoodbyeeditor);
        addgoodbye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!goodbyetext.getText().toString().isEmpty()) {
                    try {
                        //creates the file "goodbye.txt"
                        write2File(goodbyetext.getText().toString(), "goodbye.txt");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else{
                    Toast.makeText(DropdownContentEditor.this, "Please write something in \"Farewell\"!", Toast.LENGTH_LONG).show();
                }
            }
        });

        //list to remove goodbye to the list of Introductions
        ImageButton removegoodbye = findViewById(R.id.botaoremovegoodbyeeditor);
        removegoodbye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!goodbyetext.getText().toString().isEmpty()) {
                    try {
                        //deletes an entry in the file "goodbye.txt"
                        removeFromFile(goodbyetext.getText().toString(), "goodbye.txt");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else{
                    Toast.makeText(DropdownContentEditor.this, "Please write something in \"Farewell\"!", Toast.LENGTH_LONG).show();
                }
            }
        });

        //introSpinner
        Spinner introspinnereditor = findViewById(R.id.introspinnereditor);
        String[] arraySpinnerintro = new String[0];
        try {
            arraySpinnerintro = file2array("intro.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //check the type spinner
        ArrayAdapter<String> arrayAdapterintro = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item, arraySpinnerintro);
        introspinnereditor.setAdapter(arrayAdapterintro);
        arrayAdapterintro.notifyDataSetChanged();
        introspinnereditor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        Spinner quebragelospinnereditor = findViewById(R.id.quebragelospinnereditor);
        String[] arraySpinnerquebragelo = new String[0];
        try {
            arraySpinnerquebragelo = file2array("quebragelo.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //check the type spinner
        ArrayAdapter<String> arrayAdapterquebragelo = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item, arraySpinnerquebragelo);
        quebragelospinnereditor.setAdapter(arrayAdapterquebragelo);
        arrayAdapterquebragelo.notifyDataSetChanged();
        quebragelospinnereditor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        Spinner votosspinnereditor = findViewById(R.id.spinnervotoseditor);
        String[] arraySpinnervotos = new String[0];
        try {
            arraySpinnervotos = file2array("votos.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //check the type spinner
        ArrayAdapter<String> arrayAdaptervotos = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item, arraySpinnervotos);
        votosspinnereditor.setAdapter(arrayAdaptervotos);
        arrayAdaptervotos.notifyDataSetChanged();
        votosspinnereditor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        Spinner goodbyespinnereditor = findViewById(R.id.spinnerdespedidaeditor);
        String[] arraySpinnergoodbye = new String[0];
        try {
            arraySpinnergoodbye = file2array("goodbye.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //check the type spinner
        ArrayAdapter<String> arrayAdaptergoodbye = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item, arraySpinnergoodbye);
        goodbyespinnereditor.setAdapter(arrayAdaptergoodbye);
        arrayAdaptergoodbye.notifyDataSetChanged();
        goodbyespinnereditor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String string = parent.getItemAtPosition(position).toString();
                goodbyetext.setText(string);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
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
            Toast.makeText(DropdownContentEditor.this, "\""+texto+"\"\n"+" added with success!", Toast.LENGTH_LONG).show();
        }
        //in case of an unexpected error a message will pop up notifying the user to try agian
        catch (Exception e) {
            Toast.makeText(DropdownContentEditor.this, "An error occurred, please try again.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    public void removeFromFile(String delete, String namefile) throws IOException {
        try {
            File originalfile = new File("/data/data/pt.ubi.di.pdm.a43760_t0/files/"+namefile);
            File temp = File.createTempFile("tempfile",".txt");
            //variable to read from the original file
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(originalfile), "UTF-8"));
            //variable to write to a temp file
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(temp), "UTF-8"));
            //goes through every line of the original file and checks for the string to be deleted
            for (String line; (line = reader.readLine()) != null;){
                if (line.equals(delete)){
                    line = line.replace(delete, "");
                    Toast.makeText(DropdownContentEditor.this, "\""+delete+"\"\n"+" deleted with success!", Toast.LENGTH_LONG).show();
                }
                //deleting a string creates an empty line, this makes so the writer doesn't write the empty line to the temp file
                if (!line.isEmpty()) {
                    writer.write("\n"+line);
                }
            }
            reader.close();
            writer.close();
            //the original file is deleted and the temp file is saved with the name of the original
            originalfile.delete();
            temp.renameTo(originalfile);
        } catch (Exception e){
            Toast.makeText(DropdownContentEditor.this, "An error occurred, please try again.", Toast.LENGTH_LONG).show();
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
}