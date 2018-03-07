package jp.techacademy.kentaro.nakanishi.uistudy;

import android.util.Log;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView mTextView;
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button1.setOnClickListener(this);


        mTextView = (TextView) findViewById(R.id.textView);
        mEditText = (EditText) findViewById(R.id.editText);
    }


            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.button1) {
                    mTextView.setText(mEditText.getText().toString());
                } else if (v.getId() == R.id.button2) {
                    showAlertDialog();
                }
            }

            private void showAlertDialog(){
        //AlertDialog.Builderクラスを使ってAlertDialogの準備をする
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                alertDialogBuilder.setTitle("タイトル");
                alertDialogBuilder.setMessage("メッセージ");

                //肯定ボタンに表示される文字列、おした時のリスナーを設定する
                alertDialogBuilder.setPositiveButton("肯定",
                new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        Log.d("UI_PARTS", "肯定ボタン");
                    }
                });

                //中立ボタンに表示される文字列、おした時のリスナーを設定する
                alertDialogBuilder.setNeutralButton("中立",
                        new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which){
                                Log.d("UI_PARTS", "中立ボタン");
                            }
                        });
                //否定ボタンに表示される文字列、おした時のリスナーを設定する
                alertDialogBuilder.setNegativeButton("否定",
                        new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which){
                                Log.d("UI_PARTS", "否定ボタン");
                            }
                        });

                //AlertDialogを作成して表示する
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
}

