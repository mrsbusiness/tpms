package com.brainyway.mrs.tpms.reports;

import java.io.File;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.Calendar;

import javax.print.attribute.standard.DateTimeAtProcessing;

import javafx.util.converter.DateStringConverter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.joda.time.DateTime;

public class DriversKMPLCharts {

	public File getDriversKMPLCharts(DriverKMPLChartData kmplRawData) throws Exception {

		TimeSeriesCollection kmplDataset = new TimeSeriesCollection();
		TimeSeries series = new TimeSeries("Data");
		
		if(kmplRawData.getDriverKMPLList().size()==0){
			return null;
		}
		
		for (DriverKMPL kmplData : kmplRawData
				.getDriverKMPLList()) {
			DateTime dateTime = new DateTime(kmplData.getDayOfKMPL());
			if(kmplData.getKmpl()>0.0 ){
			
				series.add(new Day(dateTime.getDayOfMonth(),dateTime.getMonthOfYear(),dateTime.getYear()), kmplData.getKmpl());
			}
			
		}
		kmplDataset.addSeries(series);
		
		JFreeChart xylineChart = ChartFactory.createXYBarChart(
				kmplRawData.getDriverName().getFirstName()+" "+kmplRawData.getDriverName().getLastName() + "'s KMPL Chart for Bus  " +kmplRawData.getBusRegistrationNumber() , "Date", true,
				"KMPL", kmplDataset, PlotOrientation.VERTICAL, false, false,
				false);

		/*
		 * JFreeChart xylineChart = ChartFactory.createXYLineChart(
		 * "Browser usage statastics", "Category", "Score", dataset,
		 * PlotOrientation.VERTICAL, true, true, false);
		 */
		int width =75 * kmplRawData.getDriverKMPLList().size(); /* Width of the image */
		int height = 480; /* Height of the image */
		File xyChartFile = new File("./DriversKMPLCharts.jpeg");
		ChartUtilities.saveChartAsJPEG(xyChartFile, xylineChart, width, height);
		return xyChartFile;
		
	}
}
