package com.example.patrick.studienplaner;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.patrick.studienplaner.model.CalendarDayContent;

import java.util.List;

import com.example.patrick.studienplaner.CalendarDayFragment.OnListFragmentInteractionListener;


public class MyCalendarDayRecyclerViewAdapter extends RecyclerView.Adapter<MyCalendarDayRecyclerViewAdapter.ViewHolder> {

    private final List<CalendarDayContent.CalendarDayItem> mValues;
    private final CalendarDayFragment.OnListFragmentInteractionListener mListener;

    public MyCalendarDayRecyclerViewAdapter(List<CalendarDayContent.CalendarDayItem> items, CalendarDayFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.calendar_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.setData(mValues.get(position), mListener);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView mContentView;
        private final View view;
        public CalendarDayContent mItem;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        public void setData(final CalendarDayContent.CalendarDayItem item, final CalendarDayFragment.OnListFragmentInteractionListener mListener){
            mIdView.setText(item.id);
            mContentView.setText(item.content);
            this.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onListFragmentInteraction(item);
                }
            });
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
