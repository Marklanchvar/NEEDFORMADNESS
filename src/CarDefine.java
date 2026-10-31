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
    int lastload;
    int nlcars;
    int nlocars;
    int xnlocars;
    boolean[] include;
    String[] createdby;
    String[] loadnames;
    int nl;
    int action;
    boolean carlon;
    int reco;
    int[] lcardate;
    int haltload;
    int onloadingcar;
    int ac;
    String acname;
    String fails;
    String tnickey;
    int loadlist;
    int[] adds;
    String viewname;
    int staction;
    String onstage;
    int inslot;
    int roundslot;
    String lastcar;
    int msloaded;
    
    public CarDefine(final ContO[] bco, final Medium m, final Trackers t, final GameSparker gs) {
        this.swits = new int[][] { { 50, 185, 282 }, { 100, 200, 310 }, { 60, 180, 275 }, { 76, 195, 298 }, { 70, 170, 275 }, { 70, 202, 293 }, { 60, 170, 289 }, { 70, 206, 291 }, { 90, 210, 295 }, { 90, 190, 276 }, { 70, 200, 295 }, { 50, 160, 270 }, { 90, 200, 305 }, { 50, 130, 210 }, { 80, 200, 300 }, { 70, 210, 290 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
        this.acelf = new float[][] { { 11.0f, 5.0f, 3.0f }, { 14.0f, 7.0f, 5.0f }, { 10.0f, 5.0f, 3.5f }, { 11.0f, 6.0f, 3.5f }, { 10.0f, 5.0f, 3.5f }, { 12.0f, 6.0f, 3.0f }, { 7.0f, 9.0f, 4.0f }, { 11.0f, 5.0f, 3.0f }, { 12.0f, 7.0f, 4.0f }, { 12.0f, 7.0f, 3.5f }, { 11.5f, 6.5f, 3.5f }, { 9.0f, 5.0f, 3.0f }, { 13.0f, 7.0f, 4.5f }, { 7.5f, 3.5f, 3.0f }, { 11.0f, 7.5f, 4.0f }, { 12.0f, 6.0f, 3.5f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f }, { 0.0f, 0.0f, 0.0f } };
        this.handb = new int[] { 7, 10, 7, 15, 12, 8, 9, 10, 5, 7, 8, 10, 8, 12, 7, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.airs = new float[] { 1.0f, 1.2f, 0.95f, 1.0f, 2.2f, 1.0f, 0.9f, 0.8f, 1.0f, 0.9f, 1.15f, 0.8f, 1.0f, 0.3f, 1.3f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f };
        this.airc = new int[] { 70, 30, 40, 40, 30, 50, 40, 90, 40, 50, 75, 10, 50, 0, 100, 60, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.turn = new int[] { 6, 9, 5, 7, 8, 7, 5, 5, 9, 7, 7, 4, 6, 5, 7, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.grip = new float[] { 20.0f, 27.0f, 18.0f, 22.0f, 19.0f, 20.0f, 25.0f, 20.0f, 19.0f, 24.0f, 22.5f, 25.0f, 30.0f, 27.0f, 25.0f, 27.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f };
        this.bounce = new float[] { 1.2f, 1.05f, 1.3f, 1.15f, 1.3f, 1.2f, 1.15f, 1.1f, 1.2f, 1.1f, 1.15f, 0.8f, 1.05f, 0.8f, 1.1f, 1.15f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f };
        this.simag = new float[] { 0.9f, 0.85f, 1.05f, 0.9f, 0.85f, 0.9f, 1.05f, 0.9f, 1.0f, 1.05f, 0.9f, 1.1f, 0.9f, 1.3f, 0.9f, 1.15f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f };
        this.moment = new float[] { 1.3f, 0.75f, 1.4f, 1.2f, 1.1f, 1.38f, 1.43f, 1.48f, 1.35f, 1.7f, 1.42f, 2.0f, 1.26f, 3.0f, 1.5f, 2.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f };
        this.comprad = new float[] { 0.5f, 0.4f, 0.8f, 0.5f, 0.4f, 0.5f, 0.5f, 0.5f, 0.5f, 0.8f, 0.5f, 1.5f, 0.5f, 0.8f, 0.5f, 0.8f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f };
        this.push = new int[] { 2, 2, 3, 3, 2, 2, 2, 4, 2, 2, 2, 4, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.revpush = new int[] { 2, 3, 2, 2, 2, 2, 2, 1, 2, 1, 2, 1, 2, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.lift = new int[] { 0, 30, 0, 20, 0, 30, 0, 0, 20, 0, 0, 0, 10, 0, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.revlift = new int[] { 0, 0, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.powerloss = new int[] { 2500000, 2500000, 3500000, 2500000, 4000000, 2500000, 3200000, 3200000, 2750000, 5500000, 2750000, 4500000, 3500000, 16700000, 3000000, 5500000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.flipy = new float[] { -50, -60, -92, -44, -60, -57, -54, -60, -77, -57, -82, -85, -28, -100, -63, -127, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.msquash = new int[] { 7, 4, 7, 2, 8, 4, 6, 4, 3, 8, 4, 10, 3, 20, 3, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.clrad = new int[] { 3300, 1700, 4700, 3000, 2000, 4500, 3500, 5000, 10000, 15000, 4000, 7000, 10000, 15000, 5500, 5000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.dammult = new float[] { 0.75f, 0.8f, 0.45f, 0.8f, 0.42f, 0.7f, 0.72f, 0.6f, 0.58f, 0.41f, 0.67f, 0.45f, 0.61f, 0.25f, 0.38f, 0.52f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f };
        this.maxmag = new int[] { 7600, 4200, 7200, 6000, 6000, 15000, 17200, 17000, 18000, 11000, 19000, 10700, 13000, 45000, 5800, 18000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.dishandle = new float[] { 0.65f, 0.6f, 0.55f, 0.77f, 0.62f, 0.9f, 0.6f, 0.72f, 0.45f, 0.8f, 0.95f, 0.4f, 0.87f, 0.42f, 1.0f, 0.95f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f };
        this.outdam = new float[] { 0.68f, 0.35f, 0.8f, 0.5f, 0.42f, 0.76f, 0.82f, 0.76f, 0.72f, 0.62f, 0.79f, 0.95f, 0.77f, 1.0f, 0.85f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f };
        this.cclass = new int[] { 0, 0, 0, 0, 0, 1, 2, 2, 2, 2, 3, 4, 4, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.names = new String[] { "Tornado Shark", "Formula 7", "Wow Caninaro", "La Vita Crab", "Nimi", "MAX Revenge", "Lead Oxide", "Kool Kat", "Drifter X", "Sword of Justice", "High Rider", "EL KING", "Mighty Eight", "M A S H E E N", "Radical One", "DR Monstaa", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" };
        this.enginsignature = new int[] { 0, 1, 2, 1, 0, 3, 2, 2, 1, 0, 3, 4, 1, 4, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.lastload = 0;
        this.nlcars = 0;
        this.nlocars = 0;
        this.xnlocars = 0;
        this.include = new boolean[40];
        this.createdby = new String[40];
        this.loadnames = new String[20];
        this.nl = 0;
        this.action = 0;
        this.carlon = false;
        this.reco = -2;
        this.lcardate = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.haltload = 0;
        this.onloadingcar = 0;
        this.ac = -1;
        this.acname = "Radical One";
        this.fails = "";
        this.tnickey = "";
        this.loadlist = 0;
        this.adds = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.viewname = "";
        this.staction = 0;
        this.onstage = "";
        this.inslot = -1;
        this.roundslot = 0;
        this.lastcar = "";
        this.msloaded = 0;
        this.bco = bco;
        this.m = m;
        this.t = t;
        this.gs = gs;
    }
    
    public void loadstat(final byte[] buf, final String s, final float maxR, final float roofat, final int n3, final int n4) {
        this.names[n4] = s;
        boolean b = false;
        boolean b2 = false;
        final int[] array = { 128, 128, 128, 128, 128 };
        int n5 = 640;
        final int[] array2 = { 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50 };
        final int[] array3 = { 50, 50, 50 };
        this.enginsignature[n4] = 0;
        float n6 = 0.0f;
        this.createdby[n4 - 16] = "Unkown User";
        try {
            final DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(buf));
            String line;
            while ((line = dataInputStream.readLine()) != null) {
                final String trim = line.trim();
                if (trim.startsWith("stat(")) {
                    try {
                        n5 = 0;
                        for (int i = 0; i < 5; ++i) {
                            array[i] = this.getvalue("stat", trim, i);
                            if (array[i] > 200) {
                                array[i] = 200;
                            }
                            if (array[i] < 16) {
                                array[i] = 16;
                            }
                            n5 += array[i];
                        }
                        b = true;
                    }
                    catch (final Exception ex) {
                        b = false;
                    }
                }
                if (trim.startsWith("physics(")) {
                    try {
                        for (int j = 0; j < 11; ++j) {
                            array2[j] = this.getvalue("physics", trim, j);
                            if (array2[j] > 100) {
                                array2[j] = 100;
                            }
                            if (array2[j] < 0) {
                                array2[j] = 0;
                            }
                        }
                        for (int k = 0; k < 3; ++k) {
                            array3[k] = this.getvalue("physics", trim, k + 11);
                            if (k != 0 && array3[k] > 100) {
                                array3[k] = 100;
                            }
                            if (array3[k] < 0) {
                                array3[k] = 0;
                            }
                        }
                        this.enginsignature[n4] = this.getvalue("physics", trim, 14);
                        if (this.enginsignature[n4] > 4) {
                            this.enginsignature[n4] = 0;
                        }
                        if (this.enginsignature[n4] < 0) {
                            this.enginsignature[n4] = 0;
                        }
                        n6 = (float)this.getvalue("physics", trim, 15);
                        if (n6 > 0.0f) {
                            b2 = true;
                        }
                    }
                    catch (final Exception ex2) {
                        b2 = false;
                    }
                }
                if (trim.startsWith("handling(")) {
                    try {
                        int getvalue = this.getvalue("handling", trim, 0);
                        if (getvalue > 200) {
                            getvalue = 200;
                        }
                        if (getvalue < 50) {
                            getvalue = 50;
                        }
                        this.dishandle[n4] = getvalue / 200.0f;
                    }
                    catch (final Exception ex3) {}
                }
                if (trim.startsWith("carmaker(")) {
                    this.createdby[n4 - 16] = this.getSvalue("carmaker", trim, 0);
                }
            }
            dataInputStream.close();
        }
        catch (final Exception obj) {
            System.out.println("Error Loading Car Stat: " + obj);
        }
        if (b && b2) {
            int l = 0;
            if (n5 > 680) {
                l = 680 - n5;
            }
            if (n5 > 640 && n5 < 680) {
                l = 640 - n5;
            }
            if (n5 > 600 && n5 < 640) {
                l = 600 - n5;
            }
            if (n5 > 560 && n5 < 600) {
                l = 560 - n5;
            }
            if (n5 > 520 && n5 < 560) {
                l = 520 - n5;
            }
            if (n5 < 520) {
                l = 520 - n5;
            }
            while (l != 0) {
                for (int n7 = 0; n7 < 5; ++n7) {
                    if (l > 0 && array[n7] < 200) {
                        final int[] array4 = array;
                        final int n8 = n7;
                        ++array4[n8];
                        --l;
                    }
                    if (l < 0 && array[n7] > 16) {
                        final int[] array5 = array;
                        final int n9 = n7;
                        --array5[n9];
                        ++l;
                    }
                }
            }
            int n10 = 0;
            for (int n11 = 0; n11 < 5; ++n11) {
                n10 += array[n11];
            }
            if (n10 == 520) {
                this.cclass[n4] = 0;
            }
            if (n10 == 560) {
                this.cclass[n4] = 1;
            }
            if (n10 == 600) {
                this.cclass[n4] = 2;
            }
            if (n10 == 640) {
                this.cclass[n4] = 3;
            }
            if (n10 == 680) {
                this.cclass[n4] = 4;
            }
            int n12 = 0;
            int n13 = 0;
            float n14 = 0.5f;
            if (array[0] == 200) {
                n12 = 1;
                n13 = 1;
            }
            if (array[0] > 192 && array[0] < 200) {
                n12 = 12;
                n13 = 1;
                n14 = (array[0] - 192) / 8.0f;
            }
            if (array[0] == 192) {
                n12 = 12;
                n13 = 12;
            }
            if (array[0] > 148 && array[0] < 192) {
                n12 = 14;
                n13 = 12;
                n14 = (array[0] - 148) / 44.0f;
            }
            if (array[0] == 148) {
                n12 = 14;
                n13 = 14;
            }
            if (array[0] > 133 && array[0] < 148) {
                n12 = 10;
                n13 = 14;
                n14 = (array[0] - 133) / 15.0f;
            }
            if (array[0] == 133) {
                n12 = 10;
                n13 = 10;
            }
            if (array[0] > 112 && array[0] < 133) {
                n12 = 15;
                n13 = 10;
                n14 = (array[0] - 112) / 21.0f;
            }
            if (array[0] == 112) {
                n12 = 15;
                n13 = 15;
            }
            if (array[0] > 107 && array[0] < 112) {
                n12 = 11;
                n13 = 15;
                n14 = (array[0] - 107) / 5.0f;
            }
            if (array[0] == 107) {
                n12 = 11;
                n13 = 11;
            }
            if (array[0] > 88 && array[0] < 107) {
                n12 = 13;
                n13 = 11;
                n14 = (array[0] - 88) / 19.0f;
            }
            if (array[0] == 88) {
                n12 = 13;
                n13 = 13;
            }
            if (array[0] > 88) {
                this.swits[n4][0] = (int)((this.swits[n13][0] - this.swits[n12][0]) * n14 + this.swits[n12][0]);
                this.swits[n4][1] = (int)((this.swits[n13][1] - this.swits[n12][1]) * n14 + this.swits[n12][1]);
                this.swits[n4][2] = (int)((this.swits[n13][2] - this.swits[n12][2]) * n14 + this.swits[n12][2]);
            }
            else {
                float n15 = array[0] / 88.0f;
                if (n15 < 0.76) {
                    n15 = 0.76f;
                }
                this.swits[n4][0] = (int)(50.0f * n15);
                this.swits[n4][1] = (int)(130.0f * n15);
                this.swits[n4][2] = (int)(210.0f * n15);
            }
            int n16 = 0;
            int n17 = 0;
            float n18 = 0.5f;
            if (array[1] == 200) {
                n16 = 1;
                n17 = 1;
            }
            if (array[1] > 150 && array[1] < 200) {
                n16 = 14;
                n17 = 1;
                n18 = (array[1] - 150) / 50.0f;
            }
            if (array[1] == 150) {
                n16 = 14;
                n17 = 14;
            }
            if (array[1] > 144 && array[1] < 150) {
                n16 = 9;
                n17 = 14;
                n18 = (array[1] - 144) / 6.0f;
            }
            if (array[1] == 144) {
                n16 = 9;
                n17 = 9;
            }
            if (array[1] > 139 && array[1] < 144) {
                n16 = 6;
                n17 = 9;
                n18 = (array[1] - 139) / 5.0f;
            }
            if (array[1] == 139) {
                n16 = 6;
                n17 = 6;
            }
            if (array[1] > 128 && array[1] < 139) {
                n16 = 15;
                n17 = 6;
                n18 = (array[1] - 128) / 11.0f;
            }
            if (array[1] == 128) {
                n16 = 15;
                n17 = 15;
            }
            if (array[1] > 122 && array[1] < 128) {
                n16 = 10;
                n17 = 15;
                n18 = (array[1] - 122) / 6.0f;
            }
            if (array[1] == 122) {
                n16 = 10;
                n17 = 10;
            }
            if (array[1] > 119 && array[1] < 122) {
                n16 = 3;
                n17 = 10;
                n18 = (array[1] - 119) / 3.0f;
            }
            if (array[1] == 119) {
                n16 = 3;
                n17 = 3;
            }
            if (array[1] > 98 && array[1] < 119) {
                n16 = 5;
                n17 = 3;
                n18 = (array[1] - 98) / 21.0f;
            }
            if (array[1] == 98) {
                n16 = 5;
                n17 = 5;
            }
            if (array[1] > 81 && array[1] < 98) {
                n16 = 0;
                n17 = 5;
                n18 = (array[1] - 81) / 17.0f;
            }
            if (array[1] == 81) {
                n16 = 0;
                n17 = 0;
            }
            if (array[1] <= 80) {
                n16 = 2;
                n17 = 2;
            }
            if (array[0] <= 88) {
                n16 = 13;
                n17 = 13;
            }
            this.acelf[n4][0] = (this.acelf[n17][0] - this.acelf[n16][0]) * n18 + this.acelf[n16][0];
            this.acelf[n4][1] = (this.acelf[n17][1] - this.acelf[n16][1]) * n18 + this.acelf[n16][1];
            this.acelf[n4][2] = (this.acelf[n17][2] - this.acelf[n16][2]) * n18 + this.acelf[n16][2];
            if (array[1] <= 70 && array[0] > 88) {
                this.acelf[n4][0] = 9.0f;
                this.acelf[n4][1] = 4.0f;
                this.acelf[n4][2] = 3.0f;
            }
            float n19 = (array[2] - 88) / 109.0f;
            if (n19 > 1.0f) {
                n19 = 1.0f;
            }
            if (n19 < -0.55) {
                n19 = -0.55f;
            }
            this.airs[n4] = 0.55f + 0.45f * n19 + 0.4f * (array2[9] / 100.0f);
            if (this.airs[n4] < 0.3) {
                this.airs[n4] = 0.3f;
            }
            this.airc[n4] = (int)(10.0f + 70.0f * n19 + 30.0f * (array2[10] / 100.0f));
            if (this.airc[n4] < 0) {
                this.airc[n4] = 0;
            }
            int n20 = (int)(670.0f - (array2[9] + array2[10]) / 200.0f * 420.0f);
            if (array[0] <= 88) {
                n20 = (int)(1670.0f - (array2[9] + array2[10]) / 200.0f * 1420.0f);
            }
            if (array[2] > 190 && n20 < 300) {
                n20 = 300;
            }
            this.powerloss[n4] = n20 * 10000;
            this.moment[n4] = 0.7f + (array[3] - 16) / 184.0f * 1.0f;
            if (array[0] < 110) {
                this.moment[n4] = 0.75f + (array[3] - 16) / 184.0f * 1.25f;
            }
            if (array[3] == 200 && array[4] == 200 && array[0] <= 88) {
                this.moment[n4] = 3.0f;
            }
            float n21 = 0.9f + (array[4] - 90) * 0.01f;
            if (n21 < 0.6) {
                n21 = 0.6f;
            }
            if (array[4] == 200 && array[0] <= 88) {
                n21 = 3.0f;
            }
            this.maxmag[n4] = (int)(n6 * n21);
            this.outdam[n4] = 0.35f + (n21 - 0.6f) * 0.5f;
            if (this.outdam[n4] < 0.35) {
                this.outdam[n4] = 0.35f;
            }
            if (this.outdam[n4] > 1.0f) {
                this.outdam[n4] = 1.0f;
            }
            this.clrad[n4] = (int)(array3[0] * array3[0] * 1.5);
            if (this.clrad[n4] < 1000) {
                this.clrad[n4] = 1000;
            }
            this.dammult[n4] = 0.3f + array3[1] * 0.005f;
            this.msquash[n4] = (int)(2.0 + (float)array3[2] / 7.6);
            this.flipy[n4] = roofat;
            this.handb[n4] = (int)(7.0f + array2[0] / 100.0f * 8.0f);
            this.turn[n4] = (int)(4.0f + array2[1] / 100.0f * 6.0f);
            this.grip[n4] = 16.0f + array2[2] / 100.0f * 14.0f;
            if (this.grip[n4] < 21.0f) {
                final int[] array6 = this.swits[n4];
                final int n22 = 0;
                array6[n22] += (int)(40.0f * ((21.0f - this.grip[n4]) / 5.0f));
                if (this.swits[n4][0] > 100) {
                    this.swits[n4][0] = 100;
                }
            }
            this.bounce[n4] = 0.8f + array2[3] / 100.0f * 0.6f;
            if (array2[3] > 67) {
                final float[] airs = this.airs;
                airs[n4] *= 0.76f + (1.0f - array2[3] / 100.0f) * 0.24f;
                final int[] airc = this.airc;
                airc[n4] *= (int)(0.76f + (1.0f - array2[3] / 100.0f) * 0.24f);
            }
            this.lift[n4] = (int)(array2[5] * (float)array2[5] / 10000.0f * 30.0f);
            this.revlift[n4] = (int)(array2[6] / 100.0f * 32.0f);
            this.push[n4] = (int)(2.0f + array2[7] / 100.0f * 2.0f * ((30 - this.lift[n4]) / 30));
            this.revpush[n4] = (int)(1.0f + array2[8] / 100.0f * 2.0f);
            this.comprad[n4] = maxR / 400.0f + (array[3] - 16) / 184.0f * 0.2f;
            if (this.comprad[n4] < 0.4) {
                this.comprad[n4] = 0.4f;
            }
            this.simag[n4] = (n3 - 17) * 0.0167f + 0.85f;
        }
        else {
            this.names[n4] = "";
        }
    }
    
    public int getvalue(final String s, final String s2, final int n) {
        int n2 = 0;
        String string = "";
        for (int i = s.length() + 1; i < s2.length(); ++i) {
            final String string2 = "" + s2.charAt(i);
            if (string2.equals(",") || string2.equals(")")) {
                ++n2;
                ++i;
            }
            if (n2 == n) {
                string += s2.charAt(i);
            }
        }
        return Float.valueOf(string).intValue();
    }
    
    public String getSvalue(final String s, final String s2, final int n) {
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
    
    public int servervalue(final String s, final int n) {
        int intValue = -1;
        try {
            int index = 0;
            int n2 = 0;
            int n3 = 0;
            String string = "";
            while (index < s.length() && n3 != 2) {
                final String string2 = "" + s.charAt(index);
                if (string2.equals("|")) {
                    ++n2;
                    if (n3 == 1 || n2 > n) {
                        n3 = 2;
                    }
                }
                else if (n2 == n) {
                    string += string2;
                    n3 = 1;
                }
                ++index;
            }
            if (string.equals("")) {
                string = "-1";
            }
            intValue = Integer.valueOf(string);
        }
        catch (final Exception ex) {}
        return intValue;
    }
    
    public String serverSvalue(final String s, final int n) {
        String s2 = "";
        try {
            int index = 0;
            int n2 = 0;
            int n3 = 0;
            String string = "";
            while (index < s.length() && n3 != 2) {
                final String string2 = "" + s.charAt(index);
                if (string2.equals("|")) {
                    ++n2;
                    if (n3 == 1 || n2 > n) {
                        n3 = 2;
                    }
                }
                else if (n2 == n) {
                    string += string2;
                    n3 = 1;
                }
                ++index;
            }
            s2 = string;
        }
        catch (final Exception ex) {}
        return s2;
    }
    
    public void loadready() {
        this.m.csky[0] = 170;
        this.m.csky[1] = 220;
        this.m.csky[2] = 255;
        this.m.cfade[0] = 255;
        this.m.cfade[1] = 220;
        this.m.cfade[2] = 220;
        this.m.snap[0] = 0;
        this.m.snap[1] = 0;
        this.m.snap[2] = 0;
        this.fails = "";
        for (int i = 0; i < 20; ++i) {
            this.loadnames[i] = "";
        }
        this.nl = 0;
        this.action = 0;
    }
    
    public void sparkactionloader() {
        (this.actionloader = new Thread(this)).start();
    }
    
    public void sparkcarloader() {
        if (!this.carlon) {
            (this.carloader = new Thread(this)).start();
            this.carlon = true;
        }
    }
    
    public void sparkstageaction() {
        (this.stageaction = new Thread(this)).start();
    }
    
    public void stopallnow() {
        this.staction = 0;
        this.action = 0;
        if (this.carloader != null) {
            this.carloader.stop();
            this.carloader = null;
        }
        if (this.actionloader != null) {
            this.actionloader.stop();
            this.actionloader = null;
        }
        if (this.stageaction != null) {
            this.stageaction.stop();
            this.stageaction = null;
        }
    }
    
    @Override
    public void run() {
        if (Thread.currentThread() == this.actionloader) {
            if (this.action == 4) {
                this.m.csky[0] = 170;
                this.m.csky[1] = 220;
                this.m.csky[2] = 255;
                this.m.cfade[0] = 255;
                this.m.cfade[1] = 220;
                this.m.cfade[2] = 220;
                this.m.snap[0] = 0;
                this.m.snap[1] = 0;
                this.m.snap[2] = 0;
                {
                    if (this.lastload == 2) {
                        this.lastload = 0;
                    }
                    this.action = -1;
                }
                System.gc();
            }
            if (this.action == 12) {
                this.m.csky[0] = 170;
                this.m.csky[1] = 220;
                this.m.csky[2] = 255;
                this.m.cfade[0] = 255;
                this.m.cfade[1] = 220;
                this.m.cfade[2] = 220;
                this.m.snap[0] = 0;
                this.m.snap[1] = 0;
                this.m.snap[2] = 0;
                this.xnlocars = 36;
                final int nl = this.nl;
                this.nl = 0;
                while (this.nl < nl) {
                    ++this.nl;
                }
                this.nl = 0;
                if (this.xnlocars > 36) {
                    this.action = 13;
                }
                else {
                    this.action = -1;
                }
                System.gc();
            }
            if (this.action == 102) {
                this.m.csky[0] = 170;
                this.m.csky[1] = 220;
                this.m.csky[2] = 255;
                this.m.cfade[0] = 255;
                this.m.cfade[1] = 220;
                this.m.cfade[2] = 220;
                this.m.snap[0] = 0;
                this.m.snap[1] = 0;
                this.m.snap[2] = 0;
                for (int l = 0; l < 40; ++l) {
                    this.include[l] = false;
                }
                this.xnlocars = 36;
                final int nl2 = this.nl;
                this.nl = 0;
                while (this.nl < nl2) {
                    ++this.nl;
                }
                this.nl = 0;
                if (this.xnlocars > 36) {
                    this.action = 103;
                }
                else {
                    this.action = -1;
                }
                System.gc();
            }
            this.actionloader = null;
        }
        if (Thread.currentThread() == this.carloader) {
            while (this.nl > 0) {
                int n4 = 0;
                for (int n5 = 16; n5 < 56; ++n5) {
                    if (this.loadnames[this.nl - 1].equals(this.names[n5])) {
                        n4 = -1;
                    }
                }
                if (this.fails.indexOf("|" + this.loadnames[this.nl - 1] + "|") != -1) {
                    n4 = -1;
                }
                if (n4 != -1) {
                    int n6 = this.lcardate[0];
                    int n7 = 36;
                    if (this.haltload > 0) {
                        n7 = 36 + this.haltload;
                        n6 = this.lcardate[this.haltload];
                    }
                    int n8 = n7;
                    for (int n9 = n7; n9 < 56; ++n9) {
                        if (this.lcardate[n9 - 36] < n6) {
                            n6 = this.lcardate[n9 - 36];
                            n8 = n9;
                        }
                    }
                    this.onloadingcar = n8 - 35;
                    {
                        final int[] lcardate = this.lcardate;
                        final int n10 = n8 - 36;
                        ++lcardate[n10];
                    }
                    this.onloadingcar = 0;
                }
                --this.nl;
                try {
                    final Thread carloader = this.carloader;
                    Thread.sleep(20L);
                }
                catch (final InterruptedException ex5) {}
            }
            this.carlon = false;
            this.carloader = null;
        }
    }
    
    public void loadstagemaker() {
        this.gs.mstgs.hide();
        this.gs.mstgs.removeAll();
        this.gs.mstgs.add(this.gs.rd, "Select Stage");
        int n = 0;
        if (new File("" + Madness.fpath + "mystages/").exists()) {
            final String[] list = new File("" + Madness.fpath + "mystages/").list();
            for (int i = 0; i < list.length; ++i) {
                if (list[i].toLowerCase().endsWith(".txt") && n < 200) {
                    this.gs.mstgs.add(this.gs.rd, list[i].substring(0, list[i].length() - 4));
                    ++n;
                }
            }
        }
        if (n != 0) {
            this.msloaded = 2;
        }
        else {
            this.gs.mstgs.add(this.gs.rd, "No stages where found in your 'mystages' folder.");
            this.msloaded = -1;
        }
        this.gs.mstgs.select(0);
        this.gs.mstgs.show();
    }
    
    public void loadcarmaker() {
        this.m.csky[0] = 170;
        this.m.csky[1] = 220;
        this.m.csky[2] = 255;
        this.m.cfade[0] = 255;
        this.m.cfade[1] = 220;
        this.m.cfade[2] = 220;
        this.m.snap[0] = 0;
        this.m.snap[1] = 0;
        this.m.snap[2] = 0;
        for (int i = 0; i < 40; ++i) {
            this.include[i] = false;
        }
        this.nlcars = 16;
        if (new File("" + Madness.fpath + "mycars/").exists()) {
            final String[] list = new File("" + Madness.fpath + "mycars/").list();
            for (int j = 0; j < list.length; ++j) {
                if (list[j].toLowerCase().endsWith(".rad") && this.nlcars < 56 && this.loadcar(list[j].substring(0, list[j].length() - 4), this.nlcars) == this.nlcars) {
                    ++this.nlcars;
                }
            }
        }
        System.gc();
        if (this.nlcars > 16) {
            this.lastload = 1;
        }
    }
    
    public int loadcar(final String str, int n) {
        try {
            final File file = new File("" + Madness.fpath + "mycars/" + str + ".rad");
            if (file.exists()) {
                String string = "";
                final BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    string = string + "" + line + "\n";
                }
                bufferedReader.close();
                this.m.loadnew = true;
                this.bco[n] = new ContO(string.getBytes(), this.m, this.t);
                if (this.bco[n].errd || this.bco[n].npl <= 60) {
                    n = -1;
                }
                if (n != -1) {
                    this.bco[n].shadow = true;
                    this.bco[n].noline = false;
                    this.bco[n].decor = false;
                    this.bco[n].tnt = 0;
                    this.bco[n].disp = 0;
                    this.bco[n].disline = 7;
                    this.bco[n].grounded = 1.0f;
                    boolean b = true;
                    if (this.bco[n].keyz[0] < 0 || this.bco[n].keyx[0] > 0) {
                        b = false;
                    }
                    if (this.bco[n].keyz[1] < 0 || this.bco[n].keyx[1] < 0) {
                        b = false;
                    }
                    if (this.bco[n].keyz[2] > 0 || this.bco[n].keyx[2] > 0) {
                        b = false;
                    }
                    if (this.bco[n].keyz[3] > 0 || this.bco[n].keyx[3] < 0) {
                        b = false;
                    }
                    if (!b) {
                        n = -1;
                    }
                }
                if (n != -1) {
                    this.loadstat(string.getBytes(), str, this.bco[n].maxR, this.bco[n].roofat, this.bco[n].wh, n);
                    if (this.names[n].equals("")) {
                        n = -1;
                    }
                }
                this.m.loadnew = false;
            }
            else {
                n = -1;
            }
        }
        catch (final Exception obj) {
            n = -1;
            System.out.println("Error Loading Car: " + obj);
        }
        System.gc();
        return n;
    }
}
