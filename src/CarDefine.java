import java.io.FileReader;
import java.io.File;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.net.URL;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.ByteArrayInputStream;

public class CarDefine implements Runnable
{
    Trackers t;
    GameSparker gs;
    ContO[] bco;
    Medium m;
    Thread carloader;
    Thread actionloader;
    Thread stageaction;
    int[][] swits;
    float[][] acelf;
    int[] handb;
    float[] airs;
    int[] airc;
    int[] turn;
    float[] grip;
    float[] bounce;
    float[] simag;
    float[] moment;
    float[] comprad;
    int[] push;
    int[] revpush;
    int[] lift;
    int[] revlift;
    int[] powerloss;
    float[] flipy;
    int[] msquash;
    int[] clrad;
    float[] dammult;
    int[] maxmag;
    float[] dishandle;
    float[] outdam;
    int[] cclass;
    String[] names;
    int[] enginsignature;
    int nlcars;
    String[] createdby;
    int nl;
    int action;
    boolean carlon;
    int reco;
    int haltload;
    int onloadingcar;
    int ac;
    String fails;
    String tnickey;
    int loadlist;
    String viewname;
    String onstage;
    int inslot;
    int roundslot;
    String lastcar;
    int msloaded;
    
    public CarDefine(final ContO[] bco, final Medium m, final Trackers t, final GameSparker gs) {
        this.swits = new int[][] { { 50, 185, 282 }, { 100, 200, 310 }, { 60, 180, 275 }, { 76, 195, 298 }, { 70, 170, 275 }, { 70, 202, 293 }, { 60, 170, 289 }, { 70, 206, 291 }, { 90, 210, 295 }, { 90, 190, 276 }, { 70, 200, 295 }, { 50, 160, 270 }, { 90, 200, 305 }, { 50, 130, 210 }, { 80, 200, 300 }, { 70, 210, 290 } };
        this.acelf = new float[][] { { 11.0f, 5.0f, 3.0f }, { 14.0f, 7.0f, 5.0f }, { 10.0f, 5.0f, 3.5f }, { 11.0f, 6.0f, 3.5f }, { 10.0f, 5.0f, 3.5f }, { 12.0f, 6.0f, 3.0f }, { 7.0f, 9.0f, 4.0f }, { 11.0f, 5.0f, 3.0f }, { 12.0f, 7.0f, 4.0f }, { 12.0f, 7.0f, 3.5f }, { 11.5f, 6.5f, 3.5f }, { 9.0f, 5.0f, 3.0f }, { 13.0f, 7.0f, 4.5f }, { 7.5f, 3.5f, 3.0f }, { 11.0f, 7.5f, 4.0f }, { 12.0f, 6.0f, 3.5f }};
        this.handb = new int[] { 7, 10, 7, 15, 12, 8, 9, 10, 5, 7, 8, 10, 8, 12, 7, 7};
        this.airs = new float[] { 1.0f, 1.2f, 0.95f, 1.0f, 2.2f, 1.0f, 0.9f, 0.8f, 1.0f, 0.9f, 1.15f, 0.8f, 1.0f, 0.3f, 1.3f, 1.0f};
        this.airc = new int[] { 70, 30, 40, 40, 30, 50, 40, 90, 40, 50, 75, 10, 50, 0, 100, 60};
        this.turn = new int[] { 6, 9, 5, 7, 8, 7, 5, 5, 9, 7, 7, 4, 6, 5, 7, 6};
        this.grip = new float[] { 20.0f, 27.0f, 18.0f, 22.0f, 19.0f, 20.0f, 25.0f, 20.0f, 19.0f, 24.0f, 22.5f, 25.0f, 30.0f, 27.0f, 25.0f, 27.0f};
        this.bounce = new float[] { 1.2f, 1.05f, 1.3f, 1.15f, 1.3f, 1.2f, 1.15f, 1.1f, 1.2f, 1.1f, 1.15f, 0.8f, 1.05f, 0.8f, 1.1f, 1.15f};
        this.simag = new float[] { 0.9f, 0.85f, 1.05f, 0.9f, 0.85f, 0.9f, 1.05f, 0.9f, 1.0f, 1.05f, 0.9f, 1.1f, 0.9f, 1.3f, 0.9f, 1.15f};
        this.moment = new float[] { 1.3f, 0.75f, 1.4f, 1.2f, 1.1f, 1.38f, 1.43f, 1.48f, 1.35f, 1.7f, 1.42f, 2.0f, 1.26f, 3.0f, 1.5f, 2.0f};
        this.comprad = new float[] { 0.5f, 0.4f, 0.8f, 0.5f, 0.4f, 0.5f, 0.5f, 0.5f, 0.5f, 0.8f, 0.5f, 1.5f, 0.5f, 0.8f, 0.5f, 0.8f};
        this.push = new int[] { 2, 2, 3, 3, 2, 2, 2, 4, 2, 2, 2, 4, 2, 2, 2, 2};
        this.revpush = new int[] { 2, 3, 2, 2, 2, 2, 2, 1, 2, 1, 2, 1, 2, 2, 2, 1};
        this.lift = new int[] { 0, 30, 0, 20, 0, 30, 0, 0, 20, 0, 0, 0, 10, 0, 30, 0};
        this.revlift = new int[] { 0, 0, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32};
        this.powerloss = new int[] { 2500000, 2500000, 3500000, 2500000, 4000000, 2500000, 3200000, 3200000, 2750000, 5500000, 2750000, 4500000, 3500000, 16700000, 3000000, 5500000};
        this.flipy = new float[] { -50, -60, -92, -44, -60, -57, -54, -60, -77, -57, -82, -85, -28, -100, -63, -127};
        this.msquash = new int[] { 7, 4, 7, 2, 8, 4, 6, 4, 3, 8, 4, 10, 3, 20, 3, 8};
        this.clrad = new int[] { 3300, 1700, 4700, 3000, 2000, 4500, 3500, 5000, 10000, 15000, 4000, 7000, 10000, 15000, 5500, 5000};
        this.dammult = new float[] { 0.75f, 0.8f, 0.45f, 0.8f, 0.42f, 0.7f, 0.72f, 0.6f, 0.58f, 0.41f, 0.67f, 0.45f, 0.61f, 0.25f, 0.38f, 0.52f};
        this.maxmag = new int[] { 7600, 4200, 7200, 6000, 6000, 15000, 17200, 17000, 18000, 11000, 19000, 10700, 13000, 45000, 5800, 18000};
        this.dishandle = new float[] { 0.65f, 0.6f, 0.55f, 0.77f, 0.62f, 0.9f, 0.6f, 0.72f, 0.45f, 0.8f, 0.95f, 0.4f, 0.87f, 0.42f, 1.0f, 0.95f};
        this.outdam = new float[] { 0.68f, 0.35f, 0.8f, 0.5f, 0.42f, 0.76f, 0.82f, 0.76f, 0.72f, 0.62f, 0.79f, 0.95f, 0.77f, 1.0f, 0.85f, 1.0f};
        this.cclass = new int[] { 0, 0, 0, 0, 0, 1, 2, 2, 2, 2, 3, 4, 4, 4, 4, 4};
        this.names = new String[] { "Tornado Shark", "Formula 7", "Wow Caninaro", "La Vita Crab", "Nimi", "MAX Revenge", "Lead Oxide", "Kool Kat", "Drifter X", "Sword of Justice", "High Rider", "EL KING", "Mighty Eight", "M A S H E E N", "Radical One", "DR Monstaa"};
        this.enginsignature = new int[] { 0, 1, 2, 1, 0, 3, 2, 2, 1, 0, 3, 4, 1, 4, 0, 3};
        this.nlcars = 0;
        this.createdby = new String[16];
        this.nl = 0;
        this.action = 0;
        this.carlon = false;
        this.reco = -2;
        this.haltload = 0;
        this.onloadingcar = 0;
        this.ac = -1;
        this.fails = "";
        this.tnickey = "";
        this.loadlist = 0;
        this.viewname = "";
        this.onstage = "";
        this.inslot = -1;
        this.roundslot = 0;
        this.lastcar = "";
        this.msloaded = 0;
        this.bco = bco;
        this.m = m;
        this.t = t;
        this.gs = gs;
        this.loadstat();
    }

