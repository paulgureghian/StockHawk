package com.udacity.stockhawk.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.google.common.reflect.TypeToken;
import com.udacity.stockhawk.R;
import com.udacity.stockhawk.database.Contract;
import com.udacity.stockhawk.pojo.Stock;

import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import timber.log.Timber;

public class StockChart extends AppCompatActivity {

    String endDate;
    String startDate;
    String mStockSymbol;

    Context context;
    List<Stock> items;
    private LineChart lineChart;

    TextView symbol;
    Type listType = new TypeToken<List<Stock>>() {}.getType();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_chart);

        Intent intent = getIntent();
        mStockSymbol = intent.getExtras().getString(Contract.Quote.COLUMN_SYMBOL);

        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
        endDate = simpleDateFormat.format(date);
        calendar.add(Calendar.MONTH, -1);
        startDate = simpleDateFormat.format(calendar.getTime());

        symbol = (TextView) findViewById(R.id.symbol);
        lineChart = (LineChart) findViewById(R.id.chart);

        Timber.e(startDate);
        Timber.e(endDate);
    }

}
