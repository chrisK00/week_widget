package com.example.week_widget

import android.annotation.SuppressLint
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.os.Build
import android.widget.RemoteViews
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.temporal.WeekFields

/**
 * Implementation of App Widget functionality.
 */
class WeekWidget : AppWidgetProvider() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

@RequiresApi(Build.VERSION_CODES.O)
private fun getWeekNumber(): Int {
    val date = LocalDate.now()
    val weekFields = WeekFields.ISO
    return date.get(weekFields.weekOfWeekBasedYear())
}

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("RemoteViewLayout")
internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    // val widgetText = context.getString(R.string.appwidget_text)
    val widgetText = getWeekNumber().toString()
    // Construct the RemoteViews object
    val views = RemoteViews(context.packageName, R.layout.week_widget)
    views.setTextViewText(R.id.appwidget_text, widgetText)

    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
}