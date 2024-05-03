package org.shaikhabdulgani.exceptionhandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
/*
    An exception is disruption in flow of normal program.
    There are basically 3 types of exception.
    1. Checked: checked at compile time.
    2. Unchecked: checked at runtime.
    3. Error: Irrecoverable state.
 */
public class ExceptionHandling {
    public static void main(String[] args) {
        ExceptionHandling exceptionHandling = new ExceptionHandling();
        exceptionHandling.uncheckedExceptions();
        addGap();
        exceptionHandling.checkedExceptions();
        addGap();
        exceptionHandling.customException();
        addGap();
        System.out.println("--------Throws Keyword Example--------");
        try {
            exceptionHandling.throwsKeyword();
        }catch (CustomException e){
            System.out.println(e.getMessage());
        }
    }

    private void throwsKeyword() throws CustomException{
        throw new CustomException();
    }

    private void customException() {
        System.out.println("--------Custom Exception Example--------");
        try {
            throw new CustomException();
        }catch (CustomException e){
            System.out.println(e.getMessage());
        }
    }

    void uncheckedExceptions() {
        System.out.println("--------Unchecked Exception Examples--------");
        int data = 100;
        try {
            //This statement will throw ArithmeticException at runtime.
            System.out.println(data / 0);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        int[] array = new int[10];
        try {
            //This statement will throw ArrayIndexOutOfBoundsException at runtime.
            System.out.println(array[11]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    void checkedExceptions() {
        System.out.println("--------Checked Exception Examples--------");
        File file = new File("not_existing_file.txt");
        try {
            //This statement will throw FileNotFoundException at runtime.
            FileInputStream stream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        // we can use finally to close any resource that we opened.
        // a "finally" block will always run irrespective of whether an exception was thrown or not.
    }

    static void addGap(){
        System.out.println();
        System.out.println();
    }
}

class CustomException extends RuntimeException{
    public CustomException() {
        super("Custom exception!!");
    }
}