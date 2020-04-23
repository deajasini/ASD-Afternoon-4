package com.example.cook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.view.View.OnClickListener;
import android.widget.TextView;

import org.xml.sax.SAXException;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class AddRecipe extends AppCompatActivity {
    static String name;
    static String description = "";
    static int prep_time = 0;
    static int cooking_time = 0;
    static String sbs_description = "";
    static Image food_picture = null;

    static Boolean[] tags = {false, false, false, false, false, false, false, false, false, false};

    private CheckBox tag0, tag1, tag2, tag3, tag4, tag5, tag6, tag7, tag8, tag9;


    static ImageView recipe_image;

    public Boolean[] getTags() {
        return tags;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);
        Button add_picture_button = findViewById(R.id.add_picture);
        Button submit = findViewById(R.id.submitRecipe);
        final EditText input_name = findViewById(R.id.inputName);
        final EditText input_description = findViewById(R.id.inputDescription);
        final EditText input_prep_time = findViewById(R.id.inputPreparationTime);
        final EditText input_cooking_time = findViewById(R.id.inputCookingTime);
        final EditText input_sbs_description = findViewById(R.id.inputSbs);


        tag0 = (CheckBox) findViewById(R.id.tag0);
        tag1 = (CheckBox) findViewById(R.id.tag1);
        tag2 = (CheckBox) findViewById(R.id.tag2);
        tag3 = (CheckBox) findViewById(R.id.tag3);
        tag4 = (CheckBox) findViewById(R.id.tag4);
        tag5 = (CheckBox) findViewById(R.id.tag5);
        tag6 = (CheckBox) findViewById(R.id.tag6);
        tag7 = (CheckBox) findViewById(R.id.tag7);
        tag8 = (CheckBox) findViewById(R.id.tag8);
        tag9 = (CheckBox) findViewById(R.id.tag9);

        tag0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tag0.isChecked()){
                    tags[0] = true;
                }
            }
        });
        tag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tag1.isChecked()){
                    tags[1] = true;
                }
            }
        });
        tag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tag2.isChecked()){
                    tags[2] = true;
                }
            }
        });
        tag3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tag3.isChecked()){
                    tags[3] = true;
                }
            }
        });
        tag4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tag4.isChecked()){
                    tags[4] = true;
                }
            }
        });
        tag5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tag5.isChecked()){
                    tags[5] = true;
                }
            }
        });
        tag6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tag6.isChecked()){
                    tags[6] = true;
                }
            }
        });
        tag7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tag7.isChecked()){
                    tags[7] = true;
                }
            }
        });
        tag8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tag8.isChecked()){
                    tags[8] = true;
                }
            }
        });
        tag9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tag9.isChecked()){
                    tags[9] = true;
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = input_name.getText().toString();
                assert(!name.isEmpty());

                description = input_description.getText().toString();
                assert(!description.isEmpty());

                prep_time = Integer.parseInt(input_prep_time.getText().toString());
                assert(prep_time != 0);

                cooking_time = Integer.parseInt(input_cooking_time.getText().toString());
                assert(cooking_time != 0);

                sbs_description = input_sbs_description.getText().toString();
                assert(!sbs_description.isEmpty());

                //MainActivity.recipes.add(new Recipe(100, name, description, prep_time,
                //       cooking_time, food_picture, sbs_description, getTags()));

                //Recipe new_recipe = new Recipe(100, name, description, prep_time,
                //       cooking_time, food_picture, sbs_description, getTags());

/*
                XMLFileParser parse = new XMLFileParser();

                try {
                    parse.XMLAddRecipe(current);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                } catch (TransformerException e) {
                    e.printStackTrace();
                }

*/
                //food_picture = input_picture.getIma

                //Test
                //description.setText(name);

                Recipe.new_recipe_added = true;
                Intent go_back_to_main = new Intent(AddRecipe.this, MainActivity.class);
                startActivity(go_back_to_main);

                //MainActivity.load_list = true;
                //finish();
            }
        });

        /*submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //submit function

                //construct Recipe

                recipes recipe = new recipes(1, name, description, prep_time, cook_time, picture, tags);

                //add to recipes[]


                //save recipes in XML


            }
        });*/


        recipe_image = findViewById(R.id.imageView);

        add_picture_button.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 0);
            }});


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK) {
            Uri image_uri = data.getData();
            Bitmap bitmap;
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(image_uri));
                recipe_image.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }



    /*protected void submitRecipe() {
        submit_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.v("EditText", recipe_name.getText().toString());
                Log.v("EditText", recipe_cooking_time.getText().toString());
                Log.v("EditText", recipe_preparation_time.getText().toString());
                Log.v("EditText", recipe_Sbs.getText().toString());
            }

        });
    }*/
}
