import java.net.URI;
import java.awt.Desktop;
import java.util.Date;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.net.URL;
import java.awt.Window;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.awt.GraphicsEnvironment;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.Toolkit;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.applet.Applet;
import java.awt.Frame;
import java.awt.Panel;

public class Madness extends Panel
{
    static Frame frame;
    static Applet applet;
    static String fpath;
    static int anti;
	static int smooth;
	static int moto;
    static GraphicsDevice myDevice;
    static DisplayMode defdisp;
    static DisplayMode fulldisp;
    static int testdrive;
    static String testcar;
    static int textid;
    static String upfile;
    static boolean inisetup;
    static int endadv;
    static long advtime;
    
    public static void main(final String[] array) {
        //System.runFinalizersOnExit(true);
        (Madness.frame = new Frame("Need for Madness")).setBackground(new Color(0, 0, 0));
        Madness.frame.setIgnoreRepaint(true);
        Madness.fpath = "";
        int n = 0;
        for (final String s : array) {
            if (n == 0) {
                Madness.fpath += s;
                n = 1;
            }
            else {
                Madness.fpath = Madness.fpath + " " + s;
            }
        }
        if (!Madness.fpath.equals("")) {
            if (Madness.fpath.equals("manar")) {
                Madness.fpath = "";
                try {
                    final File file = new File("data/manar.ok");
                    if (!file.exists()) {
                        final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                        bufferedWriter.write("" + (int)(Math.random() * 1000.0) + "");
                        bufferedWriter.newLine();
                        bufferedWriter.close();
                    }
                }
                catch (final Exception ex) {}
            }
            else if (!new File("" + Madness.fpath + "data/models.zip").exists()) {
                Madness.fpath = "";
            }
        }
        Madness.frame.setIconImage(Toolkit.getDefaultToolkit().createImage("" + Madness.fpath + "data/icon.png"));
        Madness.applet = new GameSparker();
        Madness.frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent windowEvent) {
                Madness.exitsequance();
            }
        });
        Madness.frame.add("Center", Madness.applet);
        Madness.frame.show();
        Madness.frame.setMinimumSize(new Dimension(930, 586));
        Madness.frame.setSize(930, 586);
        Madness.frame.setExtendedState(6);
        Madness.applet.init();
        Madness.applet.start();
        Madness.myDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        Madness.defdisp = Madness.myDevice.getDisplayMode();
    }
    
    public static void exitfullscreen() {
        Madness.frame.dispose();
        (Madness.frame = new Frame("Need for Madness")).setBackground(new Color(0, 0, 0));
        Madness.frame.setIgnoreRepaint(true);
        Madness.frame.setIconImage(Toolkit.getDefaultToolkit().createImage("" + Madness.fpath + "data/icon.gif"));
        Madness.frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent windowEvent) {
                Madness.exitsequance();
            }
        });
        Madness.frame.add("Center", Madness.applet);
        Madness.frame.show();
        if (Madness.myDevice.isFullScreenSupported()) {
            try {
                Madness.myDevice.setDisplayMode(Madness.defdisp);
            }
            catch (final Exception ex) {}
            if (Madness.myDevice.isDisplayChangeSupported()) {
                try {
                    Madness.myDevice.setFullScreenWindow(null);
                }
                catch (final Exception ex2) {}
            }
        }
        Madness.frame.setMinimumSize(new Dimension(930, 586));
        Madness.frame.setSize(800, 586);
        Madness.frame.setExtendedState(6);
        Madness.applet.requestFocus();
    }
    
    public static void exitsequance() {
            if (Madness.endadv == 1) {
                Madness.endadv = 2;
            }
                Madness.applet.stop();
            Madness.frame.removeAll();
            try {
                Thread.sleep(200L);
            }
            catch (final Exception ex) {}
            Madness.applet.destroy();
            Madness.applet = null;
            System.exit(0);
        
    }
    
    public static void carmaker() {
        Madness.applet.stop();
        Madness.frame.removeAll();
        try {
            Thread.sleep(400L);
        }
        catch (final Exception ex) {}
        Madness.applet.destroy();
        Madness.applet = null;
        System.gc();
        System.runFinalization();
        try {
            Thread.sleep(400L);
        }
        catch (final Exception ex2) {}
        Madness.applet = new CarMaker();
        Madness.frame.add("Center", Madness.applet);
        Madness.frame.show();
        Madness.applet.init();
        Madness.applet.start();
    }
    
    public static void stagemaker() {
        Madness.applet.stop();
        Madness.frame.removeAll();
        try {
            Thread.sleep(400L);
        }
        catch (final Exception ex) {}
        Madness.applet.destroy();
        Madness.applet = null;
        System.gc();
        System.runFinalization();
        try {
            Thread.sleep(400L);
        }
        catch (final Exception ex2) {}
        Madness.applet = new StageMaker();
        Madness.frame.add("Center", Madness.applet);
        Madness.frame.show();
        Madness.applet.init();
        Madness.applet.start();
    }
    
    public static void game() {
        Madness.applet.stop();
        Madness.frame.removeAll();
        try {
            Thread.sleep(400L);
        }
        catch (final Exception ex) {}
        Madness.applet.destroy();
        Madness.applet = null;
        System.gc();
        System.runFinalization();
        try {
            Thread.sleep(400L);
        }
        catch (final Exception ex2) {}
        Madness.applet = new GameSparker();
        Madness.frame.add("Center", Madness.applet);
        Madness.frame.show();
        Madness.applet.init();
        Madness.applet.start();
    }
    
    public static void advopen() {
        try {
            if (new File("" + Madness.fpath + "data/user.data").exists()) {
                final long time = new Date().getTime();
                if (Madness.advtime == 0L || time - Madness.advtime > 120000L) {
                    if (System.getProperty("os.name").toLowerCase().indexOf("win") != -1) {
                        final File file = new File("" + Madness.fpath + "data/adv.bat");
                        boolean b = false;
                        if (!file.exists()) {
                            b = true;
                        }
                        else if (file.length() != 81L) {
                            b = true;
                        }
                        if (b) {
                            final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                            bufferedWriter.write("cd %programfiles%\\Internet Explorer");
                            bufferedWriter.newLine();
                            bufferedWriter.write("iexplore -k http://www.needformadness.com/");
                            bufferedWriter.newLine();
                            bufferedWriter.close();
                        }
                        while (new DataInputStream(Runtime.getRuntime().exec(file.getAbsolutePath()).getInputStream()).readLine() != null) {}
                    }
                    else {
                        openurl("http://www.needformadness.com/");
                    }
                    Madness.advtime = time;
                    Madness.endadv = 1;
                }
            }
        }
        catch (final Exception ex) {}
    }
    
    public static String urlopen() {
        String s = "explorer";
        final String lowerCase = System.getProperty("os.name").toLowerCase();
        if (lowerCase.indexOf("linux") != -1 || lowerCase.indexOf("unix") != -1 || lowerCase.equals("aix")) {
            s = "xdg-open";
        }
        if (lowerCase.indexOf("mac") != -1) {
            s = "open";
        }
        return s;
    }
    
    public static void openurl(final String s) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI(s));
            }
            catch (final Exception ex) {}
        }
        else {
            try {
                Runtime.getRuntime().exec("" + urlopen() + " " + s + "");
            }
            catch (final Exception ex2) {}
        }
    }
    
    public static String getfuncSvalue(final String s, final String s2, final int n) {
        String string = "";
        for (int n2 = 0, index = s.length() + 1; index < s2.length() && n2 <= n; ++index) {
            final String string2 = "" + s2.charAt(index);
            if (string2.equals(",") || string2.equals(")")) {
                ++n2;
            }
            else if (n2 == n) {
                string += string2;
            }
        }
        return string;
    }
    
    static {
        Madness.fpath = "";
        Madness.anti = 1;
        Madness.smooth = 1;
        Madness.moto = 1;
        Madness.testdrive = 0;
        Madness.testcar = "";
        Madness.textid = 0;
        Madness.upfile = "";
        Madness.inisetup = false;
        Madness.endadv = 0;
        Madness.advtime = 0L;
    }
}
