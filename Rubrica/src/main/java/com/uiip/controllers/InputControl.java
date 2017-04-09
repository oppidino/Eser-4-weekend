package com.uiip.controllers;

import java.io.BufferedReader;
import java.io.IOException;

public class InputControl {

    public static String insert(BufferedReader input) throws IOException {
        String ret;
        boolean bool;
        do {
            ret = input.readLine();
            bool = "".equals(ret);
        } while (bool);
        return ret;
    }

    public static int parseNumber(BufferedReader input) throws IOException {
        int ret = 0;
        boolean bool;
        do {
        	ret = Integer.parseInt(input.readLine());
            if (ret >= 0) 
            {
            	bool = false;
            }
            else
            {
            	bool = true;
                System.out.println("Inserisci un numero positivo!");
            }
        } while (bool);
        return ret;
    }
}
