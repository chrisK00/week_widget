# week_widget
- right click android folder -> open in android studio
- WeekWidget.kt <- code
- week_widget.xml <- UI
- week_widget_info.xml <- config
- Add either "Week number (light)" or "Week number (dark)" from the Android home screen widget picker.
- Both widgets show the current week number with contrasting background and text colors.

- flutter build apk --split-per-abi
- flutter install --device-id id  --use-application-binary=build\app\outputs\flutter-apk\app-arm64-v8a-release.apk
