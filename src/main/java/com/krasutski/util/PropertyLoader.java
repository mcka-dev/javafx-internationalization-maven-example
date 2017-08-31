package com.krasutski.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class PropertyLoader extends ResourceBundle.Control {

    private static final String PROPERTIES_RESOURCE_NAME = "properties";

    private static final PropertyLoader INSTANCE = new PropertyLoader();

    public static PropertyLoader getInstance() {
        return INSTANCE;
    }

    @Override
    public ResourceBundle newBundle(final String baseName, final Locale locale, final String format,
                                    final ClassLoader loader, final boolean reload)
            throws IllegalAccessException, InstantiationException, IOException {

        final String bundleName = toBundleName(baseName, locale);
        final String resourceName = toResourceName(bundleName, PROPERTIES_RESOURCE_NAME);

        ResourceBundle bundle = null;
        InputStream stream = null;

        if (reload) {

            final URL url = loader.getResource(resourceName);

            if (url != null) {
                final URLConnection connection = url.openConnection();
                if (connection != null) {
                    connection.setUseCaches(false);
                    stream = connection.getInputStream();
                }
            }

        } else {
            stream = loader.getResourceAsStream(resourceName);
        }

        if (stream != null) {
            try {
                bundle = new PropertyResourceBundle(new InputStreamReader(stream, StandardCharsets.UTF_8));
            } finally {
                stream.close();
            }
        }

        return bundle;
    }
}
