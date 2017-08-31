package com.krasutski.util;

import java.lang.reflect.Field;

@SuppressWarnings("WeakerAccess")
public final class ReflectionUtils {

    /**
     * Get a field.
     *
     * @param object    the object.
     * @param fieldName the field name.
     * @return the field.
     */

    public static Field getField(final Object object, final String fieldName) {
        try {
            return object.getClass().getDeclaredField(fieldName);
        } catch (final NoSuchFieldException | SecurityException | IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Get a field using full access.
     *
     * @param object    the object.
     * @param fieldName the field name.
     * @return the field.
     */

    public static Field getUnsafeField(final Object object, final String fieldName) {
        try {
            final Field field = getField(object, fieldName);
            field.setAccessible(true);
            return field;
        } catch (final SecurityException | IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Get a field value using full access.
     *
     * @param object    the object.
     * @param fieldName the field name.
     * @return the value.
     */
    public static <T> T getUnsafeFieldValue(final Object object, final String fieldName) {
        try {
            final Field field = getUnsafeField(object, fieldName);
            return unsafeCast(field.get(object));
        } catch (final SecurityException | IllegalArgumentException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Unsafe cast an object.
     *
     * @param object the object.
     * @return the casted object.
     */
    @SuppressWarnings("unchecked")
    private static <T> T unsafeCast(final Object object) {
        return (T) object;
    }

    private ReflectionUtils() {
        throw new IllegalArgumentException();
    }
}
