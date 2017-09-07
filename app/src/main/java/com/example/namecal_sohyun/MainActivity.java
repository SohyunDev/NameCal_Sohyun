package com.example.namecal_sohyun;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText inputtext;
    TextView viewtext;
    private String texts = "ㅂㅈㄷㄱㅅㅛㅕㅑㅐㅔㅁㄴㅇㄹㅎㅗㅓㅏㅣㅋㅌㅊㅍㅠㅜㅡ";
    private int[] text_num = {4,2,2,1,2,3,3,3,3,3,3,1,1,3,3,2,2,2,1,2,3,3,4,3,2,1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputtext = (EditText)this.findViewById(R.id.editText);
        viewtext = (TextView)this.findViewById(R.id.textView);
    }

    public void onButtonC_Clicked(View v){
        inputtext.setText("");
        viewtext.setText("");
    }

    public void onButtonText_Clicked(View v){
        switch(v.getId()){
            case R.id.button2:
                inputtext.append("ㅂ");
                break;
            case R.id.button3:
                inputtext.append("ㅈ");
                break;
            case R.id.button4:
                inputtext.append("ㄷ");
                break;
            case R.id.button5:
                inputtext.append("ㄱ");
                break;
            case R.id.button6:
                inputtext.append("ㅅ");
                break;
            case R.id.button7:
                inputtext.append("ㅛ");
                break;
            case R.id.button8:
                inputtext.append("ㅕ");
                break;
            case R.id.button9:
                inputtext.append("ㅑ");
                break;
            case R.id.button10:
                inputtext.append("ㅐ");
                break;
            case R.id.button11:
                inputtext.append("ㅔ");
                break;
            case R.id.button12:
                inputtext.append("ㅁ");
                break;
            case R.id.button13:
                inputtext.append("ㄴ");
                break;
            case R.id.button14:
                inputtext.append("ㅇ");
                break;
            case R.id.button15:
                inputtext.append("ㄹ");
                break;
            case R.id.button16:
                inputtext.append("ㅎ");
                break;
            case R.id.button17:
                inputtext.append("ㅗ");
                break;
            case R.id.button18:
                inputtext.append("ㅓ");
                break;
            case R.id.button19:
                inputtext.append("ㅏ");
                break;
            case R.id.button20:
                inputtext.append("ㅣ");
                break;
            case R.id.button21:
                inputtext.append("ㅋ");
                break;
            case R.id.button22:
                inputtext.append("ㅌ");
                break;
            case R.id.button23:
                inputtext.append("ㅊ");
                break;
            case R.id.button24:
                inputtext.append("ㅍ");
                break;
            case R.id.button25:
                inputtext.append("ㅠ");
                break;
            case R.id.button26:
                inputtext.append("ㅜ");
                break;
            case R.id.button27:
                inputtext.append("ㅡ");
                break;
        }
    }
    public void onButtonDel_Clicked(View v){
        // 한칸 지우기
        String origin = inputtext.getText().toString();
        String str = origin.substring(0,origin.length()-1);
        inputtext.setText(str);
    }
    public void onButtonDiv_Clicked(View v){
        inputtext.append(" ");
    }
    public void onButtonPlus_Clicked(View v){
        inputtext.append("+");
    }
    public void onButtonCalc_Clicked(View v){
        // 계산
        int result = calculate(inputtext.getText().toString());
        viewtext.setText("");
        viewtext.append("="+String.valueOf(result)+"%");
    }

    public int calculate(String str){
        String result=str;
        String[] array1=null;
        String[] array2=null;
        String[] temp=null;
        List<Integer> calculate=new ArrayList<Integer>();
        List<Integer> calculate_result=new ArrayList<Integer>();        int string_num=0;
        calculate.clear();
        calculate_result.clear();
        int int_num=0;
        int sum=0;
        int rtn=0;

        array1=result.split(" ");
        for(int i=0; i<array1.length; i++){
            temp = array1[i].split("\\+");
            for(int j=0; j<temp.length; j++) {
                sum=0;
                for(int k=0; k<temp[j].length(); k++){
                    sum+=text_num[texts.indexOf(temp[j].charAt(k))];
                }
                if(sum>=10){
                    sum=sum%10;
                }
                calculate.add(sum);
            }

        }
        while(calculate.size()>2) {

            calculate_result.clear();
            for(int i=0; i<calculate.size()-1; i++) {
                int a = calculate.get(i).intValue()+calculate.get(i+1).intValue();
                if(a>=10){
                    a=a%10;
                }
                calculate_result.add(a);
            }
            calculate.clear();
            calculate.addAll(calculate_result);
        }
        rtn=calculate.get(0).intValue()*10 + calculate.get(1).intValue();
        return rtn;
    }

}
