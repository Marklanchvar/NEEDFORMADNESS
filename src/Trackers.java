public class Trackers
{
	static final int trackersCount = 10000;
    float[] x;
    float[] y;
    float[] z;
    float[] xy;
    float[] zy;
    float[] xz;
    int[] skd;
    int[] dam;
    boolean[] notwall;
    boolean[] decor;
    int[][] c;
    float[] radx;
    float[] radz;
    float[] rady;
    int nt;
    int sx;
    int sz;
    int ncx;
    int ncz;
    int[][][] sect;
    
    public Trackers() {
        this.x = new float[trackersCount];
        this.y = new float[trackersCount];
        this.z = new float[trackersCount];
        this.xy = new float[trackersCount];
        this.zy = new float[trackersCount];
        this.xz = new float[trackersCount];
        this.skd = new int[trackersCount];
        this.dam = new int[trackersCount];
        this.notwall = new boolean[trackersCount];
        this.decor = new boolean[trackersCount];
        this.c = new int[trackersCount][3];
        this.radx = new float[trackersCount];
        this.radz = new float[trackersCount];
        this.rady = new float[trackersCount];
        this.nt = 0;
        this.sx = 0;
        this.sz = 0;
        this.ncx = 0;
        this.ncz = 0;
        this.sect = null;
    }
    
    public void devidetrackers(final int sx, final int n, final int sz, final int n2) {
        this.sect = null;
        this.sx = sx;
        this.sz = sz;
        this.ncx = n / 3000;
        if (this.ncx <= 0) {
            this.ncx = 1;
        }
        this.ncz = n2 / 3000;
        if (this.ncz <= 0) {
            this.ncz = 1;
        }
        this.sect = new int[this.ncx][this.ncz][];
        for (int everyCellX = 0; everyCellX < this.ncx; ++everyCellX) {
            for (int everyCellZ = 0; everyCellZ < this.ncz; ++everyCellZ) {
                final int sectorX = this.sx + everyCellX * 3000 + 1500;
                final int sectorZ = this.sz + everyCellZ * 3000 + 1500;
                final int[] trackerAmount = new int[trackersCount];
                int n5 = 0;
                for (int k = 0; k < this.nt; ++k) {
                    final float py = this.py(sectorX, this.x[k], sectorZ, this.z[k]);
                    if (py < 20250000 && py > 0 && this.dam[k] != 167) {
                        trackerAmount[n5] = k;
                        ++n5;
                    }
                }
                if (everyCellX == 0 || everyCellZ == 0 || everyCellX == this.ncx - 1 || everyCellZ == this.ncz - 1) {
                    for (int l = 0; l < this.nt; ++l) {
                        if (this.dam[l] == 167) {
                            trackerAmount[n5] = l;
                            ++n5;
                        }
                    }
                }
                if (n5 == 0) {
                    trackerAmount[n5] = 0;
                    ++n5;
                }
                this.sect[everyCellX][everyCellZ] = new int[n5];
                for (int n6 = 0; n6 < n5; ++n6) {
                    this.sect[everyCellX][everyCellZ][n6] = trackerAmount[n6];
                }
            }
        }
        for (int n7 = 0; n7 < this.nt; ++n7) {
            if (this.dam[n7] == 167) {
                this.dam[n7] = 1;
            }
        }
        --this.ncx;
        --this.ncz;
    }
    
    public float py(final int n, final float x2, final int n3, final float z2) {
        return (n - x2) * (n - x2) + (n3 - z2) * (n3 - z2);
    }
}
