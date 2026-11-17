package com.example.week_widget

import android.annotation.SuppressLint
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.os.Build
import android.widget.RemoteViews
import androidx.annotation.LayoutRes
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.temporal.WeekFields

abstract class WeekWidgetProvider : AppWidgetProvider() {
    @get:LayoutRes
    protected abstract val layoutResId: Int

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (appWidgetId in appWidgetIds) {
            updateWeekWidget(context, appWidgetManager, appWidgetId, layoutResId)
        }
    }
}

class WeekWidget : WeekWidgetProvider() {
    override val layoutResId = R.layout.week_widget
}

class DarkWeekWidget : WeekWidgetProvider() {
    override val layoutResId = R.layout.week_widget_dark
}

@RequiresApi(Build.VERSION_CODES.O)
private fun getWeekNumber(): Int {
    val date = LocalDate.now()
    val weekFields = WeekFields.ISO
    return date.get(weekFields.weekOfWeekBasedYear())
}

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("RemoteViewLayout")
internal fun updateWeekWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int,
    @LayoutRes layoutResId: Int
) {
    val widgetText = getWeekNumber().toString()
    val views = RemoteViews(context.packageName, layoutResId)
    views.setTextViewText(R.id.appwidget_text, widgetText)
    appWidgetManager.updateAppWidget(appWidgetId, views)
}
