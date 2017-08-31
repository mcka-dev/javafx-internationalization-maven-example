package com.krasutski.language;

import static java.util.ResourceBundle.getBundle;
import static com.krasutski.util.ReflectionUtils.getUnsafeFieldValue;

import com.sun.javafx.scene.control.skin.resources.ControlResources;
import com.krasutski.util.PropertyLoader;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * The class with all messages of this application.
 */
public abstract class Messages {

    private static ResourceBundle BUNDLE;

    private static final String FIELD_NAME = "lookup";
    private static final String BUNDLE_NAME = "messages/messages";
    private static final String CONTROLS_BUNDLE_NAME = "com/sun/javafx/scene/control/skin/resources/controls";

    public static final String MAIN_APP_TITLE;

    public static final String DIALOG_HEADER;
    public static final String MAIN_CONTROLLER_CONTENT_TEXT;
    public static final String MAIN_CONTROLLER_HELLO_TEXT;
    public static final String MAIN_CONTROLLER_GOODBYE_TEXT;

    static {
        final Locale locale = Locale.getDefault();
        final ClassLoader classLoader = ControlResources.class.getClassLoader();

        final ResourceBundle controlBundle = getBundle(CONTROLS_BUNDLE_NAME,
                locale, classLoader, PropertyLoader.getInstance());

        final ResourceBundle overrideBundle = getBundle(CONTROLS_BUNDLE_NAME,
                PropertyLoader.getInstance());

        final Map override = getUnsafeFieldValue(overrideBundle, FIELD_NAME);
        final Map original = getUnsafeFieldValue(controlBundle, FIELD_NAME);

        //noinspection ConstantConditions,ConstantConditions,unchecked
        original.putAll(override);

        BUNDLE = getBundle(BUNDLE_NAME, PropertyLoader.getInstance());

        MAIN_APP_TITLE = BUNDLE.getString("MainApp.title");

        DIALOG_HEADER = BUNDLE.getString("Dialog.information.header");
        MAIN_CONTROLLER_CONTENT_TEXT = BUNDLE.getString("MainController.contentText");
        MAIN_CONTROLLER_HELLO_TEXT = BUNDLE.getString("MainController.helloText");
        MAIN_CONTROLLER_GOODBYE_TEXT = BUNDLE.getString("MainController.goodbyeText");
    }

    public static ResourceBundle GetBundle() {
        return BUNDLE;
    }
}