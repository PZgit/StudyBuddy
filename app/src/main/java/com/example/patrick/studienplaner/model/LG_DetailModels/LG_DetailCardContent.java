package com.example.patrick.studienplaner.model.LG_DetailModels;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Patrick on 19.05.2016.
 */
public abstract class LG_DetailCardContent {

    public String name;

    public abstract int getType();

    public static List<LG_DetailCardContent> createData() {

        List<LG_DetailCardContent> LGDetailList = new ArrayList<LG_DetailCardContent>();

        LGDetailList.add(new Termin("Lerntermin111", "12Uhr", "SHL H.1.1"));
        LGDetailList.add(new Termin("Lerntermin222", "12Uhr", "SHL H.1.1"));
        LGDetailList.add(new Termin("Lerntermin333", "12Uhr", "SHL H.1.1"));
        LGDetailList.add(new TerminInvite("INVITETERMIN111", "12Uhr", "SHL H.1.1"));
        LGDetailList.add(new TerminInvite("INVITETERMIN222", "12Uhr", "SHL H.1.1"));
        LGDetailList.add(new TerminInvite("INVITETERMIN333", "12Uhr", "SHL H.1.1"));
        LGDetailList.add(new Mitglied("Member1 Michi"));
        LGDetailList.add(new Mitglied("Member2 Joseph"));

        return LGDetailList;
    }

}
