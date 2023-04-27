package com.example.lutemongame;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class LutemonStorage {
    private ArrayList<Lutemon> lutemons = new ArrayList<>();
    private static LutemonStorage storage = null;


    private LutemonStorage() {
    }

    public void addLutemon(Lutemon lutemon) {
        lutemons.add(lutemon);
    }

    public Lutemon getLutemon(int id) {
        return lutemons.get(id);
    }

    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }

    public static LutemonStorage getInstance() {
        if (storage == null) {
            storage = new LutemonStorage();
        }
        return storage;
    }

    public void saveLutemons(Context context){
        try{
            ObjectOutputStream lutemonWriter = new ObjectOutputStream(context.openFileOutput("lutemons.data", Context.MODE_PRIVATE));
            lutemonWriter.writeObject(lutemons);
            System.out.println("testi");
            lutemonWriter.close();
        } catch (IOException e) {
            System.out.println("Lutemonien tallentaminen ei onnistunut");
        }
    }

    public void loadLutemons(Context context){
        try{
            ObjectInputStream lutemonReader = new ObjectInputStream(context.openFileInput("lutemons.data"));
            lutemons = (ArrayList<Lutemon>) lutemonReader.readObject();
            lutemonReader.close();
        } catch (FileNotFoundException e){
            System.out.println("Lutemonien lukeminen ei onnistunut.");
        } catch (IOException e){
            System.out.println("Lutemonien lukeminen ei onnistunut.");
        } catch (ClassNotFoundException e){
            System.out.println("Lutemonien lukeminen ei onnistunut.");
        }

    }

}
