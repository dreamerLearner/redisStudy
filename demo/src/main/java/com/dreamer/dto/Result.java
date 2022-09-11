package com.dreamer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Result {
    private Boolean success;
    private String errorMsg;
    private Map<String,Object> data = new HashMap<String,Object>();

    private static Result result = new Result();

    private Result(){

    }

    private Result(Boolean success,String errorMsg,Map<String,Object> data){
        this.success = success;
        this.errorMsg = errorMsg;
        this.data = data;
    }
    public static Result getInstance(){
        return result;
    }

    public Result ok(){
        return new Result(true, null, this.data);
    }
    public void addData(String key,Object val){
        this.data.put(key,val);
    }
    public Result fail(String errorMsg){
        return new Result(false, errorMsg, null);
    }
}
