# week_widget
right click android folder -> open in android studio
WeekWidget.kt <- code
week_widget.xml <- UI
week_widget_info.xml <- config

flutter build apk --split-per-abi
flutter install --device-id  SM S926B --use-application-binary=build\app\outputs\flutter-apk\app-arm64-v8a-release.apk