package com.bazao.tasktwo;

import java.util.HashMap;
import java.util.Map;

public class TaskTwo {
    static HashMap<String,String> encryption = new HashMap<>();

    static {
        encryption.put("a","£");
        encryption.put("b","*");
        encryption.put("c","%");
        encryption.put("d","&");
        encryption.put("e",">");
        encryption.put("f","<");
        encryption.put("g","!");
        encryption.put("h",")");
        encryption.put("i","\"");
        encryption.put("j","(");
        encryption.put("k","@");
        encryption.put("l","a");
        encryption.put("m","b");
        encryption.put("n","c");
        encryption.put("o","d");
        encryption.put("p","e");
        encryption.put("q","f");
        encryption.put("r","g");
        encryption.put("s","h");
        encryption.put("t","i");
        encryption.put("u","j");
        encryption.put("v","k");
        encryption.put("w","l");
        encryption.put("x","m");
        encryption.put("y","n");
        encryption.put("z","o");
    }


    public static String encryptData(String input){
        StringBuilder encrypt = new StringBuilder();
        for(int i=0; i<input.length(); i++){
            if(Character.isWhitespace(input.charAt(i))){
                encrypt.append(" ");
            }else {
                if(encryption.containsKey(Character.toString(input.charAt(i)).toLowerCase())){
                    encrypt.append(encryption.get(Character.toString(input.charAt(i)).toLowerCase()));
                }
            }

        }
        return encrypt.toString();
    }
    private static String decryptData(String input){
        StringBuilder decrypt = new StringBuilder();
        for(int i=0; i<input.length(); i++){
            if(Character.isWhitespace(input.charAt(i))){
                decrypt.append(" ");
            }else {
                if(encryption.containsValue(Character.toString(input.charAt(i)).toLowerCase())){
                   for(Map.Entry<String,String> key :  encryption.entrySet()){
                       if(key.getValue().equals(Character.toString(input.charAt(i)).toLowerCase())){
                           decrypt.append(key.getKey());
                       }
                   }
                }
            }

        }
        return decrypt.toString();
    }
    public static void main(String[] args) {
        System.out.println(encryptData("Dami is a boy"));
        System.out.println(decryptData("&£b\" \"h £ *dn"));
    }
}
