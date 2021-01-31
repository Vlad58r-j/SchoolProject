package ru.vlad;

import ru.vlad.window.AppWindow;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AppWindow appWindow = new AppWindow();
        appWindow.frameJ();
        appWindow.jLabelLeft();
        appWindow.jTextFieldSurname();
        appWindow.jLabelRight();
        appWindow.setButton();
        appWindow.getVisible();
    }
}
