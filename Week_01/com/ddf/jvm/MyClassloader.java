package com.ddf.jvm;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 * @author ddf
 */
public class MyClassloader extends ClassLoader {
    public static void main(String[] args) {

        try {
            Class<?> clazz = new MyClassloader().findClass("Hello");
            Method method = clazz.getMethod("hello");
            method.invoke(clazz.newInstance());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File("Week_01/Hello.xlass");
        byte[] bytes = null;
        try {
            bytes = getClassFileBytes(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (255 - bytes[i]);
        }

        return defineClass(name, bytes, 0, bytes.length);
    }

    private byte[] getClassFileBytes(File file) throws Exception {
        try (FileInputStream fis = new FileInputStream(file); FileChannel fileC = fis.getChannel();
             ByteArrayOutputStream baos = new ByteArrayOutputStream(); WritableByteChannel outC = Channels.newChannel(baos);) {
            ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
            while (true) {
                int i = fileC.read(buffer);
                if (i == 0 || i == -1) {
                    break;
                }
                buffer.flip();
                outC.write(buffer);
                buffer.clear();
            }
            return baos.toByteArray();
        }
    }
}
