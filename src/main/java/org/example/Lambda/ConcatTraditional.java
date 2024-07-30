package org.example.Lambda;

public class ConcatTraditional implements ConcatenateInterface{
    @Override
    public String sconcat(String a, String b) {
        return a.concat(b);
    }

    public static void main(String[] args) {
        ConcatenateInterface concat = new ConcatTraditional();
        System.out.println(concat.sconcat("Hello", "World"));
    }
}
