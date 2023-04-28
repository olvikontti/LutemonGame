package com.example.lutemongame;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class LutemonStorage {

    private Home home;
    private TrainingArea trainingArea;
    private BattleField battleField;
    //protected ArrayList<Lutemon> lutemons = new ArrayList<>();
    protected ArrayList<Lutemon> allLutemons = new ArrayList<>();
    private static LutemonStorage storage = null;

    private LutemonStorage(){
    }

    public void addLutemon(Lutemon lutemon) {
        home.addLutemon(lutemon);
    }

    public Lutemon getLutemon(int id) {
        return allLutemons.get(id);
    }

    public ArrayList<Lutemon> getLutemons() {
        return allLutemons;
    }

    public int getSize() { return allLutemons.size(); }

    public ArrayList<Lutemon> getAllLutemons() {
        allLutemons.addAll(home.getLutemons());
        allLutemons.addAll(battleField.getLutemons());
        allLutemons.addAll(trainingArea.getLutemons());

        return allLutemons;
    }

    public ArrayList<Lutemon> getHomeLutemons(){
        return home.getLutemons();
    }

    public ArrayList<Lutemon> getTrainingLutemons(){
        return trainingArea.getLutemons();
    }

    public ArrayList<Lutemon> getBattleLutemons(){
        return battleField.getLutemons();
    }


    public static LutemonStorage getInstance() {
        if (storage == null) {
            storage = new LutemonStorage();
        }
        return storage;
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
            allLutemons = LutemonStorage.getInstance().getAllLutemons();
            lutemonWriter.writeObject(allLutemons);
            System.out.println("testi");
            lutemonWriter.close();
        } catch (IOException e) {
            System.out.println("Lutemonien tallentaminen ei onnistunut");
        }
    }

    public void loadLutemons(Context context){
        try{
            ObjectInputStream lutemonReader = new ObjectInputStream(context.openFileInput("lutemons.data"));
            allLutemons = (ArrayList<Lutemon>) lutemonReader.readObject();
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
