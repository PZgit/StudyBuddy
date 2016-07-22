package com.example.patrick.studienplaner.model.LerngruppenModels;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrick on 27.05.2016.
 */
public abstract class LerngruppenCardContent {
    public String name;
    public abstract int getType();

    public static List<LerngruppenCardContent> createData() {

        List<LerngruppenCardContent> LerngruppenList = new ArrayList<LerngruppenCardContent>();

        LerngruppenList.add(new Lerngruppe("Lerngruppe111"));
        LerngruppenList.add(new Lerngruppe("Lerngruppe222"));
        LerngruppenList.add(new Lerngruppe("Lerngruppe333"));
        LerngruppenList.add(new Lerngruppe("Lerngruppe444"));
        LerngruppenList.add(new Lerngruppe("Lerngruppe555"));
        LerngruppenList.add(new Lerngruppe("Lerngruppe666"));
        LerngruppenList.add(new Lerngruppe("Lerngruppe777"));


        return LerngruppenList;
    }
}
