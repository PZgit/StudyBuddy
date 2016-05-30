package com.example.patrick.studienplaner.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Julian on 09.05.2016.
 */
public class CalendarDayContent {

    /**
     * A dummy item representing a piece of content.
     */

    public static class CalendarDayItem {
        public final String id;
        public final String content;
        public final String details;

        public CalendarDayItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }

    /**
     * An array of sample (dummy) items.
     */
    public static final List<CalendarDayItem> ITEMS = new ArrayList<CalendarDayItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, CalendarDayItem> ITEM_MAP = new HashMap<String, CalendarDayItem>();

    private static final int COUNT = 24;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createItem(i));
        }
    }

    private static void addItem(CalendarDayItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static CalendarDayItem createItem(int position) {
        return new CalendarDayItem(String.valueOf(position), position + ":00", makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

}
