package com.example.lutemongame;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class LutemonStorage {

    private Home home = null;
    private TrainingArea trainingArea = null;
    private BattleField battleField = null;
    protected ArrayList<Lutemon> lutemons = new ArrayList<>();
    private static LutemonStorage storage = null;

    private LutemonStorage(){
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

    public int getSize() { return lutemons.size(); }

    public ArrayList<Lutemon> getAllLutemons() {
        ArrayList<Lutemon> all = new ArrayList<>();
        all.addAll(home.getLutemons());
        all.addAll(battleField.getLutemons());
        all.addAll(trainingArea.getLutemons());
        return all;
    }


    public static LutemonStorage getInstance() {
        if (storage == null) {
            storage = new LutemonStorage();
        }
        return storage;
    }

    public void TrainingLutemonAttack(Lutemon lutemon) {
        if (trainingArea != null) {
            trainingArea.trainAttack(lutemon);

        }
    }
    public void TrainingLutemonDefence(Lutemon lutemon) {
        if (trainingArea != null) {
            trainingArea.trainDefence(lutemon);


        }
    }

    public ArrayList<Lutemon> getHomeLutemons(){
        home.getLutemons();
        return lutemons;
    }


    public void moveLutemons(String from, String to, ArrayList<Lutemon> lutemons){

        Habitat fromHabitat = null;
        Habitat toHabitat = null;

        switch(from){
            case "home":
                fromHabitat = home;
                break;
            case "training":
                fromHabitat = trainingArea;
                break;
            case "battle":
                fromHabitat = battleField;
                break;
            default:
                System.out.println("vittu");
                throw new IllegalArgumentException("Invalid habitat" + from);
        }

        switch(to){
            case "home":
                toHabitat = home;
                break;
            case "training":
                toHabitat = trainingArea;
                break;
            case "battle":
                toHabitat = battleField;
                break;
            default:
                System.out.println("vittu");
                throw new IllegalArgumentException("Invalid habitat" + to);
        }

        for(int i = 0; i < lutemons.size(); i++) {
            fromHabitat.removeLutemon(lutemons.get(i));
            toHabitat.addLutemon(lutemons.get(i));
        }
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
