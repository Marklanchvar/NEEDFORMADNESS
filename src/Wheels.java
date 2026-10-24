public class Wheels
{
    float ground;
    int mast;
    float sparkat;
    int[] rc;
    float size;
    float depth;
	float radius;
    
    public Wheels() {
        this.ground = 0;
        this.mast = 0;
        this.sparkat = 0;
        this.rc = new int[] { 120, 120, 120 };
        this.size = 2.0f;
        this.depth = 3.0f;
        this.sparkat = 0;
        this.radius = 1;
    }
    
    public void setrims(final int n, final int n2, final int n3, final int n4, final int n5) {
        this.rc[0] = n;
        this.rc[1] = n2;
        this.rc[2] = n3;
        this.size = n4 / 10.0f;
        if (this.size < 0.0f) {
            this.size = 0.0f;
        }
        this.depth = n5 / 10.0f;
        if (this.depth / this.size > 41.0f) {
            this.depth = this.size * 41.0f;
        }
        if (this.depth / this.size < -25.0f) {
            this.depth = -(this.size * 25.0f);
        }
    }
    
    public void make(final Medium medium, final Trackers trackers, final Plane[] array, int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8) {
        final float[] array2 = new float[20];
        final float[] array3 = new float[20];
        final float[] array4 = new float[20];
        final int[] array5 = { 45, 45, 45 };
        float n9 = 0;
        final float n10 = n6 / 10.0f;
        final float n11 = n7 / 10.0f;
        if (n5 == 11) {
            n9 = (n2 + 4.0f * n10);
        }
        this.sparkat = (n11 * 24.0f);
        this.ground = (n3 + 13.0f * n11);
        this.radius = (13.0f * n11);
        
        for (int i = 0; i < 12; ++i) {
        	float radi = 13F;
        	float radian = (float) ((Math.PI / 4F) + ((i / 6F) * Math.PI));
            array2[i] = (n2 + 4.0f * n10);
        	array3[i] = (float) (n3 + (Math.sin(radian) * radi) * n11);
        	array4[i] = (float) (n4 + (Math.cos(radian) * radi) * n11);
        }
        array[n] = new Plane(medium, trackers, array2, array4, array3, 12, array5, 0, n8, 0, n9, n3, n4, 7, 0, false, 0, false);
        ++n;
        
        for (int i = 0; i < 20; ++i) {
            array2[i] = (n2 - 4.0f * n10);
        }
        for (int i = 0; i < 13; ++i) {
        	float radi = 13F;
        	float radian = (float) ((Math.PI / 4F) + ((i / 6F) * Math.PI));
        	array3[i] = (float) (n3 + (Math.sin(radian) * radi) * n11);
        	array4[i] = (float) (n4 + (Math.cos(radian) * radi) * n11);
        }
        
        for (int i = 13; i < 20; ++i) {
        	float radi = 10F;
        	float radian = (float) ((i / 3F) * Math.PI);
        	array3[i] = (float) (n3 + (Math.sin(radian) * radi) * this.size);
        	array4[i] = (float) (n4 + (Math.cos(radian) * radi) * this.size);
        }
        array[n] = new Plane(medium, trackers, array2, array4, array3, 20, array5, 0, n8, 0, n9, n3, n4, 7, 0, false, 0, false);
        array[n].master = 1;
        ++n;
        
        array2[2] = (n2 - this.depth * n10);
        array3[2] = n3;
        array4[2] = n4;
        for (int i = 0; i < 6; i++) {
        	float radian1 = (float) ((i / 3F) * Math.PI);
        	float radian2 = radian1 + (float)(Math.PI / 3F);
        	float radi = 10F;
        	array3[0] = (float) (n3 + (Math.sin(radian1) * radi) * this.size);
        	array4[0] = (float) (n4 + (Math.cos(radian1) * radi) * this.size);

        	array3[1] = (float) (n3 + (Math.sin(radian2) * radi) * this.size);
        	array4[1] = (float) (n4 + (Math.cos(radian2) * radi) * this.size);
        	array[n] = new Plane(medium, trackers, array2, array4, array3, 3, this.rc, 0, n8, 0, n9, n3, n4, 7, 0, false, 0, false);
        	if (this.depth / this.size < 7.0f) {
        		array[n].master = 2;
        	}
        	++n;
        }
        for (int i = 0; i < 12; i++) {
        	float radi = 13F;
        	float radian1 = (float) ((Math.PI / 4F) + ((i / 6F) * Math.PI));
        	float radian2 = radian1 + (float)(Math.PI / 6F);
        	array2[0] = array2[1] = (n2 - 4.0f * n10);
        	array2[2] = array2[3] = (n2 + 4.0f * n10);
        	array3[0] = array3[3] = (float) (n3 + (Math.sin(radian1) * radi) * n11);
        	array4[0] =	array4[3] = (float) (n4 + (Math.cos(radian1) * radi) * n11);
        	array3[1] = array3[2] = (float) (n3 + (Math.sin(radian2) * radi) * n11);
        	array4[1] =	array4[2] = (float) (n4 + (Math.cos(radian2) * radi) * n11);
        	array[n] = new Plane(medium, trackers, array2, array4, array3, 4, array5, 0, n8, 0, n9, n3, n4, 7, 0, false, 0, true);
        	++n;
        }
    }
}