    public void loadstat() {
        for (int carIndex = 0; carIndex < 16; ++carIndex) {
            try {
                final BufferedReader reader = new BufferedReader(new FileReader("" + Madness.fpath + "cars/" + carIndex + ".txt"));
                String line;
                while ((line = reader.readLine()) != null) {
                    final String trim = line.trim();
                    if (trim.startsWith("name(")) {
                        this.names[carIndex] = this.getSvalue("name", trim, 0);
                    }
                    else if (trim.startsWith("swits(")) {
                        for (int i = 0; i < 3; ++i) {
                            this.swits[carIndex][i] = this.getvalue("swits", trim, i);
                        }
                    }
                    else if (trim.startsWith("acelf(")) {
                        for (int i = 0; i < 3; ++i) {
                            this.acelf[carIndex][i] = this.getfloatvalue("acelf", trim, i);
                        }
                    }
                    else if (trim.startsWith("handb(")) this.handb[carIndex] = this.getvalue("handb", trim, 0);
                    else if (trim.startsWith("airs(")) this.airs[carIndex] = this.getfloatvalue("airs", trim, 0);
                    else if (trim.startsWith("airc(")) this.airc[carIndex] = this.getvalue("airc", trim, 0);
                    else if (trim.startsWith("turn(")) this.turn[carIndex] = this.getvalue("turn", trim, 0);
                    else if (trim.startsWith("grip(")) this.grip[carIndex] = this.getfloatvalue("grip", trim, 0);
                    else if (trim.startsWith("bounce(")) this.bounce[carIndex] = this.getfloatvalue("bounce", trim, 0);
                    else if (trim.startsWith("simag(")) this.simag[carIndex] = this.getfloatvalue("simag", trim, 0);
                    else if (trim.startsWith("moment(")) this.moment[carIndex] = this.getfloatvalue("moment", trim, 0);
                    else if (trim.startsWith("comprad(")) this.comprad[carIndex] = this.getfloatvalue("comprad", trim, 0);
                    else if (trim.startsWith("push(")) this.push[carIndex] = this.getvalue("push", trim, 0);
                    else if (trim.startsWith("revpush(")) this.revpush[carIndex] = this.getvalue("revpush", trim, 0);
                    else if (trim.startsWith("lift(")) this.lift[carIndex] = this.getvalue("lift", trim, 0);
                    else if (trim.startsWith("revlift(")) this.revlift[carIndex] = this.getvalue("revlift", trim, 0);
                    else if (trim.startsWith("powerloss(")) this.powerloss[carIndex] = this.getvalue("powerloss", trim, 0);
                    else if (trim.startsWith("flipy(")) this.flipy[carIndex] = this.getfloatvalue("flipy", trim, 0);
                    else if (trim.startsWith("msquash(")) this.msquash[carIndex] = this.getvalue("msquash", trim, 0);
                    else if (trim.startsWith("clrad(")) this.clrad[carIndex] = this.getvalue("clrad", trim, 0);
                    else if (trim.startsWith("dammult(")) this.dammult[carIndex] = this.getfloatvalue("dammult", trim, 0);
                    else if (trim.startsWith("maxmag(")) this.maxmag[carIndex] = this.getvalue("maxmag", trim, 0);
                    else if (trim.startsWith("dishandle(")) this.dishandle[carIndex] = this.getfloatvalue("dishandle", trim, 0);
                    else if (trim.startsWith("outdam(")) this.outdam[carIndex] = this.getfloatvalue("outdam", trim, 0);
                    else if (trim.startsWith("cclass(")) this.cclass[carIndex] = this.getvalue("cclass", trim, 0);
                    else if (trim.startsWith("enginsignature(")) this.enginsignature[carIndex] = this.getvalue("enginsignature", trim, 0);
                }
                reader.close();
            }
            catch (final Exception ex) {
                System.out.println("Error Loading Car Stat: " + ex);
            }
        }
    }

    public float getfloatvalue(final String s, final String s2, final int n) {
        String string = "";
        int valueIndex = 0;
        for (int i = s.length() + 1; i < s2.length(); ++i) {
            final char c = s2.charAt(i);
            if (c == ',' || c == ')') {
                ++valueIndex;
                ++i;
            }
            if (valueIndex == n) {
                string += c;
            }
        }
        if (string.endsWith("F") || string.endsWith("f")) {
            string = string.substring(0, string.length() - 1);
        }
        return Float.parseFloat(string);
    }
    
    public void loadstat(final byte[] buf, final String s, final float maxR, final float roofat, final int n3, final int n4) {
