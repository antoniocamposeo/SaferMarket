package com.example.asuper;

import android.content.Intent;

public class Result {
    private String result;

    public Result(){
    }

    public void setResult(String result){
        this.result = result;
    }

    public String getResult(){
        System.out.println("result: "+result);
        return result;
    }
}
